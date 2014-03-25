package Algorithm;

import Graph.GraphGenerator;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by lloydp on 09/02/14.
 */


public class NearestNeighbourAlgo extends Algorithm {

    double totalDistance = 0;

    public NearestNeighbourAlgo(GraphGenerator graphObject) {
        super(graphObject);
        drawer();
    }

    private void drawer() {

        int lastNode = drawerIterator(graphNodeArray.length - 2);
        edgeDrawerFromLastNodetotheFirstone(lastNode);
    }

    private void edgeDrawerFromLastNodetotheFirstone(int lastNode) {
        totalDistance += graphObject.edgeDrawerFromNodeItoJ(lastNode, 0, "green");
    }

    private int edgeDrawerfromItoNextClosestNode(int i) {
        //System.out.println(i);
        int nodeJ = getIndexofClosesetNodefromIwithDistance(i).getValue();
        totalDistance += graphObject.edgeDrawerFromNodeItoJ(i, nodeJ, "green");
        return nodeJ;
    }

    private int drawerIterator(int i) {

        if (i == 0) {

            int next = edgeDrawerfromItoNextClosestNode(0);
            return next;
        }
        return (edgeDrawerfromItoNextClosestNode(drawerIterator(i - 1)));


    }


    private Map.Entry<Double, Integer> getIndexofClosesetNodefromIwithDistance(int i) {
        Map.Entry<Double, Integer> thClosestElementfromI = distanceTableCreatorFromNodei(i).firstEntry();
        return thClosestElementfromI;
    }

    private TreeMap<Double, Integer> distanceTableCreatorFromNodei(int i) {
        Map<Double, Integer> distanceTable = new HashMap<Double, Integer>();
        // <distance, node>

        for (int j = 0; j < graphNodeArray.length; j++) {
            mxCell jthNode = (mxCell) graphNodeArray[j];
            if ((!(j == i)) && jthNode.getEdgeCount() < 1) distanceTable.put(graphObject.distanceFinder(i, j), j);
        }

        TreeMap<Double, Integer> sortedDistanceTable = new TreeMap<Double, Integer>();
        sortedDistanceTable.putAll(distanceTable);
        return sortedDistanceTable;
    }


    @Override
    public mxGraphComponent run() {
        return graphObject.componentGetter();

    }

    public double getTotalDistance() {
        return totalDistance;
    }
}
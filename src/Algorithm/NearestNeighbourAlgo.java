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

    public NearestNeighbourAlgo(GraphGenerator graphG) {
        super(graphG);
        drawer();
    }

    private void drawer() {

        int lastNode = drawerIterator(nodeArray.length - 2);
        edgeDrawerFromBeginningtoEnd(lastNode);
    }

    private void edgeDrawerFromBeginningtoEnd(int lastNode) {
        graphG.edgeDrawerFromNodeItoJ(lastNode, 0);
    }

    private int drawerIterator(int i) {

        if (i == 0) {

            int next = edgeDrawerfromItoNextClosestNode(0);
            return next;
        }
        return (edgeDrawerfromItoNextClosestNode(drawerIterator(i - 1)));


    }

    private int edgeDrawerfromItoNextClosestNode(int i) {
        //System.out.println(i);
        int nodeJ = getIndexofClosesetNodefromIwithDistance(i).getValue();
        graphG.edgeDrawerFromNodeItoJ(i, nodeJ);
        return nodeJ;
    }

    private Map.Entry<Double, Integer> getIndexofClosesetNodefromIwithDistance(int i) {
        Map.Entry<Double, Integer> thClosestElementfromI = distanceTableCreatorFromNodei(i).firstEntry();
        return thClosestElementfromI;
    }

    private TreeMap<Double, Integer> distanceTableCreatorFromNodei(int i) {
        Map<Double, Integer> distanceTable = new HashMap<Double, Integer>();
        // <distance, node>

        for (int j = 0; j < nodeArray.length; j++) {
            mxCell jthNode = (mxCell) nodeArray[j];
            if ((!(j == i)) && jthNode.getEdgeCount() < 1) distanceTable.put(graphG.distanceFinder(i, j), j);
        }

        TreeMap<Double, Integer> sortedDistanceTable = new TreeMap<Double, Integer>();
        sortedDistanceTable.putAll(distanceTable);
        return sortedDistanceTable;
    }


    @Override
    public mxGraphComponent run() {
        return graphG.componentGetter();

    }

    public double getTotalDistance() {
        return totalDistance;
    }
}
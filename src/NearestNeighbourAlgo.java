import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by lloydp on 09/02/14.
 */
public class NearestNeighbourAlgo extends Algorithm {


    NearestNeighbourAlgo(NewGraphGenerator graphG) {
        super(graphG);

        //edgeDrawerFromNodeItoJ(3, 4);
        //distanceTableCreatorFromNodei();
        drawerIterator(nodeArray.length - 1);


    }

    private int drawerIterator(int i) {

        if (i == 0) {
            // System.out.println("sdsdfsdfsdgsgd");
            int next = edgeDrawerfromItoNextClosestNode(0);
            return next;
        }
        return (edgeDrawerfromItoNextClosestNode(drawerIterator(i - 1)));


    }

    private int edgeDrawerfromItoNextClosestNode(int i) {

        int nodeJ = getIndexofClosesetNodefromIwithDistance(i).getValue();
        edgeDrawerFromNodeItoJ(i, nodeJ);
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
            if ((!(j == i)) && jthNode.getEdgeCount() < 1) distanceTable.put(distanceFinder(i, j), j);
        }

        TreeMap<Double, Integer> sortedDistanceTable = new TreeMap<Double, Integer>();
        sortedDistanceTable.putAll(distanceTable);
        return sortedDistanceTable;
    }

    private double distanceFinder(int i, int j) {
        mxCell ithNode = (mxCell) nodeArray[i];
        mxCell jthNode = (mxCell) nodeArray[j];

        // System.out.println(ithNode.getValue());
        // System.out.println(jthNode.getValue());

        int horizontalDistance = (int) (ithNode.getGeometry().getX() - jthNode.getGeometry().getX());
        int verticalDistance = (int) (ithNode.getGeometry().getY() - jthNode.getGeometry().getY());

        double distance = Math.sqrt((horizontalDistance * horizontalDistance) + (verticalDistance * verticalDistance));

        return Math.round(distance);
    }

    private void edgeDrawerFromNodeItoJ(int i, int j) {
        graph.getModel().beginUpdate();

        graph.insertEdge(parent, null, distanceFinder(i, j), nodeArray[i], nodeArray[j]);
        graph.getModel().endUpdate();


    }

    @Override
    public mxGraphComponent run() {
        return graphG.componentGetter();

    }
}
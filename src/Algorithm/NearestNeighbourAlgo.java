package Algorithm;

import Graph.GraphGenerator;

/**
 * Created by lloydp on 09/02/14.
 */


public class NearestNeighbourAlgo extends Algorithm {


    public NearestNeighbourAlgo(GraphGenerator graphObject) {
        super(graphObject);
        edgeColorSeletor("green");

    }


    @Override
    protected void drawer() {
        int lastNode = drawerIterator(graphNodeArray.length - 2);
        edgeDrawerFromLastNodetotheFirstone(lastNode);

        totalDistance = graphObject.findTotalDistance();
    }


    private int drawerIterator(int i) {

        if (i == 0) {
            int next = graphObject.edgeDrawerfromItoNextClosestNode(0, color);
            return next;
        }
        return (graphObject.edgeDrawerfromItoNextClosestNode(drawerIterator(i - 1), color));
    }

    private void edgeDrawerFromLastNodetotheFirstone(int lastNode) {
        graphObject.edgeDrawerFromNodeItoJ(lastNode, 0, color);
    }


}
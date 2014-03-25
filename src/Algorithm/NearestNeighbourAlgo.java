package Algorithm;

import Graph.GraphGenerator;

/**
 * Created by lloydp on 09/02/14.
 */


public class NearestNeighbourAlgo extends Algorithm {


    public NearestNeighbourAlgo(GraphGenerator graphObject) {
        super(graphObject);

    }


    @Override
    protected void drawer() {
        int lastNode = drawerIterator(graphNodeArray.length - 2);
        edgeDrawerFromLastNodetotheFirstone(lastNode);
    }

    private void edgeDrawerFromLastNodetotheFirstone(int lastNode) {
        totalDistance += graphObject.edgeDrawerFromNodeItoJ(lastNode, 0, "green");
    }

    private int edgeDrawerfromItoNextClosestNode(int i) {
        //System.out.println(i);
        int nodeJ = graphObject.getIndexofClosesetNodefromIwithDistance(i).getValue();
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





}
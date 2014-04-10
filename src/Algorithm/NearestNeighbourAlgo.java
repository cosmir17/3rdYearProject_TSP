package Algorithm;

import Graph.GraphGenerator;
import Graph.edgeColors;

/**
 * Created by lloydp on 09/02/14.
 */


public class NearestNeighbourAlgo extends Algorithm {


    public NearestNeighbourAlgo(GraphGenerator graphObject) {

        super(graphObject);
    }

    @Override
    protected void graphObjectColorSelectorAndRedefiner() {
        color = edgeColors.valueOf(this.getClass().getSimpleName());
        graphObject.color = color;
    }


    @Override
    protected void drawer() {

        nearestNeighbour();
    }

    private void nearestNeighbour() {
        int lastNode = drawerIterator(graphNodeArray.length - 2);
        edgeDrawerFromLastNodetotheFirstone(lastNode);
        //graphObject.repeatSwapping();
    }


    private int drawerIterator(int i) {

        if (i == 0) {
            int next = graphObject.edgeDrawerfromItoNextClosestNode(0);
            return next;
        }
        return (graphObject.edgeDrawerfromItoNextClosestNode(drawerIterator(i - 1)));
    }

    private void edgeDrawerFromLastNodetotheFirstone(int lastNode) {
        graphObject.edgeDrawerFromNodeItoJ(lastNode, 0);
    }


}
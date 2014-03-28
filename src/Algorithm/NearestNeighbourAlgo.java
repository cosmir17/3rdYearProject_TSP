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
    protected void layerRedefiner() {
        graphObject.layer = layer;
    }

    @Override
    protected void graphObjectColorRedefiner() {
        graphObject.color = color;
    }

    @Override
    protected void colorSelector() {
        color = edgeColors.valueOf(this.getClass().getSimpleName());
    }


    @Override
    protected void drawer() {
        int lastNode = drawerIterator(graphNodeArray.length - 2);
        edgeDrawerFromLastNodetotheFirstone(lastNode);

        totalDistance = graphObject.findTotalDistance();
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
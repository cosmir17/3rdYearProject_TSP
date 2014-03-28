package Algorithm;

import Graph.EdgeColors;
import Graph.EdgeLayers;
import Graph.GraphGenerator;

/**
 * Created by lloydp on 09/02/14.
 */


public class NearestNeighbourAlgo extends Algorithm {


    public NearestNeighbourAlgo(GraphGenerator graphObject) {

        super(graphObject);
    }

    @Override
    protected void layerSelectorAndRedefiner() {
        layer = EdgeLayers.valueOf(this.getClass().getSimpleName());
        graphObject.layer = layer;
    }

    @Override
    protected void colorSelectorAndRedefiner() {
        color = EdgeColors.valueOf(this.getClass().getSimpleName());
        graphObject.color = color;
        //  System.out.println(color.getCode());
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
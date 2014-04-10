package Algorithm;

import Graph.GraphGenerator;
import Graph.edgeColors;

/**
 * Created by lloydp on 30/03/14.
 */
public class TwoOptAlgo extends Algorithm {


    public TwoOptAlgo(GraphGenerator graphObject) {
        super(graphObject);
    }

    @Override
    protected void graphObjectColorSelectorAndRedefiner() {
        color = edgeColors.valueOf(this.getClass().getSimpleName());
        graphObject.color = color;
    }

    @Override
    protected void drawer() {

        // graphObject.drawFromEdgeList(graphObject.randomCycleEdgeListGenerator());

        // graphObject.repeatSwapping();
        nearestNeighbour();

        graphObject.twoOpt();


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


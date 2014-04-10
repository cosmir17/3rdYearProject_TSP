package Algorithm;

import Graph.GraphGenerator;
import Graph.edgeColors;

/**
 * Created by lloydp on 01/04/14.
 */
public class SimulatedAnnealingAlgo extends Algorithm {
    public double INITIAL_T = 2000000;
    public static double SCHEDULE = 0.9995;
    public static double HALT = 0.03;

    public SimulatedAnnealingAlgo(GraphGenerator graphObject, double schedule, double halt) {
        super(graphObject);
        this.SCHEDULE = schedule;
        this.HALT = halt;
    }

    public SimulatedAnnealingAlgo(GraphGenerator graphObject) {
        super(graphObject);
    }

    @Override
    protected void graphObjectColorSelectorAndRedefiner() {

        color = edgeColors.valueOf(this.getClass().getSimpleName());
        graphObject.color = color;
    }

    @Override
    protected void drawer() {

        //graphObject.drawFromEdgeList(graphObject.randomCycleEdgeListGenerator());

        //graphObject.sA(INITIAL_T, SCHEDULE, HALT);

        nearestNeighbour();
        graphObject.sAadt(INITIAL_T, SCHEDULE, HALT, true);

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

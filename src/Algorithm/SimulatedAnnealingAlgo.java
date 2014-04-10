package Algorithm;

import Graph.GraphGenerator;
import Graph.edgeColors;

/**
 * Created by lloydp on 01/04/14.
 */
public class SimulatedAnnealingAlgo extends Algorithm {
    private static final double INITIAL_T = 2000000;
    private static final double SCHEDULE = 0.99;
    private static final double HALT = 0.0005;

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

        graphObject.drawFromEdgeList(graphObject.randomCycleEdgeListGenerator());
        //graphObject.sA(INITIAL_T, SCHEDULE, HALT);
        graphObject.sAadt(INITIAL_T, SCHEDULE, HALT, true);

    }


}

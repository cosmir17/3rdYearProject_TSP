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

        graphObject.drawFromEdgeList(graphObject.randomCycleEdgeListGenerator());
        graphObject.repeatSwapping();
    }






}


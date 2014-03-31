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

        randomCycleDrawer();


    }

    private void randomCycleDrawer() {

        int lastNode = drawerIterator(graphNodeArray.length - 1);
        graphObject.edgeDrawerFromNodeItoJ(lastNode, 0);


    }


    private int drawerIterator(int i) {

        if (i == 0) {
            int next = 0;
            return next;
        }
        graphObject.edgeDrawerFromNodeItoJ(drawerIterator(i - 1), i);
        return i--;
    }


}


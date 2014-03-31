package Algorithm;

import Graph.GraphGenerator;
import Graph.edgeColors;

import java.util.HashMap;

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
        repeatSwapping();
    }

    private void repeatSwapping() {
        int nochange = 2000;

        while (3000 > nochange) {

        boolean swapHappened = false;
            HashMap<Integer, Integer> edgesWithSourceAndTargetNodes = graphObject.sourceAndTargetNodeListWithEdges();
        for (int ii : edgesWithSourceAndTargetNodes.keySet()) {
            if (!swapHappened) {
            int isourceNode = ii;
            int jtargetNode = edgesWithSourceAndTargetNodes.get(ii);

            graphObject.edgeRemoverfromItoJ(isourceNode, jtargetNode);

            for (int jj : edgesWithSourceAndTargetNodes.keySet()) {
                if (jj != ii
                        && jtargetNode != jj
                        && edgesWithSourceAndTargetNodes.get(jj) != jtargetNode
                        && edgesWithSourceAndTargetNodes.get(jj) != ii
                        && !swapHappened) {
                    int ksourceNode = jj;
                    int ltargetNode = edgesWithSourceAndTargetNodes.get(jj);

                    graphObject.edgeRemoverfromItoJ(ksourceNode, ltargetNode);

                    double initialDistance = graphObject.distanceFinder(isourceNode, jtargetNode) + graphObject.distanceFinder(ksourceNode, ltargetNode);
                    double swapDistance = graphObject.distanceFinder(isourceNode, ksourceNode) + graphObject.distanceFinder(jtargetNode, ltargetNode);

                    if (initialDistance > swapDistance) {
                        graphObject.edgeDrawerFromNodeItoJ(isourceNode, ksourceNode);
                        graphObject.edgeDrawerFromNodeItoJ(jtargetNode, ltargetNode);
                        swapHappened = true;
                        nochange -= 1;
                    } else {
                        graphObject.edgeDrawerFromNodeItoJ(ksourceNode, ltargetNode);
                        //swapHappened = false;
                        nochange += 1;
                    }
                }
            }

            if (!swapHappened) {
                graphObject.edgeDrawerFromNodeItoJ(isourceNode, jtargetNode);
            }


        }

        }
        }
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


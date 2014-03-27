package Algorithm;

import Graph.GraphGenerator;
import Graph.edgeColors;
import com.mxgraph.swing.mxGraphComponent;

/**
 * Created by lloydp on 09/02/14.
 */
public class InsertionAlgo extends Algorithm {


    public InsertionAlgo(GraphGenerator graphObject) {

        super(graphObject);

    }

    @Override
    protected void colorSelector() {
        edgeColors color = edgeColors.valueOf(this.getClass().getName());
    }

    @Override
    protected void drawer() {
        int nodeJ = graphObject.edgeDrawerfromItoNextClosestNode(0, color);
        int nodeK = graphObject.findingtheClosestNodeFromtheMiddlePointbetweentwoNodes(0, nodeJ);
        graphObject.edgeDrawerFromNodeItoJ(0, nodeK, color);
        graphObject.edgeDrawerFromNodeItoJ(nodeJ, nodeK, color);


        int nodeL = graphObject.findingtheClosestNodeFromtheMiddlePointbetweentwoNodes(nodeJ, nodeK);
        graphObject.edgeRemoverfromItoJ(nodeJ, nodeK);
        graphObject.edgeDrawerFromNodeItoJ(nodeJ, nodeL, color);
        graphObject.edgeDrawerFromNodeItoJ(nodeK, nodeL, color);

        //int nodeKcandidatefromJ = graphObject.getIndexofClosesetNodefromIwithDistance(nodeJ).getValue();


    }


    @Override
    public mxGraphComponent run() {
        return graphObject.componentGetter();
    }
}

package Algorithm;

import Graph.GraphGenerator;
import com.mxgraph.swing.mxGraphComponent;

/**
 * Created by lloydp on 09/02/14.
 */
public class InsertionAlgo extends Algorithm {


    InsertionAlgo(GraphGenerator graphObject) {
        super(graphObject);
        edgeColorSeletor("red");
    }

    @Override
    protected void drawer() {
        int nodeJ = graphObject.edgeDrawerfromItoNextClosestNode(0, color);
        int nodeK = graphObject.findingtheClosestNodeFromtheMiddlePointbetweentwoNodes(0, nodeJ);


        graphObject.findingTheMiddlePoint(0, nodeJ);


        //int nodeKcandidatefromJ = graphObject.getIndexofClosesetNodefromIwithDistance(nodeJ).getValue();


    }


    @Override
    public mxGraphComponent run() {
        return graphObject.componentGetter();
    }
}

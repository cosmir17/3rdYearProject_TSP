package Algorithm;

import Graph.GraphGenerator;
import com.mxgraph.swing.mxGraphComponent;

/**
 * Created by lloydp on 09/02/14.
 */
public class InsertionAlgo extends Algorithm {


    public InsertionAlgo(GraphGenerator graphObject) {
        super(graphObject);
        edgeColorSeletor("blue");
    }

    @Override
    protected void drawer() {
        int nodeJ = graphObject.edgeDrawerfromItoNextClosestNode(0, color);

        int nodeK = graphObject.findingtheClosestNodeFromtheMiddlePointbetweentwoNodes(0, nodeJ);
        System.out.println(nodeJ);
        System.out.println(nodeK);
        graphObject.edgeDrawerFromNodeItoJ(0, nodeK, color);


        //int nodeKcandidatefromJ = graphObject.getIndexofClosesetNodefromIwithDistance(nodeJ).getValue();


    }


    @Override
    public mxGraphComponent run() {
        return graphObject.componentGetter();
    }
}

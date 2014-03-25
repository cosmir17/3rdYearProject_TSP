package Algorithm;

import Graph.GraphGenerator;
import com.mxgraph.swing.mxGraphComponent;

/**
 * Created by lloydp on 09/02/14.
 */
public class InsertionAlgo extends Algorithm {

    InsertionAlgo(GraphGenerator graphObject) {
        super(graphObject);
    }

    @Override
    protected void drawer() {
        graphObject.edgeDrawerfromItoNextClosestNode(0);
        graphObject.getIndexofClosesetNodefromIwithDistance(0);
    }

    @Override
    public mxGraphComponent run() {
        return graphObject.componentGetter();
    }
}

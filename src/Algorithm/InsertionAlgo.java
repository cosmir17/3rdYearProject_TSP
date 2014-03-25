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
        int nextNodeIndex = graphObject.edgeDrawerfromItoNextClosestNode(0, color);

    }

    @Override
    public mxGraphComponent run() {
        return graphObject.componentGetter();
    }
}

package Algorithm;

import Graph.NewGraphGenerator;
import com.mxgraph.swing.mxGraphComponent;

/**
 * Created by lloydp on 09/02/14.
 */
public class InsertionAlgo extends Algorithm {

    InsertionAlgo(NewGraphGenerator graphG) {
        super(graphG);
    }

    @Override
    public mxGraphComponent run() {
        return graphG.componentGetter();
    }
}

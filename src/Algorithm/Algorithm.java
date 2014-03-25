package Algorithm;

import Graph.GraphGenerator;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

/**
 * Created by lloydp on 09/02/14.
 */
public abstract class Algorithm {
    protected GraphGenerator graphG;
    protected mxGraph graph;
    protected Object nodeArray[];
    protected Object parent;

    public Algorithm(GraphGenerator graphG) {
        this.graphG = graphG;
        this.graph = graphG.graph;
        this.nodeArray = graphG.graphNodeArray;
        this.parent = graph.getDefaultParent();
    }

    abstract mxGraphComponent run();

}

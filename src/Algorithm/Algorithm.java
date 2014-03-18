package Algorithm;

import Graph.NewGraphGenerator;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

/**
 * Created by lloydp on 09/02/14.
 */
public abstract class Algorithm {
    protected NewGraphGenerator graphG;
    protected mxGraph graph;
    protected Object nodeArray[];
    protected Object parent;

    public Algorithm(NewGraphGenerator graphG) {
        this.graphG = graphG;
        this.graph = graphG.graph;
        this.nodeArray = graphG.graphNodeArray;
        this.parent = graph.getDefaultParent();
    }

    abstract mxGraphComponent run();

}

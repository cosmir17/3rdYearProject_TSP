package Algorithm;

import Graph.GraphGenerator;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

/**
 * Created by lloydp on 09/02/14.
 */
public abstract class Algorithm {
    protected GraphGenerator graphObject;
    protected mxGraph graph;
    protected Object graphNodeArray[];
    protected Object parent;
    double totalDistance = 0;
    String color = "";

    public Algorithm(GraphGenerator graphObject) {
        this.graphObject = graphObject;
        this.graph = graphObject.graph;
        this.graphNodeArray = graphObject.graphNodeArray;
        this.parent = graph.getDefaultParent();

        drawer();
    }

    protected void edgeColorSeletor(String color) {
        this.color = color;
    }

    protected abstract void drawer();


    public mxGraphComponent run() {
        return graphObject.componentGetter();

    }

    public double getTotalDistance() {
        return totalDistance;
    }
}

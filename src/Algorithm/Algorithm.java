package Algorithm;

import Graph.Color;
import Graph.EdgeLayers;
import Graph.GraphGenerator;
import Graph.edgeColors;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

/**
 * Created by lloydp on 09/02/14.
 */
public abstract class Algorithm extends Thread {
    protected GraphGenerator graphObject;
    protected mxGraph graph;
    protected Object graphNodeArray[];
    protected Object parent;
    double totalDistance = 0;
    Color color;
    EdgeLayers layer;

    public Algorithm(GraphGenerator graphObject) {
        this.graphObject = graphObject;
        this.graph = graphObject.graph;
        this.graphNodeArray = graphObject.graphNodeArray;
        this.parent = graph.getDefaultParent();
        this.color = graphObject.color;
        this.layer = graphObject.layer;

        graphObjectColorSelectorAndRedefiner();

    }

    public void run() {
        drawer();
        // getTotalDis();
    }


    protected void graphObjectColorSelectorAndRedefiner() {
        color = edgeColors.valueOf(this.getClass().);
        graphObject.color = color;
    }


    public double getTotalDis() {
        totalDistance = graphObject.findTotalDistance();
        return totalDistance;
    }


    protected abstract void drawer();


    public mxGraphComponent getComputedGraph() {
        return graphObject.componentGetter();

    }

    public double getTotalDistance() {
        return totalDistance;
    }
}
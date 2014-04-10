package Algorithm;

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
    edgeColors color;
    EdgeLayers layer;

    public boolean isHasitBeenRun() {
        return hasitBeenRun;
    }

    public void setHasitBeenRun(boolean hasitBeenRun) {
        this.hasitBeenRun = hasitBeenRun;
    }

    boolean hasitBeenRun = false;
    boolean running = true;
    public Algorithm(GraphGenerator graphObject) {
        this.graphObject = graphObject;
        this.graph = graphObject.graph;
        this.graphNodeArray = graphObject.graphNodeArray;
        this.parent = graph.getDefaultParent();
        this.color = graphObject.color;
        this.layer = graphObject.layer;

        graphObjectColorSelectorAndRedefiner();

    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void run() {

        while (running) {
            drawer();
            // getTotalDis();
            running = false;
            hasitBeenRun = true;
        }
    }


    public double getTotalDis() {
        totalDistance = graphObject.findTotalDistance();
        return totalDistance;
    }


    protected abstract void graphObjectColorSelectorAndRedefiner();


    protected abstract void drawer();


    public mxGraphComponent getComputedGraph() {
        return graphObject.componentGetter();

    }

    public double getTotalDistance() {
        return totalDistance;
    }
}
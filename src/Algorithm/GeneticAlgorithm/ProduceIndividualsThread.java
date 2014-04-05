package Algorithm.GeneticAlgorithm;

import Graph.EdgeLayers;
import Graph.GraphGenerator;
import Graph.edgeColors;
import com.mxgraph.view.mxGraph;

/**
 * Created by lloydp on 04/04/14.
 */
public class ProduceIndividualsThread extends Thread {
    public GraphGenerator graphObject;
    public mxGraph graph;
    public Object graphNodeArray[];
    public Object parent;
    public double totalDistance = 0;
    public edgeColors color;
    public EdgeLayers layer;

    public ProduceIndividualsThread(GraphGenerator graphObject) {
        this.graphObject = graphObject;
        this.graph = graphObject.graph;
        this.graphNodeArray = graphObject.graphNodeArray;
        this.parent = graph.getDefaultParent();
        this.color = graphObject.color;
        this.layer = graphObject.layer;

    }

    public void run() {
        graphObject.randomCycleDrawer2();

    }


}


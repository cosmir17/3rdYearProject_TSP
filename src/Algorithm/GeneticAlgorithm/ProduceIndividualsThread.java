package Algorithm.GeneticAlgorithm;

import Graph.EdgeLayers;
import Graph.GraphGenerator;
import Graph.edgeColors;
import com.mxgraph.view.mxGraph;

/**
 * Created by lloydp on 04/04/14.
 */
public class ProduceIndividualsThread extends Thread {
    protected GraphGenerator graphObject;
    protected mxGraph graph;
    protected Object graphNodeArray[];
    protected Object parent;
    double totalDistance = 0;
    edgeColors color;
    EdgeLayers layer;

    public ProduceIndividualsThread(GraphGenerator graphObject) {
        this.graphObject = graphObject;
        this.graph = graphObject.graph;
        this.graphNodeArray = graphObject.graphNodeArray;
        this.parent = graph.getDefaultParent();
        this.color = graphObject.color;
        this.layer = graphObject.layer;

    }

    public void run() {


    }


}


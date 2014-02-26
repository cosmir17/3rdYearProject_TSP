import com.mxgraph.swing.mxGraphComponent;

/**
 * Created by lloydp on 09/02/14.
 */
public class NearestNeighbourAlgo extends Algorithm {


    NearestNeighbourAlgo(NewGraphGenerator graphG) {
        super(graphG);
        firstMethod();

    }

    private void firstMethod() {
        graph.getModel().beginUpdate();
        // graph.addEdge(parent, null, nodeArray[3], nodeArray[4], 4);
        graph.insertEdge(parent, null, "Edge", nodeArray[2], nodeArray[1]);
        graph.getModel().endUpdate();


    }

    @Override
    public mxGraphComponent run() {
        return graphG.componentGetter();

    }
}
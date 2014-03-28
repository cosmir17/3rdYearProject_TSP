package Algorithm;

import Graph.EdgeColors;
import Graph.EdgeLayers;
import Graph.GraphGenerator;
import com.mxgraph.swing.mxGraphComponent;

/**
 * Created by lloydp on 09/02/14.
 */
public class InsertionAlgo extends Algorithm {

    public InsertionAlgo(GraphGenerator graphObject) {

        super(graphObject);

        // EdgeColors.valueOf("InsertionAlgo");
        // this.getClass().getSimpleName();
        // System.out.println(EdgeColors.valueOf("InsertionAlgo")+"3");
        // System.out.println(EdgeColors.valueOf("InsertionAlgo").getCode());
        //  System.out.println(this.getClass().getSimpleName());
        // System.out.println(EdgeColors.valueOf("red")+"4");
        // System.out.println(EdgeColors.valueOf("red").getCode());
        // System.out.println( EdgeColors.valueOf(this.getClass().getSimpleName()));
        //System.out.println( EdgeColors.valueOf(this.getClass().getSimpleName()).getCode());
    }

    @Override
    protected void layerSelectorAndRedefiner() {
        layer = EdgeLayers.valueOf(this.getClass().getSimpleName());
        graphObject.layer = layer;
    }


    @Override
    protected void colorSelectorAndRedefiner() {
        color = EdgeColors.valueOf(this.getClass().getSimpleName());
        graphObject.color = color;
        //  System.out.println(color.getCode());

    }


    @Override
    protected void drawer() {


        int nodeJ = graphObject.edgeDrawerfromItoNextClosestNode(0);
        int nodeK = graphObject.findingtheClosestNodeFromtheMiddlePointbetweentwoNodes(0, nodeJ);
        graphObject.edgeDrawerFromNodeItoJ(0, nodeK);
        graphObject.edgeDrawerFromNodeItoJ(nodeJ, nodeK);


        int nodeL = graphObject.findingtheClosestNodeFromtheMiddlePointbetweentwoNodes(nodeJ, nodeK);
        graphObject.edgeRemoverfromItoJ(nodeJ, nodeK);
        graphObject.edgeDrawerFromNodeItoJ(nodeJ, nodeL);
        graphObject.edgeDrawerFromNodeItoJ(nodeK, nodeL);

        //int nodeKcandidatefromJ = graphObject.getIndexofClosesetNodefromIwithDistance(nodeJ).getValue();


    }


    @Override
    public mxGraphComponent run() {
        return graphObject.componentGetter();
    }
}

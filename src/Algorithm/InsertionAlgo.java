package Algorithm;

import Graph.GraphGenerator;
import Graph.edgeColors;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;

import java.util.TreeMap;

/**
 * Created by lloydp on 09/02/14.
 */
public class InsertionAlgo extends Algorithm {

    public InsertionAlgo(GraphGenerator graphObject) {

        super(graphObject);

        // edgeColors.valueOf("InsertionAlgo");
        // this.getClass().getSimpleName();
        // System.out.println(edgeColors.valueOf("InsertionAlgo")+"3");
        // System.out.println(edgeColors.valueOf("InsertionAlgo").getCode());
        //  System.out.println(this.getClass().getSimpleName());
        // System.out.println(edgeColors.valueOf("red")+"4");
        // System.out.println(edgeColors.valueOf("red").getCode());
        // System.out.println( edgeColors.valueOf(this.getClass().getSimpleName()));
        //System.out.println( edgeColors.valueOf(this.getClass().getSimpleName()).getCode());
    }

    @Override
    protected void graphObjectColorSelectorAndRedefiner() {
        color = edgeColors.valueOf(this.getClass().getSimpleName());
        graphObject.color = color;
    }


    @Override
    protected void drawer() {


        int nodeJ = graphObject.edgeDrawerfromItoNextClosestNode(0);
        // O-----O
        Object graphEdges[] = graph.getAllEdges(graphNodeArray);

        for (int i = 0; i < graphEdges.length - 1; i++) {
            mxCell element = (mxCell) graphEdges[i];
            Double.parseDouble(element.getValue().toString());


        }


        TreeMap<Integer, Double> minimumNodeMap = graphObject.findMinimumValueOfIJKiteratingManyNodes(0, nodeJ);
        graphObject.edgeDrawerfromijk(0, nodeJ, minimumNodeMap.firstEntry().getKey());
        //triangle is made



        /*
        int nodeK = graphObject.findingtheClosestNodeFromtheMiddlePointbetweentwoNodes(0, nodeJ);
        graphObject.edgeDrawerFromNodeItoJ(0, nodeK);
        graphObject.edgeDrawerFromNodeItoJ(nodeJ, nodeK);


        int nodeL = graphObject.findingtheClosestNodeFromtheMiddlePointbetweentwoNodes(nodeJ, nodeK);
        graphObject.edgeRemoverfromItoJ(nodeJ, nodeK);
        graphObject.edgeDrawerFromNodeItoJ(nodeJ, nodeL);
        graphObject.edgeDrawerFromNodeItoJ(nodeK, nodeL);

        //int nodeKcandidatefromJ = graphObject.getIndexofClosesetNodefromIwithDistance(nodeJ).getValue();
*/

    }


    @Override
    public mxGraphComponent run() {
        return graphObject.componentGetter();
    }
}

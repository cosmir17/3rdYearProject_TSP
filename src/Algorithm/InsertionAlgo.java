package Algorithm;

import Graph.GraphGenerator;
import Graph.edgeColors;
import com.mxgraph.swing.mxGraphComponent;

import java.util.HashMap;
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
        TreeMap<Integer, Double> minimumNodeMap = graphObject.findMinimumValueOfIJKiteratingManyNodes(0, nodeJ);
        graphObject.edgeDrawerfromijkwithoutRemovingEdgeFromIJ(0, nodeJ, minimumNodeMap.firstEntry().getKey());

        boolean isThereNodewithoutAnedge = true;

        while (isThereNodewithoutAnedge) {
            HashMap<Integer, Integer> sourceAndTarget = graphObject.sourceAndTargetNodeListWithEdges();

            TreeMap<Integer, Double> minimumNodeMap2 = new TreeMap<Integer, Double>();

            for (int i : sourceAndTarget.keySet()) {
                int sourceNode = i;
                int targetNode = sourceAndTarget.get(i);

                if (graphObject.isNodeWithoutanEdge()) {
                    minimumNodeMap2 = graphObject.findMinimumValueOfIJKiteratingManyNodes(sourceNode, targetNode);
                    graphObject.edgeDrawerfromijk(sourceNode, targetNode, minimumNodeMap2.firstEntry().getKey());
                }
            }

            isThereNodewithoutAnedge = graphObject.isNodeWithoutanEdge();

        }

/*

        HashMap<Integer, mxCell> oneEdgeOneNodeNotTwoNodes = new HashMap<Integer, mxCell>();

        for (int i = 0; i < graphEdges.length; i++) {
            mxCell element = (mxCell) graphEdges[i];
            oneEdgeOneNodeNotTwoNodes.put(Integer.parseInt(element.getId()), element);
        }

        for (Integer i : oneEdgeOneNodeNotTwoNodes.keySet()) {
            totalDistance += Double.parseDouble(oneEdgeOneNodeNotTwoNodes.get(i).getValue().toString());
        }
*/


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

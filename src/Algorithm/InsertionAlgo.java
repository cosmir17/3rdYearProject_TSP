package Algorithm;

import Graph.GraphGenerator;
import Graph.edgeColors;

import java.util.HashMap;
import java.util.Map;
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


        // previousSetting();
        newSetting();
        //  graphObject.repeatSwapping();

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

    private void newSetting() {

        boolean forDemonstration = true;
        while (graphObject.isNodeWithoutanEdge()) {


            boolean justonce = true;
            HashMap<Integer, Integer> sourceAndTarget = graphObject.sourceAndTargetNodeListWithEdges();

            TreeMap<Integer, Double> minimumNodeMap2 = new TreeMap<Integer, Double>();

            for (int i : sourceAndTarget.keySet()) {
                if (justonce) {
                    int sourceNode = i;
                    Map.Entry<Double, Integer> kCandidateList;
                    kCandidateList = graphObject.getIndexofClosesetNodefromIwithDistance(sourceNode); //kCandindate needs to be redefined once drwan.
                    int kcandidate = kCandidateList.getValue();

                    TreeMap<Double, HashMap<Integer, Integer>> jkikMinusijListWithEdgeList = new TreeMap<Double, HashMap<Integer, Integer>>();

                    for (int j : sourceAndTarget.keySet()) {
                        if (justonce) {
                            int sourceNode2 = j;
                            int targetNode = sourceAndTarget.get(j);


                            double jkDistance = graphObject.distanceFinder(sourceNode2, kcandidate);
                            double ikDistance = graphObject.distanceFinder(targetNode, kcandidate);
                            double ijDistance = graphObject.distanceFinder(sourceNode2, targetNode);

                            double calculatedValue = jkDistance + ikDistance - ijDistance;

                            HashMap<Integer, Integer> edge = new HashMap<Integer, Integer>();
                            edge.put(sourceNode2, targetNode);
                            jkikMinusijListWithEdgeList.put(calculatedValue, edge);

                            if (graphObject.isNodeWithoutanEdge() && jkikMinusijListWithEdgeList.size() == sourceAndTarget.size()) {

                                Map.Entry<Double, HashMap<Integer, Integer>> minimu = jkikMinusijListWithEdgeList.firstEntry();
                                HashMap<Integer, Integer> minimEdge = minimu.getValue();

                                int minimSource = -1;
                                int minimTarget = -1;

                                for (int minSource : minimEdge.keySet()) {
                                    minimSource = minSource;
                                    minimTarget = minimEdge.get(minimSource);

                                }

                                graphObject.edgeDrawerfromijk(minimSource, minimTarget, kcandidate);


                                justonce = false;


                            }


                        }
                    }


                }
            }


        }
    }

    private void previousSetting() {

        while (graphObject.isNodeWithoutanEdge()) {
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


        }
    }

}

package Algorithm;

import Algorithm.GeneticAlgorithm.CrossoverIndividualsThread;
import Algorithm.GeneticAlgorithm.ProduceIndividualsThread;
import Graph.GraphGenerator;
import Graph.edgeColors;

import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lloydp on 04/04/14.
 */
public class GeneticAlgo extends Algorithm implements Runnable {


    public GeneticAlgo(GraphGenerator graphObject) {

        super(graphObject);


    }

    @Override
    protected void graphObjectColorSelectorAndRedefiner() {
        color = edgeColors.valueOf(this.getClass().getSimpleName());
        graphObject.color = color;
    }

    @Override
    protected void drawer() {


        TreeMap<Double, ConcurrentHashMap<Integer, Integer>> firstGeneration = produceAhundredIndividuals();
        Vector<TreeMap<Integer, Integer>> selectedFourIndis = selectFourIndividuals(firstGeneration);

        TreeMap<Double, ConcurrentHashMap<Integer, Integer>> crossoveredGeneration = CrossoverIndividualsThreadRunner(selectedFourIndis);
        Vector<TreeMap<Integer, Integer>> selectedFourIndis2 = selectFourIndividuals(crossoveredGeneration);

        // graphObject.drawFromEdgeListTreeMap(off);

    }

    private TreeMap<Double, ConcurrentHashMap<Integer, Integer>> CrossoverIndividualsThreadRunner(Vector<TreeMap<Integer, Integer>> selectedFourIndis) {


        Vector<CrossoverIndividualsThread> threadVector = new Vector<CrossoverIndividualsThread>();
        TreeMap<Double, ConcurrentHashMap<Integer, Integer>> distanceList = new TreeMap<Double, ConcurrentHashMap<Integer, Integer>>();
        int arrayNumber = 0;
        for (int i = 0; i < selectedFourIndis.size(); i++) {
            for (int j = 0; j < selectedFourIndis.size(); j++) {
                if (i != j) {
                    TreeMap<Integer, Integer> first = selectedFourIndis.get(i);
                    TreeMap<Integer, Integer> second = selectedFourIndis.get(j);
                    for (int k = 0; k < 24; k++) {

                        threadVector.add(new CrossoverIndividualsThread(first, second, graphObject));
                        threadVector.get(arrayNumber).start();

<<<<<<< HEAD
=======
    private static void alwaysPairofArrows(TreeMap<Integer, Integer> edgelist) {
        int difference = 0;

        for (int oneByOne : edgelist.keySet()) {

            difference += oneByOne - edgelist.get(oneByOne);
        }

        if (difference != 0) {
            System.out.println("it's a problem");
        }
    }

    public static void pathConnectorIfitssaperated(TreeMap<Integer, Integer> edgelist) {

        PathDrawerIfSubgraphExist pathChecker = new PathDrawerIfSubgraphExist(edgelist);

        System.out.println("There are " + pathChecker.getHowmanyCycles() + " cycles");


    }


    public TreeMap<Integer, Integer> removingRepeatPartsANDrandomisingArrangement(TreeMap<Integer, Integer> edgeliNotaPath) {

        boolean[] isValueExist = new boolean[edgeliNotaPath.size()];

        for (int oneByOne : edgeliNotaPath.keySet()) {
            int value = edgeliNotaPath.get(oneByOne);


            if (!isValueExist[value] == true) {
                isValueExist[value] = true;
            } else {
                edgeliNotaPath.put(oneByOne, -1);
            }
        }


        //if there are indices with false values they are not used.

        Vector<Integer> nonExistiveValueList = new Vector<Integer>();
        for (int i = 0; i < isValueExist.length; i++) {
            if (isValueExist[i] == false) // i is the value should be inserted
            {
                nonExistiveValueList.add(i);
            }
        }

        //shuffling nonExistiveValueList means randoming path.
        //vectorShuffler(nonExistiveValueList);


        edgeliNotaPath = edgeListModifierToMakePath(edgeliNotaPath, nonExistiveValueList);

        return edgeliNotaPath;


    }

    public TreeMap<Integer, Integer> edgeListModifierToMakePath(TreeMap<Integer, Integer> edgeliNotaPath, Vector<Integer> nonExistiveValueList) {

        while (nonExistiveValueList.size() != 0) {
            for (int oneByOne : edgeliNotaPath.keySet()) {
                if (edgeliNotaPath.get(oneByOne) == -1) { // if a key is found with a value with -1

                    for (int i = 0; i < nonExistiveValueList.size(); i++) {
                        if (oneByOne != nonExistiveValueList.get(i)) { //not to make a self loop
>>>>>>> parent of 38a6461... path connector seems working fine?

                            try {
                                threadVector.get(arrayNumber).join();
                                distanceList.put(threadVector.get(arrayNumber).totalDistance, threadVector.get(arrayNumber).edgelist);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        arrayNumber++;
                        }
                    }
                }
        }

        TreeMap<Double, ConcurrentHashMap<Integer, Integer>> sortedDistanceList = new TreeMap<Double, ConcurrentHashMap<Integer, Integer>>();
        sortedDistanceList.putAll(distanceList);

        for (int i = 0; i < selectedFourIndis.size(); i++) {
            TreeMap<Integer, Integer> edgelistOne = selectedFourIndis.get(i);
            double dis = graphObject.gettingTotalDistanceFromTableAbstract(edgelistOne);

            sortedDistanceList.put(dis, edgelistOne);
        }


        return sortedDistanceList;


    }


    public Vector<TreeMap<Integer, Integer>> selectFourIndividuals(TreeMap<Double, ConcurrentHashMap<Integer, Integer>> firstGeneration) {

        int fourTimes = 0;
        Vector<ConcurrentHashMap<Integer, Integer>> selectedIndividuals = new Vector<ConcurrentHashMap<Integer, Integer>>();
        for (double path : firstGeneration.keySet()) {
            selectedIndividuals.add(firstGeneration.get(path));

            fourTimes++;
            if (fourTimes > 3) break;
        }

        Vector<TreeMap<Integer, Integer>> selectedIndividualTree = new Vector<TreeMap<Integer, Integer>>();
        for (int i = 0; i < selectedIndividuals.size(); i++) {
            selectedIndividualTree.add(hashmapSort(selectedIndividuals.get(i)));

        }

        return selectedIndividualTree;
    }

    public TreeMap<Double, ConcurrentHashMap<Integer, Integer>> produceAhundredIndividuals() {

        ProduceIndividualsThread threadArray[] = new ProduceIndividualsThread[100];
        TreeMap<Double, ConcurrentHashMap<Integer, Integer>> distanceList = new TreeMap<Double, ConcurrentHashMap<Integer, Integer>>();

        for (int i = 0; i < 100; i++) {

            threadArray[i] = new ProduceIndividualsThread(graphObject);
            threadArray[i].start();


            try {
                threadArray[i].join();
                distanceList.put(threadArray[i].totalDistance, threadArray[i].edgelist);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        TreeMap<Double, ConcurrentHashMap<Integer, Integer>> sortedDistanceList = new TreeMap<Double, ConcurrentHashMap<Integer, Integer>>();
        sortedDistanceList.putAll(distanceList);


        return sortedDistanceList;


    }

    public TreeMap<Integer, Integer> hashmapSort(ConcurrentHashMap<Integer, Integer> hashm) {
        TreeMap<Integer, Integer> TreeM = new TreeMap<Integer, Integer>();
        TreeM.putAll(hashm);

        return TreeM;

    }


}

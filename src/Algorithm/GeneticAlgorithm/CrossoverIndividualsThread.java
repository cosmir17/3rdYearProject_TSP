package Algorithm.GeneticAlgorithm;

import Graph.GraphGenerator;

import java.util.Random;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lloydp on 04/04/14.
 */
public class CrossoverIndividualsThread extends Thread {
    TreeMap<Integer, Integer> firstIndi;
    TreeMap<Integer, Integer> secondIndi;
    public ConcurrentHashMap<Integer, Integer> edgelist;
    public double totalDistance = 0;
    public GraphGenerator graphObject;


    public CrossoverIndividualsThread(TreeMap<Integer, Integer> firstIndi, TreeMap<Integer, Integer> secondIndi, GraphGenerator graphObject) {
        this.firstIndi = firstIndi;
        this.secondIndi = secondIndi;
        this.graphObject = graphObject;
    }

    public void run() {

        edgelist =

                TreeMap < Integer, Integer > edgelistTree = crossOver(firstIndi, secondIndi);

        // graphObject.drawFromEdgeList(edgelist);

        totalDistance = graphObject.gettingTotalDistanceFromTableAbstract(edgelist);


    }


    public TreeMap<Integer, Integer> crossOver(TreeMap<Integer, Integer> firstIndi, TreeMap<Integer, Integer> secondIndi) {

        int halfSize = 0;


        if (firstIndi.size() % 2 == 0) {
            halfSize = firstIndi.size() / 2;
        } else {
            halfSize = (firstIndi.size() - 1) / 2;
        }


        TreeMap<Integer, Integer> mixedIndi = new TreeMap<Integer, Integer>();

        int loop = 0;
        for (int oneByOne : firstIndi.keySet()) {
            mixedIndi.put(oneByOne, firstIndi.get(oneByOne));

            loop++;
            if (loop == halfSize) {
                break;
            }
        }

        int secondLooop = 0;
        for (int oneByOne : secondIndi.keySet()) {
            if (secondLooop > halfSize - 1) {
                mixedIndi.put(oneByOne, secondIndi.get(oneByOne));
            }

            secondLooop++;

        }

        //TreeMap<Integer, Integer> check = mixedIndi;

        mixedIndi = removingRepeatPartsANDrandomisingArrangement(mixedIndi);

        alwaysPairofArrows(mixedIndi);

        pathConnectorIfitssaperated(mixedIndi);


        return mixedIndi;

    }

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

        //System.out.println("There are " + pathChecker.getHowmanyCycles() + " cycles");

        edgelist = pathChecker.getEdgelist();


        // PathDrawerIfSubgraphExist path2 = new PathDrawerIfSubgraphExist(edgelist);
        // System.out.println("There are " + path2.getHowmanyCycles() + " cycles");


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
        vectorShuffler(nonExistiveValueList);


        edgeliNotaPath = edgeListModifierToMakePath(edgeliNotaPath, nonExistiveValueList);

        return edgeliNotaPath;


    }

    public TreeMap<Integer, Integer> edgeListModifierToMakePath(TreeMap<Integer, Integer> edgeliNotaPath, Vector<Integer> nonExistiveValueList) {

        while (nonExistiveValueList.size() != 0) {
            for (int oneByOne : edgeliNotaPath.keySet()) {
                if (edgeliNotaPath.get(oneByOne) == -1) { // if a key is found with a value with -1

                    for (int i = 0; i < nonExistiveValueList.size(); i++) {
                        if (oneByOne != nonExistiveValueList.get(i)) { //not to make a self loop

                            try {
                                edgeliNotaPath.put(oneByOne, nonExistiveValueList.get(i));
                                nonExistiveValueList.remove(i); //if there is a value doesn't exist in the edge list then add.

                            } catch (NullPointerException e) {
                            }
                        } else {//one node loop case.
                            int nodeJ = graphObject.getIndexofClosesetNodefromIwithDistance(oneByOne).getValue();
                            int temp2 = edgeliNotaPath.get(nodeJ); //number chosen to be swapped

                            edgeliNotaPath.put(nodeJ, oneByOne);
                            edgeliNotaPath.put(oneByOne, temp2);
                            nonExistiveValueList.remove(i);
                        }

                    }


                }


            }

        }

        return edgeliNotaPath;

    }

    public static void vectorShuffler(Vector<Integer> valueList) {

        if (valueList.size() != 1 && valueList.size() != 0) {
            int swap = 0;
            boolean isSwapEnough = true;

            while (isSwapEnough) {
                Random randomN = new Random();
                int rNumber = randomN.nextInt(valueList.size());

                Random randomN2 = new Random();
                int rNumber2 = randomN2.nextInt(valueList.size());


                int temp = valueList.get(rNumber);
                int temp2 = valueList.get(rNumber2);

                valueList.set(rNumber, temp2);
                valueList.set(rNumber2, temp);
                swap++;
                if (swap >= (int) (valueList.size() / 2)) {
                    isSwapEnough = false;
                }
            }
        }

    }


}


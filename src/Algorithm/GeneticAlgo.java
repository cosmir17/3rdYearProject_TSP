package Algorithm;

import Algorithm.GeneticAlgorithm.PathDrawerIfSubgraphExist;
import Algorithm.GeneticAlgorithm.ProduceIndividualsThread;
import Graph.GraphGenerator;
import Graph.edgeColors;

import java.util.Random;
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
        graphObject.allEdgeRemover();

        Vector<TreeMap<Integer, Integer>> selectedFourIndis = selectFourIndividuals(firstGeneration);
        Vector<TreeMap<Integer, Integer>> selectedFourIndis2 = new Vector<TreeMap<Integer, Integer>>();

        int generationNumber = 0;
        while (generationNumber < 6000) {

            if (generationNumber > 0) {
                // selectedFourIndis = selectedFourIndis2;
                selectedFourIndis = new Vector<TreeMap<Integer, Integer>>(selectedFourIndis2);
                //   selectedFourIndis2.clear();
            }

            TreeMap<Double, TreeMap<Integer, Integer>> secondGenerationList = crossoverIndividuals(selectedFourIndis); //select 4 indi and crossover and multiply to 100
            selectedFourIndis2 = new Vector<TreeMap<Integer, Integer>>(selectFourIndividualsafterFirstGeneration(secondGenerationList)); //This doesn't change.

            generationNumber++;
//            selectedFourIndis.clear();
            System.out.println("The distance is : " + graphObject.gettingTotalDistanceFromTableAbstract(selectedFourIndis2.get(0)));
        }

        graphObject.drawFromEdgeListTreeMap(selectedFourIndis2.get(0));

    }


    private TreeMap<Double, TreeMap<Integer, Integer>> crossoverIndividuals(Vector<TreeMap<Integer, Integer>> selectedFourIndis) {


        TreeMap<Double, TreeMap<Integer, Integer>> distanceList = new TreeMap<Double, TreeMap<Integer, Integer>>(); //distance list of the total individuals

        for (int i = 0; i < 4; i++) {
            TreeMap<Integer, Integer> indivi = selectedFourIndis.get(i);
            double indiviDis = graphObject.gettingTotalDistanceFromTableAbstract(indivi);
            distanceList.put(indiviDis, indivi);
        }



        for (int i = 0; i < selectedFourIndis.size(); i++) {
            for (int j = 0; j < selectedFourIndis.size(); j++) {
                if (i != j) {
                    TreeMap<Integer, Integer> first = selectedFourIndis.get(i);  //repetition of first individual
                    TreeMap<Integer, Integer> second = selectedFourIndis.get(j); //repetition of second individual

                    for (int iii = 0; iii < 20; iii++) {

                        TreeMap<Integer, Integer> randomCH = graphObject.randomTreeCycleGenerator();
                        pathConnectorIfitssaperated(randomCH);


                        TreeMap<Integer, Integer> offspring = crossOver(first, randomCH); //crossover need randomisation
                        double offspringDistance = graphObject.gettingTotalDistanceFromTableAbstract(offspring);

                        if (distanceList.containsKey(offspringDistance)) {
                            offspringDistance += 0.001;
                        }
                        distanceList.put(offspringDistance, offspring);
                    }


                    for (int jjj = 0; jjj < 20; jjj++) {

                        TreeMap<Integer, Integer> randomCH = graphObject.randomTreeCycleGenerator();
                        pathConnectorIfitssaperated(randomCH);

                        TreeMap<Integer, Integer> offspring = crossOver(second, randomCH); //crossover need randomisation
                        double offspringDistance = graphObject.gettingTotalDistanceFromTableAbstract(offspring);

                        if (distanceList.containsKey(offspringDistance)) {
                            offspringDistance += 0.001;
                        }
                        distanceList.put(offspringDistance, offspring);
                    }

                }
            }

        }


        return distanceList;


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

        // alwaysPairofArrows(mixedIndi); //'pathConnector' works it will be ok

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
        PathDrawerIfSubgraphExist pathChecker = null;
        try {
            if (edgelist.containsValue(-1)) {
                System.out.println("ops");
            }

            pathChecker = new PathDrawerIfSubgraphExist(edgelist);


            edgelist = pathChecker.getEdgelist();

        } catch (Exception e) {


            System.out.println("There are " + pathChecker.getHowmanyCycles() + " cycles");
        }




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

        if (valueList.size() > 1) {
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

    public Vector<TreeMap<Integer, Integer>> selectFourIndividuals(TreeMap<Double, ConcurrentHashMap<Integer, Integer>> firstGeneration) {

        int fourTimes = 0;
        Vector<ConcurrentHashMap<Integer, Integer>> selectedIndividualsHash = new Vector<ConcurrentHashMap<Integer, Integer>>();
        for (double path : firstGeneration.keySet()) {
            selectedIndividualsHash.add(firstGeneration.get(path));

            fourTimes++;
            if (fourTimes > 3) break;
        }

        Vector<TreeMap<Integer, Integer>> selectedIndividuals = new Vector<TreeMap<Integer, Integer>>();
        for (int i = 0; i < selectedIndividualsHash.size(); i++) {
            selectedIndividuals.add(hashmapSort(selectedIndividualsHash.get(i)));

        }
        return selectedIndividuals;
    }

    public Vector<TreeMap<Integer, Integer>> selectFourIndividualsafterFirstGeneration(TreeMap<Double, TreeMap<Integer, Integer>> generation) {



        Vector<TreeMap<Integer, Integer>> selectedIndividuals = new Vector<TreeMap<Integer, Integer>>();

        int onlyFourIteration = 0;
        for (double gener : generation.keySet()) {
            TreeMap<Integer, Integer> individual = generation.get(gener);
            selectedIndividuals.add(individual);
            onlyFourIteration++;
            if (onlyFourIteration == 4) {
                break;
            }
        }
        return selectedIndividuals;
    }

    public TreeMap<Double, ConcurrentHashMap<Integer, Integer>> produceAhundredIndividuals() {

        ProduceIndividualsThread threadArray[] = new ProduceIndividualsThread[100];
        ConcurrentHashMap<Double, ConcurrentHashMap<Integer, Integer>> distanceList = new ConcurrentHashMap<Double, ConcurrentHashMap<Integer, Integer>>();

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

package Algorithm;

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
        Vector<ConcurrentHashMap<Integer, Integer>> selectedFourIndis = selectFourIndividuals(firstGeneration);

        ConcurrentHashMap<Integer, Integer> off = crossOver(selectedFourIndis.get(0), selectedFourIndis.get(1));
        graphObject.drawFromEdgeList(off);

    }

    public ConcurrentHashMap<Integer, Integer> crossOver(ConcurrentHashMap<Integer, Integer> firstIndi, ConcurrentHashMap<Integer, Integer> secondIndi) {

        int halfSize = 0;

        if (firstIndi.size() % 2 == 0) {
            halfSize = firstIndi.size() / 2;
        } else {
            halfSize = (firstIndi.size() - 1) / 2;
        }

        ConcurrentHashMap<Integer, Integer> mixedIndi = new ConcurrentHashMap<Integer, Integer>();

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

        mixedIndi = removingRepeatPartsANDrandomisingArrangement(mixedIndi);

        pathConnectorIfitssaperated(mixedIndi);

        return mixedIndi;

    }

    public static void pathConnectorIfitssaperated(ConcurrentHashMap<Integer, Integer> edgelist) {

        for (int oneByone : edgelist.keySet()) {
            edgelist.get(oneByone);
        }

    }

    public ConcurrentHashMap<Integer, Integer> removingRepeatPartsANDrandomisingArrangement(ConcurrentHashMap<Integer, Integer> edgeliNotaPath) {

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


        edgeListModifierToMakePath(edgeliNotaPath, nonExistiveValueList);


        return edgeliNotaPath;
    }

    public static void edgeListModifierToMakePath(ConcurrentHashMap<Integer, Integer> edgeliNotaPath, Vector<Integer> nonExistiveValueList) {
        for (int oneByOne : edgeliNotaPath.keySet()) {
            if (edgeliNotaPath.get(oneByOne) == -1) { // if a key is found with a value with -1
                if (oneByOne != nonExistiveValueList.get(0)) {
                    try {
                        edgeliNotaPath.put(oneByOne, nonExistiveValueList.get(0));

                        nonExistiveValueList.remove(0);
                    } catch (NullPointerException e) {
                    }
                } else {


                    boolean notTheSameValue = true;
                    while (notTheSameValue) {
                        Random randomN = new Random();
                        int rNumber = randomN.nextInt(edgeliNotaPath.size());


                        if (oneByOne != rNumber) {
                            int temp = edgeliNotaPath.get(rNumber);
                            //int temp2 = edgeliNotaPath.get(oneByOne);

                            edgeliNotaPath.put(rNumber, oneByOne);
                            edgeliNotaPath.put(oneByOne, temp);
                            notTheSameValue = false;
                        }


                    }
                }
            }
        }
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

    public Vector<ConcurrentHashMap<Integer, Integer>> selectFourIndividuals(TreeMap<Double, ConcurrentHashMap<Integer, Integer>> firstGeneration) {

        int fourTimes = 0;
        Vector<ConcurrentHashMap<Integer, Integer>> selectedIndividuals = new Vector<ConcurrentHashMap<Integer, Integer>>();
        for (double path : firstGeneration.keySet()) {
            selectedIndividuals.add(firstGeneration.get(path));

            fourTimes++;
            if (fourTimes > 3) break;
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

}

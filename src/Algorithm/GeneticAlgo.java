package Algorithm;

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
        Vector<ConcurrentHashMap<Integer, Integer>> selectedFourIndis = selectFourIndividuals(firstGeneration);

        ConcurrentHashMap<Integer, Integer> off = crossOver(selectedFourIndis.get(0), selectedFourIndis.get(1));

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

        return mixedIndi;

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


        return edgeliNotaPath;
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

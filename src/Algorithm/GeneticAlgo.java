package Algorithm;

import Algorithm.GeneticAlgorithm.ProduceIndividualsThread;
import Graph.GraphGenerator;
import Graph.edgeColors;

import java.util.HashMap;
import java.util.TreeMap;
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
        produceAhundredIndividuals();

    }


    public void produceAhundredIndividuals() {

        ProduceIndividualsThread threadArray[] = new ProduceIndividualsThread[100];
        ConcurrentHashMap<Double, HashMap<Integer, Integer>> distanceList = new ConcurrentHashMap<Double, HashMap<Integer, Integer>>();

        for (int i = 0; i < 100; i++) {
            threadArray[i] = new ProduceIndividualsThread(graphObject);
            threadArray[i].start();

            try {
                threadArray[i].join();
                distanceList.put(threadArray[i].graphObject.findTotalDistance(), threadArray[i].graphObject.sourceAndTargetNodeListWithEdges());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        TreeMap<Double, HashMap<Integer, Integer>> sortedDistanceList = new TreeMap<Double, HashMap<Integer, Integer>>();
        sortedDistanceList.putAll(distanceList);





    }

}

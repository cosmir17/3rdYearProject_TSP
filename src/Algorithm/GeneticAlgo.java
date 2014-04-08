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


        TreeMap<Double, TreeMap<Integer, Integer>> firstGeneration = produceAhundredIndividuals();
        Vector<TreeMap<Integer, Integer>> selectedFourIndis = selectFourIndividuals(firstGeneration);

        TreeMap<Double, TreeMap<Integer, Integer>> crossoveredGeneration = CrossoverIndividualsThreadRunner(selectedFourIndis);
        Vector<TreeMap<Integer, Integer>> selectedFourIndis2 = selectFourIndividuals(crossoveredGeneration);

        // graphObject.drawFromEdgeListTreeMap(off);

    }

    private TreeMap<Double, TreeMap<Integer, Integer>> CrossoverIndividualsThreadRunner(Vector<TreeMap<Integer, Integer>> selectedFourIndis) {


        Vector<CrossoverIndividualsThread> threadVector = new Vector<CrossoverIndividualsThread>();
        ConcurrentHashMap<Double, TreeMap<Integer, Integer>> distanceList = new ConcurrentHashMap<Double, TreeMap<Integer, Integer>>();
        int arrayNumber = 0;
        for (int i = 0; i < selectedFourIndis.size(); i++) {
            for (int j = 0; j < selectedFourIndis.size(); j++) {
                if (i != j) {
                    TreeMap<Integer, Integer> first = selectedFourIndis.get(i);
                    TreeMap<Integer, Integer> second = selectedFourIndis.get(j);
                    for (int k = 0; k < 24; k++) {

                        threadVector.add(new CrossoverIndividualsThread(first, second, graphObject));
                        threadVector.get(arrayNumber).start();


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

        TreeMap<Double, TreeMap<Integer, Integer>> sortedDistanceList = new TreeMap<Double, TreeMap<Integer, Integer>>();
        sortedDistanceList.putAll(distanceList);

        for (int i = 0; i < selectedFourIndis.size(); i++) {
            TreeMap<Integer, Integer> edgelistOne = selectedFourIndis.get(i);
            double dis = graphObject.gettingTotalDistanceFromTableAbstract(edgelistOne);

            sortedDistanceList.put(dis, edgelistOne);
        }


        return sortedDistanceList;


    }


    public Vector<TreeMap<Integer, Integer>> selectFourIndividuals(TreeMap<Double, TreeMap<Integer, Integer>> firstGeneration) {

        int fourTimes = 0;
        Vector<TreeMap<Integer, Integer>> selectedIndividuals = new Vector<TreeMap<Integer, Integer>>();
        for (double path : firstGeneration.keySet()) {
            selectedIndividuals.add(firstGeneration.get(path));

            fourTimes++;
            if (fourTimes > 3) break;
        }


        return selectedIndividuals;
    }

    public TreeMap<Double, TreeMap<Integer, Integer>> produceAhundredIndividuals() {

        ProduceIndividualsThread threadArray[] = new ProduceIndividualsThread[100];
        TreeMap<Double, TreeMap<Integer, Integer>> distanceList = new TreeMap<Double, TreeMap<Integer, Integer>>();

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


        TreeMap<Double, TreeMap<Integer, Integer>> sortedDistanceList = new TreeMap<Double, TreeMap<Integer, Integer>>();
        sortedDistanceList.putAll(distanceList);


        return sortedDistanceList;


    }

    public TreeMap<Integer, Integer> hashmapSort(ConcurrentHashMap<Integer, Integer> hashm) {
        TreeMap<Integer, Integer> TreeM = new TreeMap<Integer, Integer>();
        TreeM.putAll(hashm);

        return TreeM;

    }


}

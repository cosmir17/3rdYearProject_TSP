package Algorithm.GeneticAlgorithm;

import Graph.GraphGenerator;

import java.util.TreeMap;

/**
 * Created by lloydp on 04/04/14.
 */
public class ProduceIndividualsThread extends Thread {
    public GraphGenerator graphObject;
    public TreeMap<Integer, Integer> edgelist;
    public double totalDistance = 0;


    public ProduceIndividualsThread(GraphGenerator graphObject) {
        this.graphObject = graphObject;
    }

    public void run() {

        edgelist = graphObject.randomCycleEdgeListGenerator2();

        // graphObject.drawFromEdgeList(edgelist);

        totalDistance = graphObject.gettingTotalDistanceFromTableAbstract(edgelist);


    }


}


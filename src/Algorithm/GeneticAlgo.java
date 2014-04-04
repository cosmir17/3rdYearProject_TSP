package Algorithm;

import Algorithm.GeneticAlgorithm.ProduceIndividualsThread;
import Graph.GraphGenerator;
import Graph.edgeColors;

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


    }

    public void run() {

    }

    public void randomPathDrawer() {

    }

    public void produceAhundredIndividuals() {

        Thread threadArray[] = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threadArray[i] = new ProduceIndividualsThread(graphObject);
            threadArray[i].start();
        }


    }

}

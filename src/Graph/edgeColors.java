package Graph;

/**
 * Created by lloydp on 27/03/14.
 */
public enum edgeColors {


    InsertionAlgo("green"),
    NearestNeighbourAlgo("blue"),
    TwoOptAlgo("red"),
    SimulatedAnnealingAlgo("black"),
    GeneticAlgo("purple");
    private String color;

    private edgeColors(String c) {
        color = c;
    }

    public String getCode() {
        return color;
    }

}

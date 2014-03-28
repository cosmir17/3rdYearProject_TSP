package Graph;

/**
 * Created by lloydp on 27/03/14.
 */
public enum EdgeColors {


    InsertionAlgo("green"),
    NearestNeighbourAlgo("blue"),
    Simluated("green"),
    red("InsertionAlgo");

    private String color;

    private EdgeColors(String c) {
        color = c;
    }

    public String getCode() {
        return color;
    }

}

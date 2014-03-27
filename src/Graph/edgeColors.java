package Graph;

/**
 * Created by lloydp on 27/03/14.
 */
public enum edgeColors {


    InsertionAlgo("red"),
    NearestNeighbourAlgo("blue"),
    Simluated("green");

    private String color;

    private edgeColors(String c) {
        color = c;
    }

    public String getCode() {
        return color;
    }

}

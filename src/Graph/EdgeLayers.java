package Graph;

/**
 * Created by lloydp on 28/03/14.
 */
public enum EdgeLayers {

    InsertionAlgo("InsertionLayer"),
    NearestNeighbourAlgo("NearestLayer"),
    Simluated("simulatedLayer");

    private String layer;

    private EdgeLayers(String c) {
        layer = c;
    }

    public String getCode() {
        return layer;
    }
}

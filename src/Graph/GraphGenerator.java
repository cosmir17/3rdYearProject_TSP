package Graph; /**
 * Created by lloydp on 13/02/14.
 */

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGraphModel;
import com.mxgraph.model.mxICell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GraphGenerator extends Object implements Cloneable {
    public static mxGraph graph = new mxGraph();
    Object parent = graph.getDefaultParent();
    public Object[] graphNodeArray;
    public EdgeColors color;
    public EdgeLayers layer;
    String colorString = "";

    private mxCell root;
    private mxICell base;
    private mxICell nearestLayer;
    private mxICell insertionLayer;
    private mxGraphModel model;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void finalize() throws IOException {
        try {
            super.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public GraphGenerator() {
        // mxGraph.getCellStyle(graph);
/*
        root = new mxCell();
        layer0 = root.insert(new mxCell());
        layer1 = root.insert(new mxCell());
        graph.getModel() = new mxGraphModel(root);
        graph = new mxGraph(model);
  */
    }

    public void createGraph(int numberOfCity) {
        NodeDataStore nodeArray = new NodeDataStore(numberOfCity);
        graph.removeCells(graphNodeArray, true);
        graph.getModel().beginUpdate();
        this.graphNodeArray = new Object[nodeArray.size()];

        try {
            for (int i = 0; i < nodeArray.size(); i++) {
                graphNodeArray[i] = graph.insertVertex(base, null,
                        nodeArray.returnNodeArrayList().get(i).cityName,
                        nodeArray.returnNodeArrayList().get(i).returnX(),
                        nodeArray.returnNodeArrayList().get(i).returnY(),
                        cityNameStringLengthGetter(nodeArray.returnNodeArrayList().get(i).cityName),
                        15, "ROUNDED");

            }
/*
            Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 30, 15);
            Object v2 = graph.insertVertex(parent, null, "World!", 240, 150, 30, 15);
            graph.insertEdge(parent, null, "Edge", v1, v2);

            Object v3 = graph.insertVertex(parent, null, "Hello", 40, 40, 30, 15, "ROUNDED");
            Object v4 = graph.insertVertex(parent, null, "Hello", 60, 60, 30, 15, "ROUNDED;strokeColor=red;fillColor=green");
            Object v5 = graph.insertVertex(parent, null, "Hello", 80, 80, 30, 20, ";strokeColor=red;fillColor=green");
            Object v6 = graph.insertVertex(parent, null, "Hello", 120, 120, 30, 20, "defaultVertex;fillColor=blue");
            Object v7 = graph.insertVertex(parent, null, "Hello", 120, 120, 30, 20, "");
*/

        } finally {
            graph.getModel().endUpdate();
        }
    }

    public void layoutCreator() {


        mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
        mxFastOrganicLayout organic = new mxFastOrganicLayout(graph);
    }


    public double edgeDrawerFromNodeItoJ(int i, int j) {

        //  System.out.println(color);
        colorString = color.getCode();

        graph.getModel().beginUpdate();

        try {
            graph.insertEdge(nearestLayer, null, distanceFinder(i, j), graphNodeArray[i], graphNodeArray[j],
                    "strokeColor=" + colorString + ";fontColor=" + colorString + "");

            // System.out.println(color);
            return distanceFinder(i, j);
        } finally {
            graph.getModel().endUpdate();
        }


    }

    public double edgeDrawerFromNodeItoJlayer(int i, int j, mxICell layer) {

        //  System.out.println(color);
        colorString = color.getCode();

        graph.getModel().beginUpdate();

        try {
            graph.insertEdge(layer, null, distanceFinder(i, j), graphNodeArray[i], graphNodeArray[j],
                    "strokeColor=" + colorString + ";fontColor=" + colorString + "");

            // System.out.println(color);
            return distanceFinder(i, j);
        } finally {
            graph.getModel().endUpdate();
        }


    }

    public mxGraphComponent componentGetter() {
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        graphComponent.setPreferredSize(new Dimension(910, 530));
        //graphComponent.
        return graphComponent;
        /*
        getContentPane().add(graphComponent);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(500, 520);
        super.setVisible(true);
    */
    }

    private int cityNameStringLengthGetter(String city) {
        if (city.length() < 3) return 25;
        else if (city.length() < 5) return 35;
        else if (city.length() < 8) return 50;
        else if (city.length() < 10) return 60;
        else if (city.length() < 12) return 80;
        else if (city.length() < 14) return 95;
        else return 110;
    }

    public void allEdgeRemover() {


        graph.getModel().beginUpdate();
        try {
            // graph.resetEdges(graphNodeArray);
            Object[] object3 = graph.getAllEdges(graphNodeArray);

            for (Object edge : object3) {
                graph.getModel().remove(edge);
            }

        } finally {
            graph.getModel().endUpdate();
        }

    }

    public void edgeRemoverfromItoJ(int i, int j) {
        graph.getModel().beginUpdate();
        try {
            // graph.resetEdges(graphNodeArray);

            Object[] object3 = graph.getEdgesBetween(graphNodeArray[i], graphNodeArray[j]);

            for (Object edge : object3) {
                graph.getModel().remove(edge);
            }

        } finally {
            graph.getModel().endUpdate();
        }
    }

    public void oneEdgeDrawer() {
        graph.getModel().beginUpdate();
        try {
            graph.insertEdge(parent, null, "", graphNodeArray[9], graphNodeArray[10]);


        } finally {
            graph.getModel().endUpdate();
        }

    }


    public double distanceFinder(int i, int j) {
        mxCell ithNode = (mxCell) graphNodeArray[i];
        mxCell jthNode = (mxCell) graphNodeArray[j];

        // System.out.println(ithNode.getValue());
        // System.out.println(jthNode.getValue());

        int horizontalDistance = (int) (ithNode.getGeometry().getX() - jthNode.getGeometry().getX());
        int verticalDistance = (int) (ithNode.getGeometry().getY() - jthNode.getGeometry().getY());

        double distance = Math.sqrt((horizontalDistance * horizontalDistance) + (verticalDistance * verticalDistance));

        return Math.round(distance);
    }

    public Map.Entry<Double, Integer> getIndexofClosesetNodefromIwithDistance(int i) {
        Map.Entry<Double, Integer> thClosestElementfromI = distanceTableCreatorFromNodei(i).firstEntry();
        return thClosestElementfromI;
    }

    public XYcoordinate findingTheMiddlePoint(int i, int j) {
        mxCell ithNode = (mxCell) graphNodeArray[i];
        mxCell jthNode = (mxCell) graphNodeArray[j];


        int horiDisHalf = (int) ((ithNode.getGeometry().getX() - jthNode.getGeometry().getX()) / 2);
        int vertDisHalf = (int) ((ithNode.getGeometry().getY() - jthNode.getGeometry().getY()) / 2);
        double middlePx = 0;
        double middlePy = 0;

        if (ithNode.getGeometry().getX() > jthNode.getGeometry().getX()) {
            middlePx = jthNode.getGeometry().getX() + horiDisHalf;
        } else {
            middlePx = ithNode.getGeometry().getX() + horiDisHalf;
        }

        if (ithNode.getGeometry().getY() > jthNode.getGeometry().getY()) {
            middlePy = jthNode.getGeometry().getY() + vertDisHalf;
        } else {
            middlePy = ithNode.getGeometry().getY() + vertDisHalf;
        }

        XYcoordinate xyC = new XYcoordinate(middlePx, middlePy);

        return xyC;
    }

    public int findingtheClosestNodeFromtheMiddlePointbetweentwoNodes(int i, int j) {

        XYcoordinate middlePo = this.findingTheMiddlePoint(i, j);


        mxCell jthNode = (mxCell) graphNodeArray[j];

        // System.out.println(ithNode.getValue());
        // System.out.println(jthNode.getValue());

        int horizontalDistance = (int) (middlePo.getX() - jthNode.getGeometry().getX());
        int verticalDistance = (int) (middlePo.getY() - jthNode.getGeometry().getY());

        double distance = Math.sqrt((horizontalDistance * horizontalDistance) + (verticalDistance * verticalDistance));

        Map<Double, Integer> distanceTable = new HashMap<Double, Integer>();
        // <distance, node>

        for (int p = 0; p < graphNodeArray.length; p++) {
            mxCell j2thNode = (mxCell) graphNodeArray[p];
            if (i != p && j != p && j2thNode.getEdgeCount() < 1) distanceTable.put(distance, p);


        }

        TreeMap<Double, Integer> sortedDistanceTable = new TreeMap<Double, Integer>();
        sortedDistanceTable.putAll(distanceTable);

        Map.Entry<Double, Integer> thClosestElementfromI = sortedDistanceTable.firstEntry();

        return thClosestElementfromI.getValue();
    }

    public TreeMap<Double, Integer> distanceTableCreatorFromNodei(int i) {
        Map<Double, Integer> distanceTable = new HashMap<Double, Integer>();
        // <distance, node>

        for (int j = 0; j < graphNodeArray.length; j++) {
            mxCell jthNode = (mxCell) graphNodeArray[j];
            if ((!(j == i)) && jthNode.getEdgeCount() < 1) distanceTable.put(this.distanceFinder(i, j), j);
        }

        TreeMap<Double, Integer> sortedDistanceTable = new TreeMap<Double, Integer>();
        sortedDistanceTable.putAll(distanceTable);
        return sortedDistanceTable;
    }

    public int edgeDrawerfromItoNextClosestNode(int i) {
        //System.out.println(i);
        int nodeJ = this.getIndexofClosesetNodefromIwithDistance(i).getValue();
        edgeDrawerFromNodeItoJ(i, nodeJ);
        return nodeJ;
    }

    public double findTotalDistance() {
        double totalDistance = 0;
        Object graphEdges[] = graph.getAllEdges(graphNodeArray);

        for (int i = 0; i < graphEdges.length - 1; i++) {
            mxCell element = (mxCell) graphEdges[i];
            totalDistance += Double.parseDouble(element.getValue().toString());


        }


        return totalDistance;
    }


}
import org.jgraph.JGraph;
import org.jgraph.graph.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: lloydp
 * Date: 20/11/13
 * Time: 18:42
 * To change this template use File | Settings | File Templates.
 */
public class GraphGenerator {
    private final ArrayList<Node> nodeArray;
    private NodeDataStore nodeData;
    private GraphModel model;
    private GraphLayoutCache view;
    private JGraph graph;
    private static final Dimension DEFAULT_SIZE = new Dimension(650, 500);

    public GraphGenerator(NodeDataStore nodeData) {
        this.nodeData = nodeData;
        this.nodeArray = nodeData.returnNodeArrayList();
        this.model = new DefaultGraphModel();
        this.view = new GraphLayoutCache(model, new DefaultCellViewFactory());
        // this.view = new GraphLayoutCache();
        //view.
        this.graph = new JGraph(model, view);
        this.graph.setPreferredSize(DEFAULT_SIZE);
        // graph.setSize(DEFAULT_SIZE);
        // graph.setAutoResizeGraph(true);
        //graph.setsize
        // graph.setGridSize(500);

        graphGenerator();
    }

    public void graphGenerator() {

        DefaultGraphCell[] cells = new DefaultGraphCell[nodeArray.size()];

        DefaultEdge edge = new DefaultEdge();

        for (int i = 0; i < cells.length; i++) {
            cells[i] = createVertex(nodeArray.get(i).cityName, nodeArray.get(i).returnX(), nodeArray.get(i).returnY(), 70, 18, new Color(1f, 0f, 0f, .5f), true);
        }

/*
        edge.setSource(cells[0].getChildAt(0));
        edge.setTarget(cells[1].getChildAt(0));

        GraphConstants.setLineEnd(edge.getAttributes(), GraphConstants.ARROW_CLASSIC);
       GraphConstants.setEndFill(edge.getAttributes(), true);
        cells[2] = edge;
*/

        graph.getGraphLayoutCache().insert(cells);


    }

    public JGraph returnJGraph() {
        return graph;

    }

    public static DefaultGraphCell createVertex(String name, double x, double y, double w, double h, Color bg, boolean raised) {
        DefaultGraphCell cell = new DefaultGraphCell(name);
        //GraphConstants.setBounds(cell.getAttributes(), new Rectangle2D.Double(x, y, w, h));
        GraphConstants.setBounds(cell.getAttributes(), new Rectangle.Double(x, y, w, h));
        if (bg != null) {
            GraphConstants.setGradientColor(cell.getAttributes(), bg);
            GraphConstants.setOpaque(cell.getAttributes(), true);
        }

        if (raised)
            GraphConstants.setBorder(cell.getAttributes(), BorderFactory.createRaisedBevelBorder());

        else {
            GraphConstants.setBorderColor(cell.getAttributes(), Color.black);
        }

        cell.addPort();

        return cell;
    }

}
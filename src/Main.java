import GUI.TSPGui;
import Graph.GraphGenerator;

/**
 * Created with IntelliJ IDEA.
 * User: lloydp
 * Date: 11/10/13
 * Time: 15:58
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {

        // GUI.Testing.GuiForTestingSmallparts gui = new GUI.Testing.GuiForTestingSmallparts(new Graph.Testing.GraphGenerator(4));
        //GUI.TSPGui gui = new GUI.TSPGui();

        //GUI.TSPGui panel = new GUI.TSPGui();
        // Graph.GraphGenerator newGraph = new Graph.GraphGenerator();

        GraphGenerator graphG = new GraphGenerator();
        TSPGui panel = new TSPGui(graphG);

    }

}

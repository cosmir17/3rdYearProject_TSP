/**
 * Created with IntelliJ IDEA.
 * User: lloydp
 * Date: 11/10/13
 * Time: 15:58
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {

        // GuiForTestingSmallparts gui = new GuiForTestingSmallparts(new GraphGenerator(4));
        //TSPGui gui = new TSPGui();

        //TSPGui panel = new TSPGui();
        // NewGraphGenerator newGraph = new NewGraphGenerator();

        NewGraphGenerator graphG = new NewGraphGenerator();
        TSPGui panel = new TSPGui(graphG);

    }

}

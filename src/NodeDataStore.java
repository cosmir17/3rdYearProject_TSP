import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lloydp on 03/02/14.
 */
public class NodeDataStore extends Node {



        private ArrayList<Node> nodeDataStore;
        private int numberOfNodes;

        public NodeDataStore(int numberOfNodes) {
           this.nodeDataStore = new ArrayList<Node>();
            this.numberOfNodes = numberOfNodes;

            CityNameGenerator cityNameArray = new CityNameGenerator();

            for (int i = 0; i < numberOfNodes; i++)
            {
                int x = (int) ((new Random()).nextInt(830));
                int y = (int) ((new Random()).nextInt(480));
                cityName = cityNameArray.returnNameAndDeleteNamefromList();
               Node newNodeObject = new Node(x, y, cityName);
               nodeDataStore.add(newNodeObject);
            }



        }

    public Node getNodeCoordinate(int num)
    {
        return nodeDataStore.get(num);
    }

    public ArrayList<Node> returnNodeArrayList()

    {
       return nodeDataStore;
    }

    public int size() {
        return nodeDataStore.size();
    }


}

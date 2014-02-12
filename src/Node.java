/**
 * Created by lloydp on 03/02/14.
 */
public class Node {
    int x;
    int y;
    String cityName;

    Node()
    {

    }

    public Node(int x, int y, String cityName)
    {
        this.x = x;
        this.y = y;
        this.cityName = cityName;
    }

    public String returnCityName()
    {
       return cityName;
    }

    public int returnX()
    {return x;}

    public int returnY()
    {
        return y;
    }
}

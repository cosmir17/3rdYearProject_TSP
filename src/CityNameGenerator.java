import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by lloydp on 04/02/14.
 */
public class CityNameGenerator {

    private ArrayList<CityName> cityArray;
    private ArrayList<String> cityArrayStringTyped;
    private String cityName2;

    public CityNameGenerator() {
        this.cityArray = new ArrayList<CityName>(Arrays.asList(CityName.values()));
        this.cityArrayStringTyped = new ArrayList<String>();
        for (int i = 0; i < cityArray.size(); i++) {
            cityArrayStringTyped.add(cityArray.get(i).toString());
        }


    }


    public String returnNameAndDeleteNamefromList() {
        ArrayList<String> cityArrayStringTyped2 = cityArrayStringTyped;
        if(cityArrayStringTyped.size()==0)
        {
            cityArrayStringTyped = cityArrayStringTyped2;
            for(int i = 0 ; i < cityArrayStringTyped2.size();i++)
            {
                cityArrayStringTyped.set(i, "2" + cityArrayStringTyped2.get(i));
            }


        }

        int sd =(int) (Math.random() *5000);
        int na = sd % cityArrayStringTyped.size();
        this.cityName2 = cityArrayStringTyped.get(na);
        cityArrayStringTyped.remove(na);
        return cityName2;

    }


}

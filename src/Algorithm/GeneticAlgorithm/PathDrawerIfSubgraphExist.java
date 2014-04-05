package Algorithm.GeneticAlgorithm;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lloydp on 05/04/14.
 */
public class PathDrawerIfSubgraphExist {

    private ConcurrentHashMap<Integer, Integer> edgelist;
    int number;
    private ArrayList<Integer> pathList;
    private ArrayList<Integer> otherPathList;

    public PathDrawerIfSubgraphExist(ConcurrentHashMap<Integer, Integer> edgelist, int number) {
        this.edgelist = edgelist;
        this.number = number;
        pathList = new ArrayList<Integer>();
        runner();
    }


    public ArrayList<Integer> getPathList() {
        return pathList;
    }

    public boolean isItaCompletePath() {
        if (pathList.size() == edgelist.size()) {
            return true;
        } else {
            return false;
        }
    }

    public void runner() {
        try {
            pathChecker(edgelist.size() - 1);
        } catch (NullPointerException e) {
        }

    }

    public int pathChecker(int a) {

        if (number == a && pathList.size() > 0) {
            // System.out.println(howManyRecusion);
            // System.out.println(a);
            return a;

        }


        int b = edgelist.get(a);
        pathList.add(a);
        return pathChecker(b);
    }

    public int howManyPaths() {


    }

    public void pathDrawer() {

    }

}

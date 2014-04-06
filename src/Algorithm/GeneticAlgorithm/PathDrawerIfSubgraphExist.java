package Algorithm.GeneticAlgorithm;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lloydp on 05/04/14.
 */
public class PathDrawerIfSubgraphExist {

    private ConcurrentHashMap<Integer, Integer> edgelist;
    int number;
    int number2;
    private ArrayList<Integer> pathList;
    private ArrayList<Integer> otherPathList;
    private boolean[] numberArray;

    public PathDrawerIfSubgraphExist(ConcurrentHashMap<Integer, Integer> edgelist, int number) {
        this.edgelist = edgelist;
        this.number = number;
        pathList = new ArrayList<Integer>();
        otherPathList = new ArrayList<Integer>();
        numberArray = new boolean[edgelist.size()];

        runner();
    }



    public void runner() {
        try {
            pathChecker(edgelist.size() - 1);
            if (!isItaCompletePath()) {
                otherPathFinder(findaNodeDoesnotBelongtoThePath());
            }
        } catch (NullPointerException e) {
        } catch (StackOverflowError e) {
            System.out.println("stackOverFlow");
        }

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

    public int findaNodeDoesnotBelongtoThePath() {


        for (int i = 0; i < pathList.size(); i++) {
            numberArray[pathList.get(i)] = true;
        }

        ArrayList<Integer> otherPathList = new ArrayList<Integer>();

        for (int i = 0; i < numberArray.length; i++) {
            if (numberArray[i] == false) {
                number2++;
                otherPathList.add(i);

            }

        }

        return otherPathList.get(0);
    }


    public int otherPathFinder(int c) {
        if (findaNodeDoesnotBelongtoThePath() == c && otherPathList.size() > 0) {
            // System.out.println(howManyRecusion);
            // System.out.println(a);
            return c;

        }


        int d = edgelist.get(c);
        otherPathList.add(c);
        return otherPathFinder(d);
    }

    public ConcurrentHashMap<Integer, Integer> pathDrawer() {


        int originalPathNodei = pathList.get(0);


        int subGraphPathnodei = otherPathList.get(0);


        int temp = edgelist.get(originalPathNodei);
        int temp2 = edgelist.get(subGraphPathnodei);

        edgelist.put(originalPathNodei, temp2);
        edgelist.put(subGraphPathnodei, temp);
        return edgelist;
    }

}

package Algorithm.GeneticAlgorithm;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lloydp on 05/04/14.
 */
public class PathDrawerIfSubgraphExist {

    public TreeMap<Integer, Integer> getEdgelist() {
        return edgelist;
    }

    private TreeMap<Integer, Integer> edgelist;
    int number;
    int number2;
    private ArrayList<Integer> pathList;
    private ArrayList<Integer> otherPathList;
    private boolean[] numberArray;
    private ArrayList<Integer> nodelistChecked;
    private int howmanyCycles;


    public PathDrawerIfSubgraphExist(TreeMap<Integer, Integer> edgelist) {
        this.edgelist = edgelist;
        this.number = edgelist.size() - 1;
        pathList = new ArrayList<Integer>();
        otherPathList = new ArrayList<Integer>();
        numberArray = new boolean[edgelist.size()];
        nodelistChecked = new ArrayList<Integer>();
        howmanyCycles = 0;

        edgelistDuplicator();
        runner();
    }


    private void edgelistDuplicator() {
        for (int i = 0; i < edgelist.size(); i++) {
            nodelistChecked.add(i, -1);
        }

    }

    public int getHowmanyCycles() {
        return howmanyCycles;
    }


    public void runner() {
        findHowmanyCyclesAndNodeListProducer();
        if (howmanyCycles > 1) {
            routeConnector();
        }
    }

    private void routeConnector() {

        boolean ifAllarenotSame = true;
        ConcurrentHashMap<Integer, Integer> tableA = new ConcurrentHashMap<Integer, Integer>();

        for (int i = 0; i < nodelistChecked.size(); i++) {


            tableA.put(nodelistChecked.get(i), i);
        }

        while (ifAllarenotSame) {

            for (int i = 0; i < howmanyCycles - 1; i++) {
                int firstNodeI = tableA.get(i);
                int firstNodeJ = edgelist.get(firstNodeI);

                int secondNodeI = tableA.get(i + 1);
                int secondNodeJ = edgelist.get(secondNodeI);


                edgelist.put(firstNodeI, secondNodeJ);
                edgelist.put(secondNodeI, firstNodeJ);

                for (int j = 0; j < nodelistChecked.size(); j++) {
                    if (nodelistChecked.get(j) == i + 1) {
                        nodelistChecked.set(j, i);
                    }
                }
            }


            int intheSameCycle = 0;
            for (int i = 0; i < nodelistChecked.size(); i++) {

                if (nodelistChecked.get(0) == nodelistChecked.get(i)) {
                    intheSameCycle++;
                }
                if (intheSameCycle == nodelistChecked.size()) {
                    ifAllarenotSame = false;
                }

            }

        }

    }

    private void findHowmanyCyclesAndNodeListProducer() {
        try {
            while (nodelistChecked.contains(-1)) {
                Random randomN = new Random();
                int rNumber = randomN.nextInt(edgelist.size() - 1);

                if (nodelistChecked.get(rNumber) == -1) {
                    pathChecker(rNumber);
                }
            }
        } catch (NullPointerException e) {
        } catch (StackOverflowError e) {
            System.out.println("stackOverFlow");
        }
    }


    /*
      if (!isItaCompletePath()) {
                    otherPathFinder(findaNodeDoesnotBelongtoThePath());
                }
     */

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

        if (nodelistChecked.get(a) > -1) {
            // System.out.println(howManyRecusion);
            // System.out.println(a);
            nodelistChecked.set(a, howmanyCycles);
            howmanyCycles++;
            return a;


        }

        nodelistChecked.set(a, howmanyCycles);
        int b = edgelist.get(a);
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

    public TreeMap<Integer, Integer> pathDrawer() {


        int originalPathNodei = pathList.get(0);


        int subGraphPathnodei = otherPathList.get(0);


        int temp = edgelist.get(originalPathNodei);
        int temp2 = edgelist.get(subGraphPathnodei);

        edgelist.put(originalPathNodei, temp2);
        edgelist.put(subGraphPathnodei, temp);
        return edgelist;
    }

}

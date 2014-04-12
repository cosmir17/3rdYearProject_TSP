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
    TreeMap<Integer, Boolean> cycleNumberandCompleted;
    int howmanyCycles = 0;
    boolean[] numberCheckArray;

    public PathDrawerIfSubgraphExist(TreeMap<Integer, Integer> edgelist) {

        this.edgelist = edgelist;
        this.number = edgelist.size() - 1;
        pathList = new ArrayList<Integer>();
        otherPathList = new ArrayList<Integer>();
        numberArray = new boolean[edgelist.size()];


        cycleNumberandCompleted = new TreeMap<Integer, Boolean>();


        runner();
    }


    private void edgelistDuplicator() {
        nodelistChecked = new ArrayList<Integer>();

        for (int i = 0; i < edgelist.size(); i++) {
            nodelistChecked.add(i, -1);
        }

    }

    public int getHowmanyCycles() {
        return cycleNumberandCompleted.size();
    }


    public void runner() {
        boolean untilThereisonlyCycles = true;

        while (untilThereisonlyCycles) {
            findHowmanyCyclesAndNodeListProducer();
            if (cycleNumberandCompleted.containsValue(false)) {

                disconnectedRouteConnecttoOtherroute();
        }
            findHowmanyCyclesAndNodeListProducer();
            if (!cycleNumberandCompleted.containsValue(false)) {
                untilThereisonlyCycles = false;
            }
        }


        if (cycleNumberandCompleted.size() > 1) {
            routeConnector();
        }
    }

    private void disconnectedRouteConnecttoOtherroute() {
        numberCheckArray = new boolean[edgelist.size()];
        ArrayList<Integer> numbernotused = new ArrayList<Integer>();
        for (int node : edgelist.keySet()) {
            if (edgelist.get(node) > -1) {
                numberCheckArray[edgelist.get(node)] = true;
            }
        }

        for (int i = 0; i < numberCheckArray.length; i++) {
            if (numberCheckArray[i] == false) {
                numbernotused.add(i);
            }
        }


        for (int node : edgelist.keySet()) {
            if (edgelist.get(node) == -1) {
                edgelist.put(node, numbernotused.get(0));
                numbernotused.remove(0);
            }
        }
    }

    private void routeConnector() {

        boolean ifAllarenotSame = true;
        ConcurrentHashMap<Integer, Integer> tableA = new ConcurrentHashMap<Integer, Integer>();

        for (int i = 0; i < nodelistChecked.size(); i++) {


            tableA.put(nodelistChecked.get(i), i);
        }

        while (ifAllarenotSame) {

            for (int i = 0; i < cycleNumberandCompleted.size() - 1; i++) {
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

    private void findHowmanyCyclesAndNodeListProducer() { //this will find how many path is there
        try {

            howmanyCycles = 0;
            cycleNumberandCompleted = new TreeMap<Integer, Boolean>();
            edgelistDuplicator();

            while (nodelistChecked.contains(-1)) {
                Random randomN = new Random();
                int rNumber = randomN.nextInt(edgelist.size());

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
        try {
            if (edgelist.get(a) == -1) {
                nodelistChecked.set(a, howmanyCycles);
                cycleNumberandCompleted.put(howmanyCycles, false);
                howmanyCycles++;
                return a;
            }

            if (nodelistChecked.get(a) > -1) {
                // System.out.println(howManyRecusion);
                // System.out.println(a);
                nodelistChecked.set(a, howmanyCycles);
                cycleNumberandCompleted.put(howmanyCycles, true);
                howmanyCycles++;


                return a;


    }


            nodelistChecked.set(a, howmanyCycles);
            int b = edgelist.get(a);

            return pathChecker(b);


        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("working fine   " + a);
            System.out.println("array size : " + nodelistChecked.size() + "   'a' value : " + a);
        }

        return 1;
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

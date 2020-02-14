package cn.liboyan.bjuttourguide.travelingsalesman;

import cn.liboyan.bjuttourguide.ds.ArrayList;
import cn.liboyan.bjuttourguide.ds.GraphMatrix;
import cn.liboyan.bjuttourguide.ds.Vertex;

import java.io.PrintStream;

/*
 * 旅行商问题主类
 * @author liboyan
 */
public class TravelingSalesman {
    public int[] path;
    public int[][] matrix;
    public int vertexNum;
    public int distance;

    public TravelingSalesman(int vertexNum) {
        this.vertexNum = vertexNum;
        path = new int[vertexNum];
        matrix = new int[vertexNum][vertexNum];
    }

    public void solve(GraphMatrix mapAll, ArrayList<Vertex> v) {
        // Build matrix
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                matrix[i][j] = mapAll.matrix[i][j];
            }
        }
    }

    /**
     * Output the Path after Solve
     */
    public void print() {
        for (int i = 0; i < vertexNum; i++) {
            System.out.print(path[i] + "\t");
        }
        System.out.println(path[0]);
        System.out.println("Distance: " + distance);
    }

    /**
     * Generate the Output Array
     * @return arrayList
     */
    public ArrayList<Integer> output() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < vertexNum; i++) {
            arrayList.add(path[i]);
        }
        return arrayList;
    }

    /**
     * Get Vertex's Index by ID
     * @param p
     * @return index
     */
    private int getIndexById(int p) {
        for (int i = 0; i < vertexNum; i++) {
            if (p == path[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Get Weight from from to to
     * @param from
     * @param to
     * @return weight
     */
    private double getWeight(int from, int to) {
        return matrix[from][to];
    }

    /**
     * Calculate Traveling Time
     * @param durTime
     * @param startTime
     * @param totalTime
     */
    public void calcTime(ArrayList<Integer> durTime, int startTime, ArrayList<Integer> totalTime) {
        // totalTime: 到达当前位置的时间
        System.out.println("========= Calculate Travelling Time ========");
        int currentTime = startTime;
        if (path.length > 0) {
            totalTime.setData(0, currentTime);
            for (int i = 1; i < path.length; i++) {
                currentTime = totalTime.getData(i - 1) + durTime.getData(i - 1) + (int) (getWeight(getIndexById(path[i - 1]), getIndexById(path[i])) / 60 + 0.5);
                totalTime.setData(i, currentTime);
            }
            totalTime.setData(path.length, totalTime.getData(path.length - 1) + durTime.getData(path.length - 1) + (int) (getWeight(getIndexById(path[path.length - 1]), getIndexById(path[0])) / 60 + 0.5));

        }
    }

    /**
     * Organize the Output Text, to Text or to Console
     * @param ps: PrintStream
     * @param DurTime
     * @param startTime
     * @param TotalTime
     * @param v
     */
    public void getOutput(PrintStream ps, ArrayList<Integer> DurTime, int startTime, ArrayList<Integer> TotalTime, ArrayList<Vertex> v) {
        System.setOut(ps);
        int currentTime = startTime;
        if (path.length > 0) {
            System.out.println("Place 1, " + getNameById(v, path[0]) + ": ");
            System.out.printf("Start Time: %02d:%02d\n", currentTime / 60, currentTime % 60);
            System.out.println("Duration Time: " + DurTime.getData(0));
            System.out.println();
            for (int i = 1; i < path.length; i++) {
                currentTime = TotalTime.getData(i);
                System.out.println("Place " + (i + 1) + ", " + getNameById(v, path[i]) + ": ");
                System.out.println("Travelling Time: " + (int) (getWeight(getIndexById(path[i - 1]), getIndexById(path[i])) / 60 + 0.5) + "min");
                System.out.println("Travelling Distance: " + getWeight(getIndexById(path[i - 1]), getIndexById(path[i])) + "m");
                System.out.printf("Arrived Time: %02d:%02d\n", currentTime / 60, currentTime % 60);
                System.out.println("Duration Time: " + DurTime.getData(i) + "min");
                currentTime += DurTime.getData(i);
                System.out.printf("Departure Time: %02d:%02d\n", currentTime / 60, currentTime % 60);
                System.out.println();
            }
            System.out.println("Back to Place 1, " + getNameById(v, path[0]) + "...");
            System.out.printf("Final Arrived Time: %02d:%02d\n", TotalTime.getData(path.length) / 60, TotalTime.getData(path.length) % 60);
        }
    }

    /**
     * Get Vertex's Name by ID
     * @param v
     * @param id
     * @return Name
     */
    private String getNameById(ArrayList<Vertex> v, int id) {
        for (int i = 0; i < v.getLength(); i++) {
            if (v.getData(i).getId() == id) {
                return v.getData(i).getName();
            }
        }
        return null;
    }
}
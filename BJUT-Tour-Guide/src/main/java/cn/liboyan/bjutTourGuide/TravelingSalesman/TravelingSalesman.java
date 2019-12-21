package cn.liboyan.bjutTourGuide.TravelingSalesman;

import cn.liboyan.bjutTourGuide.BJUTTourGuide;
import cn.liboyan.bjutTourGuide.ds.ArrayList;
import cn.liboyan.bjutTourGuide.ds.GraphMatrix;
import cn.liboyan.bjutTourGuide.ds.Vertex;

import java.io.PrintStream;

/*
 * 旅行商问题主类
 */
public class TravelingSalesman {
    public int[] path;
    public int[][] matrix;
    public int vertexNum;
    public int distance;

    public TravelingSalesman(int _vertexNum) {
        vertexNum = _vertexNum;
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

    public void print() {
        for (int i = 0; i < vertexNum; i++) {
            System.out.print(path[i] + "\t");
        }
        System.out.println(path[0]);
        System.out.println("Distance: " + distance);
    }

    public ArrayList<Integer> output() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < vertexNum; i++) {
            arrayList.add(path[i]);
        }
        return arrayList;
    }

    private int getIndexById(int p) {
        for (int i = 0; i < vertexNum; i++) {
            if (p == path[i]) {
                return i;
            }
        }
        return -1;
    }

    private double getWeight(int from, int to) {
        return matrix[from][to];
    }

    public void calcTime(ArrayList<Integer> DurTime, int startTime, ArrayList<Integer> TotalTime) {
        // totalTime: 到达当前位置的时间
        System.out.println("========= Calculate Travelling Time ========");
        int currentTime = startTime;
        if (path.length > 0) {
            TotalTime.setData(0, currentTime);
            for (int i = 1; i < path.length; i++) {
                currentTime = TotalTime.getData(i - 1) + DurTime.getData(i - 1) + (int) (getWeight(getIndexById(path[i - 1]), getIndexById(path[i])) / 60 + 0.5);
                TotalTime.setData(i, currentTime);
            }
            TotalTime.setData(path.length, TotalTime.getData(path.length - 1) + DurTime.getData(path.length - 1) + (int) (getWeight(getIndexById(path[path.length - 1]), getIndexById(path[0])) / 60 + 0.5));

        }
    }

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

    private String getNameById(ArrayList<Vertex> v, int id) {
        for (int i = 0; i < v.getLength(); i++) {
            if (v.getData(i).getId() == id) {
                return v.getData(i).getName();
            }
        }
        return null;
    }
}
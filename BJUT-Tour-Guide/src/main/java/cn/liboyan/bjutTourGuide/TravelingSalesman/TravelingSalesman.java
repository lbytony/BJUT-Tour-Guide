package cn.liboyan.bjutTourGuide.TravelingSalesman;

import cn.liboyan.bjutTourGuide.BJUTTourGuide;
import cn.liboyan.bjutTourGuide.ds.ArrayList;
import cn.liboyan.bjutTourGuide.ds.GraphMatrix;
import cn.liboyan.bjutTourGuide.ds.Vertex;

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

    public double getWeight(int from, int to) {
        return matrix[from][to];
    }

    public void calcTime(ArrayList<Integer> DurTime, int startTime) {
        // totalTime: 到达当前位置的时间
        System.out.println("========= Calculate Travelling Time ========");
        ArrayList<Integer> totalTime = new ArrayList<>(DurTime.getLength() + 1);
        int currentTime = startTime;
        if (path.length > 0) {
            System.out.println("Path 0: ");
            totalTime.setData(0, currentTime);
            System.out.printf("Start Time: %02d:%02d\n\n", currentTime / 60, currentTime % 60);
            System.out.println("Duration Time: " + DurTime.getData(0));
            for (int i = 1; i < path.length; i++) {
                // TODO
                System.out.println("Path " + i + ": ");
                currentTime = totalTime.getData(i-1) + DurTime.getData(i-1) + (int)(getWeight(getIndexById(path[i-1]), getIndexById(path[i])) / 60 + 0.5);
                totalTime.setData(i, currentTime);
                System.out.printf("Arrived Time: %02d:%02d\n", currentTime / 60, currentTime % 60);
                System.out.println("Travelling To Dst Time: " + (int)(getWeight(getIndexById(path[i-1]), getIndexById(path[i])) / 60 + 0.5));
                System.out.println("Travelling Distance: " + getWeight(getIndexById(path[i-1]), getIndexById(path[i])));
                System.out.println("Duration Time: " + DurTime.getData(i));
                System.out.println();
            }
            totalTime.setData(path.length, totalTime.getData(path.length-1) + DurTime.getData(path.length-1) + (int)(getWeight(getIndexById(path[path.length - 1]), getIndexById(path[0])) / 60 + 0.5));
            System.out.printf("Final Arrived Time: %02d:%02d\n", totalTime.getData(path.length) / 60, totalTime.getData(path.length) % 60);
        }
    }
}
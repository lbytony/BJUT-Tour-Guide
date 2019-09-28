package cn.liboyan.bjutTourGuide;

import cn.liboyan.bjutTourGuide.ds.ArrayList;
import cn.liboyan.bjutTourGuide.ds.GraphMatrix;
import cn.liboyan.bjutTourGuide.ds.Vertex;

public class TravelingSalesmanGreedy {
    public static int[] path;
    public static boolean[] visited;
    public static int[][] matrix;
    public static int vertexNum;
    public static int distance;

    public static void solve(GraphMatrix map, ArrayList<Vertex> v, int pointNum) {
        vertexNum = v.getLength();
        path = new int[pointNum];
        visited = new boolean[vertexNum];
        matrix = new int[vertexNum][vertexNum];
        // Build matrix
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                matrix[i][j] = map.matrix[v.getData(i).getId()][v.getData(j).getId()];
            }
        }
        int k = 0;
//        System.out.println(vertexNum);
        path[k] = v.getData(k).getId();
        visited[k] = true;
        int next = k + 1;
        int count = 1;
        while (count < pointNum) {
            int min = (int) Double.MAX_VALUE;
            for (int i = 0; i < pointNum; i++) {
                if (visited[i] == false) {
                    if (matrix[k][i] < min) {
                        min = matrix[k][i];
                        next = i;

                    }
                }
            }
            distance += min;
            if (v.getData(next).getPointType() == 1) {
                path[count] = v.getData(next).getId();
            }
            visited[next] = true;
            k = next;
            next = k + 1;
            count++;
        }
        distance += matrix[vertexNum - 1][0];
        // Output
        for (int i = 0; i < pointNum; i++) {
            System.out.print(path[i] + "\t");
        }
        System.out.println(path[0]);
        System.out.println("Distance: " + distance);
    }
}

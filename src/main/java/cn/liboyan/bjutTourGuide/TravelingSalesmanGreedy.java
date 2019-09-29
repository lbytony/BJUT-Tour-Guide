package cn.liboyan.bjutTourGuide;

import cn.liboyan.bjutTourGuide.ds.ArrayList;
import cn.liboyan.bjutTourGuide.ds.GraphMatrix;
import cn.liboyan.bjutTourGuide.ds.Vertex;

public class TravelingSalesmanGreedy {
    public int[] path;
    public boolean[] visited;
    public int[][] matrix;
    public int vertexNum;
    public int distance;
//    public GraphMatrix mapAll;
    public ArrayList<Vertex> v;

    public TravelingSalesmanGreedy(int vertexNumAll) {
        path = new int[vertexNumAll];
        visited = new boolean[vertexNumAll];
        matrix = new int[vertexNumAll][vertexNumAll];
    }

    public void solve(GraphMatrix mapAll, ArrayList<Vertex> v, int _vertexNum) {
        vertexNum = _vertexNum;
        // Build matrix
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                matrix[i][j] = mapAll.matrix[v.getData(i).getId()][v.getData(j).getId()];
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        int k = 0;
        path[k] = v.getData(k).getId();
        visited[k] = true;
        int next = k + 1;
        int count = 1;
        while (count < vertexNum) {
            int min = (int) Double.MAX_VALUE;
            for (int i = 0; i < vertexNum; i++) {
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
    }

    public void print() {
        for (int i = 0; i < vertexNum; i++) {
            System.out.print(path[i] + "\t");
        }
        System.out.println(path[0]);
        System.out.println("Distance: " + distance);
    }
}

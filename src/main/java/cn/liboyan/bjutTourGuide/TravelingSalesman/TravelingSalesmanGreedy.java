package cn.liboyan.bjutTourGuide.TravelingSalesman;

import cn.liboyan.bjutTourGuide.ds.ArrayList;
import cn.liboyan.bjutTourGuide.ds.GraphMatrix;
import cn.liboyan.bjutTourGuide.ds.Vertex;

public class TravelingSalesmanGreedy extends TravelingSalesman {
    public boolean[] visited;

    public TravelingSalesmanGreedy(int _vertexNum) {
        super(_vertexNum);
        visited = new boolean[vertexNum];
    }

    public void solve(GraphMatrix mapAll, ArrayList<Vertex> v) {
        // Build matrix
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                matrix[i][j] = mapAll.matrix[i][j];
            }
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
        distance += matrix[k][0];
    }
}
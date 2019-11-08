package cn.liboyan.bjutTourGuide.TravelingSalesman;

import cn.liboyan.bjutTourGuide.ds.ArrayList;
import cn.liboyan.bjutTourGuide.ds.GraphMatrix;
import cn.liboyan.bjutTourGuide.ds.Vertex;

public class TravelingSalesmanDynamic extends TravelingSalesman {
    public TravelingSalesmanDynamic(int _vertexNum) {
        super(_vertexNum);
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


/*

        for (int j = 1; j < 1 << (vertexNum - 1); j++) {
            for (int i = 1; i < vertexNum; i++) {
                if (((1 << (i - 1)) & j) == 0) {
                    minDis = 60000;
                    for (int k = 1; k < vertexNum; k++) {
                        if (((1 << (k - 1)) & j) != 0) {

                            temp = dis[i][k] + d[k][j - (1 << (k - 1))];
                            if (temp < minDis) {
                                minDis = temp;
                            }
                        }
                    }
                }
                d[i][j] = minDis;
            }
        }
        minDis = 60000;
        for (int k = 1; k < vertexNum; k++) {
            temp = dis[0][k] + d[k][((1 << (vertexNum - 1)) - 1) - (1 << (k - 1))];
            if (minDis > temp) {
                minDis = temp;
            }
        }
        d[0][(1 << (vertexNum - 1)) - 1] = minDis;
        cout << d[0][(1 << (vertexNum - 1)) - 1];*/
    }
}


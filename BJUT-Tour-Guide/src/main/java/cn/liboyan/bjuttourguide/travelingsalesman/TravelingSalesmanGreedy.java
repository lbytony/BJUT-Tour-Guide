package cn.liboyan.bjuttourguide.travelingsalesman;

import cn.liboyan.bjuttourguide.ds.ArrayList;
import cn.liboyan.bjuttourguide.ds.GraphMatrix;
import cn.liboyan.bjuttourguide.ds.Vertex;

public class TravelingSalesmanGreedy extends TravelingSalesman {
    private boolean[] visited;

    /**
     * Generator of the TSP
     * @param vertexNum
     */
    public TravelingSalesmanGreedy(int vertexNum) {
        super(vertexNum);
        visited = new boolean[vertexNum];
    }

    /**
     * Solve the TSP
     * @param mapAll
     * @param v
     */
    @Override
    public void solve(GraphMatrix mapAll, ArrayList<Vertex> v) {
        super.solve(mapAll, v);
        int k = 0;
        path[k] = v.getData(k).getId();
        visited[k] = true;
        int next = k + 1;
        int count = 1;
        while (count < vertexNum) {
            int min = (int) Double.MAX_VALUE;
            for (int i = 0; i < vertexNum; i++) {
                if (!visited[i]) {
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
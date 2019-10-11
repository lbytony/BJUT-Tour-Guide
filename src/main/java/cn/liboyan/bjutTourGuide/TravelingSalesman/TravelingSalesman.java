package cn.liboyan.bjutTourGuide.TravelingSalesman;

public class TravelingSalesman {
    public int[] path;
    public boolean[] visited;
    public int[][] matrix;
    public int vertexNum;
    public int distance;

    public TravelingSalesman(int _vertexNum) {
        vertexNum = _vertexNum;
        path = new int[vertexNum];
        visited = new boolean[vertexNum];
        matrix = new int[vertexNum][vertexNum];
    }

    public void print() {
        for (int i = 0; i < vertexNum; i++) {
            System.out.print(path[i] + "\t");
        }
        System.out.println(path[0]);
        System.out.println("Distance: " + distance);
    }
}

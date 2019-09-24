package cn.liboyan.bjutTourGuide;

import cn.liboyan.bjutTourGuide.ds.Edge;
import cn.liboyan.bjutTourGuide.ds.GraphMatrix;
import cn.liboyan.bjutTourGuide.ds.LinkedList;
import cn.liboyan.bjutTourGuide.ds.Vertex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJUTTourGuide {
    private static int vertexNum = 100;
    private static int edgeNum = 100;

    public static GraphMatrix readMapData(String vertexFile, String edgeFile) throws IOException {
        GraphMatrix map = null;
        String temp = new String();
        // Load Vertex Data
        BufferedReader vertex = new BufferedReader(new InputStreamReader(new FileInputStream(vertexFile)));
        Vertex[] v = new Vertex[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            // 读取一行数据
            temp = vertex.readLine();
            // 字符分割
            String[] col = temp.split(" ");
            int id, pointType, pointPosition;
            String name;
            id = Integer.valueOf(col[0]);
            name = col[1];
            pointType = Integer.valueOf(col[2]);
            pointPosition = Integer.valueOf(col[3]);
            v[i] = new Vertex(id, name, pointType, pointPosition);
        }
        // Load Edge Data
        BufferedReader edge = new BufferedReader(new InputStreamReader(new FileInputStream(edgeFile)));
        Edge[] e = new Edge[edgeNum];
        for (int i = 0; i < edgeNum; i++) {
            // 读取一行数据
            temp = edge.readLine();
            // 字符分割
            String[] col = temp.split(" ");
            int from, to, weight;
            from = Integer.valueOf(col[0]);
            to = Integer.valueOf(col[1]);
            weight = Integer.valueOf(col[2]);
            e[i] = new Edge(from, to, weight);
        }
        map = new GraphMatrix(vertexNum, edgeNum, v, e);
        return map;
    }

    public static LinkedList readVertex() {
        LinkedList list = new LinkedList();

        return list;
    }

    public static void TSP(GraphMatrix map) {

    }

    public static void main(String[] args) {
        try {
            GraphMatrix mapAll = readMapData("src/main/resources/vertex.mapdata", "src/main/resources/edge.mapdata");
        } catch (IOException e) {
            e.printStackTrace();
        }
        LinkedList point = readVertex();
//        int[][] shortestPath = map.Floyd();
        Vertex[] points = null;
        GUI gui = new GUI();
//        gui.
    }
}

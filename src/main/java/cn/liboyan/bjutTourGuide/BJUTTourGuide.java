package cn.liboyan.bjutTourGuide;

import cn.liboyan.bjutTourGuide.ds.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJUTTourGuide {
    private static int vertexNum = 51;
    private static int edgeNum = 61;
    private static GraphMatrix mapAll = null;

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
            String[] col = new String[4];
            col = temp.split(" ");
            // 提取信息
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
            String[] col = new String[3];
            col = temp.split(" ");
            // 提取信息
            int from, to, weight;
            from = Integer.valueOf(col[0]);
            to = Integer.valueOf(col[1]);
            weight = Integer.valueOf(col[2]);
            e[i] = new Edge(from, to, weight);
        }
        map = new GraphMatrix(vertexNum, edgeNum, v, e);
        return map;
    }

    public static ArrayList<Vertex> getVertex() {
        ArrayList<Vertex> list = new ArrayList<Vertex>();

        return list;
    }

    public static GraphMatrix setSubGraph(ArrayList<Vertex> point) {
        int pointNum = point.getCurLen();
        GraphMatrix sub = null;
        sub = new GraphMatrix(vertexNum, edgeNum, point.toArray(), mapAll.edge);
        return sub;
    }
    public static void main(String[] args) {
        try {
            mapAll = readMapData("src/main/resources/vertex.mapdata", "src/main/resources/edge.mapdata");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Vertex> point = getVertex();
        GraphMatrix subMap = setSubGraph(point);
        TravelingSalesman.tspTX(subMap, point.toArray());
        // GUI gui = new GUI();
//        gui.
    }
}

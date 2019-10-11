package cn.liboyan.bjutTourGuide;

import cn.liboyan.bjutTourGuide.TravelingSalesman.TravelingSalesmanGreedy;
import cn.liboyan.bjutTourGuide.ds.ArrayList;
import cn.liboyan.bjutTourGuide.ds.Edge;
import cn.liboyan.bjutTourGuide.ds.GraphMatrix;
import cn.liboyan.bjutTourGuide.ds.Vertex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 北京工业大学校园导游 - 主类
 * @author Li Boyan
 */

public class BJUTTourGuide {
    private static int vertexNum = 51;
    private static int edgeNum = 61;
    private static GraphMatrix mapAll = null;
    public static ArrayList<Vertex> vertices = new ArrayList<Vertex>(vertexNum);
    public static ArrayList<Edge> edges = new ArrayList<Edge>(edgeNum);

    /**
     * Read Map Data From *.mapdata Files
     * @param vertexFile
     * @param edgeFile
     * @return mapAll
     * @throws IOException
     */
    public static GraphMatrix readMapData(String vertexFile, String edgeFile) throws IOException {
        GraphMatrix map = null;
        String temp = new String();
        // Load Vertex Data
        BufferedReader vertex = new BufferedReader(new InputStreamReader(new FileInputStream(vertexFile)));
        for (int i = 0; i < vertexNum; i++) {
            // Read a line
            temp = vertex.readLine();
            // Split chars
            String[] col = new String[4];
            col = temp.split(" ");
            // Extract
            int id, pointType, pointPosition;
            String name;
            id = Integer.valueOf(col[0]);
            name = col[1];
            pointType = Integer.valueOf(col[2]);
            pointPosition = Integer.valueOf(col[3]);
            vertices.add(new Vertex(id, name, pointType, pointPosition));
        }
        vertex.close();
        // Load Edge Data
        BufferedReader edge = new BufferedReader(new InputStreamReader(new FileInputStream(edgeFile)));
        for (int i = 0; i < edgeNum; i++) {
            // Read a line
            temp = edge.readLine();
            // Split chars
            String[] col = new String[3];
            col = temp.split(" ");
            // Extract
            int from, to, weight;
            from = Integer.valueOf(col[0]);
            to = Integer.valueOf(col[1]);
            weight = Integer.valueOf(col[2]);
            edges.add(new Edge(from, to, weight));
        }
        edge.close();
        map = new GraphMatrix(vertexNum, edgeNum, vertices, edges);
        return map;
    }

    /**
     * Read Target Point From GUI
     * @return point
     */
    // TODO
    public static ArrayList<Vertex> getVertex() {
        ArrayList<Vertex> list = new ArrayList<Vertex>();

        return list;
    }

    private static Vertex searchVertexById(int id) {
        for (int i = 0; i < vertexNum; i++) {
            if (id == vertices.getData(i).getId()) {
                return vertices.getData(i);
            }
        }
        return null;
    }

    public static ArrayList<Vertex> toVertexArray(ArrayList<Integer> list) {
        ArrayList<Vertex> v = new ArrayList<Vertex>(list.getLength());
        for (int i = 0; i < list.getLength(); i++) {
            v.add(searchVertexById(list.getData(i)));
        }
        return v;
    }

    public static GraphMatrix setSubGraph(ArrayList<Vertex> point) {
        int pointNum = point.getSize();
        GraphMatrix sub = null;
        sub = new GraphMatrix(vertexNum, edgeNum, point, edges);
        return sub;
    }

    /**
     * Floyd algorithm
     *
     * @param map
     * @return floydResult
     */
    private static int[][] Floyd(GraphMatrix map) {
        int[][] result = new int[vertexNum][3];
        int[][] path = new int[vertexNum][vertexNum];
        final int inf = 10000;
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                path[i][j] = (map.matrix[i][j] == 0) ? inf : map.matrix[i][j];
            }
        }
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                for (int k = 0; k < vertexNum; k++) {
                    if (path[j][k] > path[j][i] + path[i][k]) {
                        path[j][k] = path[j][i] + path[i][k];
                    }
                }
            }
        }
        printMatrix(path, vertexNum, vertexNum);
        for (int i = 0; i < vertexNum; i++) {
            int min = inf, minp = -1;
            for (int j = 0; j < vertexNum; j++) {
                if (min > path[i][j]) {
                    min = path[i][j];
                    minp = j;
                }
            }
            result[i][0] = i;
            result[i][1] = minp;
            result[i][2] = min;
        }
//        printMatrix(result, vertexNum, 3);
        return path;
    }

    private static void printMatrix(int[][] m, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Generate afterFloydGraph
     *
     * @param v
     * @return floydGraph
     */
    public static GraphMatrix toFloydGraph(ArrayList<Vertex> v) {
        int newVertexNum = v.getLength();
        int[][] floydMatrix = Floyd(mapAll);
        int[][] floydVertexMatrix = new int[newVertexNum][newVertexNum];
        for (int i = 0; i < newVertexNum; i++) {
            for (int j = 0; j < newVertexNum; j++) {
                floydVertexMatrix[i][j] = floydMatrix[v.getData(i).getId()][v.getData(j).getId()];
            }
        }
        // Generate new Graph - after Floyd
        int floydEdgeNum = newVertexNum * (newVertexNum - 1) / 2;
        GraphMatrix floydGraph = new GraphMatrix(newVertexNum, floydEdgeNum);
        for (int i = 0; i < newVertexNum; i++) {
            for (int j = 0; j < newVertexNum; j++) {
                floydGraph.matrix[i][j] = floydVertexMatrix[i][j];
                System.out.print(floydVertexMatrix[i][j] + " ");
            }
            System.out.println();
        }
        return floydGraph;
    }

    public static void main(String[] args) throws IOException {
        mapAll = readMapData("src/main/resources/vertex.mapdata", "src/main/resources/edge.mapdata");
        ArrayList<Integer> point = new ArrayList<Integer>(5);
//         FOR REAL
//        point = getVertex();
//         FOR DEBUG
        Integer[] integers = {2, 10, 27, 42, 47};
        for (int i = 0; i < 5; i++) {
            point.add(integers[i]);
        }
        int pointNum = point.getSize();
        ArrayList<Vertex> subVertex = toVertexArray(point);
        GraphMatrix subMap = toFloydGraph(subVertex);
        TravelingSalesmanGreedy ts_g = new TravelingSalesmanGreedy(pointNum);
        ts_g.solve(subMap, subVertex);
        ts_g.print();
//        GUI gui = new GUI();
//        gui.
    }
}

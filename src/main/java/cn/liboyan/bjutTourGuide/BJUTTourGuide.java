package cn.liboyan.bjutTourGuide;

import cn.liboyan.bjutTourGuide.ds.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 北京工业大学校园导游 - 主类
 *
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
     *
     * @param vertexFile
     * @param edgeFile
     * @return mapAll
     * @throws IOException
     */
    private static GraphMatrix readMapData(String vertexFile, String edgeFile) throws IOException {
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
            vertices.setData(i, new Vertex(id, name, pointType, pointPosition));
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
            edges.setData(i, new Edge(from, to, weight));
        }
        edge.close();
        map = new GraphMatrix(vertexNum, edgeNum, vertices, edges);
        return map;
    }

    /**
     * Read Target Point From GUI
     *
     * @return point
     */
    // TODO
    private static ArrayList<Vertex> getVertex() {
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

    private static ArrayList<Vertex> toVertexArray(ArrayList<Integer> list) {
        ArrayList<Vertex> v = new ArrayList<Vertex>(list.getLength());
        for (int i = 0; i < list.getLength(); i++) {
            v.add(searchVertexById(list.getData(i)));
        }
        return v;
    }

    private static GraphMatrix setSubGraph(ArrayList<Vertex> point) {
        int pointNum = point.getSize();
        GraphMatrix sub = null;
        sub = new GraphMatrix(vertexNum, edgeNum, point, edges);
        return sub;
    }

    private static ArrayList<Vertex> addAdjacentPoint(ArrayList<Vertex> src) {
        int len = src.getLength();
        for (int i = 0; i < len; i++) {
            int targetId = src.getData(i).getId();
            for (int j = 0; j < vertexNum; j++) {
                if ((mapAll.matrix[targetId][j] > 0 || mapAll.matrix[j][targetId] > 0) && src.getPos(searchVertexById(j)) == -1) {
                    src.add(searchVertexById(j));
                }
            }
        }
        return src;
    }

    public static void main(String[] args) throws IOException {
        mapAll = readMapData("src/main/resources/vertex.mapdata", "src/main/resources/edge.mapdata");
        ArrayList<Integer> point = new ArrayList<Integer>(5);
        ;
        // FOR REAL
//        point = getVertex();
        //FOR DEBUG
        Integer[] integers = {0, 6, 27, 42, 47};
        for (int i = 0; i < 5; i++) {
            point.add(integers[i]);
        }
        int pointNum = point.getSize();
        ArrayList<Vertex> subVertex = toVertexArray(point);
        subVertex = addAdjacentPoint(subVertex);
        System.out.println(subVertex.getLength());
        TravelingSalesmanGreedy.solve(mapAll, subVertex, pointNum);
//        GUI gui = new GUI();
//        gui.
    }
}

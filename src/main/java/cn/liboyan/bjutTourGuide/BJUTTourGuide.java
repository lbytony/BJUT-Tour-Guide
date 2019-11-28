package cn.liboyan.bjutTourGuide;

import cn.liboyan.bjutTourGuide.TravelingSalesman.*;
import cn.liboyan.bjutTourGuide.ds.*;

import java.io.*;

/**
 * 北京工业大学校园导游 - 主类
 *
 * @author Li Boyan
 */

public class BJUTTourGuide {
    private static int vertexNum = 51;
    private static int edgeNum = 61;
    private static GraphMatrix mapAll = null;
    private static ArrayList<Location> locAll = null;
    private static int startTime = 0;
    private static int endTime = 0;
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
        String temp;
        // Load Vertex Data
        BufferedReader vertex = new BufferedReader(new InputStreamReader(new FileInputStream(vertexFile)));
        for (int i = 0; i < vertexNum; i++) {
            // Read a line
            temp = vertex.readLine();
            // Split chars
            String[] col;
            col = temp.split(" ");
            // Extract
            int id, pointType, pointPosition;
            String name;
            id = Integer.parseInt(col[0]);
            name = col[1];
            pointType = Integer.parseInt(col[2]);
            pointPosition = Integer.parseInt(col[3]);
            vertices.add(new Vertex(id, name, pointType, pointPosition));
        }
        vertex.close();
        // Load Edge Data
        BufferedReader edge = new BufferedReader(new InputStreamReader(new FileInputStream(edgeFile)));
        for (int i = 0; i < edgeNum; i++) {
            // Read a line
            temp = edge.readLine();
            // Split chars
            String[] col;
            col = temp.split(" ");
            // Extract
            int from, to, weight;
            from = Integer.parseInt(col[0]);
            to = Integer.parseInt(col[1]);
            weight = Integer.parseInt(col[2]);
            edges.add(new Edge(from, to, weight));
        }
        edge.close();
        map = new GraphMatrix(vertexNum, edgeNum, vertices, edges);
        return map;
    }

    private static ArrayList<Location> readLocData(String file) throws IOException {
        String temp;
        ArrayList<Location> locAll = new ArrayList<>();
        // Load Vertex Data
        BufferedReader loc = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        for (int i = 0; i < vertexNum; i++) {
            // Read a line
            temp = loc.readLine();
            // Split chars
            String[] col = new String[4];
            col = temp.split("\t");
            // Extract
            int id;
            double latitude, longtitude;
            longtitude = Double.parseDouble(col[0]);
            latitude = Double.parseDouble(col[1]);
            id = Integer.parseInt(col[2]);
            locAll.add(new Location(id, longtitude, latitude));
        }
        loc.close();
        return locAll;
    }

    /**
     * Read Target Point From GUI
     * @return point
     */
    private static ArrayList<Integer> getVertex(GUI gui) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < 12; i++) {
            if (gui.selCheckBox(i).isSelected()) {
                Vertex v = searchVertexByName(gui.selComboBox(i));
                int id = v.getId();
                list.add(id);
                int time = Integer.parseInt(gui.selTextField(i).getText());
                endTime += time;
            }
        }
        return list;
    }

    private static Vertex searchVertexByName(String name) {
        for (int i = 0; i < vertexNum; i++) {
            if (name.equals(vertices.getData(i).getName())) {
                return vertices.getData(i);
            }
        }
        return null;
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
        int[][] path = new int[vertexNum][vertexNum];
        final int inf = 100000;
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
    private static GraphMatrix toFloydGraph(ArrayList<Vertex> v) {
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

    private static void getTime(GUI gui) {
        // Get Start Time
        int hour = Integer.parseInt(gui.hourSelect.getSelectedItem().toString());
        int minute = Integer.parseInt(gui.minuteSelect.getSelectedItem().toString());
        startTime = hour * 60 + minute;
        // Get
    }

    private static void generateOutputFile(String file, ArrayList<Integer> outList) throws FileNotFoundException {
        PrintStream ps = new PrintStream(file);
        System.setOut(ps);
        for (int i = 0; i < outList.getLength(); i++) {
            for (int j = 0; j < locAll.getLength(); j++) {
                if (locAll.getData(j).getId() == outList.getData(i)) {
                    System.out.println(locAll);
                    break;
                }
            }
        }
        PrintStream out = System.out;
    }

    public BJUTTourGuide(GUI gui) throws IOException {
        mapAll = readMapData("src/main/resources/vertex.mapdata", "src/main/resources/edge.mapdata");
        locAll = readLocData("src/main/resources/IdAndLoc.mapdata");
        ArrayList<Integer> point = new ArrayList<>(11);
        getTime(gui);
        endTime = startTime;
        // FOR REAL
        point = getVertex(gui);
        // FOR DEBUG
//        Integer[] integers = {0, 9, 38, 27, 6, 42, 47, 12};
//        for (int i = 0; i < 8; i++) {
//            point.add(integers[i]);
//        }
        int pointNum = point.getLength();
        ArrayList<Vertex> subVertex = toVertexArray(point);
        GraphMatrix subMap = toFloydGraph(subVertex);
        // TSP-贪心算法
        TravelingSalesmanGreedy ts_g = new TravelingSalesmanGreedy(pointNum);
        ts_g.solve(subMap, subVertex);
        ts_g.print();
        ArrayList<Integer> out = ts_g.output();
        // TSP-模拟退火算法
//        TravelingSalesmanSimulatedAnnealing ts_sa = new TravelingSalesmanSimulatedAnnealing(pointNum);
//        ts_sa.solve(subMap, subVertex);
//        ts_sa.print();
        generateOutputFile("out.data", out);
    }
}
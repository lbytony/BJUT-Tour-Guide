package cn.liboyan.bjutTourGuide;

import cn.liboyan.bjutTourGuide.TravelingSalesman.*;
import cn.liboyan.bjutTourGuide.ds.*;

import java.io.*;
import java.util.Objects;

/**
 * 北京工业大学校园导游 - 主类
 * @author Li Boyan
 */

public class BJUTTourGuide {
    private static int vertexNum = 51;
    private static int edgeNum = 61;
    private static GraphMatrix mapAll = null;
    private static ArrayList<Location> locAll = null;
    private static int startTime = 0;
    private static ArrayList<Integer> DurTime = new ArrayList<>(11);
    public static ArrayList<Vertex> vertices = new ArrayList<>(vertexNum);
    public static ArrayList<Edge> edges = new ArrayList<>(edgeNum);

    /**
     * Read Map Data From *.mapdata Files
     * @return mapAll
     * @throws IOException
     */
    private static GraphMatrix readMapData() throws IOException {
        GraphMatrix map = null;
        String temp;
        // Load Vertex Data
        BufferedReader vertex = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/vertex.mapdata")));
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
        BufferedReader edge = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/edge.mapdata")));
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

    /**
     * Read Geolocation Data
     * @return locAll
     */
    private static ArrayList<Location> readLocData() {
        String temp;
        ArrayList<Location> locAll = new ArrayList<>();
        locAll.add(new Location(116.478997, 39.879036, 0));
        locAll.add(new Location(116.478992, 39.878477, 3));
        locAll.add(new Location(116.478917, 39.877740, 6));
        locAll.add(new Location(116.480231, 39.878452, 9));
        locAll.add(new Location(116.481760, 39.878584, 11));
        locAll.add(new Location(116.482098, 39.879308, 12));
        locAll.add(new Location(116.482500, 39.878209, 14));
        locAll.add(new Location(116.481165, 39.875739, 20));
        locAll.add(new Location(116.481293, 39.875200, 21));
        locAll.add(new Location(116.484013, 39.875451, 26));
        locAll.add(new Location(116.477967, 39.874759, 27));
        locAll.add(new Location(116.478815, 39.873351, 30));
        locAll.add(new Location(116.479700, 39.874240, 31));
        locAll.add(new Location(116.480811, 39.873705, 33));
        locAll.add(new Location(116.482243, 39.873804, 35));
        locAll.add(new Location(116.482356, 39.874281, 36));
        locAll.add(new Location(116.484571, 39.874376, 38));
        locAll.add(new Location(116.479663, 39.872832, 39));
        locAll.add(new Location(116.480644, 39.872182, 42));
        locAll.add(new Location(116.482103, 39.872190, 43));
        locAll.add(new Location(116.485955, 39.872898, 47));
        locAll.add(new Location(116.485982, 39.873306, 48));
        locAll.add(new Location(116.486363, 39.873685, 49));
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
                if (v == null) {
                    throw new AssertionError();
                }
                int id = v.getId();
                list.add(id);
                int time = 0;
                try {
                    time = Integer.parseInt(gui.selTextField(i).getText());
                } catch (NumberFormatException ignored) {

                }
                DurTime.add(time);
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
        ArrayList<Vertex> v = new ArrayList<>(list.getLength());
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

    private static void getStartTime(GUI gui) {
        // Get Start Time
        int hour = Integer.parseInt(Objects.requireNonNull(gui.hourSelect.getSelectedItem()).toString());
        int minute = Integer.parseInt(Objects.requireNonNull(gui.minuteSelect.getSelectedItem()).toString());
        startTime = hour * 60 + minute;
        System.out.println(startTime);
    }

    private static void generateOutputFile(ArrayList<Integer> outList) throws FileNotFoundException {
        PrintStream ps = new PrintStream("../MapOnWeb/out.txt");
        System.setOut(ps);
        for (int i = 0; i < outList.getLength(); i++) {
            for (int j = 0; j < locAll.getLength(); j++) {
                if (locAll.getData(j).getId() == outList.getData(i)) {
                    System.out.println(outList.getData(i));
                    System.out.println();
                    break;
                }
            }
        }
        PrintStream out = System.out;
    }

    public static void initialize() {

    }

    public BJUTTourGuide(GUI gui) throws IOException {
        initialize();
        mapAll = readMapData();
        locAll = readLocData();
        ArrayList<Integer> point;
        getStartTime(gui);
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
        ts_g.calcTime(DurTime, startTime);
        ArrayList<Integer> out = ts_g.output();
        // TSP-模拟退火算法
//        TravelingSalesmanSimulatedAnnealing ts_sa = new TravelingSalesmanSimulatedAnnealing(pointNum);
//        ts_sa.solve(subMap, subVertex);
//        ts_sa.print();
        generateOutputFile(out);
        // Show on Browser
        String url = "C:\\Users\\lbyto\\OneDrive\\2019-2020-1\\数据结构课设\\Project\\MapOnWeb\\index.html";
        ConnectWeb.openURL(url);
    }
}
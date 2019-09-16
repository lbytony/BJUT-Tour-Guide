package cn.liboyan.bjutTourGuide;

class Graph {
    public int numVertex, numEdge;
    public int[] visited, inDegree;
    public Vertex[] vertex;
    public Edge[] edge;

    public Graph(int _numVertex, int _numEdge) {
        numVertex = _numVertex;
        numEdge = _numEdge;
        visited = new int[numVertex];
        inDegree = new int[numVertex];
        vertex = new Vertex[numVertex];
        edge = new Edge[numEdge];
    }
}

public class GraphMatrix extends Graph {
    public int[][] matrix;
    public GraphMatrix(int _numVertex, int _numEdge) {
        super(_numVertex, _numEdge);
        matrix = new int[numVertex][numVertex];
    }
    public void setEdge(int from, int to, int weight) {
        if (matrix[from][to] <= 0) {
            matrix[from][to] = weight;
            numEdge++;
            inDegree[to]++;
        }
    }
    public void delEdge(int from, int to) {
        if (matrix[from][to] > 0) {
            numEdge--;
            inDegree[to]--;
        }
        matrix[from][to] = 0;
    }
    public Edge firstEdge(int from) {
        Edge targetEdge = null;
        targetEdge.from = from;
        for (int i = 0; i < numVertex; i++) {
            if (matrix[from][i] != 0) {
                targetEdge.weight = matrix[from][i];
                targetEdge.to = i;
                break;
            }
        }
        return targetEdge;
    }
    public Edge nextEdge(Edge sourceEdge) {
        Edge targetEdge = null;
        int from = sourceEdge.from;
        targetEdge.from = from;
        for (int i = sourceEdge.to+1; i < numVertex; i++) {
            if (matrix[from][i] != 0) {
                targetEdge.weight = matrix[from][i];
                targetEdge.to = i;
                break;
            }
        }
        return targetEdge;
    }
    private void visit(int target) {
        visited[target] = 1;
    }
    private boolean isEdge(Edge e) {
        if (matrix[e.from][e.to] >= 0) {
            return true;
        } else {
            return false;
        }
    }
    private int ToVertices(Edge e) {
        return e.to;
    }

    public void DFS(int from) {
        visit(from);
        for(Edge e = firstEdge(from); isEdge(e); e = nextEdge(e)) {
            if (visited[ToVertices(e)] == 0) {
                DFS(ToVertices(e));
            }
        }
    }
    public int[][] Floyd() {
        int[][] result = new int[numVertex][3];
        int[][] path = matrix;
        final int inf = (int)Double.POSITIVE_INFINITY;
        for (int i = 0; i < numVertex; i++) {
            for (int j = 0; j < numVertex; j++) {
                for (int k = 0; k < numVertex; k++) {
                    if (path[j][k] > path[j][i] + path[i][k]) {
                        path[j][k] = path[j][i] + path[i][k];
                    }
                }
            }
        }
        for (int i = 0; i < numVertex; i++) {
            int min = inf, minp = -1;
            for (int j = 0; j < numVertex; j++) {
                if (min > path[i][j]) {
                    min = path[i][j];
                    minp = j;
                }
            }
            result[i][0] = i;
            result[i][1] = minp;
            result[i][2] = min;
        }
        return result;
    }
}
package cn.liboyan.bjutTourGuide.ds;

class Graph {
    public int numVertex, numEdge;
    public int[] visited, inDegree;

    public Graph(int _numVertex, int _numEdge) {
        numVertex = _numVertex;
        numEdge = _numEdge;
        visited = new int[numVertex];
        inDegree = new int[numVertex];
    }
}


public class GraphMatrix extends Graph {
    public int[][] matrix;

    public GraphMatrix(int _numVertex, int _numEdge) {
        super(_numVertex, _numEdge);
        matrix = new int[numVertex][numVertex];
    }

    public GraphMatrix(int _numVertex, int _numEdge, ArrayList<Vertex> _vertices, ArrayList<Edge> _edges) {
        super(_numVertex, _numEdge);
        matrix = new int[_numVertex][_numVertex];
        for (int i = 0; i < _numEdge; i++) {
            Edge edge1 = _edges.getData(i);
            setEdge(edge1.from, edge1.to, edge1.weight);
        }
    }

    public void setEdge(int from, int to, int weight) {
        if (matrix[from][to] <= 0) {
            matrix[from][to] = matrix[to][from] = weight;
            numEdge++;
            inDegree[to]++;
        }
    }

    public void delEdge(int from, int to) {
        if (matrix[from][to] > 0) {
            numEdge--;
            inDegree[to]--;
        }
        matrix[from][to] = matrix[to][from] = 0;
    }

    public Edge firstEdge(int from) {
        Edge targetEdge = new Edge(0, 0, 0);
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
        Edge targetEdge = new Edge(0, 0, 0);
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

    static int count = 0;
    public void DFS(GraphMatrix G, int from) {
        G.visit(from);
        count++;
        System.out.print(from + " ");
        for (Edge e = G.firstEdge(from); G.isEdge(e); e = G.nextEdge(e)) {
            if (visited[G.ToVertices(e)] == 0) {
                DFS(G, G.ToVertices(e));
            }
            if (count == numVertex) {
                return;
            }
        }
    }

    public void showMatrix() {
        for (int[] matrix : this.matrix) {
            for (int i : matrix) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
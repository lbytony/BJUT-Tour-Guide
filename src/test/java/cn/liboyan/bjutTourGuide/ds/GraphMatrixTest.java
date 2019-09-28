package cn.liboyan.bjutTourGuide.ds;

class GraphMatrixTest {
    public static void main(String[] args) {
        int vertexNum = 5, edgeNum = 10;
        ArrayList<Vertex> v = new ArrayList<Vertex>(vertexNum);
        for (int i = 0; i < vertexNum; i++) {
            v.setData(i, new Vertex(i, Integer.toString(i), 1, 1));
        }
        ArrayList<Edge> e = new ArrayList<Edge>(edgeNum);
        int count = 0;
        for (int i = 0; i < vertexNum; i++) {
            for (int j = i + 1; j < vertexNum; j++) {
                e.setData(i, new Edge(i, j, 10));
                count++;
            }
        }
        GraphMatrix graph = new GraphMatrix(vertexNum, edgeNum, v, e);
        System.out.println("Original Version: ");
        graph.showMatrix();
        System.out.println();
        // Delete edge
        graph.delEdge(1, 3);
        System.out.println("Delete 1 <--> 3: ");
        graph.showMatrix();
        System.out.println();
        // DFS
        System.out.print("DFS Route: ");
        graph.DFS(graph, 0);
    }
}
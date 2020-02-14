package cn.liboyan.bjuttourguide.ds;

/**
 * Edge Class
 * @author liboyan
 */
public class Edge {
    int from, to, weight;
    public Edge() {
        from = -1;
        to = -1;
        weight = 0;
    }
    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

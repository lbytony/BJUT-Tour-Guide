package cn.liboyan.bjutTourGuide;

public class Edge {
    int from, to, weight;
    public Edge() {
        from = -1;
        to = -1;
        weight = 0;
    }
    public Edge(int _from, int _to, int _weight) {
        from = _from;
        to = _to;
        weight = _weight;
    }
}

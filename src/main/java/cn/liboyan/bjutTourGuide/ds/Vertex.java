package cn.liboyan.bjutTourGuide.ds;

/*
 * Point Type:
 *  1: Crossroad    2: Building
 * Point Position:
 *  0: North&MiddlePart 1: SouthPart
 */

public class Vertex {
    private int id = -1;
    private String name = null;
    private int pointType = 0;
    private int pointPosition = -1;

    public Vertex(int _id, String _name, int _pointType, int _pointPosition) {
        id = _id;
        name = _name;
        pointType = _pointType;
        pointPosition = _pointPosition;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPointType() {
        return pointType;
    }

    public int getPointPosition() {
        return pointPosition;
    }
}
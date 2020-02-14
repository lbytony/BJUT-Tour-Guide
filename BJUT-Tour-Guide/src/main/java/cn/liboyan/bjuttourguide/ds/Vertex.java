package cn.liboyan.bjuttourguide.ds;

/*
 * Point Type:
 *  1: Crossroad & Building    2: Crossroad    3: Building
 * Point Position:
 *  0: North & MiddlePart 1: SouthPart
 */

public class Vertex {
    private int id = -1;
    private String name = null;
    private int pointType = 0;
    private int pointPosition = -1;

    public Vertex(int id, String name, int pointType, int pointPosition) {
        this.id = id;
        this.name = name;
        this.pointType = pointType;
        this.pointPosition = pointPosition;
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
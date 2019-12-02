package cn.liboyan.bjutTourGuide.ds;

public class Location {
    private double latitude;
    private double longtitude;
    private int id;

    public Location(double longtitude, double latitude, int id) {
        this.id = id;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + longtitude + " " + latitude;
    }
}

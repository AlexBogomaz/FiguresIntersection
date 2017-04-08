package Shapes;


import Point.Point;

public class Circle extends Shape {
    private Point centre;
    private double r;

    public Circle(Point centr, double r) {
        this.centre = centr;
        this.r = r;
    }

    public Point getCentre() {
        return centre;
    }

    public double getR() {
        return r;
    }


    public static boolean valueSetCheck(double rad) {
        return rad > 0;
    }
}

package Shapes;


import Point.Point;

import java.util.ArrayList;

public class Triangle extends Shape {

    private Point x1y1;
    private Point x2y2;
    private Point x3y3;
    private ArrayList<Line> triangleLine;

    public Triangle(Point x1y1, Point x2y2, Point x3y3) {
        if(!valueSetCheck(x1y1,x2y2,x3y3)) throw new IllegalArgumentException("3 points can't lie in a line");
            this.x1y1 = x1y1;
            this.x2y2 = x2y2;
            this.x3y3 = x3y3;
            setLines();

    }

    private void setLines() {              //Create our lines in right way x1>=x2
        triangleLine = new ArrayList<Line>(3);
        triangleLine.add(x1y1.getX() >= x2y2.getX() ? new Line(x2y2, x1y1) : new Line(x1y1, x2y2));
        triangleLine.add(x2y2.getX() >= x3y3.getX() ? new Line(x3y3, x2y2) : new Line(x2y2, x3y3));
        triangleLine.add(x1y1.getX() >= x3y3.getX() ? new Line(x3y3, x1y1) : new Line(x1y1, x3y3));
    }

    public ArrayList<Line> getLines() {
        return triangleLine;
    }


    public static boolean valueSetCheck(Point p1, Point p2, Point p3) {    // Check If all 3 points lie in a line
        return !p1.equals(p2) && !p2.equals(p3) && !p3.equals(p1)
                && !(p1.getX() == p2.getX() && p1.getX() == p3.getX())
                && !(p1.getX() == p3.getX() && p1.getX() == p2.getX())
                && !(p1.getY() == p2.getY() && p1.getY() == p3.getY())
                && !(p1.getY() == p3.getY() && p1.getY() == p2.getY());
    }
}

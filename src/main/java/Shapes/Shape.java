package Shapes;

import Point.Point;

import java.util.ArrayList;

public abstract class Shape implements Figure {
    public ArrayList<Line> getLines() {
        return null;
    }

    private void setLines() {
    }

    public static boolean valueSetCheck(Point p1, Point p2) {
        return true;
    }

    public static boolean valueSetCheck(Point p1, Point p2, Point p3) {
        return true;
    }

    public static boolean valueSetCheck(double rad) {
        return true;
    }

}

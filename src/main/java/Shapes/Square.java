package Shapes;


import Point.Point;

import java.util.ArrayList;

public class Square extends Shape {
    private Point x1y1;
    private Point x2y2;
    private Point x3y3;
    private Point x4y4;
    private ArrayList<Line> squareLine;


    public Square(Point x1y1, Point x3y3) {
        if(!valueSetCheck(x1y1,x3y3)) throw new IllegalArgumentException("2 points can't lie in one line");
        this.x1y1 = x1y1;
        this.x3y3 = x3y3;
        this.x4y4 = new Point(x3y3.getX(), x1y1.getY());
        this.x2y2 = new Point(x1y1.getX(), x3y3.getY());
        setLines();
    }

    private void setLines() {
        squareLine = new ArrayList<Line>(4);
        squareLine.add(x1y1.getX() >= x2y2.getX() ? new Line(x2y2, x1y1) : new Line(x1y1, x2y2));
        squareLine.add(x2y2.getX() >= x3y3.getX() ? new Line(x3y3, x2y2) : new Line(x2y2, x3y3));
        squareLine.add(x3y3.getX() >= x4y4.getX() ? new Line(x4y4, x3y3) : new Line(x3y3, x4y4));
        squareLine.add(x1y1.getX() >= x4y4.getX() ? new Line(x4y4, x1y1) : new Line(x1y1, x4y4));
    }

    public ArrayList<Line> getLines() {
        return squareLine;
    }


    public static boolean valueSetCheck(Point x1y1, Point x3y3) {
        return x1y1.getX() != x3y3.getX() && x1y1.getY() != x3y3.getY() && !(x1y1.equals(new Point(0, 0)) && x3y3.equals(new Point(0, 0)));
    }

}

package Shapes;

import Point.Point;

public class Line {

    private Point start;
    private Point end;
    private double a, b, c;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        calcA();
        calcB();
        calcC();
    }


    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }


    private void calcA() {
        this.a = this.getStart().getY() - this.getEnd().getY();

    }

    private void calcB() {
        this.b = this.getEnd().getX() - this.getStart().getX();
    }

    private void calcC() {
        this.c = this.getEnd().getY() * this.getStart().getX() - this.getEnd().getX() * this.getStart().getY();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Line)) return false;
        Line line = (Line) obj;
        return this.getStart().equals(line.getStart()) && this.getEnd().equals(line.getEnd());
    }
}

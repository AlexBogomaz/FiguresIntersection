package Intersection;

import Point.Point;
import Shapes.*;


import java.util.ArrayList;


public class Intersection {


    private ArrayList<Point> intersectionCollection = new ArrayList<Point>();


    public Intersection(Shape first, Shape second) {
        if (!(first instanceof Circle) && !(second instanceof Circle))
            intersectionOfLines(first, second);
        if (first instanceof Circle || second instanceof Circle)
            intersectionOfCircle(first, second);
    }


    public ArrayList<Point> getIntersectionCollection() {
        return intersectionCollection;
    }

    private void intersectionOfLines(Shape first, Shape second) {
        if (!coincidenceCheck(first, second)) {
            for (Line lineTmpFirst : first.getLines()) {
                for (Line lineTmpSecond : second.getLines()) {
                    double a1 = lineTmpFirst.getA();
                    double a2 = lineTmpSecond.getA();
                    double b1 = lineTmpFirst.getB();
                    double b2 = lineTmpSecond.getB();
                    double d = a1 * b2 - a2 * b1;
                    if (d != 0) {
                        double c1 = lineTmpFirst.getC();
                        double c2 = lineTmpSecond.getC();
                        double xi = (b1 * c2 - b2 * c1) / d;
                        double yi = (a2 * c1 - a1 * c2) / d;
                        if (xi <= lineTmpFirst.getEnd().getX() && xi >= lineTmpFirst.getStart().getX() &&
                                xi <= lineTmpSecond.getEnd().getX() && xi >= lineTmpSecond.getStart().getX())
                            if (!checkPointForInterOnPoint(lineTmpFirst, lineTmpSecond, xi, yi))
                                intersectionCollection.add(new Point(xi, yi));
                    }
                }
            }
        }


    }

    private void intersectionOfCircle(Shape first, Shape second) {
        if (first instanceof Circle && second instanceof Circle)
            calculateOfCircleAndCircleIntersection(first, second);
        else
            calculateOfCircleIntersectionWithOther(first, second);

    }


    private void calculateOfCircleIntersectionWithOther(Shape first, Shape second) {
        Circle o;
        Shape p;
        if (first instanceof Circle) {
            o = new Circle(((Circle) first).getCentre(), ((Circle) first).getR());
            p = second;
        } else {
            o = new Circle(((Circle) second).getCentre(), ((Circle) second).getR());
            p = first;
        }
        for (Line lineTmp : p.getLines()) {
            Line line = lineTmp;
            double EPS = 0.01;
            double tc = line.getA() * o.getCentre().getX() + line.getB() * o.getCentre().getY() + line.getC();
            double tx = -line.getA() * tc / (line.getA() * line.getA() + line.getB() * line.getB());
            double ty = -line.getB() * tc / (line.getA() * line.getA() + line.getB() * line.getB());
            if (tc * tc > o.getR() * o.getR() * (line.getA() * line.getA() + line.getB() * line.getB()) + EPS) {
            } else if (Math.abs(tc * tc - o.getR() * o.getR() * (line.getA() * line.getA() + line.getB() * line.getB())) < EPS) {
                if (pointVerify(line, tx + o.getCentre().getX(), ty + o.getCentre().getY(), o))
                    intersectionCollection.add(new Point(tx + o.getCentre().getX(), ty + o.getCentre().getY()));
            } else {
                double d = o.getR() * o.getR() - tc * tc / (line.getA() * line.getA() + line.getB() * line.getB());
                double mult = Math.sqrt(d / (line.getA() * line.getA() + line.getB() * line.getB()));
                double x1 = tx + line.getB() * mult + o.getCentre().getX();
                double y1 = ty - line.getA() * mult + o.getCentre().getY();
                double x2 = tx - line.getB() * mult + o.getCentre().getX();
                double y2 = ty + line.getA() * mult + o.getCentre().getY();
                if (pointVerify(line, x1, y1, o))
                    intersectionCollection.add(new Point(x1, y1));
                if (pointVerify(line, x2, y2, o))
                    intersectionCollection.add(new Point(x2, y2));
            }
        }
    }

    private void calculateOfCircleAndCircleIntersection(Shape first1, Shape second2) {
        if (!coincidenceCheck(first1, second2)) {
            Circle first = new Circle(((Circle) first1).getCentre(), ((Circle) first1).getR());
            Circle second = new Circle(((Circle) second2).getCentre(), ((Circle) second2).getR());
            double d = Math.sqrt(Math.pow(Math.abs(first.getCentre().getX() - second.getCentre().getX()), 2)
                    + Math.pow(Math.abs(first.getCentre().getY() - second.getCentre().getY()), 2));
            if (d > first.getR() + second.getR()){}
            else {
                double a = (Math.pow(first.getR(), 2) - Math.pow(second.getR(), 2) + d * d) / (2 * d); //distance from r1 to point of intersection of all lines
                double h = Math.sqrt(Math.pow(first.getR(), 2) - Math.pow(a, 2)); // distance from intersection point under intersection point of all lines


                double x0 = first.getCentre().getX() + a * (second.getCentre().getX() - first.getCentre().getX()) / d;
                double y0 = first.getCentre().getY() + a * (second.getCentre().getY() - first.getCentre().getY()) / d;

                double x1 = x0 + h * (second.getCentre().getY() - first.getCentre().getY()) / d;
                double y1 = y0 - h * (second.getCentre().getX() - first.getCentre().getX()) / d;
                intersectionCollection.add(new Point(x1, y1));
                if (a == first.getR())  //Circle touch by surface
                {}

                double x2 = x0 - h * (second.getCentre().getY() - first.getCentre().getY()) / d;
                double y2 = y0 + h * (second.getCentre().getX() - first.getCentre().getX()) / d;

                intersectionCollection.add(new Point(x2, y2)); //Circles intersect
            }
        }
    }

    public boolean coincidenceCheck(Shape first, Shape second) {
        if (first instanceof Square && second instanceof Square) {
            return first.getLines().equals(second.getLines());
        }
        if (first instanceof Triangle && second instanceof Triangle)
            return first.getLines().equals(second.getLines());
        if (first instanceof Circle && second instanceof Circle)
            return ((Circle) first).getCentre().equals(((Circle) second).getCentre())
                    && ((Circle) first).getR() == ((Circle) second).getR();

        return false;
    } // check for coincidence of figures

    public boolean checkPointForInterOnPoint(Line first, Line second, double xi, double yi) {
        Point p = new Point(xi, yi);
        return first.getStart().equals(p) || first.getEnd().equals(p) || second.getStart().equals(p) || second.getEnd().equals(p);
    } //check for  intersection lines by points

    public boolean checkPointForInterOnPointCircle(Line line, double xi, double yi) {
        Point p = new Point(xi, yi);
        return line.getStart().equals(p) || line.getEnd().equals(p);
    }  // check circle for intersection on  at end or start point of line

    public boolean checkPointForTangentCase(Circle o, Line line, double xi, double yi) {
        Point p = new Point(xi, yi);
        Line tmpLine = new Line(o.getCentre(), p);
        double cos = (line.getA() * tmpLine.getA() + line.getB() * tmpLine.getB()) / (Math.sqrt(Math.pow(line.getA(), 2) + Math.pow(line.getB(), 2))
                * Math.sqrt(Math.pow(tmpLine.getA(), 2) + Math.pow(tmpLine.getB(), 2)));
        return cos != 0;
    } //check circle for touch the line by surface

    public boolean coordinateVerifyForY(Line line, double yi) {
        double yMax;
        double yMin;
        if (line.getStart().getY() < line.getEnd().getY()) {
            yMax = line.getEnd().getY();
            yMin = line.getStart().getY();
        } else {
            yMax = line.getStart().getY();
            yMin = line.getEnd().getY();
        }
        return yi <= yMax && yi >= yMin;
    }

    public boolean pointVerify(Line line, double x, double y, Circle o) {
        return !intersectionCollection.contains(new Point(x, y)) // check for same point
                && x <= line.getEnd().getX() && x >= line.getStart().getX() //check area of point
                && coordinateVerifyForY(line, y)
                && checkPointForTangentCase(o, line, x, y);    // check for tangent line
    }

}

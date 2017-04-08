package FigureFactory;

import Intersection.Intersection;
import Point.Point;
import Shapes.Circle;
import Shapes.Shape;
import Shapes.Square;
import Shapes.Triangle;

import java.util.ArrayList;
import java.util.Scanner;


public class FigureFactoryConsole {
    private static ArrayList<Shape> arrayOfShapes = new ArrayList<Shape>(2);

    public FigureFactoryConsole() {
//        System.out.println("Choose the first figure");
//        createFunc();
//        System.out.println("Choose the second figure");
//        createFunc();
//        Intersection intersection = new Intersection(arrayOfShapes.get(0), arrayOfShapes.get(1));
//        System.out.println(intersection.getIntersectionCollection());

    }
    public static void CreateFigure(){
        System.out.println("Choose the first figure");
        createFunc();
        System.out.println("Choose the second figure");
        createFunc();
        Intersection intersection = new Intersection(arrayOfShapes.get(0), arrayOfShapes.get(1));
        System.out.println(intersection.getIntersectionCollection());
    }


    private static int inputFigure() {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        if (sc.hasNextInt())
            a = sc.nextInt();
        else {
            System.out.println("Error, incorrect data");
            System.exit(-1);
        }
        return a;
    }

    private static double setCoordinate() {
        double c = 0;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextDouble())
            c = sc.nextDouble();
        else {
            System.out.println("Error, incorrect data");
            System.exit(-1);
        }
        return c;
    }

    public static void createFunc() {
        System.out.print(" 1 - Square \n 2 - Triangle \n 3 - Circle \n 0 - EXIT");
        int first = inputFigure();
        switch (first) {
            case 1: {
                System.out.println("You must enter two points of the diagonal of the square");

                System.out.println("Input x coordinate of point 1->");
                double x1 = setCoordinate();
                System.out.println("Input y coordinate of point 1->");
                double y1 = setCoordinate();
                System.out.println("Input x coordinate of point 2->");
                double x2 = setCoordinate();
                System.out.println("Input y coordinate of point 2->");
                double y2 = setCoordinate();
                if (Square.valueSetCheck(new Point(x1, y1), new Point(x2, y2)))
                    arrayOfShapes.add(new Square(new Point(x1, y1), new Point(x2, y2)));
                else
                    System.out.println("Error,incorrect coordinates");
            }
            break;
            case 2: {
                System.out.println("You must enter three point of  three vertices");

                System.out.println("Input x coordinate of point 1->");
                double x1 = setCoordinate();
                System.out.println("Input y coordinate of point 1->");
                double y1 = setCoordinate();
                System.out.println("Input x coordinate of point 2->");
                double x2 = setCoordinate();
                System.out.println("Input y coordinate of point 2->");
                double y2 = setCoordinate();
                System.out.println("Input x coordinate of point 3->");
                double x3 = setCoordinate();
                System.out.println("Input y coordinate of point 3->");
                double y3 = setCoordinate();
                if (Triangle.valueSetCheck(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3)))
                    arrayOfShapes.add(new Triangle(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3)));
                else {
                    System.out.println("Error,incorrect coordinates");
                    System.exit(-1);
                }
            }
            break;
            case 3: {
                System.out.println("You must enter coordinates of the centre and radius ");

                System.out.println("Input x coordinate of the centre");
                double x = setCoordinate();
                System.out.println("Input y coordinate of the centre");
                double y = setCoordinate();
                System.out.println("Input the radius of the circle");
                double r = setCoordinate();
                if (Circle.valueSetCheck(r))
                    arrayOfShapes.add(new Circle(new Point(x, y), r));
                else {
                    System.out.println("Error,incorrect coordinates, negative radius");
                    System.exit(-1);
                }
            }
            break;
            case 0: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Incorrect inout data please input number from 1 to 3 or 0 for EXIT");
                System.exit(-1);
            }
        }
    }

}

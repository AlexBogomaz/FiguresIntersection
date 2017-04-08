

import Intersection.Intersection;
import Point.Point;
import Shapes.Circle;
import Shapes.Square;
import Shapes.Triangle;
import org.junit.Assert;
import org.junit.Test;


public class MyTest {


    @Test
    public void intersectionOfSquareTriangleTest() {

        Square square = new Square(new Point(4, 2), new Point(7, 5));
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 5), new Point(6, 0));
        Intersection intersection = new Intersection(square, triangle);
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(4.0, 3.3333333333333335)));
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(4.8, 2.0)));
    }

    @Test
    public void intersectionOfCircleAndSquareTest() {
        Square square = new Square(new Point(3, 1), new Point(5, 3));
        Circle circle = new Circle(new Point(5, 3), 1);
        Intersection intersection = new Intersection(square, circle);
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(4.0, 3.0)));
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(5.0, 2.0)));

    }

    @Test
    public void intersectionOfCircleAndSquareTest2() {
        Square square = new Square(new Point(3, 1), new Point(5, 3));
        Circle circle = new Circle(new Point(5, 2), 1);
        Intersection intersection = new Intersection(square, circle);
        Assert.assertEquals(0, intersection.getIntersectionCollection().size());

    }

    @Test
    public void intersectionOfCircleAndSquareTest3() {
        Square square = new Square(new Point(2, 1), new Point(3, 4));
        Circle circle = new Circle(new Point(2.5, 2.5), 1);
        Intersection intersection = new Intersection(square, circle);
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(2.0, 3.3660254037844384)));
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(2.0, 1.6339745962155614)));
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(3.0, 3.3660254037844384)));
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(3.0, 1.6339745962155614)));
    }

    @Test
    public void intersectionOfCircleAndSquareTest4() {
        Square square = new Square(new Point(1, 1), new Point(3, 3));
        Circle circle = new Circle(new Point(5, 2), 1);
        Intersection intersection = new Intersection(square, circle);
        Assert.assertEquals(0, intersection.getIntersectionCollection().size());
    }

    @Test
    public void intersectionOfCircleAndSquarePointTangentTest() {
        Square square = new Square(new Point(1, 1), new Point(3, 3));
        Circle circle = new Circle(new Point(4, 2), 1);
        Intersection intersection = new Intersection(square, circle);
        Assert.assertEquals(0, intersection.getIntersectionCollection().size());

    }

    @Test
    public void intersectionOfCircleAndTriangleTest1() {
        Triangle triangle = new Triangle(new Point(2, 2), new Point(2, 4), new Point(3, 3));
        Circle circle = new Circle(new Point(2, 2), 1);
        Intersection intersection = new Intersection(circle, triangle);
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(2.0, 3.0)));
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(2.7071067811865475, 2.7071067811865475)));
    }

    @Test
    public void intersectionOfCircleAndTriangleTest2() {
        Triangle triangle = new Triangle(new Point(2, 2), new Point(3, 3), new Point(4, 2));
        Circle circle = new Circle(new Point(2, 2), 1);
        Intersection intersection = new Intersection(circle, triangle);
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(2.7071067811865475, 2.7071067811865475)));
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(3.0, 2.0)));
    }

    @Test
    public void intersectionOfCircleAndTriangleTest3() {
        Triangle triangle = new Triangle(new Point(2, 2), new Point(4, 2), new Point(3, 1));
        Circle circle = new Circle(new Point(2, 2), 1);
        Intersection intersection = new Intersection(circle, triangle);
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(2.7071067811865475, 1.2928932188134525)));
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(3.0, 2.0)));
    }

    @Test
    public void intersectionOfCircleAndTriangleTest4() {
        Triangle triangle = new Triangle(new Point(1, 1), new Point(2, 2), new Point(3, 1));
        Circle circle = new Circle(new Point(2, 2), 1);
        Intersection intersection = new Intersection(circle, triangle);
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(1.2928932188134525, 1.2928932188134525)));
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(2.7071067811865475, 1.2928932188134525)));
    }

    @Test
    public void intersectionOfCircleAndTriangleTest5() {
        Triangle triangle = new Triangle(new Point(0, 2), new Point(2, 2), new Point(1, 1));
        Circle circle = new Circle(new Point(2, 2), 1);
        Intersection intersection = new Intersection(circle, triangle);
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(1.0, 2.0)));
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(1.2928932188134525, 1.2928932188134525)));
    }

    @Test
    public void intersectionOfCircleAndTriangleTest6() {
        Triangle triangle = new Triangle(new Point(0, 2), new Point(1, 3), new Point(2, 2));
        Circle circle = new Circle(new Point(2, 2), 1);
        Intersection intersection = new Intersection(circle, triangle);
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(1.0, 2.0)));
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(1.2928932188134525, 2.7071067811865475)));
    }

    @Test
    public void intersectionOfCircleAndTriangleTest7() {
        Triangle triangle = new Triangle(new Point(1, 3), new Point(2, 4), new Point(2, 2));
        Circle circle = new Circle(new Point(2, 2), 1);
        Intersection intersection = new Intersection(circle, triangle);
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(2.0, 3.0)));
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(1.2928932188134525, 2.7071067811865475)));
    }

    @Test
    public void intersectionOfCircleAndCircleTest() {
        Circle circle = new Circle(new Point(2, 2), 1);
        Circle circle2 = new Circle(new Point(3, 2), 1);
        Intersection intersection = new Intersection(circle, circle2);
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(2.5, 1.1339745962155614)));
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(2.5, 2.8660254037844384)));
    }

    @Test
    public void coincidenceOfCircleAndCircleTest() {
        Circle circle = new Circle(new Point(2, 2), 1);
        Circle circle2 = new Circle(new Point(2, 2), 1);
        Intersection intersection = new Intersection(circle, circle2);
        Assert.assertEquals(0, intersection.getIntersectionCollection().size());
    }

    @Test
    public void touchOfCircleAndCircleTest() {
        Circle circle = new Circle(new Point(2, 2), 1);
        Circle circle2 = new Circle(new Point(4, 2), 1);
        Intersection intersection = new Intersection(circle, circle2);
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(3.0, 2.0)));
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(3.0, 2.0)));
    }

    @Test
    public void noIntersectionOfCircleAndCircleTest() {
        Circle circle = new Circle(new Point(2, 2), 1);
        Circle circle2 = new Circle(new Point(5, 2), 1);
        Intersection intersection = new Intersection(circle, circle2);
        Assert.assertEquals(0, intersection.getIntersectionCollection().size());
    }

    @Test
    public void triangleSquareTest() {
        Square square = new Square(new Point(4, 2), new Point(7, 5));
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 5), new Point(6, 0));
        Intersection intersection = new Intersection(triangle, square);
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(4.8, 2.0)));
        Assert.assertTrue(intersection.getIntersectionCollection().contains(new Point(4.0, 3.3333333333333335)));
    }

    @Test
    public void squareSquareTest() {
        Square square = new Square(new Point(4, 2), new Point(7, 5));
        Square square2 = new Square(new Point(4, 2), new Point(7, 5));
        Intersection intersection = new Intersection(square, square2);
        Assert.assertEquals(0, intersection.getIntersectionCollection().size());
    }

    @Test
    public void coincidenceCheckSquareSquareTest() {
        Square square = new Square(new Point(4, 2), new Point(7, 5));
        Square square2 = new Square(new Point(4, 2), new Point(7, 5));
        Intersection intersection = new Intersection(square, square2);
        Assert.assertTrue(intersection.coincidenceCheck(square, square2));
    }

    @Test
    public void coincidenceCheckTriangleTriangleTest() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 5), new Point(6, 0));
        Triangle triangle2 = new Triangle(new Point(0, 0), new Point(3, 5), new Point(6, 0));
        Intersection intersection = new Intersection(triangle, triangle2);
        Assert.assertTrue(intersection.coincidenceCheck(triangle, triangle2));
    }

    @Test
    public void coincidenceCheckCircleCircleTest() {
        Circle circle = new Circle(new Point(2, 2), 3);
        Circle circle2 = new Circle(new Point(2, 2), 3);
        Intersection intersection = new Intersection(circle, circle2);
        Assert.assertEquals(0, intersection.getIntersectionCollection().size());

    }

    @Test
    public void intersectionPointCheckTest() {
        Square square = new Square(new Point(1, 1), new Point(3, 3));
        Square square2 = new Square(new Point(3, 1), new Point(5, 3));
        Intersection intersection = new Intersection(square, square2);
        Assert.assertEquals(0, intersection.getIntersectionCollection().size());
    }

    @Test
    public void pointOnLineTest() {
        Square square = new Square(new Point(1, 1), new Point(3, 3));
        Square square2 = new Square(new Point(2, 1), new Point(5, 3));
        Intersection intersection = new Intersection(square, square2);
        Assert.assertEquals(0, intersection.getIntersectionCollection().size());
    }
    @Test
    public void valueSquareSetCheckTest() {
        Assert.assertTrue(Square.valueSetCheck(new Point(1, 1), new Point(3, 3)));
    }

    @Test
    public void valueSquareSetCheckTest2() {
        Assert.assertFalse(Square.valueSetCheck(new Point(1, 1), new Point(1, 3)));
    }

    @Test
    public void valueTriangleSetCheckTest() {
        Assert.assertTrue(Triangle.valueSetCheck(new Point(0, 2), new Point(1, 3), new Point(3, 3)));
    }

    @Test
    public void valueTriangleSetCheckTest2() {
        Assert.assertFalse(Triangle.valueSetCheck(new Point(0, 2), new Point(2, 2), new Point(4, 2)));
    }

}

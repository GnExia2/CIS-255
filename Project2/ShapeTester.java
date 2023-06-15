import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeTester {

    public static void main(String[] args) {

        Rectangle rectangle1 = new Rectangle(3, 4);
        Rectangle rectangle2 = new Rectangle(4, 3);
        Rectangle rectangle3 = new Rectangle(5, 6);
        Square square1 = new Square(2);
        Square square2 = new Square(4);
        Square square3 = new Square(4);
        Circle circle1 = new Circle(3);
        Circle circle2 = new Circle(5);
        Cylinder cylinder1 = new Cylinder(new Circle(3), 5);
        Cylinder cylinder2 = new Cylinder(new Circle(4), 6);
        Cylinder cylinder3 = new Cylinder(new Circle(6), 4);
        Cube cube1 = new Cube(new Square(2));
        Cube cube2 = new Cube(new Square(3));

        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(rectangle1);
        shapeList.add(rectangle2);
        shapeList.add(rectangle3);
        shapeList.add(square1);
        shapeList.add(square2);
        shapeList.add(square3);
        shapeList.add(circle1);
        shapeList.add(circle2);
        shapeList.add(cylinder1);
        shapeList.add(cylinder2);
        shapeList.add(cylinder3);
        shapeList.add(cube1);
        shapeList.add(cube2);

        System.out.println("*****PRINTING OUT THE TEXT REPRESENTATION, DESCRIPTION, AREA, AND PERIMETER/VOLUME OF EACH SHAPE");
        for (Shape shape : shapeList) {
            System.out.println(shape);
            System.out.println(shape.getDescription());
            System.out.println("\tArea: " + shape.getArea());

            if (shape instanceof TwoDimensionalShape) {
                TwoDimensionalShape twoDShape = (TwoDimensionalShape) shape;
                System.out.println("\tPerimeter: " + twoDShape.getPerimeter());
            }

            if (shape instanceof ThreeDimensionalShape) {
                ThreeDimensionalShape threeDShape = (ThreeDimensionalShape) shape;
                System.out.println("\tVolume: " + threeDShape.getVolume());
            }

            System.out.println("");
        }

        System.out.println("\n*****PRINTING ALL EQUAL, NON-ALIAS SHAPES");
        for (Shape firstShape : shapeList) {
            for (Shape secondShape : shapeList) {
                if (!firstShape.equals(secondShape) && firstShape.getDescription().equals(secondShape.getDescription()) && firstShape.equals(secondShape)) {
                    System.out.println(firstShape);
                    System.out.println(secondShape);
                    System.out.println("");
                }
            }
        }

        System.out.println("\n*****PRINTING ALL CUBE/SQUARE COMBINATIONS WHERE THE SQUARE IS A SIDE FOR THE CUBE");
        for (Shape firstShape : shapeList) {
            for (Shape secondShape : shapeList) {
                if (firstShape instanceof Cube && secondShape instanceof Square) {
                    Cube cube = (Cube) firstShape;
                    Square square = (Square) secondShape;
                    if (cube.hasSameFace(square)) {
                        System.out.println(cube);
                        System.out.println(square);
                        System.out.println("");
                    }
                }
            }
        }

        System.out.println("\n*****PRINTING ALL COMBINATIONS OF TWO-DIMENSIONAL SHAPES THAT CAN FIT INSIDE ANOTHER");
        for (Shape firstShape : shapeList) {
            for (Shape secondShape : shapeList) {
                if (firstShape instanceof TwoDimensionalShape && secondShape instanceof TwoDimensionalShape) {
                    TwoDimensionalShape shape1 = (TwoDimensionalShape) firstShape;
                    TwoDimensionalShape shape2 = (TwoDimensionalShape) secondShape;
                    if (shape1.canFitInside(shape2)) {
                        System.out.println(shape1);
                        System.out.println(shape2);
                        System.out.println("");
                    }
                }
            }
        }

    }

}

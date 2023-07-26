//In terminal run "java ShapeTester2.java"

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeTester2 {

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
        for (int i = 0; i < shapeList.size(); i++) {
            for (int j = i + 1; j < shapeList.size(); j++) {
                Shape firstShape = shapeList.get(i);
                Shape secondShape = shapeList.get(j);
                if (firstShape.getDescription().equals(secondShape.getDescription()) && firstShape.equals(secondShape)) {
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
                    if (cube.getFace().equals(square)) {
                        System.out.println(cube);
                        System.out.println(square);
                        System.out.println("");
                    }
                }
            }
        }

        System.out.println("\n*****PRINTING ALL COMBINATIONS OF TWO-DIMENSIONAL SHAPES THAT CAN FIT INSIDE ANOTHER");
        for (Shape firstShape : shapeList) {
            if (firstShape instanceof Cube) {
                Cube outerCube = (Cube) firstShape;
                for (Shape secondShape : shapeList) {
                    if (secondShape instanceof TwoDimensionalShape) {
                        TwoDimensionalShape innerShape = (TwoDimensionalShape) secondShape;
                        if (outerCube.canFitInside(innerShape)) {
                            System.out.println("Nested Shapes Found:");
                            System.out.println("\tOuter: " + outerCube);
                            System.out.println("\tInner: " + innerShape);
                            System.out.println("");
                        }
                    }
                }
            }
        }
    }
}








public abstract class Shape {
    public abstract String getDescription();

    public abstract double getArea();
}

public abstract class TwoDimensionalShape extends Shape implements PerimeterCalculable {
    public abstract double getPerimeter();
}

public abstract class ThreeDimensionalShape extends Shape implements VolumeCalculable {
    public abstract double getVolume();
}

public interface PerimeterCalculable {
    double getPerimeter();
}

public interface VolumeCalculable {
    double getVolume();
}


public class Rectangle extends TwoDimensionalShape {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String getDescription() {
        return "Rectangle (a quadrilateral with four right angles)";
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return getDescription() + " of size: " + length + "x" + width;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rectangle)) return false;
        Rectangle other = (Rectangle) obj;
        return (this.length == other.length && this.width == other.width)
                || (this.length == other.width && this.width == other.length);
    }
}












public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    public int getSide() {
        return getWidth(); // Since Square is a special case of Rectangle with equal width and height, we can use getWidth().
    }

    @Override
    public String getDescription() {
        return "Square (a quadrilateral with four equal sides and four equal angles)";
    }
}









public class Circle extends TwoDimensionalShape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String getDescription() {
        return "Circle";
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return getDescription() + " of size: " + radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Circle)) return false;
        Circle other = (Circle) obj;
        return this.radius == other.radius;
    }
}










public class Cylinder extends ThreeDimensionalShape {
    private Circle topBottom;
    private int height;

    public Cylinder(Circle topBottom, int height) {
        this.topBottom = topBottom;
        this.height = height;
    }

    public Circle getTopBottom() {
        return topBottom;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String getDescription() {
        return "Cylinder";
    }

    @Override
    public double getArea() {
        double circleArea = topBottom.getArea();
        double lateralArea = 2 * Math.PI * topBottom.getRadius() * height;
        return circleArea + lateralArea;
    }

    @Override
    public double getVolume() {
        return topBottom.getArea() * height;
    }

    @Override
    public String toString() {
        return getDescription() + " with base radius: " + topBottom.getRadius() + " and height: " + height;
    }

    public boolean canBeTopOrBottomOfCylinder(Circle circle) {
        return topBottom.equals(circle);
    }
}











public class Cube extends ThreeDimensionalShape {
    private Square face;

    public Cube(Square face) {
        this.face = face;
    }

    public Square getFace() {
        return face;
    }

    @Override
    public String getDescription() {
        return "Cube";
    }

    @Override
    public double getArea() {
        return 6 * face.getArea();
    }

    @Override
    public double getVolume() {
        return Math.pow(face.getSide(), 3);
    }

    @Override
    public String toString() {
        return getDescription() + " with side: " + face.getSide();
    }

    public boolean hasSameFace(Square square) {
        return face.equals(square);
    }

    public boolean canFitInside(TwoDimensionalShape shape) {
        if (shape instanceof Square) {
            Square square = (Square) shape;
            return face.getSide() <= square.getSide();
        }
        return false;
    }
}

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


// Shape (abstract class)
abstract class Shape {
    protected int size1;
    protected int size2;
    protected int size3;

    public Shape(int size1, int size2, int size3) {
        this.size1 = size1;
        this.size2 = size2;
        this.size3 = size3;
    }

    public int getSize1() {
        return size1;
    }

    public void setSize1(int size1) {
        this.size1 = size1;
    }

    public int getSize2() {
        return size2;
    }

    public void setSize2(int size2) {
        this.size2 = size2;
    }

    public int getSize3() {
        return size3;
    }

    public void setSize3(int size3) {
        this.size3 = size3;
    }

    public abstract String getDescription();

    public abstract double getArea();

    // Only three-dimensional shapes should have a volume
    public double getVolume() {
        return 0;
    }

    public boolean equals(Shape other) {
        return this.getDescription().equals(other.getDescription()) &&
               this.hasSameSize(other);
    }

    public boolean hasSameSize(Shape other) {
        return this.size1 == other.size1 &&
               this.size2 == other.size2 &&
               this.size3 == other.size3;
    }

    @Override
    public String toString() {
        return this.getDescription() + "\n" + this.getSizeDetails();
    }

    // Get size details in a formatted string
    protected String getSizeDetails() {
        StringBuilder builder = new StringBuilder();
        if (size1 > 0) {
            builder.append("Size: ").append("Width: ").append(size1);
        }
        if (size2 > 0) {
            builder.append("\tHeight: ").append(size2);
        }
        if (size3 > 0) {
            builder.append("\tDepth: ").append(size3);
        }
        return builder.toString();
    }

    public abstract boolean canFitInside(TwoDimensionalShape shape);

}
// TwoDimensionalShape interface
interface TwoDimensionalShape {
    double getPerimeter();
    boolean canFitInside(TwoDimensionalShape shape);
}

// ThreeDimensionalShape (interface)
interface ThreeDimensionalShape {
    // Abstract method to calculate the volume
    double getVolume();
}

// Rectangle
class Rectangle extends Shape implements TwoDimensionalShape {
    public Rectangle(int width, int height) {
        super(width, height, 0);
    }

    @Override
    public String getDescription() {
        return "Rectangle (a quadrilateral with four right angles)";
    }

    @Override
    public double getArea() {
        return size1 * size2;
    }

    @Override
    public double getPerimeter() {
        return 2 * (size1 + size2);
    }

    @Override
    public double getPerimeter() {
        return 2 * (size1 + size2);
    }

    @Override
    public boolean canFitInside(TwoDimensionalShape shape) {
        return this.getPerimeter() < shape.getPerimeter();
    }

    // Implementing the canFitInside method is not necessary for the Rectangle class.
}

// Square
class Square extends Shape implements TwoDimensionalShape {
    public Square(int side) {
        super(side, side, 0);
    }

    @Override
    public String getDescription() {
        return "Square (a quadrilateral with four equal sides and four equal angles)";
    }

    @Override
    public double getArea() {
        return size1 * size1;
    }

    @Override
    public double getPerimeter() {
        return 4 * size1;
    }

    @Override
    public double getPerimeter() {
        return 4 * size1;
    }

    @Override
    public boolean canFitInside(TwoDimensionalShape shape) {
        return this.getPerimeter() < shape.getPerimeter();
    }
    // Implementing the canFitInside method is not necessary for the Square class.
}

// Circle
class Circle extends Shape implements TwoDimensionalShape {
    public Circle(int radius) {
        super(radius, 0, 0);
    }

    @Override
    public String getDescription() {
        return "Circle";
    }

    @Override
    public double getArea() {
        return Math.PI * size1 * size1;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * size1;
    }

    // Implementing the canFitInside method is not necessary for the Circle class.
}

// Cylinder
class Cylinder extends Shape implements ThreeDimensionalShape {
    private Circle baseCircle;

    public Cylinder(Circle baseCircle, int height) {
        super(baseCircle.getSize1(), height, 0);
        this.baseCircle = baseCircle;
    }

    @Override
    public String getDescription() {
        return "Cylinder";
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * baseCircle.getSize1() * size1 + 2 * Math.PI * baseCircle.getSize1() * size2;
    }

    @Override
    public double getVolume() {
        return Math.PI * baseCircle.getSize1() * baseCircle.getSize1() * size2;
    }

    // Method to check if the given Circle could be the top/bottom of this Cylinder
    public boolean hasSameSize(Circle other) {
        return this.baseCircle.equals(other);
    }
}

// Cube
class Cube extends Shape implements ThreeDimensionalShape {
    private Square faceSquare;

    public Cube(Square faceSquare) {
        super(faceSquare.getSize1(), faceSquare.getSize2(), faceSquare.getSize3());
        this.faceSquare = faceSquare;
    }

    @Override
    public String getDescription() {
        return "Cube";
    }

    @Override
    public double getArea() {
        return 6 * faceSquare.getSize1() * faceSquare.getSize1();
    }

    @Override
    public double getVolume() {
        return faceSquare.getSize1() * faceSquare.getSize1() * faceSquare.getSize1();
    }

    // Method to check if the given Square could be a side of this Cube
    public boolean hasSameFace(Square other) {
        return this.faceSquare.equals(other);
    }
}

package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Triangle tests")
    class TriangleTest {
        @Test
        void testAddTriangle() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle("triangle", 15.1);
            int shapesQuantity = shapeCollector.getShapes().size();

            //When
            shapeCollector.addFigure(triangle);

            //Then
            assertEquals(1, shapesQuantity);
        }

        @Test
        void testRemoveTriangle() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle("triangle", 15.1);
            shapeCollector.getShapes().add(triangle);

            //When
            boolean result = shapeCollector.removeFigure(triangle);

            //Then
            assertTrue(result);
            assertEquals(0, shapeCollector.getShapes().size());
        }

        @Test
        void testRemoveTriangleNotExisting() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle("triangle", 15.1);

            //When
            boolean result = shapeCollector.removeFigure(triangle);

            //Then
            assertFalse(result);
        }
    }

    @Nested
    @DisplayName("Square tests")
    class SquareTest {
        @Test
        void testAddSquare() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square("square", 15.1);
            int shapesQuantity = shapeCollector.getShapes().size();

            //When
            shapeCollector.addFigure(square);

            //Then
            assertEquals(1, shapesQuantity);
        }

        @Test
        void testRemoveSquare() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square("square", 15.1);
            shapeCollector.getShapes().add(square);

            //When
            boolean result = shapeCollector.removeFigure(square);

            //Then
            assertTrue(result);
            assertEquals(0, shapeCollector.getShapes().size());
        }

        @Test
        void testRemoveSquareNotExisting() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square("square", 15.1);

            //When
            boolean result = shapeCollector.removeFigure(square);

            //Then
            assertFalse(result);
        }
    }

    @Nested
    @DisplayName("Circle tests")
    class CircleTest {
        @Test
        void testAddCircle() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle("circle", 15.1);
            int shapesQuantity = shapeCollector.getShapes().size();

            //When
            shapeCollector.addFigure(circle);

            //Then
            assertEquals(1, shapesQuantity);
        }

        @Test
        void testRemoveCircle() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle("circle", 15.1);
            shapeCollector.getShapes().add(circle);

            //When
            boolean result = shapeCollector.removeFigure(circle);

            //Then
            assertTrue(result);
            assertEquals(0, shapeCollector.getShapes().size());
        }

        @Test
        void testRemoveCircleNotExisting() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle("circle", 15.1);

            //When
            boolean result = shapeCollector.removeFigure(circle);

            //Then
            assertFalse(result);
        }


    }

    @Test
    void testReturnElement() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle("triangle", 15.1);

        //When
        Shape result = shapeCollector.getFigure(0);

        //Then
        assertEquals(triangle, result);
    }

    @Test
    void testShowFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle("triangle", 15.1);
        Square square = new Square("square", 6.0);
        Circle circle = new Circle("circle", 10);
        String expectedResult = "triangle, square, circle";

        //When
        String result = shapeCollector.showFigures();

        //Then
        assertEquals(expectedResult, result);
    }
}

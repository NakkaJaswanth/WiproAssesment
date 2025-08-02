package interfacedoc;

public class ShapeTest {
    public static void main(String[] args) {
        Line line = new Line();
        Circle circle = new Circle();
        Square square = new Square();

        System.out.println("=== Line ===");
        line.drawingColor();
        line.thickness();
        line.fillingColor();
        line.size();

        System.out.println("\n=== Circle ===");
        circle.drawingColor();
        circle.thickness();
        circle.fillingColor();
        circle.size();

        System.out.println("\n=== Square ===");
        square.drawingColor();
        square.thickness();
        square.fillingColor();
        square.size();
    }
}

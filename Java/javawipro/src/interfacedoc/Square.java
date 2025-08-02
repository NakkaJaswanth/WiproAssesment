package interfacedoc;

public class Square implements Drawable, Fillable {
    public void drawingColor() {
        System.out.println("Square drawing color: Green");
    }

    public void thickness() {
        System.out.println("Square border thickness: 4px");
    }

    public void fillingColor() {
        System.out.println("Square filling color: Red");
    }

    public void size() {
        System.out.println("Square side length: 6 units");
    }
}


package interfacedoc;

public class Line implements Drawable, Fillable {
    public void drawingColor() {
        System.out.println("Line drawing color: Black");
    }

    public void thickness() {
        System.out.println("Line thickness: 2px");
    }

    public void fillingColor() {
        System.out.println("Line has no filling color.");
    }

    public void size() {
        System.out.println("Line length: 10 units");
    }
}


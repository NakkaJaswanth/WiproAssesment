package interfacedoc;

public class Circle implements Drawable, Fillable {
    public void drawingColor() {
        System.out.println("Circle drawing color: Blue");
    }

    public void thickness() {
        System.out.println("Circle border thickness: 3px");
    }

    public void fillingColor() {
        System.out.println("Circle filling color: Yellow");
    }

    public void size() {
        System.out.println("Circle radius: 5 units");
    }
}

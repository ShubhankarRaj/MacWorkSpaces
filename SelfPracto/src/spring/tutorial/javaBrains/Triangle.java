package spring.tutorial.javaBrains;

/**
 * Created by raj8lm on 09/09/17.
 */
class Triangle extends Shape{
    public static void main(String args[]) {
        Triangle myTriangle = new Triangle();
        Drawing drawing = new Drawing();
        drawing.setShape(myTriangle);
        drawing.drawShape(myTriangle);
    }

}

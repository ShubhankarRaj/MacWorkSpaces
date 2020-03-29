package spring.tutorial.javaBrains;

/**
 * Created by raj8lm on 07/09/17.
 */
public class Drawing {
    private Shape shape;

    public void setShape(Shape shape){
        this.shape = shape;
    }

    public void drawShape(Shape shape){
        this.shape.draw();
    }
}

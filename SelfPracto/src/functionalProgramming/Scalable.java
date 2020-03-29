package functionalProgramming;


/*
    Interfaces used to provide only signatures of methods.
    Now they can provide behaviours as well.
 */

public interface Scalable {
    void setScale(double scale);

    //  Implicitly public static final variable
    double DEFAULT_SCALE = 1.0;

    //  implicitly public
    static boolean isScalable(Object obj){
        return obj instanceof Scalable;
    }

    default void resetScale(){
        setScale(DEFAULT_SCALE);
    }
}

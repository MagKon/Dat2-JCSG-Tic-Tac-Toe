package TicTacToe.Shapes;

import org.abstractica.javacsg.Geometry;
import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class X implements Shapes {
    private Geometry3D geometry;
    private final JavaCSG csg;
    private double width = 5;
    private double height = 10;
    private int resolution = 64;

    public X(JavaCSG csg) {
        this.csg = csg;
        createGeometry();
    }

    private void createGeometry() {
        //Create an x as 3D
        Geometry3D x = null;
        Geometry3D box1 = csg.box3D(10, 2, 1, true);
        Geometry3D box2 = csg.box3D(2, 10, 1, true);
        x = csg.union3D(box1, box2);
        setGeometry3D(x);
        this.translate(5,5,0);
    }

    @Override
    public Geometry2D getGeometry2D() {
        return null;
    }

    @Override
    public void setGeometry2D(Geometry2D geometry) {

    }

    @Override
    public Geometry3D getGeometry3D() {
        return geometry;
    }

    @Override
    public void setGeometry3D(Geometry3D geometry) {
        this.geometry = geometry;
    }

    @Override
    public void translate(double x, double y, double z) {
        this.geometry = csg.translate3D(x, y, z).transform(getGeometry3D());
    }
}

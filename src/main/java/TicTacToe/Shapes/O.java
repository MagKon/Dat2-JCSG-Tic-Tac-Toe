package TicTacToe.Shapes;

import org.abstractica.javacsg.Geometry;
import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class O implements Shapes {
    private Geometry3D geometry;
    private final JavaCSG csg;
    private double width = 5;
    private double height = 10;
    private int resolution = 64;

    public O(JavaCSG csg) {
        this.csg = csg;
        createGeometry();
    }

    private void createGeometry() {
        //Create an O as 3D
        Geometry3D o = null;
        Geometry3D base = csg.cylinder3D(10, 1, 64, true);
        Geometry3D center = csg.cylinder3D(6, 1, 64, true);
        o = csg.difference3D(base, center);
        setGeometry3D(o);
    }

    @Override
    public Geometry3D getGeometry3D() {
        return this.geometry;
    }

    @Override
    public void setGeometry3D(Geometry3D geometry) {
        this.geometry = geometry;
    }

    @Override
    public void translate(double x, double y, double z) {
        this.geometry = csg.translate3D(x, y,z).transform(getGeometry3D());
    }
}

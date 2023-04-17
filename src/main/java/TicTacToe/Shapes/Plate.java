package TicTacToe.Shapes;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Plate implements Shapes {
    private Geometry3D geometry;
    private JavaCSG csg;

    public Plate(JavaCSG csg) {
        this.csg = csg;
        createGeometry();
    }

    public void createGeometry() {
        Geometry3D plate = null;
        plate = csg.box3D(10, 10, 1, true);
        setGeometry3D(plate);
    }

    @Override
    public Geometry3D getGeometry3D() {
        return null;
    }

    @Override
    public void setGeometry3D(Geometry3D geometry) {

    }

    @Override
    public void translate(double x, double y, double z) {

    }
}

package TicTacToe.Shapes;

import org.abstractica.javacsg.Geometry;
import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class O implements Shapes {
    private Geometry2D geometry;
    private final JavaCSG csg;
    private double width = 5;
    private double height = 10;
    private int resolution = 64;

    public O(JavaCSG csg) {
        this.csg = csg;
        createGeometry();
    }

    private void createGeometry() {
        setGeometry2D(csg.char2D('o', width, height, resolution));
    }

    @Override
    public Geometry2D getGeometry2D() {
        return this.geometry;
    }

    @Override
    public void setGeometry2D(Geometry2D geometry) {
        this.geometry = geometry;
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
        this.geometry = csg.translate2D(x, y).transform(getGeometry2D());
    }
}

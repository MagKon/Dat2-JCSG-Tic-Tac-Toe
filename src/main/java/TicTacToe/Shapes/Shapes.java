package TicTacToe.Shapes;

import org.abstractica.javacsg.Geometry;
import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;

public interface Shapes {
    Geometry2D getGeometry2D();
    void setGeometry2D(Geometry2D geometry);
    Geometry3D getGeometry3D();
    void setGeometry3D(Geometry3D geometry);
    void translate(double x, double y, double z);
}

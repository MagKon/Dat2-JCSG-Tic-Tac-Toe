package TicTacToe.Shapes;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Plate implements Shapes {
    private Geometry3D geometry;
    private final JavaCSG csg;

    public Plate(JavaCSG csg) {
        this.csg = csg;
        createGeometry();
    }

    public void createGeometry() {
        Geometry3D platefinal = null;

        Geometry3D plate = csg.box3D(60, 60, 10, false);
        plate = csg.translate3D(30, 30,0).transform(plate);
        Geometry3D plate2 = csg.box3D(25, 25, 15, false);

        plate2 = csg.translate3D(25, 25,0).transform(plate2);

        var plates1 = csg.box3D(60,20,15, false);
        plates1 = csg.translate3D(30, 10,0).transform(plates1);
        var plates2 = csg.box3D(40,20,15, false);
        plates2 = csg.translate3D(40, 30,0).transform(plates2);
        var plates3 = csg.box3D(20,20,15, false);
        plates3 = csg.translate3D(50, 50,0).transform(plates3);

        var unionPlate2 = csg.union3D(plates1, plates2, plates3);

        var upperPlate = csg.box3D(40, 20, 20, false);
        upperPlate = csg.translate3D(40, 10,0).transform(upperPlate);

        var upperPlate2 = csg.box3D(20, 20, 20, false);
        upperPlate2 = csg.translate3D(50, 30,0).transform(upperPlate2);

        var upperUnion = csg.union3D(upperPlate, upperPlate2);

        var uppestPlate = csg.box3D(20, 20, 25, false);
        uppestPlate = csg.translate3D(50, 10,0).transform(uppestPlate);

        var lowerPlate = csg.box3D(22, 22, 15, false);
        lowerPlate = csg.translate3D(9, 51,5).transform(lowerPlate);



        var removeVol = csg.box3D(18, 18, 20, false);

        var union = csg.union3D(plate, unionPlate2,upperUnion, uppestPlate);


        // removevols

        union = csg.difference3D(union, lowerPlate);

        union = volRemove(9,51,5, union);

        union = volRemove(10,50,3, union);
        union = volRemove(30,50,8, union);
        union = volRemove(50,50,14,union);

        // second layer
        union = volRemove(10,30,8, union);
        union = volRemove(30,30,13,union);
        union = volRemove(50,30,18,union);

        // third layer
        union = volRemove(10,10,13, union);
        union = volRemove(30,10,18, union);
        union = volRemove(50,10,23,union);

        platefinal = union;
        setGeometry3D(platefinal);
    }

    public Geometry3D volRemove (int x,int y,int z, Geometry3D union) {
        var removeVol = csg.box3D(18, 18, 20, false);
        removeVol = csg.translate3D(x,y,z).transform(removeVol);
        union = csg.difference3D(union, removeVol);
        return union;
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

    }
}

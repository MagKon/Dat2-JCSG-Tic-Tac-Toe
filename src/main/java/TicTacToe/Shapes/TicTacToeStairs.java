package TicTacToe.Shapes;

import org.abstractica.javacsg.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TicTacToeStairs {
    public Geometry3D GeneratePlate(JavaCSG csg) {
        Geometry3D product = null;

        JavaCSG csg = JavaCSGFactory.createDefault();

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

        var lowerPlate = csg.box3D(20, 20, 15, false);
        lowerPlate = csg.translate3D(10, 50,5).transform(lowerPlate);



        var removeVol = csg.box3D(18, 18, 21, false);
        removeVol = csg.translate3D(50, 30,8).transform(removeVol);

        var union = csg.union3D(plate, unionPlate2,upperUnion, uppestPlate);


        // removevols

        var lowestPlate = csg.box3D(18, 18, 5, false);
        lowestPlate = csg.translate3D(10, 50,5).transform(lowestPlate);

        var newUnion = csg.difference3D(union, lowestPlate);
        newUnion = csg.difference3D(union, lowerPlate);


        removeVol = csg.translate3D(30,10,5).transform(removeVol);
        newUnion = csg.difference3D(newUnion, removeVol);
        product = newUnion;


        return product;
    }

    public Geometry2D GenerateBricks(JavaCSG csg) {
        Geometry2D product = null;
        Shapes x1 = new TicTacToe.Shapes.X(csg);

        Shapes o1 = new TicTacToe.Shapes.O(csg);
        o1.translate(10, 0, 0);
        //convert 2d to 3d
        o1.getGeometry2D();

        product = csg.union2D(x1.getGeometry2D(), o1.getGeometry2D());

        return product;
    }

    public void Generate(JavaCSG csg) throws IOException {
        //Read View0.scad and save in string
        csg.view(this.GenerateBricks(csg));
        File file = new File("OpenSCAD/View0.scad");
        Scanner scanner = new Scanner(file);
        String fileString = scanner.useDelimiter("\\Z").next();
        scanner.close();

        csg.view(this.GeneratePlate(csg));
        File file2 = new File("OpenSCAD/View0.scad");
        Scanner scanner2 = new Scanner(file2);
        String fileString2 = scanner2.useDelimiter("\\Z").next();
        scanner2.close();

        //Write string to file
        FileWriter fileWriter = new FileWriter("OpenSCAD/View0.scad");
        fileWriter.write(fileString);
        fileWriter.write(fileString2);
        fileWriter.close();
    }
}

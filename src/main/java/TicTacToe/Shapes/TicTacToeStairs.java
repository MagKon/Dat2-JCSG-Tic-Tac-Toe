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

        Geometry3D cyl = csg.cylinder3D(10, 20, 32, true);
        Geometry3D square = csg.box3D(90, 90, 1, true);
        product = csg.difference3D(square, cyl);
        Geometry3D inter = csg.intersection3D(square, cyl );
        inter = csg.translate3DZ(10).transform(inter);
//        product = csg.union3D(diff, inter);
//		csg.view(diff);
//        csg.view(union);
//		csg.view(inter);


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

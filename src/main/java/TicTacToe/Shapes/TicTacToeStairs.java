package TicTacToe.Shapes;

import org.abstractica.javacsg.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TicTacToeStairs {
    private int amountOfBricks = 3;

    public Geometry3D GeneratePlate(JavaCSG csg) {
        Geometry3D product;

        Shapes plate = new Plate(csg);

        product = plate.getGeometry3D();

        return product;
    }

    public Geometry3D GenerateBricks(JavaCSG csg) {
        Geometry3D product = null;
        int translater = 20;


        for (int i = 0; i < amountOfBricks; i++) {
            Geometry3D newProduct = null;
            Shapes x = new X(csg);
            x.translate(0,5,0);
            Shapes o = new O(csg);

            newProduct = csg.union3D(x.getGeometry3D(), o.getGeometry3D());
            if (product != null)
                product = csg.union3D(newProduct, product);
            else
                product = newProduct;
            product = csg.translate3D(translater, 0, 0).transform(product);
        }

        product = csg.translate3D(0, 80, 0).transform(product);
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

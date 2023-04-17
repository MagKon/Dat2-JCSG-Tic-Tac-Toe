package TicTacToe;

import TicTacToe.Shapes.Shapes;
import TicTacToe.Shapes.TicTacToeStairs;
import org.abstractica.javacsg.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CadGen {
    public static void main(String[] args) throws IOException {
        JavaCSG csg = JavaCSGFactory.createDefault();
        TicTacToeStairs ticTacToeStairs = new TicTacToeStairs();
        ticTacToeStairs.Generate(csg);
    }
}

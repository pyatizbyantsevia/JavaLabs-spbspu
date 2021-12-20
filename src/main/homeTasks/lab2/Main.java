package main.homeTasks.lab2;

import main.homeTasks.lab2.Exceptions.DivideNullException;
import main.homeTasks.lab2.Exceptions.MatrixSizeOverflow;
import main.homeTasks.lab2.Exceptions.UndefinedFileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {

    final static String sourceName = "main/homeTasks/lab2/resources/temp.txt";

    public static void main(String[] args) {
        System.out.println(sourceName);
        File source = new File(sourceName);
        try {
            int N = getN(source);
            Matrix matrix = new Matrix(N);
            matrix.printMatrix("output.txt");
            for (int i = 0; i < 3; i++) {
                matrix.divideAndRotateMatrix();
                matrix.printMatrix("output.txt");
            }
        } catch (IOException | MatrixSizeOverflow | UndefinedFileException | DivideNullException err) {
            System.err.println(err.getMessage());
        }
    }

    public static int getN(File file) throws UndefinedFileException, FileNotFoundException {
        try (Scanner in = new Scanner(file)) {
            if (in.hasNextInt()) {
                int n = in.nextInt();
                return n;
            } else {
                throw new UndefinedFileException();
            }
        }
    }

}

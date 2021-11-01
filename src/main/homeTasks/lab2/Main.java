package main.homeTasks.lab2;

import main.homeTasks.lab2.Exceptions.DivideNullException;
import main.homeTasks.lab2.Exceptions.MatrixSizeOverflow;
import main.homeTasks.lab2.Exceptions.UndefinedFileException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    final static String inputFilePath = "/home/ilyait/JavaProjects/Global/JavaLabs-spbspu/src/main/homeTasks/lab2/temp.txt";

    public static void main(String[] args) {
        try {
            int N = readUsingFile();
            Matrix matrix = new Matrix(N);
            matrix.printMatrix("output.txt");
            for (int i = 0; i < 3; i++) {
                matrix.divideAndRotateMatrix();
                matrix.printMatrix("output.txt");
            }
        } catch (IOException | DivideNullException | MatrixSizeOverflow | UndefinedFileException err) {
            System.err.println(err.getMessage());
        }
    }

    private static int readUsingFile() throws UndefinedFileException {
        Path path = Paths.get(inputFilePath);
        List<String> allLines;
        int temp;
        try {
            allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
            temp = Integer.parseInt(allLines.get(0));
        } catch (IOException | NumberFormatException | IndexOutOfBoundsException e) {
            throw new UndefinedFileException();
        }
        return temp;
    }
}

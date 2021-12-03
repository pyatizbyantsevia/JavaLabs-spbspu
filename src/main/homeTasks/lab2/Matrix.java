package main.homeTasks.lab2;

import main.homeTasks.lab2.Exceptions.DivideNullException;
import main.homeTasks.lab2.Exceptions.MatrixSizeOverflow;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Matrix {

    private double[][] matrix;
    private static Logger logger;
    static
    {
        try(FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ilya_\\Documents\\Projects\\Java\\JavaLabs-spbspu\\src\\main\\homeTasks\\lab2\\resources\\log.config")){
            LogManager.getLogManager().readConfiguration(fileInputStream);
            logger = Logger.getLogger(Matrix.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Matrix(int size) throws MatrixSizeOverflow {
        if (size > 1000000) {
            throw new MatrixSizeOverflow();
        }
        Random rnd = new Random(System.currentTimeMillis());
        matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = ((-size) + rnd.nextInt(size - (-size) + 1));
            }
        }
    }

    public void printMatrix(String fileName) throws IOException {
        int N = matrix.length;
        FileWriter writer = new FileWriter(fileName, true);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                writer.write(String.valueOf(matrix[i][j]) + ' ');
            }
            writer.write('\n');
        }
        writer.write("\n-------------\n");
        writer.close();
    }

    public void divideAndRotateMatrix() throws DivideNullException {
        int N = matrix.length;
        ArrayList fullMatrix = new ArrayList();
        double[][] temp = new double[N][N];

        this.divideMatrix();

        for (int i = (N - 1); i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                fullMatrix.add(matrix[j][i]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = (double) fullMatrix.get(0);
                fullMatrix.remove(0);
            }
        }
        matrix = temp;
    }

    private void divideMatrix() throws DivideNullException {
        int N = matrix.length;
        double[][] temp = new double[N][N];
        double denominator;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    denominator = matrix[i][j+1];
                    if (denominator == 0.0) {
                        logger.log(Level.WARNING, "Problem element in the matrix: " + (i + 1) + " row, " + (j + 1) + " column.\n");
                        throw new DivideNullException();
                    }
                    temp[i][j] = Utils.roundingDouble(matrix[i][j] / denominator);
                } else if(j == (N - 1)) {
                    denominator = matrix[i][j-1];
                    if (denominator == 0.0) {
                        logger.log(Level.WARNING, "Problem element in the matrix: " + (i + 1) + " row, " + (j + 1) + " column.\n");
                        throw new DivideNullException();
                    }
                    temp[i][j] = Utils.roundingDouble(matrix[i][j] / denominator);
                } else {
                    denominator = (matrix[i][j-1] + matrix[i][j+1]);
                    if (denominator == 0.0) {
                        logger.log(Level.WARNING, "Problem element in the matrix: " + (i + 1) + " row, " + (j + 1) + " column.\n");
                        throw new DivideNullException();
                    }
                    temp[i][j] = Utils.roundingDouble(matrix[i][j] / denominator);
                }
            }
        }
        matrix = temp;
    }
}

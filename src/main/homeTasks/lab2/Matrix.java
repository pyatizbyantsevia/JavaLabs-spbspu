package main.homeTasks.lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Matrix {

    private double[][] matrix;

    public Matrix(int size) {
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
        writer.write("\n---\n");
        writer.close();
    }

    public void rotateAndDivideMatrix() {
        int N = matrix.length;
        ArrayList fullMatrix = new ArrayList();
        double[][] temp = new double[N][N];

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
        this.divideMatrix();
    }

    private void divideMatrix() {
        int N = matrix.length;
        double[][] temp = new double[N][N];
        double denominator;

        for (int i = 0; i < N; i++) { //must rework for exceptions
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    denominator = matrix[i][j+1];
                    if (denominator == 0.0) {
                        temp[i][j] = 10; //throw (?)
                        continue;
                    }
                    temp[i][j] = Utils.roundingDouble(matrix[i][j] / denominator);
                } else if(j == (N - 1)) {
                    denominator = matrix[i][j-1];
                    if (denominator == 0.0) {
                        temp[i][j] = 10;
                        continue;
                    }
                    temp[i][j] = Utils.roundingDouble(matrix[i][j] / denominator);
                } else {
                    denominator = (matrix[i][j-1] + matrix[i][j+1]);
                    if (denominator == 0.0) {
                        temp[i][j] = 10;
                        continue;
                    }
                    temp[i][j] = Utils.roundingDouble(matrix[i][j] / denominator);
                }
            }
        }
        matrix = temp;
    }
}

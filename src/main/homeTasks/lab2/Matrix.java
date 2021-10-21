package main.homeTasks.lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Matrix {

    private double[][] matrix;// = {{1,4,3,4}, {6,2,3,2}, {8,2,3,8}, {1,2,3,2}};

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
        writer.write("\n--------\n");
        writer.close();
    }

    public void rotateAndDivideMatrix() {
        int N = matrix.length;
        ArrayList fullMatrix = new ArrayList();
        double[][] temp = new double[N][N];

        for (int i = (N - 1); i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                double x = matrix[j][i];
                fullMatrix.add(x);
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

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    temp[i][j] = matrix[i][j] / matrix[i][j+1];
                } else if(j == (N - 1)) {
                    temp[i][j] = matrix[i][j] / matrix[i][j-1];
                } else {
                    temp[i][j] = matrix[i][j] / (matrix[i][j-1]+ matrix[i][j+1]);
                }
            }
        }
        matrix = temp;
    }
}

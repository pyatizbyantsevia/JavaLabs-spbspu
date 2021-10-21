package main.homeTasks.lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Matrix {

    private double[][] matrix = {{1,4,3,4}, {6,2,3,2}, {8,2,3,8}, {1,2,3,2}};

    public Matrix(int size) {
//        matrix = new double[size][size];
//        int[][] matrix = {{1,4,3,4}, {6,2,3,2}, {8,2,3,8}, {1,2,3,2}};
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                matrix[i][j] = (int) (Math.random() * N);
//            }
//        }
    }

    public void printMatrix(String fileName) throws IOException {
        int N = matrix.length;
        FileWriter writer = new FileWriter(fileName, false);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                writer.write(String.valueOf(matrix[i][j]) + ' ');
            }
            writer.write('\n');
        }
        writer.close();
    }

    public void rotateMatrix() {
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
    }
}

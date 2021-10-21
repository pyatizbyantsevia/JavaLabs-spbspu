package main.homeTasks.lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> list = readUsingFiles("/home/ilyait/JavaProjects/Global/JavaLabs-spbspu/src/main/homeTasks/lab2/temp.txt");
        int N = Integer.valueOf(list.get(0));

        int[][] matrix = {{1,2,3,4}, {1,2,3,2}, {1,2,3,8}, {1,2,3,2}};
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                matrix[i][j] = (int) (Math.random() * N);;
//            }
//        }
        printMatrix(matrix, "output.txt");

        int[][]rotatedMatrix = rotateMatrix(matrix);
        printMatrix(rotatedMatrix, "output1.txt");

        int[][]devidedMatrix = divideMatrix(rotatedMatrix);
        printMatrix(devidedMatrix, "output2.txt");
;
    }

    private static List<String> readUsingFiles(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        byte[] bytes = Files.readAllBytes(path);
        List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        return allLines;
    }

    public static int[][] rotateMatrix(int [][] src) {
        int N = src.length;
        ArrayList fullMatrix = new ArrayList();
        int[][] temp = new int[src.length][src.length];

        for (int i = (N - 1); i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                int x = src[j][i];
                fullMatrix.add(x);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = (int) fullMatrix.get(0);
                fullMatrix.remove(0);
            }
        }
        return temp;
    }

    public static void printMatrix(int [][] src, String fileName) throws IOException {
        int N = src.length;
        FileWriter writer = new FileWriter(fileName, false);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                writer.write(String.valueOf(src[i][j]) + ' ');
            }
            writer.write('\n');
        }
        writer.close();
    }

    public static int[][] divideMatrix(int [][] src) {
        int N = src.length;
        if (N == 0 || N == 1) {
            return src;
        }
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    temp[i][j] = src[i][j] / src[i][j+1];
                } else if(j == (N - 1)) {
                    temp[i][j] = src[i][j] / src[i][j-1];
                } else {
                    temp[i][j] = src[i][j] / (src[i][j-1]+ src[i][j+1]);
                }
            }
        }
        return temp;
    }
}

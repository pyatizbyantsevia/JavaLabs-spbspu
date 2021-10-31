package main.homeTasks.lab2;

public class Utils {

    public static double roundingDouble(double src) {
        String roundedString = String.format("%.3f",src);
        String refactoredString = roundedString.replace(',', '.');
        return Double.parseDouble(refactoredString);
    }
}

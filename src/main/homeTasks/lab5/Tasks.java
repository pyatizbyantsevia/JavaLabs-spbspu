package main.homeTasks.lab5;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Tasks {
    public static double task1(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics()
                .getAverage();
    }

    public static List<String> task2(List<String> list) {
        return list.stream()
                .map(str -> str = str.toUpperCase())
                .map(str -> str = "_new_" + str)
                .toList();
    }

    public static List<Integer> task3(List<Integer> list) {
        return list.stream()
                .filter(n -> Collections.frequency(list, n) == 1)
                .map(n -> n * n)
                .toList();
    }

    public static List<String> task4(Collection<String> list, String firstChar) {
        return list.stream()
                .filter(n -> n.startsWith(firstChar))
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .toList();
    }

    public static <T> T task5(Collection<T> collection) {
        return collection.stream()
                .reduce((a, b) -> b)
                .orElseThrow(() -> new NoSuchElementException("Collection is empty"));
    }

    public static int task6(int[] a) {
        return Arrays.stream(a)
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Map<Character, String> task7(List<String> list) {
        return list.stream()
                .collect(Collectors.toMap(str -> str.charAt(0), str -> str.substring(1)));
    }

}

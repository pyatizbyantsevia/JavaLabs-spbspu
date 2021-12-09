package main.homeTasks.lab4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        MyClass test = new MyClass();
        try {
            callAnnotatedMethods(test);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void callAnnotatedMethods(Object object) throws InvocationTargetException, IllegalAccessException {
        Class c = object.getClass();
        for (Method method:c.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                for (int i = 0; i < method.getAnnotation(MyAnnotation.class).value(); i++) {
                    method.setAccessible(true);
                    method.invoke(object);
                }
            }
        }
    }
}

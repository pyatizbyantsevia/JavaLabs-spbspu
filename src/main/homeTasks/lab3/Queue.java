package main.homeTasks.lab3;

import main.homeTasks.lab3.animal.vertebrata.mammalia.Mammalia;
import main.homeTasks.lab3.animal.vertebrata.mammalia.cat.Cat;

import java.util.ArrayList;

public class Queue<T> {
    private ArrayList<T> arrayList = new ArrayList<>();

    public void add(T src) {
        arrayList.add(src);
    }

    public T get(int i) {
        return arrayList.get(i);
    }

    private int size() {
        return this.arrayList.size();
    }


    public Queue<T> produce(Queue<T> src) {
        Queue<T> temp = new Queue<>();
        for (int i = 0; i < src.size(); i++) {
            if(src.get(i) instanceof Mammalia) {
                temp.add(src.get(i));
            }
        }
        return temp;
    }

    public ArrayList<Queue<T>> consume(Queue<T> src) {
        ArrayList<Queue<T>> temp = new ArrayList<>();
        ArrayList<? super Cat> first = new ArrayList<>();
        Queue<T> second = new Queue<>();

        for (int i = 0; i < src.size(); i++) {
            if(true) { //first.add(src.get(i))

            }

        }


        return temp;
    }



    public void print(){
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}

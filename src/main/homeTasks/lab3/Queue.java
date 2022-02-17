package main.homeTasks.lab3;

import main.homeTasks.lab3.animal.vertebrata.Vertebrata;
import main.homeTasks.lab3.animal.vertebrata.mammalia.Mammalia;
import main.homeTasks.lab3.animal.vertebrata.mammalia.cat.Cat;
import main.homeTasks.lab3.animal.vertebrata.mammalia.cat.assasin.Assasin;
import main.homeTasks.lab3.animal.vertebrata.mammalia.cat.assasin.UltraAssasin.UltraAssasin;
import main.homeTasks.lab3.animal.vertebrata.mammalia.primates.Primates;
import main.homeTasks.lab3.animal.vertebrata.mammalia.primates.homo.Homo;
import main.homeTasks.lab3.animal.vertebrata.mammalia.primates.homo.sapiens.Sapiens;

import java.util.ArrayList;
import java.util.Iterator;

public class Queue<T> {
    private ArrayList<T> queue;

    public Queue(int size) {
        if (size <= 0){
            throw new RuntimeException();
        }
        queue = new ArrayList<>(size);
    }

    private Queue(ArrayList<T> list)
    {
        if (list == null || list.isEmpty()) {
            throw new RuntimeException();
        }
        queue = list;
    }


    public void add(T src) {
        queue.add(src);
    }

    public T get(int i) {
        return queue.get(i);
    }

    public static Queue<? extends Vertebrata> produce(int n) {
        Vertebrata[] vertebratas = {
                new Mammalia(), new Cat(), new Assasin(), new UltraAssasin(),
                new Primates(), new Homo(), new Sapiens()
        };
        Queue<Vertebrata> producer = new Queue<>(n);
        for (int i = 0; i < n; i++) {
            producer.add(vertebratas[i]);
        }
        return producer;
    }

    public static void consume(Queue<? extends Vertebrata> producer) {
        ArrayList<Vertebrata> ultraAssasin = new ArrayList<>();
        ArrayList<Vertebrata> sapiens = new ArrayList<>();

        for (Iterator<? extends Vertebrata> iter = producer.queue.iterator(); iter.hasNext();) {
            Vertebrata o = iter.next();
            if (isParent(o, UltraAssasin.class)) {
                ultraAssasin.add(o);
            }
            if (isParent(o, Sapiens.class)) {
                sapiens.add(o);
            }
        }
        Queue<? super UltraAssasin> parentUltraAssasin = new Queue<>(ultraAssasin);
        Queue<? super Homo> parentHomo = new Queue<>(sapiens);

        System.out.println("Parents of UltraAssasin:");
        parentUltraAssasin.print();

        System.out.println("Parents of Sapiens:");
        parentHomo.print();

    }

    private static boolean isParent(Vertebrata parent, Class<? extends Vertebrata> child) {
        if (parent == null) {
            return false;
        }
        Class<?> current = child;
        while (current != Vertebrata.class) {
            if (current == parent.getClass()) {
                return true;
            }
            current = current.getSuperclass();
        }
        return false;
    }


    public void print(){
        if (queue.size() == 0) {
            throw new RuntimeException();
        }
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.get(i));
        }
    }
}

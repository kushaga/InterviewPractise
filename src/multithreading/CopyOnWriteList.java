package multithreading;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteList {
    //a thread safe implementation of arrayList , a new copy of the list is made when we add , remove elements
    //but it is very slow as compared to arraylist ,should be used when the application is read intensive.
    //the iterator dosen't support remove if used then it throws RuntimeException stating UnsupportedOperationException
    private static CopyOnWriteArrayList list = new CopyOnWriteArrayList();

    public static void main(String[] args) {
        list.add(1);
        list.add("1");
        list.add("abc");
        list.add("def");

        for (Object iter : list) {
            System.out.println(iter);
        }
        System.out.println(list);
    }
}

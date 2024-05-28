package main;

import java.util.LinkedList;

public class Cola<T> {

    private LinkedList<T> list;

    public Cola() {
        list = new LinkedList<T>();
    }

    public void inserta(T e) {
        list.add((T) e);
    }

    public T elimina() {
        T item = list.getFirst();
        list.remove(item);
        return item;
    }

    public boolean vacia() {
        return (list.isEmpty());
    }

    public T primero() {
        return list.getFirst();
    }

    public T ultimo() {
        return list.getLast();
    }

    public String toString() {
        return list.toString();
    }
}

package main;

public class Service {

    public Service() {
    }

    Integer[] dataGeneration(int start, int end, int n) {
        Integer[] aux = new Integer[n];
        for (int i = 0; i < n; i++) {
            aux[i] = (Integer) (int) (Math.floor(Math.random() * (end - start + 1) + start));
        }
        return aux;
    }

    Integer[] dataSelection(int start, int end, Integer[] array) {
        if (end > array.length - 1) {
            end = array.length - 1;
        }
        Integer[] aux = new Integer[end - start + 1];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = array[start + i];
        }
        return aux;
    }
}
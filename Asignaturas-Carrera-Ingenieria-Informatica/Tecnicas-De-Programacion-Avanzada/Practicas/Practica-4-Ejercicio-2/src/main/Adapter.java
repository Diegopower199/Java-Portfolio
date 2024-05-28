package main;

import java.util.ArrayList;

public class Adapter extends Client {

    private Service service1;

    public Adapter(Service servicio1) {
        this.service1 = servicio1;
    }

    public ArrayList<Integer> dataGeneration(int start, int end, int n) {
        ArrayList<Integer> aux = new ArrayList<Integer>(n);
        for (start = 0; start < n; start++) {
            aux.add((Integer) (int) (Math.floor(Math.random() * (end - start + 1) + start)));
        }

        return aux;
    }

    public ArrayList<Integer> dataSelection(int start, int end, ArrayList<Integer> array) {
        if (end > array.size() - 1) {
            end = array.size() - 1;
        }
        Integer[] aux = new Integer[end - start + 1];
        ArrayList<Integer> integerArray = new ArrayList<>(aux.length);

        for (int i = 0; i < aux.length; i++) {
            aux[i] = array.get(start + i);
            integerArray.add(aux[i]);
        }

        return integerArray;
    }

}

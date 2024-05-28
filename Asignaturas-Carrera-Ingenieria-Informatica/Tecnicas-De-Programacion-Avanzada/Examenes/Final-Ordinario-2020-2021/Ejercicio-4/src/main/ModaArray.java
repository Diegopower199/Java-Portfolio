package main;

import java.util.HashMap;
import java.util.Map;

public class ModaArray implements IModaEstadistica {

    int[] datos;

    public ModaArray(int[] datos) {
        this.datos = datos;
    }

    @Override
    public double moda() {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int repetido = 0, numMax = -1, repetidoCon = 0;

        for (int i : datos) {
            if (map.containsKey(i)) {
                repetido = map.get(i);
                map.put(i, ++repetido);
            } else {
                map.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (repetidoCon < e.getValue()) {
                repetidoCon = e.getValue();
                numMax = e.getKey();
            }
        }

        return numMax;
    }

}

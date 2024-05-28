package main;

import java.util.ArrayList;

public enum ComponentList {
    LED("LED"), BUZZER("BUZZER"), IR("IR");

    private final String items;

    ComponentList(String items) {
        this.items = items;
    }

    public static String[] getItems() {
        ComponentList[] items = ComponentList.values();
        ArrayList<String> stringItems = new ArrayList<String>();
        for (ComponentList item : items) {
            stringItems.add(item.toString());
        }
        String[] array = stringItems.toArray(new String[0]);

        return array;
    }

}

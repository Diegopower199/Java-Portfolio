package main;

public enum AtributoEnum {
    EROGANDO, MEZCLANDO;

    public static String[] getItems() {
        AtributoEnum[] Components = AtributoEnum.values();
        String[] stock = new String[Components.length];

        for (int i = 0; i < Components.length; i++) {
            stock[i] = (String) Components[i].toString();
        }

        return stock;
    }
}

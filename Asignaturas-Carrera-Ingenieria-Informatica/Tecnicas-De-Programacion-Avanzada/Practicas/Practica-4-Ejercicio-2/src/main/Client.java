package main;

import java.util.ArrayList;

public class Client {

    Client() {
        numbers = new ArrayList<Integer>();
    }

    private ArrayList<Integer> numbers;

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers.clear();
        this.numbers = numbers;
    }

}

package main;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger.setValue("logger 1");
        System.out.println(logger.getValue());

        logger2.setValue("logger 2");
        System.out.println(logger2.getValue());
    }
}

public class Result {

    private static int stringCounter = 0;
    private static int intCounter = 0;
    private static int doubleCounter = 0;

    public static void typeCounter(String sentence) {
        String[] wordsArray = sentence.split(" ");

        for (String input : wordsArray) {
            if (isInteger(input)) {
                intCounter += 1;
            } else if (isDouble(input)) {
                doubleCounter += 1;
            } else {
                stringCounter += 1;
            }
        }

        System.out.println("stringCounter: " + stringCounter + "\nintCounter: " + intCounter + "\ndoubleCounter: "
                + doubleCounter);

    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

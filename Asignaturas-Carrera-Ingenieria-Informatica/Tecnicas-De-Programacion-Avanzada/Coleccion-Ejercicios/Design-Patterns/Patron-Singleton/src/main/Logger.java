package main;

public class Logger {

    private static Logger log;

    private String value;

    private Logger() {
        super();
    }

    public static Logger getInstance() {
        if (log == null) {
            log = new Logger();
        }

        return log;
    }

    public String log(String msg) {
        return msg;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

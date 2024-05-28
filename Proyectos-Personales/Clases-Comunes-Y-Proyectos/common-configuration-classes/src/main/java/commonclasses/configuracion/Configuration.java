package commonclasses.configuracion;

public class Configuration {
    private String databaseUrl;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Configuration{" +
                "databaseUrl='" + databaseUrl + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package Domain;

public class Login {
    private String userType;
    private String username;
    private String password;

    public Login(String userType, String username, String password) {
        this.userType = userType;
        this.username = username;
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

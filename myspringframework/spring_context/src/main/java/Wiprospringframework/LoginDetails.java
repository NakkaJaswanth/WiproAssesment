package Wiprospringframework;

public class LoginDetails {

    private String username;
    private String password;

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    public void display() {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}

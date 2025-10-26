package ProjectPhase1;

class User {
    // Private attributes for username and password
    private String username;
    private String password;

    // Constructor to initialize user credentials
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Login method (validates username and password)
    public boolean login(String u, String p) {
        return username.equals(u) && password.equals(p);
    }

    // Getter for username
    public String getUsername() {
        return username;
    }
}

class AdminUser extends User {
    public AdminUser(String username, String password) {
        super(username, password);
    }

    // this method displays admin-specific message
    public void adminMessage() {
        System.out.println("Welcome Admin! You have full access.");
    }
}

class NormalUser extends User {
    public NormalUser(String username, String password) {
        super(username, password);
    }

    // this method displays normal user message
    public void userMessage() {
        System.out.println("Welcome User! Limited access granted.");
    }
}


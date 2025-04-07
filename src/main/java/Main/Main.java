package Main;

import Views.LoginView;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        LoginView index = new LoginView();
        index.loginView();
    }
}
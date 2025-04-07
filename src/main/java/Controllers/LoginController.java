package Controllers;

import Domain.Login;
import Model.LoginRepository;

import java.io.FileNotFoundException;

public class LoginController {
    private LoginRepository loginRepository;

    /**
     * Criamos o repositório com a data vinda do modelo
     */
    public LoginController(String loginPath) throws FileNotFoundException {
        this.loginRepository = LoginRepository.getInstance(loginPath);
    }

    /**
     * Função para fazer login
     *
     * @param username
     * @param password
     * @return o tipo de utilizador
     */
    public String loginFunction(String username, String password) {
        for (Login user : this.loginRepository.getLogins()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user.getUserType();
            }
        }
        return "ERROR";
    }
}

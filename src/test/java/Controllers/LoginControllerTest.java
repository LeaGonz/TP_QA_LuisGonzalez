package Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {
    private LoginController loginController;

    /**
     * Criamos o ambiente de test antes de cada test
     * @throws FileNotFoundException
     */
    @BeforeEach
    void setUp() throws FileNotFoundException {
        loginController = new LoginController("src/test/resources/Cesaeland_logins.csv");
    }

    /**
     * Testa o login bem-sucedido como um ADMIN
     */
    @Test
    void loginFunctionAdminTest() {
        assertEquals("ADMIN", loginController.loginFunction("root", "root"));
    }

    /**
     * Testa o login bem-sucedido como um ENG
     */
    @Test
    void loginFunctionEngineerTest() {
        assertEquals("ENG", loginController.loginFunction("pimentaMachado", "domingo"));
    }

    /**
     * Testa o login con credencias invalidas
     */
    @Test
    void loginFunctionInvalidUsernameTest() {
        assertEquals("ERROR", loginController.loginFunction("nonexistent", "password"));
    }

    /**
     * Testa a sensibilidade a maiúsculas/minúsculas no nome de utilizador
     */
    @Test
    void loginFunctionCaseSensitiveUsernameTest() {
        assertEquals("ERROR", loginController.loginFunction("ROOT", "root"));
    }

    /**
     * Testa a sensibilidade a maiúsculas/minúsculas na palavra-passe
     */
    @Test
    void loginFunctionCaseSensitivePasswordTest() {
        assertEquals("ERROR", loginController.loginFunction("root", "ROOT"));
    }

    /**
     * Testa o comportamento com credenciais vazias
     */
    @Test
    void loginFunctionEmptyCredentialsTest() {
        assertEquals("ERROR", loginController.loginFunction("", ""));
    }

    /**
     * Testa o comportamento com espaços em branco nas credenciais
     */
    @Test
    void loginFunctionWithWhitespaceTest() {
        assertEquals("ERROR", loginController.loginFunction(" root ", " root "));
    }

}
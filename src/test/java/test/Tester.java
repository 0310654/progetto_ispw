package test;

import com.example.progetto_ispw.dao.TesterDAO;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Tester {
    static TesterDAO tdao;

    @BeforeAll
    static void setup(){
        tdao = new TesterDAO();
    }

    @Test
    @Order(1)
    void connectionTest() {
        assertTrue(tdao.connectionTest(), "connessione eseguita correttamente");
    }

    @Test
    @Order(2)
    void registrazioneTest() {
        assertTrue(tdao.registrazioneTest());
    }

    @Test
    @Order(3)
    void loginTest() {
        assertTrue(tdao.loginTest(true), "login effettuato correttamente con mail e password giuste");
        assertFalse(tdao.loginTest(false), "login non effettuato con mail e password sbagliate");
    }

    @AfterAll
    static void deleteUserTest() {
        System.out.println("cancello l'utente di prova");
        tdao.deleteUserTest();
    }
}

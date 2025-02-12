package test;

import com.example.progetto_ispw.controller.TestController;
import com.example.progetto_ispw.dao.TesterDAO;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Tester {
    static TesterDAO tdao;
    static TestController controllerTest;

    @BeforeAll
    static void setup(){
        tdao = new TesterDAO();
        controllerTest = new TestController();
    }

    @Test
    @Order(1)
    void connectionTest() {
        assertTrue(tdao.connectionTest(), "connessione eseguita correttamente");
    }

    // PUNTO DI VISTA DEL DAO
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

    @Test
    @Order(4)
    void getQuestionariosTestDAO() {
        assertTrue(tdao.getQuestionariosTest());
    }

    @Test
    @Order(5)
    void votedQuestTestDAO(){
        assertTrue(tdao.votedQuestTest(), "votato correttamente con user test");
    }

    @AfterAll
    static void deleteDBRows() {
        System.out.println("cancello l'utente di prova (DAO Test user luigi)");
        tdao.deleteUserTestDAO("luigi@email.com", "password");
        System.out.println("cancello dalle collabs la votazione di prova (DAO Test votaz luigi)");
        tdao.deleteVoteTestDAO("luigi@email.com");
        System.out.println("cancello l'utente di prova (Controller test: user carlo)");
        tdao.deleteUserTestController("carlo@email.com", "password");
        System.out.println("cancello dalle collabs la votazione di prova (Controller test: votaz. carlo)");
        tdao.deleteVoteTestController("carlo@email.com");
    }

    //PUNTO DI VISTA DEL CONTROLLER
    @Test
    @Order(6)
    void registrazioneControllerTest(){
        assertTrue(controllerTest.test_registrazioneUser(), "registrato correttamente lo user test");
    }

    @Test
    @Order(7)
    void loginControllerTest(){
        assertTrue(controllerTest.loginTest(true), "login effettuato correttamente con mail e password giuste");
        assertFalse(controllerTest.loginTest(false), "login non effettuato con mail e password sbagliate");
    }

    @Test
    @Order(8)
    void getQuestionarioControllerTest(){
        assertTrue(controllerTest.getQuestionarioTest());
    }

    @Test
    @Order(9)
    void votedQuestControllerTest(){
        assertTrue(controllerTest.votedQuestTest(), "votato correttamente con user test");
    }

    @Test
    @Order(10)
    void cercaQuestControllerTest(){
        assertEquals(controllerTest.cercaQuestTest("Animali"), 0, "trovato match perfetto");
        assertEquals(controllerTest.cercaQuestTest("Cartaceo"), 1, "trovato questionario a distanza 1");
        assertEquals(controllerTest.cercaQuestTest("xxxxxxxxxxxxxx"), -1, "non trovato alcun match");
    }
}

package com.example.progetto_ispw.controller;

import com.example.progetto_ispw.dao.MasterDAO;
import com.example.progetto_ispw.model.Questionario;
import com.example.progetto_ispw.view.MasterView;

import java.util.*;

public class QuestionarioController {

    private static QuestionarioController instance;
    private ArrayList<Questionario> questionarios;
    private int currentQuest;

    private ArrayList<Questionario> questionariCercati;
    private int currentQuestCercati;
    private boolean ricercati = false;

    /**
     * Costruttore privato della classe. Inizializza i questionari disponibili
     * e imposta l'indice corrente della domanda.
     */
    private QuestionarioController() {
        setupQuestionari();
    }

    /**
     * Inizializza la lista di questionari disponibili recuperandoli dal database
     * tramite il DAO e imposta l'indice del questionario corrente a 0.
     */
    protected void setupQuestionari(){
        this.questionarios = MasterDAO.getInstance().getQuestionarios();
        this.currentQuest = 0;
    }

    /**
     * Restituisce l'istanza singleton di QuestionarioController.
     * Se l'istanza non esiste, viene creata una nuova istanza.
     *
     * @return l'istanza unica di QuestionarioController
     */
    public static QuestionarioController getInstance() {
        if(instance==null) {
            instance = new QuestionarioController();
        }
        return instance;
    }

    /**
     * Se non è stata eseguita una ricerca, restituisce il questionario dalla lista principale.
     * Se è stata eseguita una ricerca, restituisce il questionario dalla lista dei "cercati".
     *
     * @return il questionario corrente, o null se non ci sono più domande disponibili
     */
    public Questionario getQuestionario() {
        if (!ricercati) {
            if (questionarios == null || currentQuest >= questionarios.size()) {
                return null;
            }
            else {
                Questionario q = questionarios.get(currentQuest);
                return q ;
            }
        }
        else {
            if (questionariCercati == null || currentQuestCercati >= questionariCercati.size()) {
                return null;
            }
            else {
                Questionario q = questionariCercati.get(currentQuestCercati);
                return q ;
            }
        }
    }

    public boolean votedQuest(String risposta, String email) {
        String codiceQuest = questionarios.get(currentQuest).getCodice();
        return MasterDAO.getInstance().votedQuest( codiceQuest, risposta, email);
    }

    /**
     * Disabilita la modalità di ricerca, tornando alla visualizzazione dei questionari originali.
     */
    public void disattivaRicerca() {
        this.ricercati = false;
    }

    /**
     * Calcola la distanza di Levenshtein tra due stringhe, che rappresenta il numero minimo di operazioni
     * necessarie per trasformare una stringa nell'altra.
     *
     * @param s1 la prima stringa da confrontare
     * @param s2 la seconda stringa da confrontare
     * @return la distanza di Levenshtein tra le due stringhe
     */
    public static int levCalculate(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j] + 1,
                                    dp[i][j - 1] + 1),
                            dp[i - 1][j - 1] + cost
                    );
                }
            }
        }
        return dp[len1][len2];
    }


    public void cercaQuest(String input) {

        this.questionariCercati = new ArrayList<>();
        this.currentQuestCercati = 0;
        HashMap<Questionario, Integer> levVal ;
        try {
            levVal = controllaRicerca(input);
        } catch (NonTrovatoException e) {
            throw new RuntimeException(e);
        }
        List<Map.Entry<Questionario, Integer>> list = new ArrayList<>(levVal.entrySet());
        list.sort(Comparator.comparingInt(p -> p.getValue()));
        for (Map.Entry<Questionario, Integer> entry : list ) {
            questionariCercati.add(entry.getKey());
        }
        this.ricercati= true;
    }

    /**
     * Controlla se ci sono questionari che corrispondono all'input di ricerca.
     * Calcola la distanza di Levenshtein tra l'input e i testi delle domande, risposte e argomenti.
     * Se la distanza è inferiore o uguale a 2, il questionario viene aggiunto ai risultati della ricerca.
     *
     * @param input la parola chiave fornita dall'utente per la ricerca
     * @return una mappa contenente i questionari e la loro distanza di Levenshtein rispetto all'input
     * @throws NonTrovatoException se non ci sono questionari che corrispondono alla ricerca
     */
    private HashMap<Questionario, Integer> controllaRicerca(String input) throws NonTrovatoException {

        HashMap<Questionario, Integer> levVal = new HashMap<>();

        for ( Questionario q : questionarios) {
            Integer minDistance = null;
            int distanza;
            String domanda = q.getDomanda();
            for (String s : domanda.split(" ")) {
                distanza = levCalculate(input.toLowerCase(), s.toLowerCase());
                if (distanza <= 2 && minDistance == null) {
                    minDistance = distanza;
                }
                else if (distanza <= 2 && distanza < minDistance) {
                    minDistance = distanza;
                }
            }
            for (String s : q.getPossibiliRisposte()) {
                distanza = levCalculate(input.toLowerCase(), s.toLowerCase());
                if (distanza <= 2 && minDistance == null) {
                    minDistance = distanza;
                }
                else if (distanza <= 2 && distanza < minDistance) {
                    minDistance = distanza;
                }
            }
            String argomento = q.getArgomento();
            for (String s : argomento.split(" ")) {
                distanza = levCalculate(input.toLowerCase(), s.toLowerCase());
                if (distanza <= 2 && minDistance == null) {
                    minDistance = distanza;
                }
                else if (distanza <= 2 && distanza < minDistance) {
                    minDistance = distanza;
                }
            }
            if (minDistance != null) {
                levVal.put(q, minDistance);
            }
        }
        if(levVal.isEmpty()){
            throw new NonTrovatoException("Non ci sono questionari corrispondenti alla ricerca");
        }
        return levVal;
    }


    protected void nextQuest() {
        if (ricercati == false) {
            currentQuest ++;
        }
        else {
            currentQuestCercati ++;
        }
    }
}

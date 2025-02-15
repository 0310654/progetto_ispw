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

    private QuestionarioController() {
        setupQuestionari();
    }

    protected void setupQuestionari(){
        this.questionarios = MasterDAO.getInstance().getQuestionarios();
        this.currentQuest = 0;
    }

    public static QuestionarioController getInstance() {
        if(instance==null) {
            instance = new QuestionarioController();
        }
        return instance;
    }

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

    public void disattivaRicerca() {
        this.ricercati = false;
    }

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
            System.out.println(entry.getKey().getDomanda());
            System.out.println(entry.getValue());
        }
        this.ricercati= true;
    }

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

package com.example.progetto_ispw.view;

import java.util.ArrayList;

public class UserView {
    public int showMenu() {
        //TODO inserire azioni user
        System.out.println("inserire azione tramite valore:\n" +
                "0 - EXIT\n"
                /*"1 - cambio turno impiegato\n" +
                "2 - report\n" +
                "3 - registra nuovo impiegato\n" +
                "4 - aggiungi turni mensili\n" +
                "5 - cambia il ruolo"*/);

        String action;
        while (true) {
            action = getInput("");
            try {
                int action_int = Integer.parseInt(action);
                if (action_int >= 0 && action_int <= 5) {
                    return action_int;
                } else {
                    System.out.println("l'input deve essere un numero compreso tra 0 e 3, inserire nuovamente");
                }
            } catch (NumberFormatException e) {
                System.out.println("l'input deve essere un numero, inserire un valore ammissibile");
            }
        }
    }


//TODO inserire azioni
    /*public ArrayList<String> cambioruoliinput() {
        String nuovoRuolo = getInput( "Inserire nuovo ruolo:");
        String inizioPeriodo = getInput( "Inserire data di inizio con il nuovo ruolo:");
        String cfImpiegato = getInput( "Codice fiscale dell'impiegato:");
        ArrayList<String> result = new ArrayList<>();
        result.add(nuovoRuolo);
        result.add(inizioPeriodo);
        result.add(cfImpiegato);
        result.add(cfImpiegato);
        System.out.println("nuovo ruolo: " + nuovoRuolo);
        System.out.println("inizioPeriodo: " + inizioPeriodo);
        System.out.println("cfImpiegato: " + cfImpiegato);
        return result;
    }*/
}

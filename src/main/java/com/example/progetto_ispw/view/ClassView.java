package com.example.progetto_ispw.view;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ClassView {

    private Scanner scanner;

    public ClassView(){
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner(){
        return this.scanner;
    }

    public String getInput(String prompt) {
        System.out.println(prompt);
        String userinput = scanner.nextLine();
        System.out.println("hai inserito: " + userinput);
        return userinput;
    }

    public void printResultSet(ResultSet rs, String descrizione) {

        System.out.println("-------------------");
        System.out.println(descrizione);
        System.out.println("-------------------");
        try {
            int numero_colonne = rs.getMetaData().getColumnCount();
            for (int i = 1; i<=numero_colonne; i++){
                System.out.print(rs.getMetaData().getColumnName(i) + " | ");
            }
            System.out.println();
            while(rs.next()) {
                for (int i = 1; i<=numero_colonne; i++) {
                    System.out.print(rs.getString(i) + " | ");
                }
                System.out.println();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------");
    }

}

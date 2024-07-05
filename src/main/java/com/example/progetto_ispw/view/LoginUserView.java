package com.example.progetto_ispw.view;



import java.util.ArrayList;

public class LoginUserView extends ClassView {


    public ArrayList<String> logininput() {
        String email = getInput( "Inserire email:");
        String password = getInput("Inserire password:");
        ArrayList<String> result = new ArrayList<>();
        result.add(email);
        result.add(password);
        return result;
    }
}

package com.example.progetto_ispw.controller;

import java.sql.Connection;
import java.util.ArrayList;

public interface Controller {
    void start(Connection connection, ArrayList<String> attributi);
}

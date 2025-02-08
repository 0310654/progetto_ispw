package com.example.progetto_ispw.controller;
import com.example.progetto_ispw.dao.MasterDAO;
import java.util.AbstractMap;
import java.util.List;

public class CollabsController {

    public List<AbstractMap.SimpleEntry<String, String>> getCollabs(String email) {
        return MasterDAO.getInstance().getCollabs(email);
    }
}

package com.example.progetto_ispw.dao;

import com.example.progetto_ispw.controller.MasterController;

import java.sql.Connection;

public class MasterDAO {

    private static MasterDAO instance;
    private Connection connection;

    private MasterDAO() {
        this.connection = DBConnectionDAO.getInstance().getConnection();
    }

    public static Connection getConnection() {
        return DBConnectionDAO.getInstance().getConnection();
    }

    public static MasterDAO getInstance() {
        if(instance==null) {
            instance = new MasterDAO();
        }
        return instance;
    }

    public boolean loginUser(String email, String password) {
        LoginUserDAO lud = new LoginUserDAO(connection);
        lud.loginUser(email, password);
        return lud.loginUser(email, password);
    }

    public boolean internalLogin(String token) {
        Connection connection = this.connection;
        InternalLoginDAO ild = new InternalLoginDAO(connection);
        ild.internalLogin(token);
        return ild.internalLogin(token);
    }



}

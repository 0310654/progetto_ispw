package com.example.progetto_ispw.dao;

import com.example.progetto_ispw.controller.MasterController;

import java.sql.Connection;

public class MasterDAO {

    private static MasterDAO instance;
    private Connection connection;

    private MasterDAO() {}

    public void setConnection(Connection connection) {
        this.connection = DBConnectionDAO.getConnection();
    }

    public static MasterDAO getInstance() {
        if(instance==null) {
            instance = new MasterDAO();
        }
        return instance;
    }

    public boolean loginUser(String email, String password) {
        Connection connection = this.connection;
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

package com.example.progetto_ispw.controller;

public class WrongLoginException extends Exception {
    public WrongLoginException(String avviso){
        super(avviso);
    }
}

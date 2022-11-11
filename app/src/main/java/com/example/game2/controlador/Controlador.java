package com.example.game2.controlador;

import com.example.game2.MainActivity;
import com.example.game2.modelo.Modelo;
import com.example.game2.vista.vista;

public class Controlador implements Game,ParidaComunicacion{
    vista view;
    Modelo model;
    Partida partida;
    public Controlador(vista mainActivity,Modelo m) {
        this.view = mainActivity;
        this.model = m;
        partida = new Partida(this);
    }

    @Override
    public void player1Accion() {
        view.moveLeft();

    }

    @Override
    public void player2Accion() {
        view.moveRight();
    }

    @Override
    public boolean isOnRace() {
        return false;
    }

    @Override
    synchronized public void startPartida() {
        view.showMsg("Go!");
        view.hideMsg();


    }

    @Override
    synchronized public void showTime(int tiempo) {

    }

    @Override
    synchronized public void ShowMsgPreparatorio(int time) {

    }
}

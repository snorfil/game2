package com.example.game2.controlador;

public class Partida extends Thread {
    ParidaComunicacion controlador;

    public Partida(ParidaComunicacion controlador) {
        this.controlador = controlador;
    }

    @Override
    public void run() {
        super.run();

    }
}

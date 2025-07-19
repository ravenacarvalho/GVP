package app;

import organizador.Organizador;
import telas.TelaPrincipal;

public class Main {
    public static void main(String[] args) {
        Organizador organizador = new Organizador();
        new TelaPrincipal(organizador);
    }
}
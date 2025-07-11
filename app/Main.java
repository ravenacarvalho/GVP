package app;

import sistema.GerenciadorItens;
import telas.TelaPrincipal;

public class Main {
    public static void main(String[] args) {
        GerenciadorItens gerenciador = new GerenciadorItens();
        new TelaPrincipal(gerenciador);
    }
}
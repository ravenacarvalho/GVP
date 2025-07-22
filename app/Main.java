package app;

import organizador.Organizador;
import telas.TelaPrincipal;
import entidades.*;
import java.util.List;
import java.util.ArrayList;
import arquivos.ArquivoItens;
import arquivos.ArquivoLooks;

public class Main {
    public static void main(String[] args) {
        Organizador organizador = new Organizador();
        ArquivoItens arqItens = new ArquivoItens("itens.txt");
        ArquivoLooks arqLooks = new ArquivoLooks("looks.txt"); 

        //Carrega os itens do arquivo
        ArrayList<Item> itensLidos = arqItens.lerItens();
        for (int i = 0; i < itensLidos.size(); i++) {
            organizador.adicionar(itensLidos.get(i));
        }

        //Carrega os looks do arquivo
        List<Look> looksLidos = arqLooks.lerLooks(new ArrayList<>(organizador.pegarItens()));
        for (int i = 0; i < looksLidos.size(); i++) {
            organizador.adicionarLook(looksLidos.get(i));
        }

        //Inicia a tela principal
        new TelaPrincipal(organizador, arqItens, arqLooks);
    }
}

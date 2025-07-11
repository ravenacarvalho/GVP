package arquivos;

import entidades.*;
import java.util.*;
import java.io.*;

public class ArquivoItens {
    private String caminhoArquivo;

    public ArquivoItens(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    // Salva todos os itens
    public void salvarItens(List<Item> itens) {
        try {
            FileWriter fw = new FileWriter(caminhoArquivo);
            PrintWriter gravador = new PrintWriter(fw);
            for (Item item : itens) {
                String tipo = item.getClass().getSimpleName();
                gravador.println(tipo + "," +
                    item.getNome() + "," +
                    item.getCor() + "," +
                    item.getTamanho() + "," +
                    item.getLojaOrigem() + "," +
                    item.getEstadoConservacao() + "," +
                    item.getCaminhoImagem() + "," +
                    item.getVezesUsado());
            }
            gravador.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // Lê os itens do arquivo
    public List<Item> lerItens() {
        List<Item> itens = new ArrayList<>();
        try {
            FileReader fr = new FileReader(caminhoArquivo);
            BufferedReader leitor = new BufferedReader(fr);
            String linha;
            while((linha = leitor.readLine()) != null) {
                String[] campos = linha.split(",");
                String tipo = campos[0];
                String nome = campos[1];
                String cor = campos[2];
                String tamanho = campos[3];
                String loja = campos[4];
                String conservacao = campos[5];
                String caminhoImagem = campos[6];
                int vezesUsado = Integer.parseInt(campos[7]);

                Item item = null;
                switch(tipo) {
                    case "Camisa":
                        item = new Camisa(nome, cor, tamanho, loja, conservacao, caminhoImagem); break;
                    case "Calca":
                        item = new Calca(nome, cor, tamanho, loja, conservacao, caminhoImagem); break;
                    case "Saia":
                        item = new Saia(nome, cor, tamanho, loja, conservacao, caminhoImagem); break;
                    case "Casaco":
                        item = new Casaco(nome, cor, tamanho, loja, conservacao, caminhoImagem); break;
                    case "Calcinha":
                        item = new Calcinha(nome, cor, tamanho, loja, conservacao, caminhoImagem); break;
                    case "Cueca":
                        item = new Cueca(nome, cor, tamanho, loja, conservacao, caminhoImagem); break;
                    case "Relogio":
                        item = new Relogio(nome, cor, tamanho, loja, conservacao, caminhoImagem); break;
                    case "Pulseira":
                        item = new Pulseira(nome, cor, tamanho, loja, conservacao, caminhoImagem); break;
                }
                if (item != null) {
                    for (int i = 0; i < vezesUsado; i++) item.registrarUso();
                    itens.add(item);
                }
            }
            leitor.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return itens;
    }
}
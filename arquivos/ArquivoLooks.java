package arquivos;

import entidades.*;
import java.util.*;
import java.io.*;

public class ArquivoLooks {
    private String caminho;

    public ArquivoLooks(String arquivo) {
        this.caminho = arquivo;
    }

    // Salva todos os looks com seus itens 
    public void salvarLooks(ArrayList<Look> listaLooks) {
        try {
            FileWriter fw = new FileWriter(caminho);
            PrintWriter gravador = new PrintWriter(fw);

            for (int i = 0; i < listaLooks.size(); i++) {
                Look lk = listaLooks.get(i);
                StringBuilder linha = new StringBuilder();
                linha.append(lk.getNome());
                for (Item it : lk.getItens()) {
                    linha.append(";").append(it.getNome());
                }
                gravador.println(linha.toString());
            }
            gravador.close();
        } catch (Exception erro) {
            System.out.println("Deu erro ao salvar os looks.");
        }
    }

    // Para ler looks do arquivo, precisa passar os itens já carregados
    public List<Look> lerLooks(List<Item> listaDeItens) {
        ArrayList<Look> looksLidos = new ArrayList<Look>();
        try {
            BufferedReader leitura = new BufferedReader(new FileReader(caminho));
            String linhaAtual = leitura.readLine();
            while (linhaAtual != null) {
                String[] partes = linhaAtual.split(";");
                Look novoLook = new Look(partes[0]);
                for (int i = 1; i < partes.length; i++) {
                    String nomeItem = partes[i];
                    Item achado = buscarItemPorNome(nomeItem, listaDeItens);
                    if (achado != null) {
                        novoLook.montar(achado);
                    }
                }
                looksLidos.add(novoLook);
                linhaAtual = leitura.readLine();
            }
            leitura.close();
        } catch (Exception exc) {
            System.out.println("Não consegui ler os looks.");
        }
        return looksLidos;
    }

    // Função para buscar item pelo nome numa lista
    private Item buscarItemPorNome(String nome, List<Item> lista) {
        for (int i = 0; i < lista.size(); i++) {
            Item it = lista.get(i);
            if (it.getNome().equals(nome)) {
                return it;
            }
        }
        return null;
    }
}

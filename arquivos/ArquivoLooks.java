package arquivos;

import entidades.*;
import java.util.*;
import java.io.*;

public class ArquivoLooks {
    private String caminho;

    public ArquivoLooks(String arquivo) {
        this.caminho = arquivo;
    }

    //Salva todos os looks no arquivo, um por linha
    public void salvarLooks(ArrayList<Look> listaLooks) {
        try {
            FileWriter fw = new FileWriter(caminho);
            PrintWriter gravador = new PrintWriter(fw);
    
            for (int k = 0; k < listaLooks.size(); k++) { // Loop para cada look
                Look lk = listaLooks.get(k);
                StringBuilder linha = new StringBuilder();
                linha.append(lk.getNome());
                //Junta o nome dos itens do look, separados por ';'
                for (int i = 0; i < lk.pegarItens().size(); i++) { // Loop para cada item do look
                    Item it = lk.pegarItens().get(i);
                    linha.append(";").append(it.getNome());
                }
                gravador.println(linha.toString());
            }
            gravador.close();
        } catch (Exception erro) {
            System.out.println("Erro ao salvar os looks.");
        }
    }    

    //Lê os looks do arquivo (precisa passar os itens já carregados pra poder montar o look)
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
            System.out.println("Erro ao salvar os looks.");
        }
        return looksLidos;
    }

    // Busca um item pelo nome na lista passada
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

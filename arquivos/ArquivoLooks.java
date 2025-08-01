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
                ArrayList<Item> itens = new ArrayList<>(lk.pegarItens());
                for (int i = 0; i < itens.size(); i++) { // Loop para cada item do look
                    linha.append(";").append(itens.get(i).getNome());
                }
                //Adiciona usos registrados, separados por '|', tudo ao final da linha
                linha.append(";");
                ArrayList<String> usos = new ArrayList<>(lk.getUsos());
                if (usos != null && !usos.isEmpty()) {
                    for (int u = 0; u < usos.size(); u++) {
                        linha.append(usos.get(u));
                        if (u < usos.size() - 1) linha.append("|");
                    }
                }
                gravador.println(linha.toString());
            }
            gravador.close();
        } catch (Exception erro) {
            System.out.println("Erro ao salvar os looks.");
        }
    }    

    //Lê os looks salvos, precisa dos itens carregados para reconstruir cada look
    public List<Look> lerLooks(List<Item> listaDeItens) {
        ArrayList<Look> looksLidos = new ArrayList<Look>();
        try {
            BufferedReader leitura = new BufferedReader(new FileReader(caminho));
            String linhaAtual = leitura.readLine();
            while (linhaAtual != null) {
                String[] partes = linhaAtual.split(";");
                Look novoLook = new Look(partes[0]);
                //Adiciona os itens (menos o primeiro, que é nome, e o último, que são usos)
                for (int i = 1; i < partes.length - 1; i++) {
                    String nomeItem = partes[i];
                    Item achado = buscarItemPorNome(nomeItem, listaDeItens);
                    if (achado != null) {
                        novoLook.montar(achado);
                    }
                }
                //Só adiciona uso se não vazio e tiver " - " (ex: "10-07-2025 - Festa")
                String usosStr = partes[partes.length - 1];
                if (!usosStr.isEmpty() && usosStr.contains(" - ")) {
                    String[] usos = usosStr.split("\\|");
                    for (int j = 0; j < usos.length; j++) {
                        novoLook.registrarUso(usos[j]);
                    }
                }
                looksLidos.add(novoLook);
                linhaAtual = leitura.readLine();
            }
            leitura.close();
        } catch (Exception exc) {
            System.out.println("Erro ao ler os looks.");
        }
        return looksLidos;
    }
    
    //Busca um item pelo nome na lista passada
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

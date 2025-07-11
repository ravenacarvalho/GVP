package arquivos;

import entidades.*;
import java.util.*;
import java.io.*;

public class ArquivoLooks {
    private String caminhoArquivo;

    public ArquivoLooks(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    // Salva todos os looks
    public void salvarLooks(List<Look> looks) {
        try {
            FileWriter fw = new FileWriter(caminhoArquivo);
            PrintWriter gravador = new PrintWriter(fw);
            for (Look look : looks) {
                StringBuilder linha = new StringBuilder();
                linha.append(look.getNome());
                for (Item item : look.getItens()) {
                    linha.append(",").append(item.getNome());
                }
                gravador.println(linha.toString());
            }
            gravador.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // Lê os looks do arquivo
    public List<Look> lerLooks(List<Item> itens) {
        List<Look> looks = new ArrayList<>();
        try {
            FileReader fr = new FileReader(caminhoArquivo);
            BufferedReader leitor = new BufferedReader(fr);
            String linha;
            while((linha = leitor.readLine()) != null) {
                String[] campos = linha.split(",");
                String nomeLook = campos[0];
                Look look = new Look(nomeLook);
                for (int i = 1; i < campos.length; i++) {
                    for (Item item : itens) {
                        if (item.getNome().equalsIgnoreCase(campos[i])) {
                            look.adicionarItem(item);
                            break;
                        }
                    }
                }
                looks.add(look);
            }
            leitor.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return looks;
    }
}
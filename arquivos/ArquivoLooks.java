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
                gravador.println(look.getNome());
            }
            gravador.close();
        } catch(Exception e) {
            System.out.println("Ops! Não foi possível salvar os looks");
        }
    }

    // Lê os looks do arquivo
    public List<Look> lerLooks() {
        List<Look> looks = new ArrayList<>();
        try {
            FileReader fr = new FileReader(caminhoArquivo);
            BufferedReader leitor = new BufferedReader(fr);
            String linha = leitor.readLine();
            while (linha != null) {
                Look look = new Look(linha);
                if (look != null) {
                    looks.add(look);
                }
                linha = leitor.readLine();
            }
            leitor.close();
        } catch(Exception e) {
            System.out.println("Ops! Não foi possível ler os looks");
        }
        return looks;
    }
}

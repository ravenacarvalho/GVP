package arquivos;

import entidades.*;
import java.util.*;
import java.io.*;

public class ArquivoItens {
    private String caminho;

    public ArquivoItens(String arquivo) {
        this.caminho = arquivo;
    }

    // Método para salvar itens no arquivo
    public void salvarItens(ArrayList<Item> listaItens) {
        try {
            FileWriter fw = new FileWriter(caminho);
            PrintWriter gravador = new PrintWriter(fw);

            for (int pos = 0; pos < listaItens.size(); pos++) {
                Item it = listaItens.get(pos);
                String tipo = "";
                if (it instanceof Camisa) {
                    tipo = "Camisa";
                } 
                else if (it instanceof Calca) {
                    tipo = "Calca";
                }
                else if (it instanceof Saia) {
                    tipo = "Saia";
                }
                else if (it instanceof Casaco) {
                    tipo = "Casaco";
                }
                else if (it instanceof Calcinha) {
                    tipo = "Calcinha";
                }
                else if (it instanceof Cueca) {
                    tipo = "Cueca";
                }
                else if (it instanceof Relogio) {
                    tipo = "Relogio";
                }
                else if (it instanceof Pulseira) {
                    tipo = "Pulseira";
                }

                gravador.println(tipo + ";" +
                    it.getNome() + ";" +
                    it.getCor() + ";" +
                    it.getTamanho() + ";" +
                    it.getLojaOrigem() + ";" +
                    it.getEstadoConservacao() + ";" +
                    it.getCaminhoImagem() + ";" +
                    it.getVezesUsado()
                );
            }
            gravador.close();

        } catch (Exception erro) {
            System.out.println("Deu erro ao salvar os itens... Tenta de novo aí.");
        }
    }

    // Método para ler itens do arquivo
    public ArrayList<Item> lerItens() {
        ArrayList<Item> itensLidos = new ArrayList<Item>();
        try {
            BufferedReader leitura = new BufferedReader(new FileReader(caminho));
            String linhaAtual = leitura.readLine();
            while (linhaAtual != null) {
                String[] partesLinha = linhaAtual.split(";");
                String tipo = partesLinha[0];
                String nomeItem = partesLinha[1];
                String corItem = partesLinha[2];
                String tamItem = partesLinha[3];
                String lojaItem = partesLinha[4];
                String conserv = partesLinha[5];
                String img = partesLinha[6];
                int qtdUsos = Integer.parseInt(partesLinha[7]);

                Item item = null;
                if (tipo.equals("Camisa")) {
                    item = new Camisa(nomeItem, corItem, tamItem, lojaItem, conserv, img);
                }
                else if (tipo.equals("Calca")) {
                    item = new Calca(nomeItem, corItem, tamItem, lojaItem, conserv, img);
                }
                else if (tipo.equals("Saia")) {
                    item = new Saia(nomeItem, corItem, tamItem, lojaItem, conserv, img);
                }
                else if (tipo.equals("Casaco")) {
                    item = new Casaco(nomeItem, corItem, tamItem, lojaItem, conserv, img);
                }
                else if (tipo.equals("Calcinha")) {
                    item = new Calcinha(nomeItem, corItem, tamItem, lojaItem, conserv, img);
                }
                else if (tipo.equals("Cueca")) {
                    item = new Cueca(nomeItem, corItem, tamItem, lojaItem, conserv, img);
                }
                else if (tipo.equals("Relogio")) {
                    item = new Relogio(nomeItem, corItem, tamItem, lojaItem, conserv, img);
                }
                else if (tipo.equals("Pulseira")) {
                    item = new Pulseira(nomeItem, corItem, tamItem, lojaItem, conserv, img);
                }

                if (item != null) {
                    for (int k = 0; k < qtdUsos; k++) {
                        item.registrarUso();
                    }
                    itensLidos.add(item);
                }
                linhaAtual = leitura.readLine();
            }
            leitura.close();

        } catch (Exception erro) {
            System.out.println("Não consegui ler os itens... vê se o arquivo existe ou se está certinho.");
        }
        return itensLidos;
    }
}

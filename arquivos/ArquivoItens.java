package arquivos;

import entidades.*;
import java.util.*;
import java.io.*;
import interfaces.IEmprestavel;

public class ArquivoItens {
    private String caminho;

    public ArquivoItens(String arquivo) {
        this.caminho = arquivo;
    }

    //Salva todos os itens no arquivo (um por linha, separados por ;)
    public void salvarItens(ArrayList<Item> listaItens) {
        try {
            FileWriter fw = new FileWriter(caminho);
            PrintWriter gravador = new PrintWriter(fw);

            for (int pos = 0; pos < listaItens.size(); pos++) {
                Item it = listaItens.get(pos);
                String tipo = it.getTipo();

                //Monta a linha com os dados do item
                String linha = tipo + ";" +
                    it.getNome() + ";" +
                    it.getCor() + ";" +
                    it.getTamanho() + ";" +
                    it.getLojaOrigem() + ";" +
                    it.getEstadoConservacao() + ";" +
                    it.getCaminhoImagem() + ";" +
                    it.getVezesUsado();

                //Se o item é emprestável, adiciona os campos de empréstimo
                if (it instanceof IEmprestavel) {
                    IEmprestavel emp = (IEmprestavel) it;
                    linha += ";" + emp.estaEmprestado(); //true/false
                    String nomePessoa = emp.getNomePessoaEmprestimo();
                    linha += ";" + (nomePessoa == null ? "" : nomePessoa);
                    String data = "";
                    if (emp.getDataEmprestimo() != null) {
                        data = emp.getDataEmprestimo().toString(); //yyyy-MM-dd
                    }
                    linha += ";" + data;
                } else {
                    // Se não é emprestável, deixa os campos vazios
                    linha += ";false;;";
                }

                gravador.println(linha);
            }
            gravador.close();

        } catch (Exception erro) {
            System.out.println("Deu erro ao salvar os itens... Tenta de novo aí.");
        }
    }

    //Lê todos os itens do arquivo e devolve uma lista
    public ArrayList<Item> lerItens() {
        ArrayList<Item> itensLidos = new ArrayList<Item>();
        try {
            BufferedReader leitura = new BufferedReader(new FileReader(caminho));
            String linhaAtual = leitura.readLine();
            while (linhaAtual != null) {
                //Quebra a linha pelos ";"
                String[] partesLinha = linhaAtual.split(";");
                String tipo = partesLinha[0];
                String nomeItem = partesLinha[1];
                String corItem = partesLinha[2];
                String tamItem = partesLinha[3];
                String lojaItem = partesLinha[4];
                String conserv = partesLinha[5];
                String img = partesLinha[6];
                int qtdUsos = Integer.parseInt(partesLinha[7]);

                // =Campos de empréstimo (se existirem)
                boolean emprestado = false;
                String pessoa = "";
                String dataEmp = "";
                if (partesLinha.length > 8) {
                    emprestado = Boolean.parseBoolean(partesLinha[8]);
                }
                if (partesLinha.length > 9) {
                    pessoa = partesLinha[9];
                }
                if (partesLinha.length > 10) {
                    dataEmp = partesLinha[10];
                }

                Item item = null;
                // Cria o objeto correto conforme o tipo
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
                    //Marca o número de usos desse item em looks
                    for (int k = 0; k < qtdUsos; k++) {
                        item.registrarUso();
                    }
                    //Se for emprestável, seta os dados de empréstimo
                    if (item instanceof IEmprestavel) {
                        IEmprestavel emp = (IEmprestavel) item;
                        emp.setEmprestado(emprestado);
                        emp.setPessoaEmprestimo(pessoa);
                        if (!dataEmp.isEmpty()) {
                            emp.setDataEmprestimo(java.time.LocalDate.parse(dataEmp));
                        }
                    }
                    itensLidos.add(item);
                }
                linhaAtual = leitura.readLine();
            }
            leitura.close();

        } catch (Exception erro) {
            System.out.println("Erro ao ler os itens do arquivo.");
        }
        return itensLidos;
    }
}

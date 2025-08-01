package telas;

import entidades.*;
import organizador.Organizador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TelaCadastroItem extends JFrame {
    public TelaCadastroItem(Organizador organizador, arquivos.ArquivoItens arqItens) {
        super("Cadastro de Item");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painel = new JPanel();

        //Cada campo do formulário, um embaixo do outro
        painel.setLayout(new GridLayout(8, 2));

        painel.add(new JLabel("Tipo:"));
        // Montei o combo aqui com os tipos de item que criei
        JComboBox<String> comboTipo = new JComboBox<>(new String[]{"Camisa", "Calca", "Saia", "Casaco", "Calcinha", "Cueca", "Relogio", "Pulseira"});
        painel.add(comboTipo);

        painel.add(new JLabel("Nome:"));
        JTextField campoNome = new JTextField();
        painel.add(campoNome);

        painel.add(new JLabel("Cor:"));
        JTextField campoCor = new JTextField();
        painel.add(campoCor);

        painel.add(new JLabel("Tamanho:"));
        JTextField campoTamanho = new JTextField();
        painel.add(campoTamanho);

        painel.add(new JLabel("Loja:"));
        JTextField campoLoja = new JTextField();
        painel.add(campoLoja);

        painel.add(new JLabel("Conservação:"));
        JTextField campoConservacao = new JTextField();
        painel.add(campoConservacao);

        painel.add(new JLabel("Imagem (caminho):"));
        JTextField campoImagem = new JTextField();
        painel.add(campoImagem);

        JButton botaoCadastrar = new JButton("Cadastrar");
        painel.add(botaoCadastrar);
        painel.add(new JLabel("")); //Só pra completar o GridLayout

        getContentPane().add(painel);

        //Quando clicar, pega todos os dados e cadastra o item
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Pega tudo que foi preenchido
                String tipo = (String) comboTipo.getSelectedItem();
                String nome = campoNome.getText();
                String cor = campoCor.getText();
                String tamanho = campoTamanho.getText();
                String loja = campoLoja.getText();
                String conservacao = campoConservacao.getText();
                String imagem = campoImagem.getText();

                Item item = null;

                //Cria a subclasse correspondente conforme a escolha do tipo
                if (tipo.equals("Camisa")) {
                    item = new Camisa(nome, cor, tamanho, loja, conservacao, imagem);
                }
                else if (tipo.equals("Calca")) {
                    item = new Calca(nome, cor, tamanho, loja, conservacao, imagem);
                }
                else if (tipo.equals("Saia")) {
                    item = new Saia(nome, cor, tamanho, loja, conservacao, imagem);
                }
                else if (tipo.equals("Casaco")) {
                    item = new Casaco(nome, cor, tamanho, loja, conservacao, imagem);
                } 
                else if (tipo.equals("Calcinha")) {
                    item = new Calcinha(nome, cor, tamanho, loja, conservacao, imagem);
                }
                else if (tipo.equals("Cueca")) {
                    item = new Cueca(nome, cor, tamanho, loja, conservacao, imagem);
                } 
                else if (tipo.equals("Relogio")) {
                    item = new Relogio(nome, cor, tamanho, loja, conservacao, imagem);
                }
                else if (tipo.equals("Pulseira")) {
                    item = new Pulseira(nome, cor, tamanho, loja, conservacao, imagem);
                }
                // Se criou, adiciona no organizador e já salva no arquivo
                if (item != null) {
                    organizador.adicionar(item);
                    arqItens.salvarItens(new ArrayList<>(organizador.pegarItens()));
                    JOptionPane.showMessageDialog(null, "Item cadastrado!");
                    dispose();
                }
            }
        });

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

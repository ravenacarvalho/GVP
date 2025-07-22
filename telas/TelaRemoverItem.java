package telas;

import organizador.Organizador;
import entidades.Item;
import arquivos.ArquivoItens;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaRemoverItem extends JFrame {
    public TelaRemoverItem(Organizador organizador, ArquivoItens arqItens) {
        super("Remover Item");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());

        //Campo pra digitar o nome do item que vai remover
        painel.add(new JLabel("Nome do item que vai remover:"));
        JTextField campoNome = new JTextField(15);
        painel.add(campoNome);

        //Botão pra remover o item
        JButton botaoRemover = new JButton("Tentar Remover");
        painel.add(botaoRemover);

        //Quando clicar, tenta remover o item com esse nome
        botaoRemover.addActionListener(e -> {
            String nome = campoNome.getText();
            Item item = organizador.procurarItem(nome);

            if (item != null) {
                organizador.remover(item); //Remove da lista em memória
                arqItens.salvarItens(new ArrayList<>(organizador.pegarItens())); //Atualiza o arquivo com a lista nova
                JOptionPane.showMessageDialog(null, "Item removido com sucesso!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Item não encontrado!");
            }
        });

        getContentPane().add(painel);
        setSize(350, 120);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

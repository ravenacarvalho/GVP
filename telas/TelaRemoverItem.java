package telas;

import sistema.GerenciadorItens;
import entidades.Item;
import javax.swing.*;
import java.awt.*;

public class TelaRemoverItem extends JFrame {
    public TelaRemoverItem(GerenciadorItens gerenciador) {
        super("Remover Item");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());

        // Pergunta o nome do item pra remover
        painel.add(new JLabel("Nome do item que vai remover:"));
        JTextField campoNome = new JTextField(15);
        painel.add(campoNome);

        JButton botaoRemover = new JButton("Tentar Remover");
        painel.add(botaoRemover);

        // Quando clicar, tenta remover da lista
        botaoRemover.addActionListener(e -> {
            String nome = campoNome.getText();
            Item item = gerenciador.procurarItem(nome);

            if (item != null) {
                gerenciador.remover(item);
                // Dá um aviso quando conseguiu
                JOptionPane.showMessageDialog(null, "Item removido com sucesso!");
            } else {
                // Não achou o item, mostra aviso
                JOptionPane.showMessageDialog(null, "Item não encontrado!");
            }
        });

        getContentPane().add(painel);
        setSize(350, 120);
        // Centraliza a janela na tela
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

package telas;

import organizador.Organizador;
import entidades.Item;
import arquivos.ArquivoItens;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaRemoverItem extends JFrame {
    // Tela de remoção de itens do sistema
    public TelaRemoverItem(Organizador organizador, ArquivoItens arqItens) {
        super("Remover Item");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());

        // Campo para informar o nome do item a ser removido
        painel.add(new JLabel("Nome do item que vai remover:"));
        JTextField campoNome = new JTextField(15);
        painel.add(campoNome);

        // Botão para tentar remover o item informado
        JButton botaoRemover = new JButton("Tentar Remover");
        painel.add(botaoRemover);

        // Remove o item e salva a lista atualizada
        botaoRemover.addActionListener(e -> {
            String nome = campoNome.getText();
            Item item = organizador.procurarItem(nome);

            if (item != null) {
                organizador.remover(item); // Remove da lista em memória
                arqItens.salvarItens(new ArrayList<>(organizador.pegarItens())); // Salva no arquivo (persistência)
                JOptionPane.showMessageDialog(null, "Item removido com sucesso!");
                dispose(); // Fecha a tela após remover
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

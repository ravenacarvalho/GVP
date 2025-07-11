package telas;

import sistema.GerenciadorItens;
import entidades.Item;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaRemoverItem extends JFrame {
    public TelaRemoverItem(GerenciadorItens gerenciador) {
        super("Remover Item");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());
        painel.add(new JLabel("Nome do item para remover:"));
        JTextField campoNome = new JTextField(15);
        painel.add(campoNome);
        JButton botaoRemover = new JButton("Remover");
        painel.add(botaoRemover);
        botaoRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                Item item = gerenciador.buscarPorNome(nome);
                if (item != null) {
                    gerenciador.removerItem(item);
                    JOptionPane.showMessageDialog(null, "Removido!");
                } else {
                    JOptionPane.showMessageDialog(null, "Não encontrado.");
                }
            }
        });
        getContentPane().add(painel);
        setSize(350, 120);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
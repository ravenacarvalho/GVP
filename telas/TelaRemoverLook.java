package telas;

import organizador.Organizador;
import entidades.Look;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import arquivos.ArquivoLooks;

public class TelaRemoverLook extends JFrame {
    public TelaRemoverLook(Organizador organizador, ArquivoLooks arqLooks) {
        super("Remover Look");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());

        painel.add(new JLabel("Nome do look para remover:"));
        JTextField campoNome = new JTextField(15);
        painel.add(campoNome);

        JButton botaoRemover = new JButton("Remover");
        painel.add(botaoRemover);

        botaoRemover.addActionListener(e -> {
            String nome = campoNome.getText();
            Look look = organizador.buscarLookPorNome(nome);
            if (look != null) {
                organizador.removerLook(look);
                arqLooks.salvarLooks(new ArrayList<>(organizador.pegarLooks()));
                JOptionPane.showMessageDialog(null, "Look removido com sucesso!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Look não encontrado.");
            }
        });

        getContentPane().add(painel);
        setSize(350, 120);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

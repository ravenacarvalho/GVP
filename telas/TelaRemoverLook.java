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

        //Campo pra digitar o nome do look que quer remover
        painel.add(new JLabel("Nome do look para remover:"));
        JTextField campoNome = new JTextField(15);
        painel.add(campoNome);

        //Botão pra remover
        JButton botaoRemover = new JButton("Remover");
        painel.add(botaoRemover);

         //Quando clicar, tenta remover o look pelo nome digitado
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

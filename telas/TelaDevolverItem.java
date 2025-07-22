package telas;

import entidades.Item;
import organizador.Organizador;
import interfaces.IEmprestavel;
import javax.swing.*;
import java.awt.*;
import arquivos.ArquivoItens;

public class TelaDevolverItem extends JFrame {
    public TelaDevolverItem(Organizador organizador, arquivos.ArquivoItens arqItens) {
        super("Devolver Item");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());

        //Campo pra digitar o nome do item
        painel.add(new JLabel("Nome do item para devolver:"));
        JTextField campoNome = new JTextField(15);
        painel.add(campoNome);

        //Botão pra registrar devolução
        JButton botaoDevolver = new JButton("Registrar Devolução");
        painel.add(botaoDevolver);

        //Quando clicar, tenta devolver o item pelo nome
        botaoDevolver.addActionListener(e -> {
            String nome = campoNome.getText();
            Item item = organizador.procurarItem(nome);

            if (item instanceof IEmprestavel) {
                IEmprestavel emp = (IEmprestavel) item;
                if (emp.isEmprestado()) {
                    emp.registrarDevolucao();
                    // Salva o novo estado dos itens
                    arqItens.salvarItens(new java.util.ArrayList<>(organizador.pegarItens()));
                    JOptionPane.showMessageDialog(null, "Devolução registrada!");
                } else {
                    JOptionPane.showMessageDialog(null, "Item não está emprestado.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Item não é emprestável.");
            }
        });

        getContentPane().add(painel);
        setSize(350, 120);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

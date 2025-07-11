package telas;

import sistema.GerenciadorItens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal(GerenciadorItens gerenciador) {
        super("Gestor de Vestuário Pessoal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnCadastro = new JButton("Cadastrar Item");
        JButton btnListar = new JButton("Listar Itens");
        JButton btnRemover = new JButton("Remover Item");
        JButton btnSair = new JButton("Sair");

        painel.add(btnCadastro);
        painel.add(btnListar);
        painel.add(btnRemover);
        painel.add(btnSair);

        getContentPane().add(painel);

        btnCadastro.addActionListener(e -> new TelaCadastroItem(gerenciador));
        btnListar.addActionListener(e -> new TelaListarItens(gerenciador));
        btnRemover.addActionListener(e -> new TelaRemoverItem(gerenciador));
        btnSair.addActionListener(e -> System.exit(0));

        setSize(300, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
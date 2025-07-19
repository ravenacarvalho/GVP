package telas;

import organizador.Organizador;
import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal(Organizador organizador) {
        super("Gestor de Vestuário Pessoal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();

        painel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton botaoCad = new JButton("Cadastrar Item"); // Pra cadastrar roupa nova
        JButton botaoListar = new JButton("Listar Itens"); // Mostra tudo que já foi cadastrado
        JButton botaoDel = new JButton("Remover Item"); // Pra apagar algum item
        JButton botaoFechar = new JButton("Sair"); // Fecha o programa

        // Adicionando os botões no painel
        painel.add(botaoCad);
        painel.add(botaoListar);
        painel.add(botaoDel);
        painel.add(botaoFechar);

        getContentPane().add(painel);

        // Quando clica no botão, abre a tela correspondente
        botaoCad.addActionListener(e -> new TelaCadastroItem(organizador));
        botaoListar.addActionListener(e -> new TelaListarItens(organizador));
        botaoDel.addActionListener(e -> new TelaRemoverItem(organizador));
        botaoFechar.addActionListener(e -> System.exit(0));

        setSize(300, 250);
        setVisible(true);
    }
}

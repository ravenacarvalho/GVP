package telas;

import organizador.Organizador;
import javax.swing.*;
import java.awt.*;
import arquivos.ArquivoItens;
import arquivos.ArquivoLooks;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal(Organizador organizador, ArquivoItens arqItens, ArquivoLooks arqLooks) {
        super("Gestor de Vestuário Pessoal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        //Painel dos botões principais
        JPanel colItens = new JPanel(new GridLayout(6, 1, 10, 10));
        JPanel colLooks = new JPanel(new GridLayout(6, 1, 10, 10));
        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 30, 0));

        //Adicionando os botões de itens
        JButton botaoCad = new JButton("Cadastrar Item");
        colItens.add(botaoCad);
        botaoCad.addActionListener(e -> new TelaCadastroItem(organizador, arqItens));

        JButton botaoEditar = new JButton("Editar Item");
        colItens.add(botaoEditar);
        botaoEditar.addActionListener(e -> new TelaEditarItem(organizador, arqItens));

        JButton botaoDel = new JButton("Remover Item");
        colItens.add(botaoDel);
        botaoDel.addActionListener(e -> new TelaRemoverItem(organizador, arqItens));

        JButton botaoEmprestar = new JButton("Emprestar Item");
        colItens.add(botaoEmprestar);
        botaoEmprestar.addActionListener(e -> new TelaEmprestarItem(organizador, arqItens));

        JButton botaoDevolver = new JButton("Devolver Item");
        colItens.add(botaoDevolver);
        botaoDevolver.addActionListener(e -> new TelaDevolverItem(organizador, arqItens));

        JButton botaoListar = new JButton("Listar Itens");
        colItens.add(botaoListar);
        botaoListar.addActionListener(e -> new TelaListarItens(organizador));

        //Botões dos looks
        JButton botaoMontarLook = new JButton("Montar Look");
        colLooks.add(botaoMontarLook);
        botaoMontarLook.addActionListener(e -> new TelaMontarLook(organizador, arqLooks, arqItens));

        JButton botaoEditarLook = new JButton("Editar Look");
        colLooks.add(botaoEditarLook);
        botaoEditarLook.addActionListener(e -> new TelaEditarLook(organizador, arqLooks));

        JButton botaoRemoverLook = new JButton("Remover Look");
        colLooks.add(botaoRemoverLook);
        botaoRemoverLook.addActionListener(e -> new TelaRemoverLook(organizador, arqLooks));

        JButton botaoRegistrarUsoLook = new JButton("Registrar Uso Look");
        colLooks.add(botaoRegistrarUsoLook);
        botaoRegistrarUsoLook.addActionListener(e -> new TelaRegistrarUsoLook(organizador, arqLooks));

        JButton botaoVerUsoLook = new JButton("Ver Uso Look");
        colLooks.add(botaoVerUsoLook);
        botaoVerUsoLook.addActionListener(e -> new TelaVerUsoLook(organizador));

        JButton botaoListarLooks = new JButton("Listar Looks");
        colLooks.add(botaoListarLooks);
        botaoListarLooks.addActionListener(e -> new TelaListarLooks(organizador, arqLooks));

        //Junta os dois lados no painelBotoes
        painelBotoes.add(colItens);
        painelBotoes.add(colLooks);
        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);

        //Botão pra sair do sistema fica embaixo sozinho
        JButton botaoFechar = new JButton("Sair");
        JPanel painelSair = new JPanel();
        painelSair.add(botaoFechar);
        painelPrincipal.add(painelSair, BorderLayout.SOUTH);
        botaoFechar.addActionListener(e -> System.exit(0));

        getContentPane().add(painelPrincipal);

        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

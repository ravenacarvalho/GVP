package telas;

import organizador.Organizador;
import javax.swing.*;
import java.awt.*;
import arquivos.ArquivoItens;
import arquivos.ArquivoLooks;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal(Organizador organizador, arquivos.ArquivoItens arqItens, arquivos.ArquivoLooks arqLooks) {
        super("Gestor de Vestuário Pessoal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();

        //GridLayout pra ficar tudo alinhado, um botão embaixo do outro
        painel.setLayout(new GridLayout(11, 1, 10, 10));

        //Tipos de botões
        JButton botaoCad = new JButton("Cadastrar Item"); //Pra cadastrar item novo
        JButton botaoEditar = new JButton("Editar Item"); //Pra editar item
        JButton botaoListar = new JButton("Listar Itens"); //Pra listar todos os itens cadastrados
        JButton botaoDel = new JButton("Remover Item"); //Pra apagar algum item
        JButton botaoEmprestar = new JButton("Emprestar Item"); //Pra emprestar algum item
        JButton botaoDevolver = new JButton("Devolver Item"); //Pra devolver algum item
        JButton botaoMontarLook = new JButton("Montar Look"); //Pra montar looks
        JButton botaoEditarLook = new JButton("Editar Look"); //Pra editar looks
        JButton botaoListarLooks = new JButton("Listar Looks"); //Pra listar todos os looks criados
        JButton botaoRemoverLook = new JButton("Remover Look"); //Pra remover algum look
        JButton botaoFechar = new JButton("Sair"); //Fecha o programa

        //Adiciona os botões no painel
        painel.add(botaoCad);
        painel.add(botaoEditar);
        painel.add(botaoListar);
        painel.add(botaoDel);
        painel.add(botaoEmprestar);
        painel.add(botaoDevolver);
        painel.add(botaoMontarLook);
        painel.add(botaoEditarLook);
        painel.add(botaoListarLooks);
        painel.add(botaoRemoverLook);
        painel.add(botaoFechar);

        getContentPane().add(painel);

        //Quando clica no botão, abre a tela correspondente
        botaoCad.addActionListener(e -> new TelaCadastroItem(organizador, arqItens));
        botaoEditar.addActionListener(e -> new TelaEditarItem(organizador, arqItens));
        botaoListar.addActionListener(e -> new TelaListarItens(organizador));
        botaoDel.addActionListener(e -> new TelaRemoverItem(organizador, arqItens));
        botaoEmprestar.addActionListener(e -> new TelaEmprestarItem(organizador, arqItens));
        botaoDevolver.addActionListener(e -> new TelaDevolverItem(organizador, arqItens));
        botaoMontarLook.addActionListener(e -> new TelaMontarLook(organizador, arqLooks, arqItens));
        botaoEditarLook.addActionListener(e -> new TelaEditarLook(organizador, arqLooks));
        botaoListarLooks.addActionListener(e -> new TelaListarLooks(organizador, arqLooks));
        botaoRemoverLook.addActionListener(e -> new TelaRemoverLook(organizador, arqLooks));

        botaoFechar.addActionListener(e -> System.exit(0)); //Fecha o programa

        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

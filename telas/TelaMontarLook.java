package telas;

import entidades.*;
import organizador.Organizador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import arquivos.ArquivoLooks;
import arquivos.ArquivoItens;
import java.util.ArrayList;

public class TelaMontarLook extends JFrame {
    public TelaMontarLook(Organizador organizador, ArquivoLooks arqLooks, arquivos.ArquivoItens arqItens) {
        super("Montar Look");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        // Campo para nome do look
        JPanel painelTopo = new JPanel();
        painelTopo.setLayout(new GridLayout(2, 1));
        JPanel linhaNome = new JPanel();
        linhaNome.add(new JLabel("Nome do Look:"));
        JTextField campoNome = new JTextField(15);
        linhaNome.add(campoNome);
        painelTopo.add(linhaNome);
        painelTopo.add(new JLabel("Segure Ctrl para selecionar mais de um item!"));
        painel.add(painelTopo, BorderLayout.NORTH);

        // Lista de itens disponíveis
        DefaultListModel<Item> modelo = new DefaultListModel<>();
        for (int i = 0; i < organizador.pegarItens().size(); i++) {
            Item item = organizador.pegarItens().get(i);
            modelo.addElement(item);
        }

        JList<Item> listaItens = new JList<>(modelo);
        listaItens.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane scroll = new JScrollPane(listaItens);
        painel.add(scroll, BorderLayout.CENTER);

        // Botão para montar look
        JButton botaoMontar = new JButton("Montar Look");
        painel.add(botaoMontar, BorderLayout.SOUTH);

        botaoMontar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText().trim();
                if (nome.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Dê um nome ao look.");
                    return;
                }
                Look look = new Look(nome);
                java.util.List<Item> selecionados = listaItens.getSelectedValuesList();
                for (int i = 0; i < selecionados.size(); i++) {
                    Item item = selecionados.get(i);
                    look.montar(item);
                    item.registrarUso();
                }
                organizador.adicionarLook(look);
                arqLooks.salvarLooks(new ArrayList<>(organizador.pegarLooks())); // Salva os looks
                arqItens.salvarItens(new ArrayList<>(organizador.pegarItens())); // Salva os itens com os usos atualizados
                JOptionPane.showMessageDialog(null, "Look criado!");
                dispose();
            }
        });        

        getContentPane().add(painel);
        setSize(400, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

package telas;

import entidades.*;
import organizador.Organizador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import arquivos.ArquivoLooks;

public class TelaEditarLook extends JFrame {
    public TelaEditarLook(Organizador organizador, ArquivoLooks arqLooks) {
        super("Editar Look");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel(new BorderLayout());

        //Seleciona o look a ser editado
        JPanel painelTopo = new JPanel(new GridLayout(2, 1, 5, 5));
        painelTopo.add(new JLabel("Selecione o Look:"));
        JComboBox<Look> comboLooks = new JComboBox<>();
        for (int i = 0; i < organizador.pegarLooks().size(); i++) {
            Look look = organizador.pegarLooks().get(i);
            comboLooks.addItem(look);
        }
        painelTopo.add(comboLooks);

        painel.add(painelTopo, BorderLayout.NORTH);

        //Campos para editar nome e itens
        JPanel painelCentro = new JPanel();
        painelCentro.add(new JLabel("Novo nome do Look:"));
        JTextField campoNome = new JTextField(15);
        painelCentro.add(campoNome);

        painelCentro.add(new JLabel("Itens do Look:"));
        DefaultListModel<Item> modelo = new DefaultListModel<>();
        for (int i = 0; i < organizador.pegarItens().size(); i++) {
            modelo.addElement(organizador.pegarItens().get(i));
        }
        JList<Item> listaItens = new JList<>(modelo);
        listaItens.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scroll = new JScrollPane(listaItens);
        scroll.setPreferredSize(new Dimension(200, 170));
        painelCentro.add(scroll);

        painel.add(painelCentro, BorderLayout.CENTER);

        //Botão salvar
        JButton botaoSalvar = new JButton("Salvar Alterações");
        painel.add(botaoSalvar, BorderLayout.SOUTH);

        //Quando selecionar um look, preenche os campos
        comboLooks.addActionListener(e -> {
            Look selecionado = (Look) comboLooks.getSelectedItem();
            if (selecionado != null) {
                campoNome.setText(selecionado.getNome());
                // Marca os itens que já pertencem ao look
                List<Item> itensDoLook = selecionado.pegarItens();
                ArrayList<Integer> indicesList = new ArrayList<>();
                for (int i = 0; i < modelo.size(); i++) {
                    if (itensDoLook.contains(modelo.getElementAt(i))) {
                        indicesList.add(i);
                    }
                }
                int[] indices = indicesList.stream().mapToInt(i -> i).toArray();
                listaItens.setSelectedIndices(indices);
            }
        });

        //Inicializa os campos com o primeiro look
        if (comboLooks.getItemCount() > 0) {
            comboLooks.setSelectedIndex(0);
        }

        botaoSalvar.addActionListener(e -> {
            Look selecionado = (Look) comboLooks.getSelectedItem();
            if (selecionado != null) {
                String novoNome = campoNome.getText().trim();
                if (!novoNome.isEmpty()) {
                    selecionado.setNome(novoNome);
                }
                selecionado.limparItens();
                List<Item> selecionados = listaItens.getSelectedValuesList();
                for (int i = 0; i < selecionados.size(); i++) {
                    selecionado.montar(selecionados.get(i));
                }
                //Atualiza o arquivo de looks
                arqLooks.salvarLooks(new ArrayList<>(organizador.pegarLooks()));
                JOptionPane.showMessageDialog(null, "Look modificado com sucesso!");
                dispose();
            }
        });

        getContentPane().add(painel);
        setSize(400, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

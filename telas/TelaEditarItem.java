package telas;

import entidades.Item;
import organizador.Organizador;
import javax.swing.*;
import java.awt.*;
import arquivos.ArquivoItens;
import java.util.ArrayList;

public class TelaEditarItem extends JFrame {
    public TelaEditarItem(Organizador organizador, ArquivoItens arqItens) {
        super("Editar Item");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(8, 2, 5, 5));

        painel.add(new JLabel("Selecione o item:"));
        //Combo pra escolher qual item quer editar
        JComboBox<Item> comboItem = new JComboBox<>();
        ArrayList<Item> listaItens = organizador.pegarItens();  // Usar o próprio objeto como referência permite acessar métodos direto na seleção
        for (int i = 0; i < listaItens.size(); i++) {
            comboItem.addItem(listaItens.get(i));
        }
        painel.add(comboItem);

        painel.add(new JLabel("Cor:"));
        JTextField campoCor = new JTextField();
        painel.add(campoCor);

        painel.add(new JLabel("Tamanho:"));
        JTextField campoTamanho = new JTextField();
        painel.add(campoTamanho);

        painel.add(new JLabel("Loja:"));
        JTextField campoLoja = new JTextField();
        painel.add(campoLoja);

        painel.add(new JLabel("Conservação:"));
        JTextField campoConservacao = new JTextField();
        painel.add(campoConservacao);

        painel.add(new JLabel("Imagem (caminho):"));
        JTextField campoImagem = new JTextField();
        painel.add(campoImagem);

        //Quando escolher o item, preenche os campos com os dados dele
        comboItem.addActionListener(e -> {
            Item selecionado = (Item) comboItem.getSelectedItem();
            if (selecionado != null) {
                campoCor.setText(selecionado.getCor());
                campoTamanho.setText(selecionado.getTamanho());
                campoLoja.setText(selecionado.getLojaOrigem());
                campoConservacao.setText(selecionado.getEstadoConservacao());
                campoImagem.setText(selecionado.getCaminhoImagem());
            }
        });

        //Já preenche os campos com o primeiro item, se tiver algum
        if (comboItem.getItemCount() > 0) {
            comboItem.setSelectedIndex(0);
            Item selecionado = (Item) comboItem.getSelectedItem();
            campoCor.setText(selecionado.getCor());
            campoTamanho.setText(selecionado.getTamanho());
            campoLoja.setText(selecionado.getLojaOrigem());
            campoConservacao.setText(selecionado.getEstadoConservacao());
            campoImagem.setText(selecionado.getCaminhoImagem());
        }

        //Botão pra salvar as alterações feitas
        JButton botaoSalvar = new JButton("Salvar Alterações");
        painel.add(botaoSalvar);

        painel.add(new JLabel("")); //Só pra alinhar o layout

        botaoSalvar.addActionListener(e -> {
            Item selecionado = (Item) comboItem.getSelectedItem();
            if (selecionado == null) {
                JOptionPane.showMessageDialog(null, "Selecione um item para editar.");
                return;
            }
            //Atualiza as infos direto no objeto selecionado
            selecionado.setCor(campoCor.getText().trim());
            selecionado.setTamanho(campoTamanho.getText().trim());
            selecionado.setLojaOrigem(campoLoja.getText().trim());
            selecionado.setEstadoConservacao(campoConservacao.getText().trim());
            selecionado.setCaminhoImagem(campoImagem.getText().trim());

            //Salva toda a lista de itens no arquivo (pra garantir que ficou salvo)
            arqItens.salvarItens(new ArrayList<>(organizador.pegarItens()));
            JOptionPane.showMessageDialog(null, "Item alterado com sucesso!");
            dispose();
        });

        getContentPane().add(painel);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

package telas;

import entidades.*;
import organizador.Organizador;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import arquivos.ArquivoItens;
import java.time.format.DateTimeFormatter; 

public class TelaEmprestarItem extends JFrame {
    public TelaEmprestarItem(Organizador organizador, arquivos.ArquivoItens arqItens) {
        super("Emprestar Item");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 2, 5, 5));

        // Combo só com itens emprestáveis
        painel.add(new JLabel("Selecione o item:"));
        JComboBox<Item> comboItem = new JComboBox<>();
        for (int i = 0; i < organizador.pegarItens().size(); i++) {
            Item item = organizador.pegarItens().get(i);
            if (item instanceof interfaces.IEmprestavel) {
                interfaces.IEmprestavel emp = (interfaces.IEmprestavel) item;
                if (!emp.isEmprestado()) { // Só mostra se não estiver emprestado
                    comboItem.addItem(item);
                }
            }
        }
        painel.add(comboItem);

        painel.add(new JLabel("Para quem?"));
        JTextField campoPessoa = new JTextField();
        painel.add(campoPessoa);

        painel.add(new JLabel("Data (DD-MM-YYYY):"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        JTextField campoData = new JTextField(LocalDate.now().format(formatter));;
        painel.add(campoData);

        JButton botaoEmprestar = new JButton("Emprestar");
        painel.add(botaoEmprestar);

        // Só pra alinhar o botão na grade
        painel.add(new JLabel(""));

        botaoEmprestar.addActionListener(e -> {
            Item selecionado = (Item) comboItem.getSelectedItem();
            String pessoa = campoPessoa.getText().trim();
            String dataStr = campoData.getText().trim();

            if (selecionado == null) {
                JOptionPane.showMessageDialog(null, "Escolha um item para emprestar.");
                return;
            }
            if (pessoa.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha o nome da pessoa.");
                return;
            }
            try {
                LocalDate dataEmprestimo = LocalDate.parse(dataStr, formatter);
                interfaces.IEmprestavel itemEmp = (interfaces.IEmprestavel) selecionado;
                itemEmp.registrarEmprestimo(pessoa, dataEmprestimo);
                arqItens.salvarItens(new java.util.ArrayList<>(organizador.pegarItens()));
                JOptionPane.showMessageDialog(null, "Item emprestado!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Data inválida! Use o formato DD-MM-AAAA.");
            }
        });

        getContentPane().add(painel);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

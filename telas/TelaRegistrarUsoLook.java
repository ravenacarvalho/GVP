package telas;

import entidades.Look;
import organizador.Organizador;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import arquivos.ArquivoLooks;

public class TelaRegistrarUsoLook extends JFrame {
    public TelaRegistrarUsoLook(Organizador organizador, ArquivoLooks arqLooks) {
        super("Registrar Uso de Look");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Painel principal
        JPanel painel = new JPanel(new GridLayout(5, 2, 5, 5));

        //Campo pra escolher qual look foi usado
        painel.add(new JLabel("Selecione o Look:"));
        JComboBox<Look> comboLooks = new JComboBox<>();
        for (int i = 0; i < organizador.pegarLooks().size(); i++) {
            Look look = organizador.pegarLooks().get(i);
            comboLooks.addItem(look);
        }        
        painel.add(comboLooks);

        //Campo pra digitar a data do uso
        painel.add(new JLabel("Data (DD-MM-AAAA):"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        JTextField campoData = new JTextField(LocalDate.now().format(formatter));
        painel.add(campoData);

        //Campo pra descrever a ocasião do uso
        painel.add(new JLabel("Descrição da ocasião:"));
        JTextField campoDescricao = new JTextField();
        painel.add(campoDescricao);

        //Botão pra registrar o uso
        JButton botaoRegistrar = new JButton("Registrar Uso");
        painel.add(botaoRegistrar);

        painel.add(new JLabel("")); //Só pra alinhar a grade

        //Quando clicar no botão, salva o uso do look
        botaoRegistrar.addActionListener(e -> {
            Look selecionado = (Look) comboLooks.getSelectedItem();
            String dataStr = campoData.getText().trim();
            String descricao = campoDescricao.getText().trim();
            if (selecionado == null) {
                JOptionPane.showMessageDialog(null, "Selecione um look.");
                return;
            }
            if (descricao.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe a ocasião.");
                return;
            }
            try {
                LocalDate data = LocalDate.parse(dataStr, formatter);
                String textoUso = data.format(formatter) + " - " + descricao;
                selecionado.registrarUso(textoUso);
                // Salva os looks atualizados, incluindo o uso registrado
                arqLooks.salvarLooks(new ArrayList<>(organizador.pegarLooks()));
                JOptionPane.showMessageDialog(null, "Uso registrado com sucesso!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Data inválida! Use o formato DD-MM-AAAA.");
            }
        });

        getContentPane().add(painel);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

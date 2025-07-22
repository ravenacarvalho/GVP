package telas;

import entidades.Look;
import organizador.Organizador;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaVerUsoLook extends JFrame {
    public TelaVerUsoLook(Organizador organizador) {
        super("Histórico de Usos do Look");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Painel principal
        JPanel painel = new JPanel(new BorderLayout());

        //Campo pra escolher o look
        JComboBox<Look> comboLooks = new JComboBox<>();
        for (int i = 0; i < organizador.pegarLooks().size(); i++) {
            Look look = organizador.pegarLooks().get(i);
            comboLooks.addItem(look);
        }
        painel.add(comboLooks, BorderLayout.NORTH);

        //Área pra mostrar os usos do look
        JTextArea areaUsos = new JTextArea(10, 40);
        areaUsos.setEditable(false);
        painel.add(new JScrollPane(areaUsos), BorderLayout.CENTER);

        //Atualiza a área toda vez que mudar o look selecionado
        comboLooks.addActionListener(e -> {
            Look selecionado = (Look) comboLooks.getSelectedItem();
            if (selecionado != null) {
                List<String> usos = selecionado.getUsos();
                StringBuilder texto = new StringBuilder();
                if (usos.isEmpty()) {
                    texto.append("Nenhuma utilização registrada.");
                } else {
                    //Mostra cada uso numa linha
                    for (int i = 0; i < usos.size(); i++) {
                        texto.append(usos.get(i)).append("\n");
                    }
                }
                areaUsos.setText(texto.toString());
            }
        });

        //Já exibe o primeiro look ao abri, se tiver
        if (comboLooks.getItemCount() > 0) {
            comboLooks.setSelectedIndex(0);
        }

        getContentPane().add(painel);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

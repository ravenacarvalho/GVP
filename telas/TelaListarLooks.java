package telas;

import entidades.*;
import organizador.Organizador;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import arquivos.ArquivoLooks;

public class TelaListarLooks extends JFrame {
    public TelaListarLooks(Organizador organizador, ArquivoLooks arqLooks) {
        super("Looks Cadastrados");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultListModel<Look> modelo = new DefaultListModel<>();
        List<Look> looks = organizador.pegarLooks();
        for (int i = 0; i < looks.size(); i++) {
            modelo.addElement(looks.get(i));
        }

        JList<Look> listaLooks = new JList<>(modelo);
        JScrollPane scroll = new JScrollPane(listaLooks);

        getContentPane().add(scroll, BorderLayout.CENTER);

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

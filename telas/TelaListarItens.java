package telas;

import entidades.Item;
import organizador.Organizador;
import javax.swing.*;
import java.awt.*;

public class TelaListarItens extends JFrame {
    public TelaListarItens(Organizador organizador) {
        super("Listar Itens");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        JTextArea areaTexto = new JTextArea(10, 40);
        areaTexto.setEditable(false);
        StringBuilder texto = new StringBuilder();
        for (Item item : organizador.pegarItens()) {
            texto.append(item.getTipo())
                 .append(" - ").append(item.getNome())
                 .append(", Cor: ").append(item.getCor())
                 .append(", Tamanho: ").append(item.getTamanho())
                 .append(", Loja: ").append(item.getLojaOrigem())
                 .append(", Conservação: ").append(item.getEstadoConservacao())
                 .append(", Usos: ").append(item.getVezesUsado())
                 .append("\n");
        }
        areaTexto.setText(texto.toString());
        painel.add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        getContentPane().add(painel);
        setSize(500, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

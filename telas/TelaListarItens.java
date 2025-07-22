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

        //Layout pra centralizar a lista
        painel.setLayout(new BorderLayout());

        //Aqui vai aparecer a lista de todos os itens cadastrados
        JTextArea areaTexto = new JTextArea(10, 40);
        areaTexto.setEditable(false);

        //Adiciona rolagem pra conseguir ver tudo se a lista ficar grande
        painel.add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        //Monta o texto de cada item pra mostrar na tela
        StringBuilder texto = new StringBuilder();
        //Percorre todos os itens cadastrados no organizador para exibir na tela
        for (int i = 0; i < organizador.pegarItens().size(); i++) {
            Item item = organizador.pegarItens().get(i);
            texto.append(item.getTipo())
                 .append(" - ").append(item.getNome())
                 .append(", Cor: ").append(item.getCor())
                 .append(", Tamanho: ").append(item.getTamanho())
                 .append(", Loja: ").append(item.getLojaOrigem())
                 .append(", Conservação: ").append(item.getEstadoConservacao())
                 .append(", Usos: ").append(item.getVezesUsado());

            // Exibe dias desde o empréstimo se o item for emprestável e está emprestado
            if (item instanceof interfaces.IEmprestavel) {
                interfaces.IEmprestavel emp = (interfaces.IEmprestavel) item;
                if (emp.estaEmprestado()) {
                    long dias = emp.quantidadeDiasEmprestado();
                    texto.append(" (Emprestado há ").append(dias).append(" dias)");
                }
            }
            texto.append("\n");
        }

        //Joga o texto dos itens pra área de exibição
        areaTexto.setText(texto.toString());

        getContentPane().add(painel);
        setSize(500, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Look implements Serializable {
    private String nomeLook;
    private List<Item> itensDoLook;
    private List<String> usosLook;

    public Look(String nomeLook) {
        this.nomeLook = nomeLook;
        this.itensDoLook = new ArrayList<>();
        this.usosLook = new ArrayList<>();
    }
    //Adiciona item no look
    public void montar(Item item) {
        itensDoLook.add(item);
    }
    //Remove item do look
    public void removerItem(Item item) {
        itensDoLook.remove(item);
    }
    //Mostra todos os itens do look como string
    @Override
    public String toString() {
        String res = "Look: " + nomeLook + "\n";
        for (int i = 0; i < itensDoLook.size(); i++) {
            Item it = itensDoLook.get(i);
            String tipo = "";
            if (it instanceof Camisa) {
                tipo = "Camisa";
            } else if (it instanceof Calca) {
                tipo = "Calça";
            } else if (it instanceof Saia) {
                tipo = "Saia";
            } else if (it instanceof Casaco) {
                tipo = "Casaco";
            } else if (it instanceof Calcinha) {
                tipo = "Calcinha";
            } else if (it instanceof Cueca) {
                tipo = "Cueca";
            } else if (it instanceof Pulseira) {
                tipo = "Pulseira";
            } else if (it instanceof Relogio) {
                tipo = "Relógio";
            } else {
                tipo = "Item";
            }
            res += "  " + tipo + " - " + it.getNome() + "\n";
        }
    return res;
    }

    //Registrar uso do look e manter histórico
    public void registrarUso(String descricao) {
        usosLook.add(descricao);
    }

    public String getNome() {
        return nomeLook;
    }
    public List<Item> pegarItens() {
        return itensDoLook;
    }

    public void setNome(String nome) {
        this.nomeLook = nome;
    }

    public void limparItens() {
        itensDoLook.clear(); 
    }
}

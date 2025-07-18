package entidades;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Look implements Serializable {
    private String nomeLook;
    private List<Item> listaItens;
    private List<String> usosLook;

    public Look(String nomeLook) {
        this.nomeLook = nomeLook;
        this.listaItens = new ArrayList<>();
        this.usosLook = new ArrayList<>();
    }

    public String getNome() {
        return nomeLook;
    }

    public List<Item> getItens() {
        return listaItens;
    }

    public void adicionarItem(Item item) {
        listaItens.add(item);
    }

    public void removerItem(Item item) {
        listaItens.remove(item);
    }

    public void registrarUso(String descricao) {
        usosLook.add(descricao);
    }

    public List<String> getUsos() {
        return usosLook;
    }

    @Override
    public String toString() {
        return nomeLook;
    }
}

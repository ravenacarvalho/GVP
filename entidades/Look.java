package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Look implements Serializable {
    private String nome;
    private List<Item> itens;
    private List<String> usos; // Exemplo: "10/03/2025 - Aniversário da Maria"

    public Look(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
        this.usos = new ArrayList<>();
    }

    public String getNome() { 
        return nome; 
    }
    
    public List<Item> getItens() { 
        return itens; 
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }

    public void registrarUso(String descricao) {
        usos.add(descricao);
    }

    public List<String> getUsos() { return usos; }

    @Override
    public String toString() {
        return nome;
    }
}

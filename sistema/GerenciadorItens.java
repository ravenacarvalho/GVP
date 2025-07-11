package sistema;

import entidades.Item;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorItens {
    private List<Item> itens;

    public GerenciadorItens() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }

    public List<Item> getItens() {
        return itens;
    }

    public Item buscarPorNome(String nome) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null;
    }

    public void editarItem(String nome, Item novoItem) {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getNome().equalsIgnoreCase(nome)) {
                itens.set(i, novoItem);
                break;
            }
        }
    }
}

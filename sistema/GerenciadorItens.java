package sistema;

import entidades.Item;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorItens {
    private List<Item> lstItens;

    public GerenciadorItens() {
        lstItens = new ArrayList<>();
    }

    // Adiciona item na lista 
    public void adicionar(Item it) {
        lstItens.add(it);
    }

    // Remove item na lista
    public void remover(Item it) {
        lstItens.remove(it);
    }

    // Procura item pelo nome
    public Item procurarItem(String nome) {
        for (Item item : lstItens) {
            if (item.getNome().equals(nome)) {
                return item;
            }
        }
        return null;
    }

    // Troca item antigo por outro novo 
    public void trocarItem(String nome, Item novo) {
        for (int i = 0; i < lstItens.size(); i++) {
            if (lstItens.get(i).getNome().equals(nome)) {
                lstItens.set(i, novo);
                break;
            }
        }
    }

    // Pega a lista pra mostrar na tela 
    public List<Item> pegarItens() {
        return lstItens;
    }
}

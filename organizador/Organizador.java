package organizador;

import entidades.*;
import java.util.ArrayList;
import java.util.List;

public class Organizador {
    private ArrayList<Item> lstItens;
    private ArrayList<Look> looks;

    public Organizador() {
        lstItens = new ArrayList<>();
        looks = new ArrayList<>();
    }

    // Métodos de Item
    public void adicionar(Item it) {
        lstItens.add(it);
    }
    public void remover(Item it) {
        lstItens.remove(it);
    }
    public Item procurarItem(String nome) {
        for (int i = 0; i < lstItens.size(); i++) {
            Item item = lstItens.get(i);
            if (item.getNome().equals(nome)) {
                return item;
            }
        }
        return null;
    }
    public void trocarItem(String nome, Item novo) {
        for (int i = 0; i < lstItens.size(); i++) {
            if (lstItens.get(i).getNome().equals(nome)) {
                lstItens.set(i, novo);
                break;
            }
        }
    }
    public ArrayList<Item> pegarItens() {
        return lstItens;
    }

    //Estatísticas
    public void mostrarItemMaisUsado() {
        if (lstItens == null || lstItens.isEmpty()) {
            System.out.println("Sem item cadastrado");
            return;
        }
        Item maisUsado = lstItens.get(0);
        for (int i = 1; i < lstItens.size(); i++) {
            if (lstItens.get(i).getVezesUsado() > maisUsado.getVezesUsado()) {
                maisUsado = lstItens.get(i);
            }
        }
        System.out.println("O item mais usado é: " + maisUsado.getNome() + " (" + maisUsado.getVezesUsado() + " usos)");
    }
    public void mostrarItemMenosUsado() {
        if (lstItens == null || lstItens.isEmpty()) {
            System.out.println("Sem itens na lista pra ver o menos usado.");
            return;
        }
        Item menosUsado = lstItens.get(0);
        for (int i = 1; i < lstItens.size(); i++) {
            if (lstItens.get(i).getVezesUsado() < menosUsado.getVezesUsado()) {
                menosUsado = lstItens.get(i);
            }
        }
        System.out.println("O item menos usado é: " + menosUsado.getNome() + " (" + menosUsado.getVezesUsado() + " usos)");
    }
    public void mostrarItensEmprestados() {
        boolean temEmp = false;
        for (int i = 0; i < lstItens.size(); i++) {
            Item it = lstItens.get(i);

            if (it instanceof interfaces.IEmprestavel) {
                interfaces.IEmprestavel emp = (interfaces.IEmprestavel) it;
                if (emp.isEmprestado()) {
                    System.out.println(it.getNome() + " está emprestado agora.");
                    temEmp = true;
                }
            }
        }
        if (!temEmp) {
            System.out.println("Nenhum item emprestado.");
        }
    }

    // Métodos de Look
    public void adicionarLook(Look look) {
        looks.add(look);
    }
    public void removerLook(Look look) {
        looks.remove(look);
    }
    public ArrayList<Look> pegarLooks() {
        return looks;
    }
    public Look buscarLookPorNome(String nome) {
        for (int i = 0; i < looks.size(); i++) {
            if (looks.get(i).getNome().equalsIgnoreCase(nome)) {
                return looks.get(i);
            }
        }
        return null;
    }
}

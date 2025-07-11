package sistema;

import entidades.Look;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorLooks {
    private List<Look> looks;

    public GerenciadorLooks() {
        this.looks = new ArrayList<>();
    }

    public void adicionarLook(Look look) {
        looks.add(look);
    }

    public void removerLook(Look look) {
        looks.remove(look);
    }

    public List<Look> getLooks() {
        return looks;
    }

    public Look buscarPorNome(String nome) {
        for (Look look : looks) {
            if (look.getNome().equalsIgnoreCase(nome)) {
                return look;
            }
        }
        return null;
    }
}

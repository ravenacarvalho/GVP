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
    // Adicionar item no look
    public void montar(Item item) {
        itensDoLook.add(item);
    }
    // Remover item do look
    public void removerItem(Item item) {
        itensDoLook.remove(item);
    }
    // Mostrar todos os itens do look
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
    
    // Trocar Camisa
    public void modificarCamisa(Camisa novaCamisa) {
        boolean trocou = false;
        for (int i = 0; i < itensDoLook.size(); i++) {
            if (itensDoLook.get(i) instanceof Camisa) {
                itensDoLook.set(i, novaCamisa);
                trocou = true;
                break;
            }
        }
        if (!trocou) {
            itensDoLook.add(novaCamisa); // se não tinha, coloca
        }
    }

    // Trocar Calca
    public void modificarCalca(Calca novaCalca) {
        boolean trocou = false;
        for (int i = 0; i < itensDoLook.size(); i++) {
            if (itensDoLook.get(i) instanceof Calca) {
                itensDoLook.set(i, novaCalca);
                trocou = true;
                break;
            }
        }
        if (!trocou) {
            itensDoLook.add(novaCalca); // se não tinha, coloca
        }
    }

    // Trocar Saia
    public void modificarSaia(Saia novaSaia) {
        boolean trocou = false;
        for (int i = 0; i < itensDoLook.size(); i++) {
            if (itensDoLook.get(i) instanceof Saia) {
                itensDoLook.set(i, novaSaia);
                trocou = true;
                break;
            }
        }
        if (!trocou) {
            itensDoLook.add(novaSaia); // se não tinha, coloca
        }
    }

    // Trocar Casaco
    public void modificarCasaco(Casaco novoCasaco) {
        boolean trocou = false;
        for (int i = 0; i < itensDoLook.size(); i++) {
            if (itensDoLook.get(i) instanceof Casaco) {
                itensDoLook.set(i, novoCasaco);
                trocou = true;
                break;
            }
        }
        if (!trocou) {
            itensDoLook.add(novoCasaco);
        }
    }

    // Trocar Calcinha
    public void modificarCalcinha(Calcinha novaCalcinha) {
        boolean trocou = false;
        for (int i = 0; i < itensDoLook.size(); i++) {
            if (itensDoLook.get(i) instanceof Calcinha) {
                itensDoLook.set(i, novaCalcinha);
                trocou = true;
                break;
            }
        }
        if (!trocou) {
            itensDoLook.add(novaCalcinha);
        }
    }

    // Trocar Cueca
    public void modificarCueca(Cueca novaCueca) {
        boolean trocou = false;
        for (int i = 0; i < itensDoLook.size(); i++) {
            if (itensDoLook.get(i) instanceof Cueca) {
                itensDoLook.set(i, novaCueca);
                trocou = true;
                break;
            }
        }
        if (!trocou) {
            itensDoLook.add(novaCueca);
        }
    }

    // Trocar Pulseira
    public void modificarPulseira(Pulseira novaPulseira) {
        boolean trocou = false;
        for (int i = 0; i < itensDoLook.size(); i++) {
            if (itensDoLook.get(i) instanceof Pulseira) {
                itensDoLook.set(i, novaPulseira);
                trocou = true;
                break;
            }
        }
        if (!trocou) {
            itensDoLook.add(novaPulseira);
        }
    }

    // Trocar Relogio
    public void modificarRelogio(Relogio novoRelogio) {
        boolean trocou = false;
        for (int i = 0; i < itensDoLook.size(); i++) {
            if (itensDoLook.get(i) instanceof Relogio) {
                itensDoLook.set(i, novoRelogio);
                trocou = true;
                break;
            }
        }
        if (!trocou) {
            itensDoLook.add(novoRelogio);
        }
    }

    // Registrar uso e manter histórico
    public void registrarUso(String descricao) {
        usosLook.add(descricao);
    }
    public List<String> getUsos() {
        return usosLook;
    }
    public String getNome() {
        return nomeLook;
    }
    public List<Item> pegarItens() {
        return itensDoLook;
    }
}

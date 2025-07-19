package entidades;

import interfaces.ILavavel;
import java.time.LocalDate;

public class Cueca extends Item implements ILavavel {
    private LocalDate ultimaLavagem = null;

    public Cueca(String nomeCueca, String corCueca, String tam, String loja, String conservacao, String img) {
        super(nomeCueca, corCueca, tam, loja, conservacao, img, "Cueca");
    }
    @Override
    public void registrarLavagem(LocalDate data) {
        ultimaLavagem = data;
    }
    @Override
    public LocalDate getUltimaLavagem() {
        return ultimaLavagem;
    }
}

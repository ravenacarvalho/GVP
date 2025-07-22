package entidades;

import interfaces.ILavavel;
import java.time.LocalDate;

public class Calcinha extends Item implements ILavavel {
    private LocalDate ultimaLavagem = null;

    public Calcinha(String nomeCalcinha, String corCalcinha, String tam, String loja, String conservacao, String img) {
        super(nomeCalcinha, corCalcinha, tam, loja, conservacao, img, "Calcinha");
    }

    //Métodos ILavavel
    @Override
    public void registrarLavagem(LocalDate data) {
        ultimaLavagem = data;
    }
    @Override
    public LocalDate getUltimaLavagem() {
        return ultimaLavagem;
    }
}

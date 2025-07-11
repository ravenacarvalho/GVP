package entidades;

import interfaces.ILavavel;
import java.time.LocalDate;

public class Cueca extends Item implements ILavavel {
    private LocalDate ultimaLavagem = null;

    public Cueca(String nome, String cor, String tamanho, String lojaOrigem, String estadoConservacao, String caminhoImagem) {
        super(nome, cor, tamanho, lojaOrigem, estadoConservacao, caminhoImagem);
    }

    @Override
    public void registrarLavagem(LocalDate data) {
        this.ultimaLavagem = data;
    }

    @Override
    public LocalDate getUltimaLavagem() {
        return ultimaLavagem;
    }
}

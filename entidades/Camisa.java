package entidades;

import interfaces.IEmprestavel;
import interfaces.ILavavel;
import java.time.LocalDate;

public class Camisa extends Item implements IEmprestavel, ILavavel {
    private boolean emprestado = false;
    private String nomePessoaEmprestimo = "";
    private LocalDate dataEmprestimo = null;
    private LocalDate ultimaLavagem = null;

    public Camisa(String nome, String cor, String tamanho, String lojaOrigem, String estadoConservacao, String caminhoImagem) {
        super(nome, cor, tamanho, lojaOrigem, estadoConservacao, caminhoImagem);
    }

    // IEmprestavel
    @Override
    public void registrarEmprestimo(String nome, LocalDate data) {
        if (!emprestado) {
            this.emprestado = true;
            this.nomePessoaEmprestimo = nome;
            this.dataEmprestimo = data;
        }
    }

    @Override
    public int quantidadeDiasEmprestado() {
        if (!emprestado || dataEmprestimo == null) return 0;
        LocalDate hoje = LocalDate.now();
        int dias = 0;
        LocalDate aux = dataEmprestimo;
        while (aux.isBefore(hoje)) {
            aux = aux.plusDays(1);
            dias++;
        }
        return dias;
    }

    @Override
    public void registrarDevolucao() {
        this.emprestado = false;
        this.nomePessoaEmprestimo = "";
        this.dataEmprestimo = null;
    }

    // ILavavel
    @Override
    public void registrarLavagem(LocalDate data) {
        this.ultimaLavagem = data;
    }

    @Override
    public LocalDate getUltimaLavagem() {
        return ultimaLavagem;
    }
}

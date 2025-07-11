package entidades;

import interfaces.IEmprestavel;
import java.time.LocalDate;

public class Relogio extends Item implements IEmprestavel {
    private boolean emprestado = false;
    private String nomePessoaEmprestimo = "";
    private LocalDate dataEmprestimo = null;

    public Relogio(String nome, String cor, String tamanho, String lojaOrigem, String estadoConservacao, String caminhoImagem) {
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
}

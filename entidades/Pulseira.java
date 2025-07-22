package entidades;

import interfaces.IEmprestavel;
import java.time.LocalDate;

public class Pulseira extends Item implements IEmprestavel {
    private boolean emprestado = false;
    private String pessoaEmprestimo = "";
    private LocalDate dataEmprestimo = null;

    public Pulseira(String nome, String cor, String tamanho, String lojaOrigem, String estadoConservacao, String caminhoImagem) {
        super(nome, cor, tamanho, lojaOrigem, estadoConservacao, caminhoImagem, "Pulseira");
    }

    // Métodos IEmprestavel
    @Override
    public boolean isEmprestado() {
        return emprestado;
    }

    @Override
    public void registrarEmprestimo(String pessoa, LocalDate data) {
        if (!emprestado) {
            emprestado = true;
            pessoaEmprestimo = pessoa;
            dataEmprestimo = data;
        }
    }

    @Override
    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    @Override
    public void setPessoaEmprestimo(String pessoa) {
        this.pessoaEmprestimo = pessoa;
    }

    @Override
    public void setDataEmprestimo(LocalDate data) {
        this.dataEmprestimo = data;
    }

    @Override
    public void registrarDevolucao() {
        emprestado = false;
        pessoaEmprestimo = "";
        dataEmprestimo = null;
    }

    @Override
    public int quantidadeDiasEmprestado() {
        if (!emprestado || dataEmprestimo == null) {
            return 0;
        }
        LocalDate hoje = LocalDate.now();

        int anoEmp = dataEmprestimo.getYear();
        int mesEmp = dataEmprestimo.getMonthValue();
        int diaEmp = dataEmprestimo.getDayOfMonth();

        int anoHoje = hoje.getYear();
        int mesHoje = hoje.getMonthValue();
        int diaHoje = hoje.getDayOfMonth();

        int totalDias = 0;

        // Cálculo bem manual (não considera bissexto)
        totalDias += (anoHoje - anoEmp) * 365;
        totalDias += (mesHoje - mesEmp) * 30;
        totalDias += (diaHoje - diaEmp);

        if (totalDias < 0) {
            totalDias = 0;
        }

        return totalDias;
    }

    @Override
    public String getNomePessoaEmprestimo() {
        return pessoaEmprestimo;
    }

    @Override
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

}

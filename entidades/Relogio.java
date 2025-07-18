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
    
        int anoEmp = dataEmprestimo.getYear();
        int mesEmp = dataEmprestimo.getMonthValue();
        int diaEmp = dataEmprestimo.getDayOfMonth();
    
        int anoAtual = java.time.LocalDate.now().getYear();
        int mesAtual = java.time.LocalDate.now().getMonthValue();
        int diaAtual = java.time.LocalDate.now().getDayOfMonth();
    
        int dias = 0;
    
        // Não tratei ano bissexto, ficou só no básico mesmo
        for (int a = anoEmp; a < anoAtual; a++) {
            dias += 365;
        }
    
        for (int m = mesEmp; m < mesAtual; m++) {
            if (m == 2) dias += 28;
            else if (m == 4 || m == 6 || m == 9 || m == 11) dias += 30;
            else dias += 31;
        }
    
        dias += diaAtual - diaEmp;
    
        // Só para testar no console, pode apagar depois
        System.out.println("Dias emprestado: " + dias);
    
        return dias;
    }
    
    @Override
    public void registrarDevolucao() {
        this.emprestado = false;
        this.nomePessoaEmprestimo = "";
        this.dataEmprestimo = null;
    }
}

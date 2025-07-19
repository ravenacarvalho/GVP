package entidades;

import interfaces.IEmprestavel;
import interfaces.ILavavel;
import java.time.LocalDate;

public class Casaco extends Item implements IEmprestavel, ILavavel {
    private boolean emprestado = false;
    private String pessoaEmprestimo = "";
    private LocalDate dataEmprestimo = null;
    private LocalDate ultimaLavagem = null;

    public Casaco(String nomeCasaco, String corCasaco, String tam, String loja, String conservacao, String img) {
        super(nomeCasaco, corCasaco, tam, loja, conservacao, img, "Casaco");
    }

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
        totalDias += (mesHoje - mesEmp) * 30; // Média escolhida pra facilitar o cálculo
        totalDias += (diaHoje - diaEmp);

        if (totalDias < 0) {
            totalDias = 0;
        }

        return totalDias;
    }
    @Override
    public void registrarDevolucao() {
        emprestado = false;
        pessoaEmprestimo = "";
        dataEmprestimo = null;
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

package interfaces;

import java.time.LocalDate;

public interface IEmprestavel {
    void registrarEmprestimo(String nomePessoa, LocalDate data);
    int quantidadeDiasEmprestado();
    void registrarDevolucao();
}

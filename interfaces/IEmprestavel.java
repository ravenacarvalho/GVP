package interfaces;

import java.time.LocalDate;

public interface IEmprestavel {
    boolean isEmprestado(); 
    void registrarEmprestimo(String nomePessoa, LocalDate data);
    int quantidadeDiasEmprestado();
    void registrarDevolucao();
    String getNomePessoaEmprestimo();
    LocalDate getDataEmprestimo();

    void setEmprestado(boolean emprestado);
    void setPessoaEmprestimo(String pessoa);
    void setDataEmprestimo(LocalDate data);
}

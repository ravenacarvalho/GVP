package interfaces;

import java.time.LocalDate;

public interface IEmprestavel {
    boolean isEmprestado(); //Diz se o item está emprestado
    void registrarEmprestimo(String nomePessoa, LocalDate data); //Marca empréstimo
    void registrarDevolucao(); //Marca devolução
    void setEmprestado(boolean emprestado); //Altera status de emprestado
    void setPessoaEmprestimo(String pessoa); //Altera nome de quem pegou
    void setDataEmprestimo(LocalDate data); //Altera data do empréstimo
    int quantidadeDiasEmprestado(); //Quantos dias emprestado
    String getNomePessoaEmprestimo(); //Quem pegou
    LocalDate getDataEmprestimo(); //Data do empréstimo
}

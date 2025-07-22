package entidades;

import java.io.Serializable;

public abstract class Item implements Serializable {
    private String nome;
    private String cor;
    private String tamanho;
    private String lojaOrigem;
    private String estadoConservacao;
    private String caminhoImagem;
    private int vezesUsado;
    private String tipo;

    public Item(String nome, String cor, String tamanho, String lojaOrigem, String estadoConservacao, String caminhoImagem, String tipo) {
        this.tipo = tipo;
        this.nome = nome;
        this.cor = cor;
        this.tamanho = tamanho;
        this.lojaOrigem = lojaOrigem;
        this.estadoConservacao = estadoConservacao;
        this.caminhoImagem = caminhoImagem;
        this.vezesUsado = 0;
    }

    public String getNome() { 
        return nome; 
    }
    public String getCor() { 
        return cor; 
    }
    public String getTamanho() { 
        return tamanho; 
    }
    public String getLojaOrigem() { 
        return lojaOrigem; 
    }
    public String getEstadoConservacao() {
        return estadoConservacao; 
    }
    public String getCaminhoImagem() {
        return caminhoImagem; 
    }
    public int getVezesUsado() { 
        return vezesUsado; 
    }
    public String getTipo() {
        return tipo;
    }
    public void registrarUso() { 
        vezesUsado++; 
    }

    //Setters pra TelaEditarItem
    public void setNome(String nome) { 
        this.nome = nome; 
    }
    public void setCor(String cor) { 
        this.cor = cor; 
    }
    public void setTamanho(String tamanho) { 
        this.tamanho = tamanho; 
    }
    public void setLojaOrigem(String lojaOrigem) { 
        this.lojaOrigem = lojaOrigem;
     }
    public void setEstadoConservacao(String estadoConservacao) { 
        this.estadoConservacao = estadoConservacao; }
    public void setCaminhoImagem(String caminhoImagem) {
         this.caminhoImagem = caminhoImagem; 
    }

    //Exibe só o nome ao usar JComboBox ou JList
    @Override
    public String toString() {
        return nome;
    }
}

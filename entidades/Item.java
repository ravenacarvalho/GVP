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

    public Item(String nome, String cor, String tamanho, String lojaOrigem, String estadoConservacao, String caminhoImagem) {
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

    public void registrarUso() { 
        vezesUsado++; 
    }

    // Para mostrar nome na lista de Swing:
    @Override
    public String toString() {
        return nome;
    }
}

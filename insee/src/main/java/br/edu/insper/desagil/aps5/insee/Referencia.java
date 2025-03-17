package br.edu.insper.desagil.aps5.insee;

public class Referencia {
    protected String observacao;

    public Referencia() {
        this.observacao = "";
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int comointeiro() {
        throw new UnsupportedOperationException("Método deve ser implementado em subclasses");
    }
}

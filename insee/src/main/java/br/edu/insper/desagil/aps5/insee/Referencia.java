package br.edu.insper.desagil.aps5.insee;

public abstract class Referencia {
    private String observacao;

    public Referencia(String observacao) {
        this.observacao = observacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    //O enunciado cita "implementação de método". Portanto, o método deve ser abstrato
    public abstract int comoInteiro();
}

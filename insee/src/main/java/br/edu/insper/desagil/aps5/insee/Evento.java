package br.edu.insper.desagil.aps5.insee;

public class Evento {
    private final DataTempo inicio;
    private final DataTempo fim;

    public Evento(DataTempo inicio, DataTempo fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public DataTempo getInicio() {
        return inicio;
    }

    public DataTempo getFim() {
        return fim;
    }

    public boolean valido() {
        return inicio.comointeiro() < fim.comointeiro();
    }
}
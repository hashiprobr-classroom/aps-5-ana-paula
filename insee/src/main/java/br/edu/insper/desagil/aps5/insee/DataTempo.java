package br.edu.insper.desagil.aps5.insee;

public class DataTempo extends Referencia {
    private final Data data;
    private final Tempo tempo;

    public DataTempo(Data data, Tempo tempo) {
        this.data = data;
        this.tempo = tempo;
    }

    public Data getData() {
        return data;
    }

    public Tempo getTempo() {
        return tempo;
    }

    @Override
    public int comointeiro() {
        return data.comointeiro() * 1440 + tempo.comointeiro();
    }
}

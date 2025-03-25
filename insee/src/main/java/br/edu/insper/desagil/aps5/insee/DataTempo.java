package br.edu.insper.desagil.aps5.insee;

public class DataTempo extends Referencia{
    Data data;
    Tempo tempo;

    public DataTempo(String observacao, Data data, Tempo tempo) {
        super(observacao);
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
    public int comoInteiro() {
        //deve devolver o número de minutos passados desde 1/1/1970 00:00
        // até a data e tempo definido pelos atributos
        int dataPassada = data.comoInteiro();
        int tempoPassado = tempo.comoInteiro();
        return (dataPassada*1440)+tempoPassado;
    }
}

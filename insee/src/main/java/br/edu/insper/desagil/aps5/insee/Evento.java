package br.edu.insper.desagil.aps5.insee;

public class Evento {
    private DataTempo inicio;
    private DataTempo fim;

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

    public boolean valido(){
        int inicioComoInteiro = inicio.comoInteiro();
        int fimComoInteiro = fim.comoInteiro();
        int delta = fimComoInteiro - inicioComoInteiro;

        if (delta>0){
            return true;
        }
        else{
            return false;
        }
    }
}

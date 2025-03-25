package br.edu.insper.desagil.aps5.insee;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Evento> eventos;

    public Agenda(ArrayList<Evento> eventos) {
       this.eventos = new ArrayList<>(); //está sendo inicializada como vazia
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void adiciona(Evento evento){
        try{
            if (evento.valido()==true){
                eventos.add(evento);
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("Evento inválido!");
        }
    }
}
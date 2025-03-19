package br.edu.insper.desagil.aps5.insee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AgendaTest {
    Agenda agenda;

    @BeforeEach
    void setUp(){
        agenda = new Agenda();
    }

    @Test
    void constroi(){
        assertTrue(agenda.getEventos().isEmpty());
        //O teste deve ser com um booleano para verificar se a lista está vazia
    }

    @Test
    void adicionaValido(){

        Data dataInicio = new Data();
        dataInicio.atualiza(2024, 9, 26);
        Tempo tempoInicio = new Tempo();
        tempoInicio.atualiza(10, 0);


        Data dataFim = new Data();
        dataFim.atualiza(2024, 9, 26);
        Tempo tempoFim = new Tempo();
        tempoFim.atualiza(12, 0);

        DataTempo inicio = new DataTempo(dataInicio, tempoInicio);
        DataTempo fim = new DataTempo(dataFim, tempoFim);

        Evento evento = new Evento(inicio, fim);
        agenda.adiciona(evento);

        assertTrue(evento.valido());

    }

    @Test
    void adicionaInvalido() {
        Data dataInicio = new Data();
        dataInicio.atualiza(2025, 9, 26);
        Tempo tempoInicio = new Tempo();
        tempoInicio.atualiza(10, 0);

        Data dataFim = new Data();
        dataFim.atualiza(2024, 9, 26);
        Tempo tempoFim = new Tempo();
        tempoFim.atualiza(12, 0);

        DataTempo inicio = new DataTempo(dataInicio, tempoInicio);
        DataTempo fim = new DataTempo(dataFim, tempoFim);

        Evento evento = new Evento(inicio, fim);
        
        assertFalse(evento.valido());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.adiciona(evento);
        });

        assertEquals("Evento inválido!", exception.getMessage());
    }
}

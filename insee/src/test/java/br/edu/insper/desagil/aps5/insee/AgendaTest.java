package br.edu.insper.desagil.aps5.insee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AgendaTest {
    private Agenda agenda;
    private ArrayList<Evento> eventos;

    @BeforeEach
    void setUp(){
        agenda = new Agenda(eventos);
    }

    @Test
    void constroi(){
        assertNull(eventos);
    }

    @Test
    void adicionaValido(){
        Data data_inicio = new Data("Inicio");
        data_inicio.atualiza(2025,3,25);

        Data data_fim = new Data("Fim");
        data_fim.atualiza(2025,3,26);

        Tempo tempo_inicio = new Tempo("Inicio");
        tempo_inicio.atualiza(15,50);

        Tempo tempo_fim = new Tempo("Fim");
        tempo_fim.atualiza(16,30);

        DataTempo inicio = new DataTempo("Inicio", data_inicio, tempo_inicio);
        DataTempo fim = new DataTempo("Fim", data_fim, tempo_fim);

        Evento evento = new Evento(inicio, fim); //início e fim do Evento são do tipo DataTempo, então, tem que construir passo a passo

        agenda.adiciona(evento);

        assertTrue(evento.valido());
    }

    @Test
    void adicionaInvalido(){
        Data data_inicio = new Data("Inicio");
        data_inicio.atualiza(2025,3,25);

        Data data_fim = new Data("Fim");
        data_fim.atualiza(2025,3,24);

        Tempo tempo_inicio = new Tempo("Inicio");
        tempo_inicio.atualiza(15,50);

        Tempo tempo_fim = new Tempo("Fim");
        tempo_fim.atualiza(16,30);

        DataTempo inicio = new DataTempo("Inicio", data_inicio, tempo_inicio);
        DataTempo fim = new DataTempo("Fim", data_fim, tempo_fim);

        Evento evento = new Evento(inicio, fim);

        agenda.adiciona(evento);

        NumberFormatException e = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("Evento inválido!");
        });
        assertEquals("For input string: \"Evento inválido!\"", e.getMessage());
    }
}

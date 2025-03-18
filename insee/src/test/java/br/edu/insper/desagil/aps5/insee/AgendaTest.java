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
        Evento evento = new Evento();
        agenda.adiciona();
    }
}

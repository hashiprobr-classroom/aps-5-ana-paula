package br.edu.insper.desagil.aps5.isail;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ItemAbstracao {
    private String nome;
    private double minimo;
    private List<LocalDateTime> momentos;
    private List<Comprador> compradores;
    private List<Double> ofertas;

    public ItemAbstracao(String nome, double minimo) {
        this.nome = nome;
        this.minimo = minimo;
        this.momentos = new ArrayList<>();
        this.compradores = new ArrayList<>();
        this.ofertas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int calcula(double oferta){
        int maior = 0;
        for (int i = 1; i < ofertas.size(); i++) {
            if (ofertas.get(maior) < ofertas.get(i)) {
                maior = i;
            }
        }
        if (oferta <= ofertas.get(maior)) {
            return maior;
        }
        return maior;
    }

    public void fazLance(Comprador comprador, double oferta) {
        if (oferta < minimo) {
            return;
        }
        else if (!ofertas.isEmpty()) {
            int maior = calcula(oferta);
        }

        momentos.add(LocalDateTime.now());
        compradores.add(comprador);
        ofertas.add(oferta);

        comprador.incrementa();
    }

    public void imprimeMelhorLance(double oferta) {
        if (ofertas.isEmpty()) {
            System.out.println("Nenhum lance foi feito ainda!");
        } else {
            int maior = calcula(0);
            System.out.println(compradores.get(maior) + " ofereceu " + ofertas.get(maior) + " (" + momentos.toString() + ")");
        }
    }
}

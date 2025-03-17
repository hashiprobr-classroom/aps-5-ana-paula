package br.edu.insper.desagil.aps5.insee;

import java.util.HashMap;
import java.util.Map;

public class Data extends Referencia {
    private int ano;
    private int mes;
    private int dia;
    private Map<Integer, Integer> limites;

    public Data() {
        this.ano = 1970;
        this.mes = 1;
        this.dia = 1;
        this.limites = new HashMap<>();
        this.inicializarLimites();
    }

    private void inicializarLimites() {
        limites.put(1, 31);
        limites.put(2, 28);
        limites.put(3, 31);
        limites.put(4, 30);
        limites.put(5, 31);
        limites.put(6, 30);
        limites.put(7, 31);
        limites.put(8, 31);
        limites.put(9, 30);
        limites.put(10, 31);
        limites.put(11, 30);
        limites.put(12, 31);
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public void atualiza(int ano, int mes, int dia) {

        //se o valor do ano for menor que 1970, o atributo deve ser atualizado para 1970 em vez desse valor;
        if (ano < 1970) {
            this.ano = 1970;
        } else {
            this.ano = ano;
        }

        //se o valor do mês for menor que 1, o atributo deve ser atualizado para 1 em vez desse valor;
        if (mes < 1) {
            this.mes = 1;
        }
        //se o valor do mês for maior que 12, o atributo deve ser atualizado para 12 em vez desse valor;
        else if (mes > 12) {
            this.mes = 12;
        } else {
            this.mes = mes;
        }


        int limiteDias = limites.get(this.mes);
        //se o valor do dia for menor que 1, o atributo deve ser atualizado para 1 em vez desse valor;
        if (dia < 1) {
            this.dia = 1;
        } else if (dia > limiteDias) {
            this.dia = limiteDias;
        } else {
            this.dia = dia;
        }
    }

    @Override
    public int comointeiro() {
        int totalDias = 0;

        // soma os anos completos
        totalDias += (this.ano - 1970) * 365;

        // soma os meses completos do ano atual
        for (int i = 1; i < this.mes; i++) {
            totalDias += limites.get(i);
        }

        // soma os dias do mês atual
        totalDias += (this.dia - 1);

        return totalDias;
    }
}

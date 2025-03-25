package br.edu.insper.desagil.aps5.insee;

import java.util.HashMap;
import java.util.Map;

public class Data extends Referencia{
    private int ano;
    private int mes;
    private int dia;
    private HashMap<Integer, Integer>limites;


    public Data(String observacao){
        super(observacao);
        this.ano = 1970;
        this.mes = 1;
        this.dia = 1;

        limites = new HashMap<>();

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

    public void atualiza(int ano, int mes, int dia){
        if (ano < 1970) {
            this.ano = 1970; //tem que ter o this para atualizar o valor daquele ano
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
    public int comoInteiro() {
        int diasTotais = 0;

        // Somar dias de anos inteiros desde 1970
        diasTotais += (ano - 1970) * 365;

        // Somar dias de meses anteriores ao mês atual
        for (int m = 1; m < mes; m++) {
            diasTotais += limites.get(m); //acessa diretamente os valores do dicionário
        }

        diasTotais += dia - 1;

        return diasTotais;
    }

}

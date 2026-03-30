package br.furb.iot.adaptador;

import br.furb.analise.algoritmos.LampadaPhellipes;
import br.furb.iot.dispositivo.Lampada;

public class LampadaAdaptadorPhelippes implements Lampada {

    private static final int INTENSIDADE_LIGADA = 100;
    private static final int INTENSIDADE_DESLIGADA = 0;

    private final LampadaPhellipes lampadaPhellipes;

    public LampadaAdaptadorPhelippes(LampadaPhellipes lampadaPhellipes) {
        this.lampadaPhellipes = lampadaPhellipes;
    }

    @Override
    public void ligar() {
        lampadaPhellipes.setIntensidade(INTENSIDADE_LIGADA);
    }

    @Override
    public void desligar() {
        lampadaPhellipes.setIntensidade(INTENSIDADE_DESLIGADA);
    }
}

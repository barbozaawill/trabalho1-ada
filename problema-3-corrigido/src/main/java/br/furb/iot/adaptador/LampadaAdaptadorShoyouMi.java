package br.furb.iot.adaptador;

import br.furb.analise.algoritmos.LampadaShoyuMi;
import br.furb.iot.dispositivo.Lampada;

public class LampadaAdaptadorShoyouMi implements Lampada {

    private final LampadaShoyuMi lampadaShoyuMi;

    public LampadaAdaptadorShoyouMi(LampadaShoyuMi lampadaShoyuMi) {
        this.lampadaShoyuMi = lampadaShoyuMi;
    }

    @Override
    public void ligar() {
        lampadaShoyuMi.ligar();
    }

    @Override
    public void desligar() {
        lampadaShoyuMi.desligar();
    }
}

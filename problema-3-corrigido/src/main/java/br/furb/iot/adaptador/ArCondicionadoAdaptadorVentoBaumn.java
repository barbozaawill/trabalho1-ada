package br.furb.iot.adaptador;

import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import br.furb.iot.dispositivo.ArCondicionado;

public class ArCondicionadoAdaptadorVentoBaumn implements ArCondicionado {

    private static final int TEMPERATURA_INICIAL = 24;

    private final ArCondicionadoVentoBaumn arCondicionadoVentoBaumn;
    private int temperaturaAtual;

    public ArCondicionadoAdaptadorVentoBaumn(ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
        this.arCondicionadoVentoBaumn = arCondicionadoVentoBaumn;
        this.temperaturaAtual = TEMPERATURA_INICIAL;
    }

    @Override
    public void ligar() {
        arCondicionadoVentoBaumn.ligar();
    }

    @Override
    public void desligar() {
        arCondicionadoVentoBaumn.desligar();
    }

    @Override
    public void aumentarTemperatura() {
        temperaturaAtual++;
        arCondicionadoVentoBaumn.definirTemperatura(temperaturaAtual);
    }

    @Override
    public void diminuirTemperatura() {
        temperaturaAtual--;
        arCondicionadoVentoBaumn.definirTemperatura(temperaturaAtual);
    }

    @Override
    public void definirTemperatura(int temperatura) {
        temperaturaAtual = temperatura;
        arCondicionadoVentoBaumn.definirTemperatura(temperaturaAtual);
    }
}

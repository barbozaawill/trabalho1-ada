package br.furb.iot.adaptador;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.iot.dispositivo.ArCondicionado;

public class ArCondicionadoAdaptadorGellaKaza implements ArCondicionado {

    private static final int TEMPERATURA_INICIAL = 28;

    private final ArCondicionadoGellaKaza arCondicionadoGellaKaza;
    private int temperaturaAtual;

    public ArCondicionadoAdaptadorGellaKaza(ArCondicionadoGellaKaza arCondicionadoGellaKaza) {
        this.arCondicionadoGellaKaza = arCondicionadoGellaKaza;
        this.temperaturaAtual = TEMPERATURA_INICIAL;
    }

    @Override
    public void ligar() {
        arCondicionadoGellaKaza.ativar();
    }

    @Override
    public void desligar() {
        arCondicionadoGellaKaza.desativar();
    }

    @Override
    public void aumentarTemperatura() {
        arCondicionadoGellaKaza.aumentarTemperatura();
        temperaturaAtual++;
    }

    @Override
    public void diminuirTemperatura() {
        arCondicionadoGellaKaza.diminuirTemperatura();
        temperaturaAtual--;
    }

    @Override
    public void definirTemperatura(int temperatura) {
        ajustarParaTemperatura(temperatura);
    }

    private void ajustarParaTemperatura(int temperaturaAlvo) {
        while (temperaturaAtual < temperaturaAlvo) {
            aumentarTemperatura();
        }
        while (temperaturaAtual > temperaturaAlvo) {
            diminuirTemperatura();
        }
    }
}

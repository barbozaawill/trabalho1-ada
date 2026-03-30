package br.furb.iot.fachada;

import br.furb.iot.dispositivo.ArCondicionado;
import br.furb.iot.dispositivo.Lampada;
import br.furb.iot.dispositivo.Persiana;

import java.util.ArrayList;
import java.util.List;

public class CasaInteligente {

    private static final int TEMPERATURA_TRABALHO = 25;

    private final List<Persiana> persianas;
    private final List<Lampada> lampadas;
    private final List<ArCondicionado> arsCondicionados;

    public CasaInteligente() {
        this.persianas = new ArrayList<>();
        this.lampadas = new ArrayList<>();
        this.arsCondicionados = new ArrayList<>();
    }

    public void adicionarPersiana(Persiana persiana) {
        persianas.add(persiana);
    }

    public void adicionarLampada(Lampada lampada) {
        lampadas.add(lampada);
    }

    public void adicionarArCondicionado(ArCondicionado arCondicionado) {
        arsCondicionados.add(arCondicionado);
    }

    public void modoSono() {
        arsCondicionados.forEach(ArCondicionado::desligar);
        lampadas.forEach(Lampada::desligar);
        persianas.forEach(Persiana::fechar);
    }

    public void modoTrabalho() {
        lampadas.forEach(Lampada::ligar);
        arsCondicionados.forEach(ArCondicionado::ligar);
        arsCondicionados.forEach(ac -> ac.definirTemperatura(TEMPERATURA_TRABALHO));
        persianas.forEach(Persiana::abrir);
    }
}

package br.furb.iot.dispositivo;

public interface ArCondicionado {

    void ligar();

    void desligar();

    void aumentarTemperatura();

    void diminuirTemperatura();

    void definirTemperatura(int temperatura);
}

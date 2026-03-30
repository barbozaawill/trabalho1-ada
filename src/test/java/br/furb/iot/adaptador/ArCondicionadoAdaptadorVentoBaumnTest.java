package br.furb.iot.adaptador;

import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class ArCondicionadoAdaptadorVentoBaumnTest {

    @Mock
    private ArCondicionadoVentoBaumn arCondicionadoVentoBaumn;

    private ArCondicionadoAdaptadorVentoBaumn adaptador;

    @BeforeEach
    void setUp() {
        adaptador = new ArCondicionadoAdaptadorVentoBaumn(arCondicionadoVentoBaumn);
    }

    @Test
    void ligarDeveInvocarLigar() {
        adaptador.ligar();

        verify(arCondicionadoVentoBaumn).ligar();
        verifyNoMoreInteractions(arCondicionadoVentoBaumn);
    }

    @Test
    void desligarDeveInvocarDesligar() {
        adaptador.desligar();

        verify(arCondicionadoVentoBaumn).desligar();
        verifyNoMoreInteractions(arCondicionadoVentoBaumn);
    }

    @Test
    void aumentarTemperaturaDeveIncrementarEDefinirTemperatura() {
        adaptador.aumentarTemperatura();

        verify(arCondicionadoVentoBaumn).definirTemperatura(25);
        verifyNoMoreInteractions(arCondicionadoVentoBaumn);
    }

    @Test
    void diminuirTemperaturaDeveDecrementarEDefinirTemperatura() {
        adaptador.diminuirTemperatura();

        verify(arCondicionadoVentoBaumn).definirTemperatura(23);
        verifyNoMoreInteractions(arCondicionadoVentoBaumn);
    }

    @Test
    void definirTemperaturaDevePassarValorDireto() {
        adaptador.definirTemperatura(20);

        verify(arCondicionadoVentoBaumn).definirTemperatura(20);
        verifyNoMoreInteractions(arCondicionadoVentoBaumn);
    }

    @Test
    void aumentarTemperaturaDuasVezesDeveChegar26() {
        adaptador.aumentarTemperatura();
        adaptador.aumentarTemperatura();

        verify(arCondicionadoVentoBaumn).definirTemperatura(25);
        verify(arCondicionadoVentoBaumn).definirTemperatura(26);
    }
}

package br.furb.iot.adaptador;

import br.furb.analise.algoritmos.LampadaPhellipes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class LampadaAdaptadorPhelippesTest {

    @Mock
    private LampadaPhellipes lampadaPhellipes;

    private LampadaAdaptadorPhelippes adaptador;

    @BeforeEach
    void setUp() {
        adaptador = new LampadaAdaptadorPhelippes(lampadaPhellipes);
    }

    @Test
    void ligarDeveDefinirIntensidade100() {
        adaptador.ligar();

        verify(lampadaPhellipes).setIntensidade(100);
        verifyNoMoreInteractions(lampadaPhellipes);
    }

    @Test
    void desligarDeveDefinirIntensidade0() {
        adaptador.desligar();

        verify(lampadaPhellipes).setIntensidade(0);
        verifyNoMoreInteractions(lampadaPhellipes);
    }
}

package br.furb.iot.adaptador;

import br.furb.analise.algoritmos.LampadaShoyuMi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class LampadaAdaptadorShoyouMiTest {

    @Mock
    private LampadaShoyuMi lampadaShoyuMi;

    private LampadaAdaptadorShoyouMi adaptador;

    @BeforeEach
    void setUp() {
        adaptador = new LampadaAdaptadorShoyouMi(lampadaShoyuMi);
    }

    @Test
    void ligarDeveInvocarLigarNaLampada() {
        adaptador.ligar();

        verify(lampadaShoyuMi).ligar();
        verifyNoMoreInteractions(lampadaShoyuMi);
    }

    @Test
    void desligarDeveInvocarDesligarNaLampada() {
        adaptador.desligar();

        verify(lampadaShoyuMi).desligar();
        verifyNoMoreInteractions(lampadaShoyuMi);
    }
}

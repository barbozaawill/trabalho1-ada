package br.furb.iot.adaptador;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class ArCondicionadoAdaptadorGellaKazaTest {

    @Mock
    private ArCondicionadoGellaKaza arCondicionadoGellaKaza;

    private ArCondicionadoAdaptadorGellaKaza adaptador;

    @BeforeEach
    void setUp() {
        adaptador = new ArCondicionadoAdaptadorGellaKaza(arCondicionadoGellaKaza);
    }

    @Test
    void ligarDeveInvocarAtivar() {
        adaptador.ligar();

        verify(arCondicionadoGellaKaza).ativar();
        verifyNoMoreInteractions(arCondicionadoGellaKaza);
    }

    @Test
    void desligarDeveInvocarDesativar() {
        adaptador.desligar();

        verify(arCondicionadoGellaKaza).desativar();
        verifyNoMoreInteractions(arCondicionadoGellaKaza);
    }

    @Test
    void aumentarTemperaturaDeveInvocarAumentarTemperatura() {
        adaptador.aumentarTemperatura();

        verify(arCondicionadoGellaKaza).aumentarTemperatura();
        verifyNoMoreInteractions(arCondicionadoGellaKaza);
    }

    @Test
    void diminuirTemperaturaDeveInvocarDiminuirTemperatura() {
        adaptador.diminuirTemperatura();

        verify(arCondicionadoGellaKaza).diminuirTemperatura();
        verifyNoMoreInteractions(arCondicionadoGellaKaza);
    }

    @Test
    void definirTemperaturaAbaixoDoInicialDeveAbaixarGrauAGrau() {
        adaptador.definirTemperatura(25);

        verify(arCondicionadoGellaKaza, times(3)).diminuirTemperatura();
        verifyNoMoreInteractions(arCondicionadoGellaKaza);
    }

    @Test
    void definirTemperaturaAcimaDoInicialDeveAumentarGrauAGrau() {
        adaptador.definirTemperatura(30);

        verify(arCondicionadoGellaKaza, times(2)).aumentarTemperatura();
        verifyNoMoreInteractions(arCondicionadoGellaKaza);
    }

    @Test
    void definirTemperaturaIgualAAtualNaoDeveInvocarNada() {
        adaptador.definirTemperatura(28);

        verifyNoMoreInteractions(arCondicionadoGellaKaza);
    }
}

package br.furb.iot.fachada;

import br.furb.iot.dispositivo.ArCondicionado;
import br.furb.iot.dispositivo.Lampada;
import br.furb.iot.dispositivo.Persiana;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class CasaInteligenteTest {

    @Mock
    private Persiana persiana;

    @Mock
    private Lampada lampada;

    @Mock
    private ArCondicionado arCondicionado;

    private CasaInteligente casaInteligente;

    @BeforeEach
    void setUp() {
        casaInteligente = new CasaInteligente();
        casaInteligente.adicionarPersiana(persiana);
        casaInteligente.adicionarLampada(lampada);
        casaInteligente.adicionarArCondicionado(arCondicionado);
    }

    @Test
    void modoSonoDeveDesligarArCondicionado() {
        casaInteligente.modoSono();

        verify(arCondicionado).desligar();
    }

    @Test
    void modoSonoDeveDesligarLampada() {
        casaInteligente.modoSono();

        verify(lampada).desligar();
    }

    @Test
    void modoSonoDeveFecharPersiana() {
        casaInteligente.modoSono();

        verify(persiana).fechar();
    }

    @Test
    void modoSonoNaoDeveLigarNenhumDispositivo() {
        casaInteligente.modoSono();

        verify(persiana).fechar();
        verifyNoMoreInteractions(persiana);
        verify(lampada).desligar();
        verifyNoMoreInteractions(lampada);
        verify(arCondicionado).desligar();
        verifyNoMoreInteractions(arCondicionado);
    }

    @Test
    void modoTrabalhoDeveLigarLampada() {
        casaInteligente.modoTrabalho();

        verify(lampada).ligar();
    }

    @Test
    void modoTrabalhoDeveLigarArCondicionado() {
        casaInteligente.modoTrabalho();

        verify(arCondicionado).ligar();
    }

    @Test
    void modoTrabalhoDeveDefinirTemperatura25NoArCondicionado() {
        casaInteligente.modoTrabalho();

        verify(arCondicionado).definirTemperatura(25);
    }

    @Test
    void modoTrabalhoDeveAbrirPersiana() {
        casaInteligente.modoTrabalho();

        verify(persiana).abrir();
    }

    @Test
    void modoTrabalhoNaoDeveFecharNemDesligarNenhumDispositivo() {
        casaInteligente.modoTrabalho();

        verify(persiana).abrir();
        verifyNoMoreInteractions(persiana);
        verify(lampada).ligar();
        verifyNoMoreInteractions(lampada);
        verify(arCondicionado).ligar();
        verify(arCondicionado).definirTemperatura(25);
        verifyNoMoreInteractions(arCondicionado);
    }

    @Test
    void modoSonoComMultiplosDispositivosDeveAcionarTodos() {
        Persiana persiana2 = org.mockito.Mockito.mock(Persiana.class);
        Lampada lampada2 = org.mockito.Mockito.mock(Lampada.class);
        ArCondicionado arCondicionado2 = org.mockito.Mockito.mock(ArCondicionado.class);

        casaInteligente.adicionarPersiana(persiana2);
        casaInteligente.adicionarLampada(lampada2);
        casaInteligente.adicionarArCondicionado(arCondicionado2);

        casaInteligente.modoSono();

        verify(persiana).fechar();
        verify(persiana2).fechar();
        verify(lampada).desligar();
        verify(lampada2).desligar();
        verify(arCondicionado).desligar();
        verify(arCondicionado2).desligar();
    }

    @Test
    void modoTrabalhoComMultiplosDispositivosDeveAcionarTodos() {
        Persiana persiana2 = org.mockito.Mockito.mock(Persiana.class);
        Lampada lampada2 = org.mockito.Mockito.mock(Lampada.class);
        ArCondicionado arCondicionado2 = org.mockito.Mockito.mock(ArCondicionado.class);

        casaInteligente.adicionarPersiana(persiana2);
        casaInteligente.adicionarLampada(lampada2);
        casaInteligente.adicionarArCondicionado(arCondicionado2);

        casaInteligente.modoTrabalho();

        verify(persiana).abrir();
        verify(persiana2).abrir();
        verify(lampada).ligar();
        verify(lampada2).ligar();
        verify(arCondicionado).ligar();
        verify(arCondicionado).definirTemperatura(25);
        verify(arCondicionado2).ligar();
        verify(arCondicionado2).definirTemperatura(25);
    }
}

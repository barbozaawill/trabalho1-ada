package br.furb.iot.adaptador;

import br.furb.analise.algoritmos.PersianaNatLight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class PersianaAdaptadorNatLightTest {

    @Mock
    private PersianaNatLight persianaNatLight;

    private PersianaAdaptadorNatLight adaptador;

    @BeforeEach
    void setUp() {
        adaptador = new PersianaAdaptadorNatLight(persianaNatLight);
    }

    @Test
    void abrirDeveAbrirPalhetaAntesDeSubir() throws Exception {
        adaptador.abrir();

        InOrder ordem = inOrder(persianaNatLight);
        ordem.verify(persianaNatLight).abrirPalheta();
        ordem.verify(persianaNatLight).subirPalheta();
    }

    @Test
    void fecharDeveDescerAntesDeFecharPalheta() throws Exception {
        adaptador.abrir();
        adaptador.fechar();

        InOrder ordem = inOrder(persianaNatLight);
        ordem.verify(persianaNatLight).abrirPalheta();
        ordem.verify(persianaNatLight).subirPalheta();
        ordem.verify(persianaNatLight).descerPalheta();
        ordem.verify(persianaNatLight).fecharPalheta();
    }

    @Test
    void abrirDuasVezesNaoDeveSubirNemAbrirPalhetaDuasVezes() throws Exception {
        adaptador.abrir();
        adaptador.abrir();

        verify(persianaNatLight, times(1)).abrirPalheta();
        verify(persianaNatLight, times(1)).subirPalheta();
        verifyNoMoreInteractions(persianaNatLight);
    }

    @Test
    void fecharSemAbrirNaoDeveInvocarNadaNaPersiana() {
        adaptador.fechar();

        verifyNoMoreInteractions(persianaNatLight);
    }

    @Test
    void fecharDuasVezesNaoDeveDescerNemFecharPalhetaDuasVezes() throws Exception {
        adaptador.abrir();
        adaptador.fechar();
        adaptador.fechar();

        verify(persianaNatLight, times(1)).descerPalheta();
        verify(persianaNatLight, times(1)).fecharPalheta();
    }

    @Test
    void abrirAposFecharDeveAbrirNovamente() throws Exception {
        adaptador.abrir();
        adaptador.fechar();
        adaptador.abrir();

        verify(persianaNatLight, times(2)).abrirPalheta();
        verify(persianaNatLight, times(2)).subirPalheta();
    }
}

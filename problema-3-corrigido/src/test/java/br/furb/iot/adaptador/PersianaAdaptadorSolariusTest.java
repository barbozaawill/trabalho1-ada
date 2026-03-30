package br.furb.iot.adaptador;

import br.furb.analise.algoritmos.PersianaSolarius;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class PersianaAdaptadorSolariusTest {

    @Mock
    private PersianaSolarius persianaSolarius;

    private PersianaAdaptadorSolarius adaptador;

    @BeforeEach
    void setUp() {
        adaptador = new PersianaAdaptadorSolarius(persianaSolarius);
    }

    @Test
    void abrirDeveInvocarSubirPersiana() {
        adaptador.abrir();

        verify(persianaSolarius).subirPersiana();
        verifyNoMoreInteractions(persianaSolarius);
    }

    @Test
    void fecharDeveInvocarDescerPersiana() {
        adaptador.fechar();

        verify(persianaSolarius).descerPersiana();
        verifyNoMoreInteractions(persianaSolarius);
    }
}

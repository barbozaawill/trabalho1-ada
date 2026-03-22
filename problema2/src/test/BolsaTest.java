package bolsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BolsaTest {

    private Acao acao;
    private Investidor mariana;
    private Investidor joaquim;

    @BeforeEach
    void setUp() {
        acao    = new Acao("BBAS3", 23.50);
        mariana = new Investidor("Mariana");
        joaquim = new Investidor("Joaquim");
    }

    //testes de ordem 

    @Test
    void deveAdicionarOrdemSemMatchNaLista() {
        mariana.registrarOrdem(acao, TipoOrdem.VENDA, 24.00);
        assertEquals(1, acao.getOrdens().size());
    }

    @Test
    void deveRealizarMatchERemoverOrdens() {
        mariana.registrarOrdem(acao, TipoOrdem.VENDA,  24.00);
        joaquim.registrarOrdem(acao, TipoOrdem.COMPRA, 24.00);

        assertEquals(0, acao.getOrdens().size());
    }

    @Test
    void naoDeveRealizarMatchComValoresDiferentes() {
        mariana.registrarOrdem(acao, TipoOrdem.VENDA,  24.00);
        joaquim.registrarOrdem(acao, TipoOrdem.COMPRA, 23.00);

        assertEquals(2, acao.getOrdens().size());
    }

    @Test
    void deveAtualizarValorDaAcaoAposMatch() {
        mariana.registrarOrdem(acao, TipoOrdem.VENDA,  24.00);
        joaquim.registrarOrdem(acao, TipoOrdem.COMPRA, 24.00);

        assertEquals(24.00, acao.getValor(), 0.001);
    }

    @Test
    void naoDeveAtualizarValorSemMatch() {
        double valorInicial = acao.getValor();
        mariana.registrarOrdem(acao, TipoOrdem.VENDA, 24.00);

        assertEquals(valorInicial, acao.getValor(), 0.001);
    }

    //testes de observer 

    @Test
    void deveRegistrarObserver() {
        mariana.assinarAcao(acao);
        assertEquals(1, acao.getObservers().size());
    }

    @Test
    void deveRemoverObserver() {
        mariana.assinarAcao(acao);
        mariana.cancelarAssinaturaAcao(acao);
        assertEquals(0, acao.getObservers().size());
    }

    @Test
    void deveNotificarObserversAposMatch() {
        List<Double> notificacoes = new ArrayList<>();

        Observer observadorTeste = (acaoNome, novoValor) -> notificacoes.add(novoValor);
        acao.registrarObserver(observadorTeste);

        mariana.registrarOrdem(acao, TipoOrdem.VENDA,  24.00);
        joaquim.registrarOrdem(acao, TipoOrdem.COMPRA, 24.00);

        assertEquals(1, notificacoes.size());
        assertEquals(24.00, notificacoes.get(0), 0.001);
    }

    @Test
    void naoDeveNotificarSemMatch() {
        List<Double> notificacoes = new ArrayList<>();
        Observer observadorTeste = (acaoNome, novoValor) -> notificacoes.add(novoValor);
        acao.registrarObserver(observadorTeste);

        mariana.registrarOrdem(acao, TipoOrdem.VENDA, 24.00);

        assertEquals(0, notificacoes.size());
    }

    @Test
    void naoDeveAdicionarMesmoObserverDuasVezes() {
        mariana.assinarAcao(acao);
        mariana.assinarAcao(acao); 
        assertEquals(1, acao.getObservers().size());
    }
}
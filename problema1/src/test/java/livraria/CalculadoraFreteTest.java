package livraria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraFreteTest {

    private CalculadoraFrete calculadora;
    private EncomendaPAC pac;
    private Sedex sedex;
    private RetiradaNoLocal retirada;

    @BeforeEach
    void setUp() {
        calculadora = new CalculadoraFrete();
        pac = new EncomendaPAC();
        sedex = new Sedex();
        retirada = new RetiradaNoLocal();
    }

    private Pedido pedidoComPeso(double pesoGramas) {
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Livro", 30.00, pesoGramas));
        return pedido;
    }

    @Test
    void pac_pesoExatamente1kg_deveRetornar10() {
        assertEquals(10.00, calculadora.calcular(pedidoComPeso(1000), pac));
    }

    @Test
    void pac_pesoAbaixoDe1kg_deveRetornar10() {
        assertEquals(10.00, calculadora.calcular(pedidoComPeso(500), pac));
    }

    @Test
    void pac_pesoEntre1kgE2kg_deveRetornar15() {
        assertEquals(15.00, calculadora.calcular(pedidoComPeso(1500), pac));
    }

    @Test
    void pac_pesoExatamente2kg_deveRetornar15() {
        assertEquals(15.00, calculadora.calcular(pedidoComPeso(2000), pac));
    }

    @Test
    void pac_pesoAcimaDe2kg_deveLancarExcecao() {
        assertThrows(IllegalArgumentException.class,
            () -> calculadora.calcular(pedidoComPeso(2001), pac));
    }

    @Test
    void sedex_pesoAte500g_deveRetornar12_50() {
        assertEquals(12.50, calculadora.calcular(pedidoComPeso(300), sedex));
    }

    @Test
    void sedex_pesoExatamente500g_deveRetornar12_50() {
        assertEquals(12.50, calculadora.calcular(pedidoComPeso(500), sedex));
    }

    @Test
    void sedex_pesoEntre500gE1000g_deveRetornar20() {
        assertEquals(20.00, calculadora.calcular(pedidoComPeso(750), sedex));
    }

    @Test
    void sedex_pesoExatamente1000g_deveRetornar20() {
        assertEquals(20.00, calculadora.calcular(pedidoComPeso(1000), sedex));
    }

    @Test
    void sedex_pesoAcimaDe1kg_100gAdicionais_deveRetornar48() {
        assertEquals(48.00, calculadora.calcular(pedidoComPeso(1100), sedex));
    }

    @Test
    void sedex_pesoAcimaDe1kg_250gAdicionais_deveRetornar51() {
        assertEquals(51.00, calculadora.calcular(pedidoComPeso(1250), sedex));
    }

    @Test
    void sedex_pesoAcimaDe1kg_1000gAdicionais_deveRetornar61_50() {
        assertEquals(61.50, calculadora.calcular(pedidoComPeso(2000), sedex));
    }

    @Test
    void retirada_qualquerPeso_deveRetornarZero() {
        assertEquals(0.00, calculadora.calcular(pedidoComPeso(5000), retirada));
    }

    @Test
    void pedidoComMultiplosProdutos_pesoTotalSomadoCorretamente() {
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Livro A", 20.00, 400));
        pedido.adicionarProduto(new Produto("Livro B", 35.00, 700));
        assertEquals(15.00, calculadora.calcular(pedido, pac));
    }

    @Test
    void pedidoComMultiplosProdutos_sedexAcimaDe1kg() {
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Livro A", 20.00, 600));
        pedido.adicionarProduto(new Produto("Livro B", 35.00, 600));
        assertEquals(49.50, calculadora.calcular(pedido, sedex));
    }
}

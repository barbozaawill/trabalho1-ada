package livraria;

public class CalculadoraFrete {

    public double calcular(Pedido pedido, ModalidadeEntrega modalidade) {
        return modalidade.calcularFrete(pedido);
    }
}

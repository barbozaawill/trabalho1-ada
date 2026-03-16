package livraria;

public interface ModalidadeEntrega {
    double calcularFrete(Pedido pedido);
    String getNome();
}

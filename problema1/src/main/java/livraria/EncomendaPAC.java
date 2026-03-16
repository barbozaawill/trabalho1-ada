package livraria;

public class EncomendaPAC implements ModalidadeEntrega {

    @Override
    public double calcularFrete(Pedido pedido) {
        double pesoGramas = pedido.getPesoTotal();

        if (pesoGramas <= 1000) {
            return 10.00;
        } else if (pesoGramas <= 2000) {
            return 15.00;
        } else {
            throw new IllegalArgumentException(
                "Encomenda PAC não aceita pedidos acima de 2 kg. Peso atual: " + pesoGramas + "g"
            );
        }
    }

    @Override
    public String getNome() {
        return "Encomenda PAC";
    }
}

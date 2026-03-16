package livraria;

public class Sedex implements ModalidadeEntrega {

    @Override
    public double calcularFrete(Pedido pedido) {
        double pesoGramas = pedido.getPesoTotal();

        if (pesoGramas <= 500) {
            return 12.50;
        } else if (pesoGramas <= 1000) {
            return 20.00;
        } else {
            double gramsAcimaDe1kg = pesoGramas - 1000;
            double adicional = Math.ceil(gramsAcimaDe1kg / 100) * 1.50;
            return 46.50 + adicional;
        }
    }

    @Override
    public String getNome() {
        return "Entrega Sedex";
    }
}

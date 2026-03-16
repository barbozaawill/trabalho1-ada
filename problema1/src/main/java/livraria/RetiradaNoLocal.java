package livraria;

public class RetiradaNoLocal implements ModalidadeEntrega {

    @Override
    public double calcularFrete(Pedido pedido) {
        return 0.00;
    }

    @Override
    public String getNome() {
<<<<<<< HEAD
        return "Fazer retirada no Local";
=======
        return "Retirada no Local";
>>>>>>> origin/master
    }
}

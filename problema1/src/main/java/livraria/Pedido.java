package livraria;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> produtos;

    public Pedido() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double getPesoTotal() {
        return produtos.stream().mapToDouble(Produto::getPeso).sum();
    }

    public double getValorTotal() {
        return produtos.stream().mapToDouble(Produto::getValor).sum();
    }
}

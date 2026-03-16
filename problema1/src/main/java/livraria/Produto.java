package livraria;

public class Produto {
    private String nome;
    private double valor;
    private double peso; // pedido em gramas 

    public Produto(String nome, double valor, double peso) {
        this.nome = nome;
        this.valor = valor;
        this.peso = peso;
    }

    public String getNome() { return nome; }
    public double getValor() { return valor; }
    public double getPeso() { return peso; }
}

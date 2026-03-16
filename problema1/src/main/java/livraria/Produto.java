package livraria;

public class Produto {
    private String nome;
    private double valor;
<<<<<<< HEAD
    private double peso; // pedido em g 
=======
    private double peso; // em gramas
>>>>>>> origin/master

    public Produto(String nome, double valor, double peso) {
        this.nome = nome;
        this.valor = valor;
        this.peso = peso;
    }

    public String getNome() { return nome; }
    public double getValor() { return valor; }
    public double getPeso() { return peso; }
}

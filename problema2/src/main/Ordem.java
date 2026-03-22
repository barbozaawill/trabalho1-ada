package bolsa;

public class Ordem {
    private String nomeInvestidor;
    private TipoOrdem tipo;
    private double valor;

    public Ordem(String nomeInvestidor, TipoOrdem tipo, double valor) {
        this.nomeInvestidor = nomeInvestidor;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getNomeInvestidor() {
        return nomeInvestidor;
    }

    public TipoOrdem getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "investidor='" + nomeInvestidor + '\'' +
                ", tipo=" + tipo +
                ", valor=" + valor +
                '}';
    }
}
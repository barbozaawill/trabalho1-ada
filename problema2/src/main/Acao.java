package bolsa;

import java.util.ArrayList;
import java.util.List;

public class Acao implements Observable {

    private String nome;
    private double valor;
    private List<Ordem> ordens;
    private List<Observer> observers;

    public Acao(String nome, double valorInicial) {
        this.nome = nome;
        this.valor = valorInicial;
        this.ordens = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    @Override
    public void registrarObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers() {
        for (Observer o : observers) {
            o.update(nome, valor);
        }
    }

    public void registrarOrdem(Ordem novaOrdem) {
        System.out.println("[" + nome + "] Nova ordem registrada: " + novaOrdem);

        Ordem match = encontrarMatch(novaOrdem);

        if (match != null) {
            // Realiza o match
            ordens.remove(match);
            System.out.println("[" + nome + "] Match realizado entre "
                    + novaOrdem.getNomeInvestidor() + " e " + match.getNomeInvestidor()
                    + " no valor R$" + novaOrdem.getValor());

            valor = novaOrdem.getValor();
            notificarObservers();
        } else {
            ordens.add(novaOrdem);
        }
    }

    private Ordem encontrarMatch(Ordem novaOrdem) {
        TipoOrdem tipoOposto = (novaOrdem.getTipo() == TipoOrdem.COMPRA)
                ? TipoOrdem.VENDA
                : TipoOrdem.COMPRA;

        for (Ordem ordemExistente : ordens) {
            if (ordemExistente.getTipo() == tipoOposto
                    && Double.compare(ordemExistente.getValor(), novaOrdem.getValor()) == 0) {
                return ordemExistente;
            }
        }
        return null;
    }


    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public List<Ordem> getOrdens() {
        return new ArrayList<>(ordens);
    }

    public List<Observer> getObservers() {
        return new ArrayList<>(observers);
    }
}
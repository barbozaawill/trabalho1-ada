package bolsa;

public interface Observable {
    void registrarObserver(Observer observer);
    void removerObserver(Observer observer);
    void notificarObservers();
}
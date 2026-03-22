package bolsa;

public class Investidor implements Observer {

    private String nome;

    public Investidor(String nome) {
        this.nome = nome;
    }

    public void registrarOrdem(Acao acao, TipoOrdem tipo, double valor) {
        Ordem ordem = new Ordem(nome, tipo, valor);
        acao.registrarOrdem(ordem);
    }

    public void assinarAcao(Acao acao) {
        acao.registrarObserver(this);
        System.out.println("[Notificação] " + nome + " agora acompanha a ação " + acao.getNome());
    }

    public void cancelarAssinaturaAcao(Acao acao) {
        acao.removerObserver(this);
        System.out.println("[Notificação] " + nome + " parou de acompanhar a ação " + acao.getNome());
    }

    @Override
    public void update(String acaoNome, double novoValor) {
        System.out.println("[Notificação] " + nome
                + " foi notificado: ação " + acaoNome
                + " agora vale R$" + novoValor);
    }

    public String getNome() {
        return nome;
    }
}
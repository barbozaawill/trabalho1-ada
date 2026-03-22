package bolsa;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Simulação da Bolsa de Valores ===\n");

        Acao bbas3 = new Acao("BBAS3", 23.50);

        Investidor mariana = new Investidor("Mariana");
        Investidor joaquim = new Investidor("Joaquim");
        Investidor carlos  = new Investidor("Carlos");

        carlos.assinarAcao(bbas3);
        mariana.assinarAcao(bbas3);

        System.out.println();

        mariana.registrarOrdem(bbas3, TipoOrdem.VENDA, 24.00);

        System.out.println();

        joaquim.registrarOrdem(bbas3, TipoOrdem.COMPRA, 24.00);

        System.out.println();

        carlos.registrarOrdem(bbas3, TipoOrdem.COMPRA, 25.00);

        System.out.println("\n=== Fim da Simulação ===");
    }
}
package br.furb.iot.adaptador;

import br.furb.analise.algoritmos.PersianaSolarius;
import br.furb.iot.dispositivo.Persiana;

public class PersianaAdaptadorSolarius implements Persiana {

    private final PersianaSolarius persianaSolarius;

    public PersianaAdaptadorSolarius(PersianaSolarius persianaSolarius) {
        this.persianaSolarius = persianaSolarius;
    }

    @Override
    public void abrir() {
        persianaSolarius.subirPersiana();
    }

    @Override
    public void fechar() {
        persianaSolarius.descerPersiana();
    }
}

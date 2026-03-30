package br.furb.iot.adaptador;

import br.furb.analise.algoritmos.PersianaNatLight;
import br.furb.iot.dispositivo.Persiana;

public class PersianaAdaptadorNatLight implements Persiana {

    private final PersianaNatLight persianaNatLight;
    private boolean palhetaAberta;
    private boolean palhetaErguida;

    public PersianaAdaptadorNatLight(PersianaNatLight persianaNatLight) {
        this.persianaNatLight = persianaNatLight;
        this.palhetaAberta = false;
        this.palhetaErguida = false;
    }

    @Override
    public void abrir() {
        abrirPalheta();
        subirPalheta();
    }

    @Override
    public void fechar() {
        descerPalheta();
        fecharPalheta();
    }

    private void abrirPalheta() {
        if (palhetaAberta) {
            return;
        }
        persianaNatLight.abrirPalheta();
        palhetaAberta = true;
    }

    private void subirPalheta() {
        if (palhetaErguida) {
            return;
        }
        try {
            persianaNatLight.subirPalheta();
            palhetaErguida = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void descerPalheta() {
        if (!palhetaErguida) {
            return;
        }
        persianaNatLight.descerPalheta();
        palhetaErguida = false;
    }

    private void fecharPalheta() {
        if (!palhetaAberta) {
            return;
        }
        try {
            persianaNatLight.fecharPalheta();
            palhetaAberta = false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

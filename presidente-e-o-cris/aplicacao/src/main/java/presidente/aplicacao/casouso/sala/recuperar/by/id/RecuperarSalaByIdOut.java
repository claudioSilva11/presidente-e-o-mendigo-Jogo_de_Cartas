package presidente.aplicacao.casouso.sala.recuperar.by.id;

import presidente.dominio.valorobjeto.AccessConfig;
import presidente.dominio.entidade.Sala;

public record RecuperarSalaByIdOut(String link, String status, AccessConfig.Visibility visibility) {

    static RecuperarSalaByIdOut of(Sala aSala) {
        return new RecuperarSalaByIdOut(
                aSala.getLinkSala().getValor().toString(),
                aSala.getStatus().name(),
                aSala.getAccessConfig().getVisibility()
        );
    }
}


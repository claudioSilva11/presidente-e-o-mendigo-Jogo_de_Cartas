package presidente.aplicacao.casouso.sala.criar;

import presidente.dominio.entidade.Sala;

public record CriarSalaOut(String salaId, String link, String status) {

    static CriarSalaOut of(Sala aSala) {
        return new CriarSalaOut(
                aSala.getSalaId().getValor(),
                aSala.getLinkSala().getValor().toString(),
                aSala.getStatus().name()
        );
    }
}

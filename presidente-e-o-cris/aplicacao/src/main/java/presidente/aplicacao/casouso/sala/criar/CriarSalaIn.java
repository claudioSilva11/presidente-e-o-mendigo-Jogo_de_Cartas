package presidente.aplicacao.casouso.sala.criar;

import presidente.dominio.entidade.Player;
import presidente.dominio.entidade.Sala;
import presidente.dominio.valorobjeto.AccessConfig;

public record CriarSalaIn(
        String nickName,
        AccessConfig.Visibility visibility,
        int maxPlayers) {


    public Sala toSala() {
        return Sala.of(
                Player.of(nickName),
                AccessConfig.of(maxPlayers, visibility)
        );
    }

}



package presidente.aplicacao.casouso.sala.recuperar.by.id;

import presidente.dominio.repositorio.SalaRepositorio;
import presidente.dominio.valorobjeto.identificador.SalaId;

public class RecuperarSalaByIdCasoUsuarioImplementacao implements RecuperarSalaByIdCasoUsuario {

    private final SalaRepositorio repositorio;

    public RecuperarSalaByIdCasoUsuarioImplementacao(SalaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public RecuperarSalaByIdOut execute(SalaId anIn) {

        return RecuperarSalaByIdOut.of(
                repositorio.getById(anIn)
        );

    }

}

package presidente.aplicacao.casouso.sala.criar;

import presidente.dominio.repositorio.SalaRepositorio;

public class CriarSalaCasoUsuarioImplementacao implements CriarSalaCasoUsuario {

    private final SalaRepositorio repositorio;

    public CriarSalaCasoUsuarioImplementacao(SalaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public CriarSalaOut execute(CriarSalaIn anIn) {

        return CriarSalaOut.of(
                repositorio.save(anIn.toSala())
        );

    }

}
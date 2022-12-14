package presidente.dominio.repositorio;

import presidente.dominio.entidade.Sala;
import presidente.dominio.valorobjeto.identificador.SalaId;

public interface SalaRepositorio {
    Sala save(Sala aSala);

    void delete(SalaId anId);

    Sala getById(SalaId anId);

    Sala getByLink(String aLink);
}

package presidente.infraestrutura.salas.repositorios;

import presidente.dominio.entidade.Sala;
import presidente.dominio.repositorio.SalaRepositorio;
import presidente.dominio.valorobjeto.identificador.SalaId;

import java.util.HashMap;
import java.util.Map;

public class SalaEmMemoriaRepositorio implements SalaRepositorio {
    private final static Map<String, Sala> SALAS = new HashMap<>();

    @Override
    public Sala save(Sala aSala) {

        SALAS.put(aSala.getSalaId().getValor(), aSala);

        return aSala;

    }

    @Override
    public void delete(SalaId anId) {
        SALAS.remove(anId.getValor());
    }

    @Override
    public Sala getById(SalaId anId) {
        return SALAS.get(anId.getValor());
    }

    @Override
    public Sala getByLink(String aLink) {
        return null;
    }
}

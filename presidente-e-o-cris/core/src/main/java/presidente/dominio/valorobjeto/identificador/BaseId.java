package presidente.dominio.valorobjeto.identificador;

import presidente.dominio.valorobjeto.ValorObjeto;

import java.util.Objects;
import java.util.UUID;

public abstract class BaseId implements ValorObjeto {

    private final UUID valor;

    protected BaseId(final UUID valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseId baseId = (BaseId) o;
        return valor.equals(baseId.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

}

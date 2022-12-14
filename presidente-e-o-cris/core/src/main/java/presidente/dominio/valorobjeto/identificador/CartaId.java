package presidente.dominio.valorobjeto.identificador;

import java.util.UUID;

public class CartaId extends  BaseId {

    private CartaId(final UUID value) {
        super(value);
    }

    public static CartaId of() {
        return new CartaId(UUID.randomUUID());
    }

    public static CartaId of(final UUID value) {
        return new CartaId(value);
    }

}
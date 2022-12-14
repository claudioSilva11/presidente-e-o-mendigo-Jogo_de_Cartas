package presidente.dominio.valorobjeto.identificador;

import java.util.UUID;

public class SalaId extends  BaseId {

    private SalaId(UUID value) {
        super(value);
    }

    public static SalaId of() {
        return new SalaId(UUID.randomUUID());
    }

    public static SalaId of(UUID value) {
        return new SalaId(value);
    }

    public static SalaId of(String value) {
        return new SalaId(UUID.fromString(value));
    }

}

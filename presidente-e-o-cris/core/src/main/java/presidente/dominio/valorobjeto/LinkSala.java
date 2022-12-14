package presidente.dominio.valorobjeto;

import java.util.UUID;

public class LinkSala implements ValorObjeto {

    private final UUID valor;

    private LinkSala(final UUID valor) {
        this.valor = valor;
    }

    public static LinkSala of() {
        return new LinkSala(UUID.randomUUID());
    }

    public UUID getValor() {
        return valor;
    }
}

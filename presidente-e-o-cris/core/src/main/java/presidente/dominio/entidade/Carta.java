package presidente.dominio.entidade;

import presidente.dominio.valorobjeto.Nipe;
import presidente.dominio.valorobjeto.ValorCarta;
import presidente.dominio.valorobjeto.identificador.CartaId;

public class Carta implements Comparable<Carta>{

    private final CartaId cartaId;
    private final ValorCarta cartaValor;
    private final Nipe nipe;

    private Carta(final CartaId cartaId, final ValorCarta cartaValor, final Nipe nipe) {
        this.cartaId = cartaId;
        this.cartaValor = cartaValor;
        this.nipe = nipe;
    }

    public static Carta of(final ValorCarta cartaValor, final Nipe nipe) {
        return new Carta(CartaId.of(), cartaValor, nipe);
    }

    public CartaId getCartaId() {
        return cartaId;
    }

    public ValorCarta getValorCarta() {
        return cartaValor;
    }

    public Nipe getNipe() {
        return nipe;
    }
    @Override
    public String toString() {
        return this.cartaValor + " of " + this.nipe;
    }

    @Override
    public int compareTo(final Carta o) {
        return o.getValorCarta().getValor() - this.getValorCarta().getValor();
    }

}


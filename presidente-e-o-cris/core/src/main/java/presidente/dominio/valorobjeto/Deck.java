package presidente.dominio.valorobjeto;

import presidente.dominio.entidade.Carta;

public class Deck implements ValorObjeto {

    private final Carta[] cartas;

    private Deck() {
        this.cartas = new Carta[52];

        for (final var carta : ValorCarta.values()) {
            for (final var nipe : Nipe.values()) {
                cartas[carta.ordinal() + nipe.ordinal() * 13] = Carta.of(carta, nipe);
            }
        }
    }


    public static Deck of() {
        return new Deck();
    }
    public Carta[] getCartas() {
        return cartas;
    }


}


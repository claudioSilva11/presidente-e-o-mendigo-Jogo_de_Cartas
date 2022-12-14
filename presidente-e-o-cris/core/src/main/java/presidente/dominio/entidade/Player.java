package presidente.dominio.entidade;

import presidente.dominio.valorobjeto.identificador.PlayerId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player implements  Comparable<Player> {

    private PlayerId playerId;
    private String nickName;
    private List<Carta> cartas;
    private Carta sortearCartas;

    private Player(
            final PlayerId playerId,
            final String nickName,
            final List<Carta> cards,
            final Carta choiceCard) {

        this.playerId = playerId;
        this.nickName = nickName;
        this.cartas = cards;
        this.sortearCartas = choiceCard;

    }

    public static Player of(final String nickName) {

        return new Player(
                PlayerId.of(),
                nickName,
                new ArrayList<>(),
                null
        );

    }

    public void sortearCartas(final Carta card) {
        this.sortearCartas = card;
    }
    public void addCarta(final Carta carta) {
        this.cartas.add(carta);
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public String getNickName() {
        return nickName;
    }

    public List<Carta> getCards() {
        return Collections.unmodifiableList(cartas);
    }

    public Carta getChoiceCard() {
        return sortearCartas;
    }

    @Override
    public int compareTo(final Player player) {
        return this.sortearCartas.compareTo(player.sortearCartas);
    }
}

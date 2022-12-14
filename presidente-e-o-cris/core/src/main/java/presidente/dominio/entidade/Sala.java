package presidente.dominio.entidade;

import presidente.dominio.valorobjeto.*;
import presidente.dominio.valorobjeto.identificador.PlayerId;
import presidente.dominio.valorobjeto.identificador.SalaId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sala {

    private final static int N_DECKS = 2;
    private final SalaId salaId;
    private Player proprietario;
    private final LinkSala salaLink;
    private AccessConfig accessConfig;
    private List<Player> players;
    private List<PlayerId> playersEmSorteio;
    private List<Carta> cartasEmSorteio;

    private List<Carta> cartasEntrega;
    private Status status;

    private Sala(
            final SalaId salaId,
            final Player proprietario,
            final LinkSala salaLink,
            final AccessConfig accessConfig,
            final List<Player> players) {

        this.salaId = salaId;
        this.proprietario = proprietario;
        this.salaLink = salaLink;
        this.accessConfig = accessConfig;
        this.players = players;
        this.cartasEmSorteio = new ArrayList<>();
        this.cartasEntrega = new ArrayList<>();

        initializePlayers(players);

        this.status = Status.WAITING;

    }

    public void dealCards() {

        var qtyCartaOfRemove = (N_DECKS * 52) % players.size();

        for (int i = 0; i < N_DECKS; i++) {
            for (final var carta : Deck.of().getCartas()) {
                if (carta.getValorCarta().equals(ValorCarta.TRÊS) && qtyCartaOfRemove > 0) {
                    qtyCartaOfRemove--;
                    continue;
                }
                cartasEntrega.add(carta);
            }
        }

        Collections.shuffle(cartasEntrega);

        var currentPlayer = 0;

        for (final var carta : cartasEntrega) {
            players.get(currentPlayer).addCarta(carta);
            currentPlayer = (currentPlayer + 1) % players.size();
        }

    }

    private void initializePlayers(List<Player> players) {
        this.playersEmSorteio = new ArrayList<>(
                players.stream().map(p -> p.getPlayerId()).toList()
        );
    }

    public void toSorting() {

        if (status != Status.WAITING) {
            throw new IllegalStateException("Room is not waiting");
        }

        shuffleCardsToChoice();
        this.status = Status.IN_SORTING;

    }

    private void shuffleCardsToChoice() {

        if (players.size() < accessConfig.getMinPlayers()) {
            throw new RuntimeException("'min players' can't be less than four!");
        }

        for (final var cardValue : ValorCarta.values()) {
            cartasEmSorteio.add(Carta.of(cardValue, Nipe.CLUBS));
        }

        Collections.shuffle(cartasEmSorteio);

    }

    public static Sala of(final Player proprietario, final AccessConfig accessConfig) {

        final var salaId = SalaId.of();
        final var salaLink = LinkSala.of();
        final var players = new ArrayList<Player>();
        players.add(proprietario);

        return new Sala(
                salaId,
                proprietario,
                salaLink,
                accessConfig,
                players
        );

    }

    public Carta sortearCartas(final Player player) {

        if (status != Status.IN_SORTING) {
            throw new IllegalStateException("Room is not in sorting");
        }

        if (!playersEmSorteio.contains(player.getPlayerId())) {
            throw new IllegalArgumentException(
                    "Can't choice card for player " + player.getPlayerId().getValor()
            );
        }

        final var carta = cartasEmSorteio.get(0);
        player.sortearCartas(carta);
        cartasEmSorteio.remove(carta);
        playersEmSorteio.remove(player.getPlayerId());

        return carta;

    }

    public void sortPlayers() {
        if (playersEmSorteio.isEmpty()) {
            players.sort(Player::compareTo);
            toThrowing();
        }
    }

    void toThrowing() {

        if (status != Status.IN_SORTING && status != Status.ROUND_FINISHED) {
            throw new IllegalStateException("A sala não está em ordem");
        }

        this.status = Status.THROWING_CARDS;
    }

    public void toInGame() {

        if (status != Status.THROWING_CARDS) {
            throw new IllegalStateException("A sala não está jogando cartas");
        }

        status = Status.IN_GAME;

    }

    public void addPlayer(final Player player) {

        if (players.size() >= accessConfig.getMaxPlayers()) {
            throw new RuntimeException("Esta sala está cheia!");
        }

        this.players.add(player);
        this.playersEmSorteio.add(player.getPlayerId());

    }

    public SalaId getSalaId() {
        return salaId;
    }

    public Player getProprietario() {
        return proprietario;
    }

    public LinkSala getLinkSala() {
        return salaLink;
    }

    public AccessConfig getAccessConfig() {
        return accessConfig;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Status getStatus() {
        return status;
    }

    public List<Carta> getCartasEntrega() {
        return Collections.unmodifiableList(cartasEntrega);
    }

    public enum Status {
        WAITING, IN_SORTING, THROWING_CARDS, IN_GAME, ROUND_FINISHED, GAME_FINISHED

    }
}


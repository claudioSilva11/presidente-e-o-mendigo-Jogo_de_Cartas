package presidente.dominio;

import presidente.dominio.entidade.Player;
import presidente.dominio.entidade.Sala;
import presidente.dominio.valorobjeto.AccessConfig;


public class Main {

    public static void main(String[] args) {

        final var p1 = Player.of("Cláudio");
        final var p2 = Player.of("Eduardo");
        final var p3 = Player.of("João");
        final var p4 = Player.of("Carlos");

        final var sala = Sala.of(p1, AccessConfig.ofPrivate(4));

        sala.addPlayer(p2);
        sala.addPlayer(p3);
        sala.addPlayer(p4);

        sala.toSorting();

        sala.sortearCartas(p1);
        sala.sortearCartas(p2);
        sala.sortearCartas(p3);
        sala.sortearCartas(p4);

        sala.sortPlayers();

        print(sala);

        sala.dealCards();

        System.out.println("-------------------------");
        p1.getCards().forEach(System.out::println);
        System.out.println(p1.getCards().size());

        System.out.println("-------------------------");
        p2.getCards().forEach(System.out::println);
        System.out.println(p2.getCards().size());

        System.out.println("-------------------------");
        p3.getCards().forEach(System.out::println);
        System.out.println(p3.getCards().size());

        System.out.println("-------------------------");
        p4.getCards().forEach(System.out::println);
        System.out.println(p4.getCards().size());

        System.out.println("-------------------------");

    }

    private static void print(final Sala sala) {
        System.out.println("Sala id: " + sala.getSalaId().getValor());
        System.out.println("Dono: " + sala.getProprietario().getNickName());
        sala.getPlayers().forEach(p -> {
            System.out.println("Player: " + p.getNickName());
            System.out.println("Chosen Card: " + p.getChoiceCard().getValorCarta());
        });
        System.out.println("Valor do Link: " + sala.getLinkSala().getValor());
        System.out.println("Min players: " + sala.getAccessConfig().getMinPlayers());
        System.out.println("Max players: " + sala.getAccessConfig().getMaxPlayers());
        System.out.println("Time of next player: " + sala.getAccessConfig().getTimeOfNextPlayer());
        System.out.println("Visibility: " + sala.getAccessConfig().getVisibility());
    }
}


package presidente.dominio.valorobjeto;

public enum ValorCarta implements ValorObjeto {

    DOZE(12),
    DOIS (13),
    TRÊS (1),
    QUATRO(2),
    CINCO (3),
    SEIS(4),
    SETE(5),
    OITO (6),
    NOVE(7),
    DEZ(8),
    JACK(9),
    RAINHA (10),
    REI(11);
    private final int valor;

    ValorCarta(final int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
    public int compare(final ValorCarta c) {
        return this.getValor() - c.getValor();
    }
}


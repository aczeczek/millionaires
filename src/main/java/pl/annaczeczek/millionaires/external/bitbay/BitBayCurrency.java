package pl.annaczeczek.millionaires.external.bitbay;

public enum BitBayCurrency {
    BTCPLN("Bitcoin"),
    BCCPLN("Bitcoin Cash"),
    BTGPLN("Bitcoin Gold"),
    LTCPLN("Litecoin"),
    ETHPLN("Etherium"),
    DASHPLN("Dash"),
    LSKPLN("Lisk"),
    GAMEPLN("GameCredits");

    public final String name;


    BitBayCurrency(String name) {
        this.name = name;
    }
}

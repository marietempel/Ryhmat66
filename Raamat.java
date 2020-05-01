public class Raamat {

    //autori perenimi;autori eesnimi;originaal pealkiri;originaal ilmumisaasta;t6lke pealkiri;t6lkja;
    //      0                1                2                    3                 4          5
    // t6lke avaldamisaasta;kirjastus;keel;lehek9lgi;asukoht;Control number
    //      6              7           8      9        10         11

    private String autoriPerenimi;
    private String autoriEesnimi;
    //String autor; praegu kommenteerisin välja, sest ees- ja perenimega eraldi on alguses lihtsam teha objekti
    private String originaalPealkiri;
    private int originaalIlmumisaasta;
    private String kirjastus;
    private String keel;
    private int lehekülgedeArv;
    Riiul täpneAsukoht;

    //konstruktor
    public Raamat(String autoriPerenimi, String autoriEesnimi, String originaalPealkiri, int originaalIlmumisaasta,
                  String kirjastus, String keel, int lehekülgedeArv, Riiul raamaturiiul) {
        this.autoriPerenimi = autoriPerenimi;
        this.autoriEesnimi = autoriEesnimi;
        this.originaalPealkiri = originaalPealkiri;
        this.originaalIlmumisaasta = originaalIlmumisaasta;
        this.kirjastus = kirjastus;
        this.keel = keel;
        this.lehekülgedeArv = lehekülgedeArv;
        this.täpneAsukoht = raamaturiiul;
    }


    public Riiul getTäpneAsukoht() {
        return täpneAsukoht;
    }

    public String getAutoriPerenimi() {
        return autoriPerenimi;
    }

    public String getOriginaalPealkiri() {
        return originaalPealkiri;
    }

    public String getKeel() {
        return keel;
    }

    @Override
    public String toString() {
        return autoriPerenimi + ";" + autoriEesnimi + ";" + originaalPealkiri + ";" +
                originaalIlmumisaasta + ";" + kirjastus + ";" + keel + ";" + lehekülgedeArv + ";"
                + täpneAsukoht;
    }
}

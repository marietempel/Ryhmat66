public class TolkeRaamat extends Raamat {

    //t6lke pealkiri;t6lkja;t6lke avaldamisaasta;
    //     4            5           6

    String tõlkePealkiri;
    String tõlkija;
    int tõlkeAvaldamisaasta;

    //konstruktor
    public TolkeRaamat(String autoriPerenimi, String autoriEesnimi, String originaalPealkiri,
                       int originaalIlmumisaasta, String tõlkePealkiri, String tõlkija, int tõlkeAvaldamisaasta,
                       String kirjastus, String keel, int lehekülgedeArv, Riiul täpneAsukoht) {
        super(autoriPerenimi, autoriEesnimi, originaalPealkiri, originaalIlmumisaasta, kirjastus, keel,
                lehekülgedeArv, täpneAsukoht);
        this.tõlkePealkiri = tõlkePealkiri;
        this.tõlkija = tõlkija;
        this.tõlkeAvaldamisaasta = tõlkeAvaldamisaasta;
    }

    @Override
    public String toString() {
        return super.toString() + " " +
                "tõlke pealkiri: '" + tõlkePealkiri + '\'' +
                ", tõlkija: '" + tõlkija + '\'' +
                ", tõlke avaldamisaasta: '" + tõlkeAvaldamisaasta + '\'' +
                '}';
    }


}

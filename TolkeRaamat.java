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

    public String getTõlkePealkiri() {
        return tõlkePealkiri;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + tõlkePealkiri + ";" + tõlkija + ";" + tõlkeAvaldamisaasta;
    }


}

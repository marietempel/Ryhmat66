package rühmatöö1;

public class TolkeRaamat extends Raamat {
    String tõlkija;
    String originaalPealkiri;

    public TolkeRaamat(String pealkiri, String autor, int lehekülgedeArv, Raamaturiiul raamaturiiul, Riiul täpneAsukoht,
                       String tõlkija, String originaalPealkiri) {
        super(pealkiri, autor, lehekülgedeArv, raamaturiiul, täpneAsukoht);
        this.tõlkija = tõlkija;
        this.originaalPealkiri = originaalPealkiri;
    }
}

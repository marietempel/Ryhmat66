package rühmatöö1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Raamat {

    //autori perenimi;autori eesnimi;originaal pealkiri;originaal ilmumisaasta;t6lke pealkiri;t6lkja;t6lke avaldamisaasta;kirjastus;keel;lehek9lgi;asukoht;Control number
    //      0                1                2                    3                 4          5              6              7       8      9        10         11

    //kõik on sõnedena, sest alguses nii lihtsam
    //private on sellepärast, et Magnar ütles, et kõik isendiväljad peaks üldiselt olema privaatsed ja kui neid on mujal vaja kasutada, siis tuleb kasutada gettereid ja settereid
    private String autoriPerenimi;
    private String autoriEesnimi;
    //String autor; praegu kommenteerisin välja, sest ees- ja perenimega eraldi on alguses lihtsam teha objekti
    private String originaalPealkiri;
    private int originaalIlmumisaasta;
    private String kirjastus;
    private String keel;
    private int lehekülgedeArv;
    private String asukoht;
    private int kontrollNumber;
    //Raamaturiiul raamaturiiul;
    //Riiul täpneAsukoht;

    public static List<Raamat> kõigiRaamatuteList = new ArrayList<>();

    // meetod loob listi, kus on massiividena kõik read failist
    public static List<String[]> loeRaamatudFailist(File  failitee) throws IOException {
        List<String[]> raamatud = new ArrayList<>();
        try (Scanner sc = new Scanner(failitee, StandardCharsets.UTF_8)){
            while (sc.hasNext()) {
                String[] raamatMassiivina = sc.nextLine().split(";"); // võtab reas ära semikooloni ja tekitab massiivi, kus on kõik "tükid" elementidena
                raamatud.add(raamatMassiivina); // lisab listi massiivi
            }
        }
        return raamatud;
    }

    public static void isenditeLoomineJaListiLisamine(List<String[]> massiivideList) {
        for (String[] raamaturida : massiivideList) {
            if (raamaturida[4].equals("xxx")) { // loob Raamat tüüpi objekti, kui ei ole tõlgitud raamat, ja lisab selle kõigi raamatute listi
                Raamat raamat = new Raamat(raamaturida[0], raamaturida[1], raamaturida[2], Integer.parseInt(raamaturida[3]), raamaturida[7],
                        raamaturida[8], Integer.parseInt(raamaturida[9]), raamaturida[10], Integer.parseInt(raamaturida[11]));
                kõigiRaamatuteList.add(raamat);
            }
            else {
                Raamat raamat = new TolkeRaamat(raamaturida[0], raamaturida[1], raamaturida[2], Integer.parseInt(raamaturida[3]), raamaturida[4], raamaturida[5], Integer.parseInt(raamaturida[6]),
                        raamaturida[7], raamaturida[8], Integer.parseInt(raamaturida[9]), raamaturida[10], Integer.parseInt(raamaturida[11]));
                kõigiRaamatuteList.add(raamat);
            }
        }
    }

    /*loob meetodi abil massiivide listi
    kui massiiv[4] == "xxx", siis loob uue isendi, kus xxx pole vaja
    ja lisab selle listi, kus on raamatud
     */



    //konstruktor
    public Raamat(String autoriPerenimi, String autoriEesnimi, String originaalPealkiri, int originaalIlmumisaasta, String kirjastus, String keel, int lehekülgedeArv, String asukoht, int kontrollNumber) {
        this.autoriPerenimi = autoriPerenimi;
        this.autoriEesnimi = autoriEesnimi;
        this.originaalPealkiri = originaalPealkiri;
        this.originaalIlmumisaasta = originaalIlmumisaasta;
        this.kirjastus = kirjastus;
        this.keel = keel;
        this.lehekülgedeArv = lehekülgedeArv;
        this.asukoht = asukoht;
        this.kontrollNumber = kontrollNumber;
    }

    @Override
    public String toString() {
        return "Raamat{" +
                "autori perenimi: '" + autoriPerenimi + '\'' +
                ", autori eesnimi: '" + autoriEesnimi + '\'' +
                ", originaali pealkiri: '" + originaalPealkiri + '\'' +
                ", originaali ilmumisaasta: '" + originaalIlmumisaasta + '\'' +
                ", kirjastus: '" + kirjastus + '\'' +
                ", keel: '" + keel + '\'' +
                ", lehekülgede arv: '" + lehekülgedeArv + '\'' +
                ", asukoht: '" + asukoht + '\'' +
                ", kontrollnumber: '" + kontrollNumber + '\'' +
                '}';
    }
}

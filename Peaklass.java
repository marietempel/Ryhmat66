import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Peaklass {

    static File failRaamatud = new File("raamatud.txt");
    static File failRiiulid = new File("riiulid.txt");

    public static void ettevalmistus() throws IOException {
        AndmeteHoidla andmeteHoidla = new AndmeteHoidla();
        andmeteHoidla.riiuliIsenditeLoomineJaListiLisamine(failRiiulid);
        List<String[]> massiivideList = andmeteHoidla.loeRaamatudFailist(failRaamatud);
        andmeteHoidla.isenditeLoomineJaListiLisamine(massiivideList);
        //List<Raamat> kõigiRaamatuteList = andmeteHoidla.getRaamatud();
        //List<Raamaturiiul> kõigiRaamaturiiuliteList = andmeteHoidla.getRiiulid();
    }

    public static void main(String[] args) throws Exception {

        // ettevalmistus
        ettevalmistus();

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //SUHTLUS KASUTAJAGA
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        lugemiseTsitaat(); // programmi käivitamisel saab kasutaja mingi stitaadi lugemise kohta
        System.out.println("Tere tulemast kasutama koduraamatukogu! \n" +
                "Programm loeb tekstifailidest info raamatute ja riiulite kohta, et saaksid teha erinevaid päringuid. \n" +
                "Palun kontrolli koodist üle, kas real \"static File failRaamatud = new File();\" ja " +
                "\"static File failRiiulid = new File()\" on File() argumendiks õige failitee, et programm saaks töötada. \n" +
                "Programmi kasutades on oluline jälgida, et sisendis poleks kirjavigu, sh algustäht.");

        String sisend = "";
        while (!sisend.equals("lõpp")) { // programm töötab, kuni kasutaja ei ole kirjutanud "lõpp"
            System.out.println("\nMida soovid teha? Programmi töö lõpetamiseks kirjuta \"lõpp\". \n" +
                    "(1) Kuvada raamatu info pealkirja järgi \n" +
                    "(2) Kuvada info ühe autori kõigi raamatute kohta \n" +
                    "(3) Kuvada ühe riiuli kõik raamatud \n" +
                    "(4) Kuvada mingis keeles kõik raamatud \n" +
                    "(5) Kuvada info kõigi raaamtute kohta");

            Scanner küsibSisendit = new Scanner(System.in);  // Loob Scanner-tüüpi objekti
            System.out.println("Sisesta tegevuse number: ");
            sisend = küsibSisendit.nextLine();  // Loeb kasutaja sisendit
            kasutajaTegevused(sisend);  // Tegutseb vastavalt sisendile
        }

        System.out.println("\nAitäh, et kasutasid koduraamatukogu. Ilusat päeva!");
    }

///////////////////////////////////////ABIMEETODID///////////////////////////////////////


    // Valib etteantud tsitaatidest suvalise, mida kasutajale näidata
    public static String lugemiseTsitaat() {
        double suvaarv = Math.random();
        if (suvaarv >= 0.5) return "\"Raamat on nagu peegel: kui vaatab sisse ahv, ei saa talle ingel vastu vaadata" +
                ".\"\n" +
                "- Georg Christoph Lichtenberg";
        else return "\"Pealegi milleks peakski veel raamatuid kirjutama, kirjastama või lugema, kui maailmas valitseb" +
                " ideaalne ühiskondlik kord.\"" +
                "Raamat on pahe, millega tahetakse saavutada voorust, aga kes mõtleb pahele, kui ta on ideaalselt vooruslik. \n" +
                "- Anton Hansen Tammsaare";
    }

    // Valib meetodi vastavalt kasutaja sisendile
    private static void kasutajaTegevused(String sisend) throws IOException {
        switch (sisend) {
            case "1":
                //infoPealkirjaJärgi();
                break;
            case "2":
                //üheAutoriKõikRaamatud();
                break;
            case "3":
                //üheRiiuliKõikRaamatud();
                break;
            case "4":
                //üheKeeleKõikRaamatud();
                break;
            case "5":
                //väljastaKõikRaamatud();
                break;
        }
    }

///////////////////////////////////////TEGEVUSTE MEETODID///////////////////////////////////////

    public static ObservableList<String> kõikVastavadPealkirjad(String pealkiri) {
        ObservableList<String> kõikVastavadRaamatud = FXCollections.observableArrayList();
        for (Raamat raamat : AndmeteHoidla.raamatud) {
            if (raamat.getOriginaalPealkiri().equals(pealkiri)) {
                if (raamat instanceof TolkeRaamat) {
                    kõikVastavadRaamatud.add(((TolkeRaamat) raamat).getTõlkePealkiri());
                } else
                    kõikVastavadRaamatud.add(pealkiri);
            }
        }
        return kõikVastavadRaamatud;
    }

    public static ObservableList<String> infoPealkirjaJärgi(String pealkiri) {

        ObservableList<String> raamatuInfo = FXCollections.observableArrayList();
        for (Raamat raamat : AndmeteHoidla.raamatud) {
            if (raamat instanceof TolkeRaamat) {
                if (((TolkeRaamat) raamat).getTõlkePealkiri().equals(pealkiri)) {
                    String[] massiiv = raamat.toString().split(";");
                    for (String s : massiiv) {
                        raamatuInfo.add(s);
                    }
                    return raamatuInfo;
                }
            }
            if (raamat.getOriginaalPealkiri().equals(pealkiri)) {
                String[] massiiv = raamat.toString().split(";");
                for (String s : massiiv) {
                    raamatuInfo.add(s);
                }
                return raamatuInfo;
            }
        }
        raamatuInfo.addAll("Ei", "leitud", "raamatut");
        return raamatuInfo;

    }

    public static ObservableList<String> üheAutoriKõikRaamatud(String autor) {

        ObservableList<String> autoriKõikRaamatud = FXCollections.observableArrayList();

        boolean kasLeitiRaamat = false;

        for (Raamat raamat : AndmeteHoidla.raamatud) {
            if (raamat.getAutoriPerenimi().equals(autor)) {
                if (raamat instanceof TolkeRaamat) {
                    autoriKõikRaamatud.add(((TolkeRaamat) raamat).getTõlkePealkiri());
                } else
                    autoriKõikRaamatud.add(raamat.getOriginaalPealkiri());
            }
        }
        return autoriKõikRaamatud;
    }

    public static ObservableList<String> üheRiiuliKõikRaamatud(String tunnus) {

        int soovitudRiiuliIndeks = 1000;
        ObservableList<String> raamatudRiiulis = FXCollections.observableArrayList();
        for (Raamaturiiul riiul : AndmeteHoidla.riiulid) {
            if (riiul.getAsukohtVõiTunnusmärk().equals(tunnus)) { //leiab soovitud riiuli
                soovitudRiiuliIndeks = AndmeteHoidla.riiulid.indexOf(riiul);
            }
        }

        if (soovitudRiiuliIndeks == 1000) { // kui ei muutnud eelmise tsükliga riiuli indeksit
            raamatudRiiulis.addAll("Ei", "leidnud", "sellist",
                    "riiulit");
        } else {
            for (Raamat raamat : AndmeteHoidla.raamatud) { // väljastab ainult soovitud tunnusega riiuli raamatud
                if (raamat.getTäpneAsukoht().getRaamaturiiul().equals(AndmeteHoidla.riiulid.get(soovitudRiiuliIndeks))) {
                    if (raamat instanceof TolkeRaamat) {
                        raamatudRiiulis.add(((TolkeRaamat) raamat).getTõlkePealkiri());
                    } else
                        raamatudRiiulis.add(raamat.getOriginaalPealkiri());
                }
            }
        }
        return raamatudRiiulis;
    }

    public static ObservableList<String> üheKeeleKõikRaamatud(String keel) {

        ObservableList<String> antudKeelsedRaamatud = FXCollections.observableArrayList();
        for (Raamat raamat : AndmeteHoidla.raamatud) {
            if (raamat.getKeel().equals(keel)) {
                if (raamat instanceof TolkeRaamat) {
                    antudKeelsedRaamatud.add(((TolkeRaamat) raamat).getTõlkePealkiri());
                } else
                    antudKeelsedRaamatud.add(raamat.getOriginaalPealkiri());
            }
        }
        return antudKeelsedRaamatud;
    }

    public static ObservableList<String> väljastaKõikRaamatud() {
        ObservableList<String> kõikRaamatud = FXCollections.observableArrayList();
        for (Raamat raamat : AndmeteHoidla.raamatud) {
            if (raamat instanceof TolkeRaamat) {
                kõikRaamatud.add(((TolkeRaamat) raamat).getTõlkePealkiri());
            } else
                kõikRaamatud.add(raamat.getOriginaalPealkiri());
        }
        return kõikRaamatud;
    }
}

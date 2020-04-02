package rühmatöö1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static rühmatöö1.Raamat.*;
import static rühmatöö1.Raamaturiiul.*;

public class Peaklass {

    //static File failRaamatud = new File("C:/Users/tempel/Documents/OOP/oop/src/rühmatöö1/raamatud");
    //static File failRiiulid = new File("C:/Users/tempel/Documents/OOP/oop/src/rühmatöö1/riiulid.txt");
    static File failRaamatud = new File("C:\\Users\\carmen akkermann\\IdeaProjects\\OOP2\\src\\rühmatöö1\\raamatud.txt");
    static File failRiiulid = new File("C:\\Users\\carmen akkermann\\IdeaProjects\\OOP2\\src\\rühmatöö1\\riiulid.txt");

    public static void main(String[] args) throws Exception {

        // ettevalmistus

        riiuliIsenditeLoomineJaListiLisamine(failRiiulid);
        List<String[]> massiivideList = loeRaamatudFailist(failRaamatud);
        isenditeLoomineJaListiLisamine(massiivideList);

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
    private static void lugemiseTsitaat() {
        double suvaarv = Math.random();
        if (suvaarv >= 0.5) System.out.println("\"Raamat on nagu peegel: kui vaatab sisse ahv, ei saa talle ingel vastu vaadata.\"\n" +
                "- Georg Christoph Lichtenberg");
        else System.out.println("\"Pealegi milleks peakski veel raamatuid kirjutama, kirjastama või lugema, kui maailmas valitseb ideaalne ühiskondlik kord.\"" +
                "Raamat on pahe, millega tahetakse saavutada voorust, aga kes mõtleb pahele, kui ta on ideaalselt vooruslik. \n" +
                "- Anton Hansen Tammsaare");
        System.out.println();
    }

    // Valib meetodi vastavalt kasutaja sisendile
    private static void kasutajaTegevused(String sisend) throws IOException {
        switch (sisend) {
            case "1":
                infoPealkirjaJärgi();
                break;
            case "2":
                üheAutoriKõikRaamatud();
                break;
            case "3":
                üheRiiuliKõikRaamatud();
                break;
            case "4":
                üheKeeleKõikRaamatud();
                break;
            case "5":
                väljastaKõikRaamatud();
                break;
        }
    }

///////////////////////////////////////TEGEVUSTE MEETODID///////////////////////////////////////

    private static void infoPealkirjaJärgi() {

        Scanner küsibSisendit = new Scanner(System.in);  // Loob Scanner-tüüpi objekti
        System.out.println("Sisesta raamatu originaalpealkiri: ");
        String sisend = küsibSisendit.nextLine();

        boolean kasLeitiRaamat = false;

        for (Raamat raamat : kõigiRaamatuteList) {
            if (raamat.getOriginaalPealkiri().equals(sisend)) {
                System.out.println(raamat);
                kasLeitiRaamat = true;
            }
        }

        // kui soovitud pealkirjaga raamatut ei leitud
        if (!kasLeitiRaamat) System.out.println("Ei leidnud sellise pealkirjaga raamatuid.");
    }

    private static void üheAutoriKõikRaamatud() {
        Scanner küsibSisendit = new Scanner(System.in);  // Loob Scanner-tüüpi objekti
        System.out.println("Sisesta raamatu autori perenimi: ");
        String sisend = küsibSisendit.nextLine();

        boolean kasLeitiRaamat = false;

        for (Raamat raamat : kõigiRaamatuteList) {
            if (raamat.getAutoriPerenimi().equals(sisend)) {
                System.out.println(raamat);
                kasLeitiRaamat = true;
            }
        }

        // kui soovitud autori raamatut ei leitud
        if (!kasLeitiRaamat) System.out.println("Ei leidnud selle autori raamatut.");
    }

    private static void üheRiiuliKõikRaamatud() throws IOException {

        Scanner küsibSisendit = new Scanner(System.in);  // Loob Scanner-tüüpi objekti
        System.out.println("Sisesta riiuli tunnus (minu, suur, sinine): ");

        String sisend = küsibSisendit.nextLine();  // Loeb kasutaja sisendit

        int soovitudRiiuliIndeks = 1000;
        for (Raamaturiiul riiul : kõigiRaamaturiiuliteList) {
            if (riiul.getAsukohtVõiTunnusmärk().equals(sisend)){ //leiab soovitud riiuli
                soovitudRiiuliIndeks = kõigiRaamaturiiuliteList.indexOf(riiul);
            }
        }

        if (soovitudRiiuliIndeks == 1000) { // kui ei muutnud eelmise tsükliga riiuli indeksit
            System.out.println("Ei leidnud sellise tunnusega raamatut.");
        }
        else {
            for (Raamat raamat : kõigiRaamatuteList) { // väljastab ainult soovitud tunnusega riiuli raamatud
                if (raamat.getTäpneAsukoht().getRaamaturiiul().equals(kõigiRaamaturiiuliteList.get(soovitudRiiuliIndeks))) {
                    System.out.println(raamat);
                }
            }
        }

    }

    private static void üheKeeleKõikRaamatud() {
        Scanner küsibSisendit = new Scanner(System.in);  // Loob Scanner-tüüpi objekti
        System.out.println("Sisesta soovitav raamatu keel (nt eesti, inglise): ");
        String sisend = küsibSisendit.nextLine();

        boolean kasLeitiRaamat = false;

        for (Raamat raamat : kõigiRaamatuteList) {
            if (raamat.getKeel().equals(sisend)) {
                System.out.println(raamat);
                kasLeitiRaamat = true;
            }
        }

        // kui soovitud keeles raamatut ei leitud
        if (!kasLeitiRaamat) System.out.println("Ei leidnud selles keeles raamatuid.");
    }

    private static void väljastaKõikRaamatud() {
        for (Raamat raamat : kõigiRaamatuteList) {
            System.out.println(raamat);
        }
    }

}

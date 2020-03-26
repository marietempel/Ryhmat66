package rühmatöö1;

import java.util.Arrays;

public class Testklass {

    // Järjendid (massiivi), mis moodustatakse faili ridadest
    static String pealkiri;
    static String autor;
    static int lehekülgedeArv;
    static Raamaturiiul raamaturiiul;
    static Riiul täpneAsukoht;

    static String[] readFailist(String fNimi){
        fNimi = "raamatud.txt";
        String[] ss = new String[110000];
        // sisestada read failist järjendisse ss:
        Gen_RiduTekstifailist gen = new Gen_RiduTekstifailist(fNimi); // generaator
        int i = 0; // indeks failides
        while(gen.hasNext()){
            String rida = gen.next(); // järjekordne rida failist
            if(rida.startsWith("20"))
                ss[i++] = rida;
        }//while

        // i on loetud ridade arv (viimase indeks + 1)
        return Arrays.copyOfRange(ss, 0, i);
    }//readFailist

    static void kolmJärjendit(String[] read){
        int n = read.length;
        pealkiri = new String();
        autor = new String();
        lehekülgedeArv = new int[];
        raamaturiiul = new Raamaturiiul();
        täpneAsukoht = new Riiul();
        for(int i = 0; i < n; i++){ // iga rea korral
            kuupäev[i]  = read[i].substring(0, 10);
            kellaaeg[i] = read[i].substring(11, 19);
            temperatuur[i] = Double.parseDouble(read[i].substring(21, read[i].length()));
        }//for
    }//kolmJärjendit

    public static void main(String[] args) {
        String fNimi = "temperatuurid2019.txt"; // lühinimi, fail asub jooksvas kaustas
        // täisnime näide:
        //String fNimi = "C:\\Jyri\\ownCloud\\ProgrammeerimiseHarjutused\\2020k\\Ülesanded\\Kodutööd\\Kodu3\\temperatuurid2019.txt";
        String[] read = readFailist(fNimi);
        // massiivi 'read' elemendiks on rida failist fNimi,
        // 									näiteks "2018-12-12 23:45:00, -2.07697986577"
        kolmJärjendit(read); // kolm järjendit (massiivi) faili ridadest
        // formeeritud on kolm järjendit (kuupäev[], kellaaeg[] ja temperatuur[])

        // kontroll, 10 esimest elementi igast järjendist:
        /*System.out.println("\nKontrolliks, järjendite algused: ");
        System.out.println("kuupäev[]\tkellaaeg[]\t temperatuur[]");
        for(int i = 0; i < 10; i++)
            System.out.println(kuupäev[i] + "\t" + kellaaeg[i] + "\t" + temperatuur[i]);
        System.out.println("   ...   \t   ...   \t    ...");*/
    }

}

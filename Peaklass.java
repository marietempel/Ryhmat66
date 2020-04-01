package rühmatöö1;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static rühmatöö1.Raamat.*;

public class Peaklass {

    public static void main(String[] args) throws Exception {

        //Ma ei suuda mõelda hetkel, missugune see fail välja peaks nägema või kuidas sealt andmeid võtma peaks
        //java.io.File fail = new java.io.File("C:/Users/tempel/Documents/OOP/oop/src/nadal4/kodu/marsruut.txt");
        // sinu fail on ilmselt teise teekonnaga jätame mõlemad sisse, lihtsalt igaüks kommenteerib välja selle, mis
        // talle ei sobi.
        //File fail = new File("C:\\Users\\carmen akkermann\\IdeaProjects\\OOP2\\src\\rühmatöö1\\raamatud.txt");
        //String fail = "raamatud.txt";

        Raamaturiiul sinine = new Raamaturiiul(1,2,"sinine");
        Raamaturiiul suurTuba = new Raamaturiiul(7,5, "Suur Tuba");
        Raamaturiiul marieTuba = new Raamaturiiul(9,4, "Marie tuba");
        //Raamat minaOlenSurm = new Raamat("Mina Olen Surm", "Mairi Laurik", 224, suurTuba, new Riiul(3,4));
        //System.out.println(minaOlenSurm);

        List<String[]> massiivideList = loeRaamatudFailist(fail);
        //kontrolliks
        /*for (String[] strings : massiivideList) {
            for (int i = 0; i < 11; i++) {
                System.out.print(strings[i] + " ");
            }
            System.out.println();
        }*/

        isenditeLoomineJaListiLisamine(massiivideList);

        for (Raamat raamat : kõigiRaamatuteList) {
            System.out.println(raamat);
        }
    }
}

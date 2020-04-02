package rühmatöö1;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static rühmatöö1.Raamat.*;
import static rühmatöö1.Raamaturiiul.*;

public class Peaklass {

    public static void main(String[] args) throws Exception {


        java.io.File failRaamatud = new java.io.File("C:/Users/tempel/Documents/OOP/oop/src/rühmatöö1/raamatud");
        java.io.File failRiiulid = new java.io.File("C:/Users/tempel/Documents/OOP/oop/src/rühmatöö1/riiulid.txt");
        //File failRaamatud = new File("C:\\Users\\carmen akkermann\\IdeaProjects\\OOP2\\src\\rühmatöö1\\raamatud.txt");
        //String fail = "raamatud.txt";

        Raamaturiiul sinine = new Raamaturiiul("sinine", 1, 2);

        int soovitudRiiuliIndeks =0; // idee, kuidas otsida välja ainult mingi kindla soovitud tunnusega raamatud
        riiuliIsenditeLoomineJaListiLisamine(failRiiulid);
        for (Raamaturiiul riiul : kõigiRaamaturiiuliteList) {
            if (riiul.getAsukohtVõiTunnusmärk().equals("sinine")){ //leiab soovitud riiuli
                soovitudRiiuliIndeks = kõigiRaamaturiiuliteList.indexOf(riiul);
            }
        }
        List<String[]> massiivideList = loeRaamatudFailist(failRaamatud);
        isenditeLoomineJaListiLisamine(massiivideList);
        for (Raamat raamat : kõigiRaamatuteList) { // väljastab ainult sinise riiuli raamatud hetkel
            if (raamat.getTäpneAsukoht().getRaamaturiiul().equals(kõigiRaamaturiiuliteList.get(soovitudRiiuliIndeks))) {
                System.out.println(raamat);
            }
        }
    }
}

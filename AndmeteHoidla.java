import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AndmeteHoidla {
    public static List<Raamat> raamatud = new ArrayList<Raamat>();
    public static List<Raamaturiiul> riiulid = new ArrayList<Raamaturiiul>();

    public AndmeteHoidla() {
    }

    // meetod loob listi, kus on massiividena kõik read failist
    public List<String[]> loeRaamatudFailist(File failitee) throws IOException {
        List<String[]> raamatud = new ArrayList<>();
        try (Scanner sc = new Scanner(failitee, StandardCharsets.UTF_8)) {
            while (sc.hasNext()) {
                String[] raamatMassiivina = sc.nextLine().split(";"); // võtab reas ära semikooloni ja
                raamatud.add(raamatMassiivina); // lisab listi massiivi    // tekitab massiivi, kus on kõik "tükid" elementidena

            }
        }
        return raamatud;
    }

    public void isenditeLoomineJaListiLisamine(List<String[]> massiivideList) { ;
        for (String[] raamaturida : massiivideList) { //leiab raamaturiiuli
            int riiuliNumber = 0;
            String[] riiuliKordinaadid = raamaturida[10].split(" ");
            for (int i = 0; i < riiulid.size(); i++) { // otsib üles õige raamaturiiuli.
                if (riiuliKordinaadid[0].equals(riiulid.get(i).getAsukohtVõiTunnusmärk())) {
                    riiuliNumber = i;
                    break;
                }
            }
            Riiul riiul = new Riiul(Integer.parseInt(riiuliKordinaadid[1]), Integer.parseInt(riiuliKordinaadid[2]),
                    riiulid.get(riiuliNumber));


            if (raamaturida[4].equals("xxx")) { // loob Raamat tüüpi objekti, kui ei ole tõlgitud raamat,
                // ja lisab selle kõigi raamatute listi
                Raamat raamat = new Raamat(raamaturida[0], raamaturida[1], raamaturida[2], Integer.parseInt(raamaturida[3]),
                        raamaturida[7], raamaturida[8], Integer.parseInt(raamaturida[9]), riiul);
                raamatud.add(raamat);
            } else {
                Raamat raamat = new TolkeRaamat(raamaturida[0], raamaturida[1], raamaturida[2],
                        Integer.parseInt(raamaturida[3]), raamaturida[4], raamaturida[5], Integer.parseInt(raamaturida[6]),
                        raamaturida[7], raamaturida[8], Integer.parseInt(raamaturida[9]), riiul);
                raamatud.add(raamat);
            }
        }
    }

    public List<String[]> loeRiiulidFailist(File failitee) throws IOException {
        List<String[]> riiulid = new ArrayList<>();
        try (Scanner sc = new Scanner(failitee, StandardCharsets.UTF_8)) {
            while (sc.hasNext()) {
                String[] riiulMassiivina = sc.nextLine().split(" "); // võtab reas ära semikooloni ja
                riiulid.add(riiulMassiivina); // lisab listi massiivi    // tekitab massiivi, kus on kõik "tükid"
                // elementidena
            }
        }
        return riiulid;
    }
    //need kaks (loeRiiulidFailist ja riiuliIsenditeLoomineJaListiLisamine) meetodid on sisuliselt copy paste klassi
    // Raamatu omadest.
    public void riiuliIsenditeLoomineJaListiLisamine(File failitee) throws IOException {
        List<String[]> massiivideList = loeRiiulidFailist(failitee);
        for (String[] riiul : massiivideList) {
            Raamaturiiul raamaturiiul = new Raamaturiiul(riiul[0], Integer.parseInt(riiul[1]),
                    Integer.parseInt(riiul[2]));
            riiulid.add(raamaturiiul);
        }
    }

    public List<Raamat> getRaamatud() {
        return raamatud;
    }

    public List<Raamaturiiul> getRiiulid() {
        return riiulid;
    }
}


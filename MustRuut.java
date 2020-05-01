import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MustRuut extends Application {

    // tegevuste logi muutuja sisu kirjutab programmi töö lõpetamisel tekstifaili,
    // töö käigus salvestab sinna kasutaja tegevuse
    private List<String> tegevusteLogi = new ArrayList<>();
    // abiAvatud ja lõppAvatud on vajalikud, et kontrollida, kas on vaja akna avamisel erindit visata või mitte
    private boolean abiAvatud = false;
    private boolean lõppAvatud = false;

    @Override
    public void start(Stage peaLava) throws IOException {

        FlowPane flow = new FlowPane();

        // lisab kõik ülemise rea nupud ühte listi, et vastavalt sellele saaks hakata neile sisu andma
        BorderPane ülemisedNupud = new BorderPane();
        ülemisedNupud.setMinWidth(510);
        HBox hbox = new HBox();
        List<Button> nupudListis = new ArrayList<>();
        List<String> nuppudeTekstid = new ArrayList<>(Arrays.asList(
                "Kuva üks raamat", "Kuva ühe autori teosed",
                "Kuva üks riiul", "Kuva kindel keel", "Kuva kõik"));
        for (String nupuTekst : nuppudeTekstid) {
            Button nupp = new Button(nupuTekst);
            hbox.getChildren().add(nupp); // lisab aknasse
            nupudListis.add(nupp); // lisab listi
        }
        ülemisedNupud.setCenter(hbox);
        flow.getChildren().add(ülemisedNupud);

        // alumise rea kolm nuppu
        BorderPane alumisedNupud = new BorderPane();
        alumisedNupud.setMinWidth(510);
        Button nupp6 = new Button("Lisa raamat"); //ma arvan, et on ok, kui me ei jõua seda valmis
        Button nupp7 = new Button("Lõpp");
        Button nupp8 = new Button("Abi");
        alumisedNupud.setRight(nupp7);
        alumisedNupud.setCenter(nupp8);
        alumisedNupud.setLeft(nupp6);
        nupudListis.add(nupp6);
        nupudListis.add(nupp7);
        nupudListis.add(nupp8);
        flow.getChildren().add(alumisedNupud);

        BorderPane tekstiVäli = new BorderPane();
        tekstiVäli.setMinWidth(510);
        TextField tekst = new TextField();
        tekst.setText(Peaklass.lugemiseTsitaat());
        tekstiVäli.setCenter(tekst);
        flow.getChildren().add(tekstiVäli);

        ListView<String> list1 = new ListView<String>();
        ObservableList<String> pealkirjad = FXCollections.observableArrayList(
                "Siia", "tulevad", "pealkirjad.");
        list1.setMaxHeight(200);
        list1.setItems(pealkirjad);
        flow.getChildren().add(list1);

        ListView<String> list2 = new ListView<String>();
        ObservableList<String> info = FXCollections.observableArrayList(
                "Siia", "tuleb", "kogu", "muu", "info.");
        list2.setMaxHeight(200);
        list2.setItems(info);
        flow.getChildren().add(list2);


        Scene stseen1 = new Scene(flow, 510, 300, Color.SNOW);

        //laiuse muutmine
        peaLava.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                tekstiVäli.setMinWidth((Double) newValue); //tekstiväli pikeneb
                ülemisedNupud.setMinWidth((Double) newValue); //kujundus ei lähe hukka
            }
        });

        //kõrguse muutmine
        peaLava.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                list1.setMaxHeight((Double) newValue); //peaks pikendama listide pikkusi
                list2.setMaxHeight((Double) newValue);
            }
        });

        peaLava.setScene(stseen1);
        peaLava.setTitle("Koduraamatukogu");
        peaLava.show();

////////////////////////////////////////KASUTAJA TEGEVUS////////////////////////////////////////

        // esimesena näeb kautaja kasutusjuhendit
        try {
            kasutusjuhend(peaLava);
        } catch (AkenAvatudErind e) {
            tekst.setText(e.getMessage());
        }

        Peaklass.ettevalmistus(); // failidest lugemine jms, mis toimub peaklassis

        // nuppudele vastavad tegevused
        for (Button nupp : nupudListis) {
            nupp.setOnMouseClicked(event -> {
                String nupuTekst = nupp.getText();
                if (nupuTekst.equals("Kuva üks raamat")) {
                    tekst.setText("Sisesta raamatu pealkiri");
                    tegevusteLogi.add("Pealkirja järgi raamat");
                    tekst.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            list1.setItems(Peaklass.kõikVastavadPealkirjad(newValue));
                        }
                    });                }
                else if (nupuTekst.equals("Kuva ühe autori teosed")) {
                    tekst.setText("Sisesta autori perenimi");
                    tegevusteLogi.add("Autori teosed");
                    tekst.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            list1.setItems(Peaklass.üheAutoriKõikRaamatud(newValue));
                        }
                    });
                }
                else if (nupuTekst.equals("Kuva üks riiul")) {
                    tekst.setText("Sisesta riiuli tunnus");
                    tegevusteLogi.add("Riiuli teosed");
                    tekst.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            list1.setItems(Peaklass.üheRiiuliKõikRaamatud(newValue));
                        }
                    });
                }
                else if (nupuTekst.equals("Kuva kindel keel")) {
                    tekst.setText("Sisesta keel (nt eesti, inglise)");
                    tegevusteLogi.add("Ühes keeles kõik teosed");
                    tekst.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            list1.setItems(Peaklass.üheKeeleKõikRaamatud(newValue));
                        }
                    });
                }
                else if (nupuTekst.equals("Kuva kõik")) {
                    tekst.setText("Kuvan kõik raamatud.");
                    tegevusteLogi.add("Kõik raamatud");
                    list1.setItems(Peaklass.väljastaKõikRaamatud());
                }
                else if (nupuTekst.equals("Lisa raamat")) {
                    tekst.setText("See funktsionaalsus veel ei tööta!");
                }
                else if (nupuTekst.equals("Abi")) {
                    tegevusteLogi.add("Kasutusjuhend");
                    // kui juba on kasutusjuhendi aken avatud, siis annab sellest teada ja ei lase uuesti sama avada, kuni eelmine pole suletud.
                    try {
                        kasutusjuhend(peaLava);
                    } catch (AkenAvatudErind e) {
                        tekst.setText(e.getMessage());
                    }
                }
                else if (nupuTekst.equals("Lõpp")) {
                    tegevusteLogi.add("Lõpp");
                    // kui juba on lõpetamise aken avatud, siis annab sellest teada ja ei lase uuesti sama avada, kuni eelmine pole suletud.
                    try {
                        väljumiseKontroll(peaLava);
                    } catch (AkenAvatudErind e) {
                        tekst.setText(e.getMessage());
                    }
                }
            });

            list1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                    list2.setItems(Peaklass.infoPealkirjaJärgi(newValue));
                }
            });

        }

        // kui kasutaja tahab akent sulgeda, siis programm küsib, kas on kindel
        peaLava.setOnHiding(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                // kui juba on lõpetamise aken avatud, siis annab sellest teada ja ei lase uuesti sama avada, kuni eelmine pole suletud.
                try {
                    väljumiseKontroll(peaLava);
                } catch (AkenAvatudErind e) {
                    tekst.setText(e.getMessage());
                }
            }
        });
    }

    private void kasutusjuhend(Stage peaLava) throws AkenAvatudErind {
        if (abiAvatud) throw new AkenAvatudErind("Oled juba akna \"Kasutusjuhend\" avanud!");
        abiAvatud = true;
        // luuakse teine lava
        Stage kusimus = new Stage();
        kusimus.setTitle("Kasutusjuhend");
        // juhendi ja kahe nupu loomine
        Label tühiRuumÜlespoole = new Label("");
        Label label = new Label("Tere tulemast kasutama koduraamatukogu!\nEnne tegutsemist loe palun läbi kasutusjuhend.");
        Label juhised = new Label("\n   Selles koduraamatukogus on nii eesti- kui võõrkeelseid raamatuid eri autoritelt ja eri riiulitel. \n" +
                "   Päringu tegemiseks kliki esmalt nupul ja sisesta vajalik info tekstivälja (alguses on seal tsitaat).\n" +
                "       \"Kuva üks raamat\" - sisesta tekstivälja raamatu pealkiri, et näha infot raamatu kohta.\n" +
                "       \"Kuva ühe autori teosed\" - sisesta tekstivälja autor, et näha kõiki tema teoseid.\n" +
                "       \"Kuva üks riiul\" - sisesta tekstivälja riiuli tunnus, et näha kõiki sellel olevaid teoseid.\n" +
                "       \"Kuva kindel keel\" - näed raamatuid, mis on kirjutatud selles keeles, mille sisestad tekstivälja.\n" +
                "       \"Kuva kõik\" - näed kõiki raamatuid, mis koduraamatukogus on.\n" +
                "       \"Lisa raamat\" - see feature veel ei tööta, aga tulevikus peaks saama siit lisada uusi raamatuid uues aknas,   \n      mis kirjutatakse nii raamatute faili kui lisatakse raamatute listi.\n" +
                "       \"Abi\" - näed uuesti seda kasutusjuhendit.\n" +
                "       \"Lõpp\" - lõpeta programmi töö ja salvesta tegevused logifaili.\n\n" +
                "   Vasakpoolsesse veergu tekivad õnnestunud päringu korral raamatute pealkirjad.\n" +
                "   Et näha rohkem infot, kliki pealkirjal. Näed lisainfot (järjekorras autori perenimi, autori eesnimi, \n" +
                "       originaali avaldamise aasta, kirjastus, keel, lehekülgede arv, riiuli info,\n" +
                "       tõlkeraamatu puhul ka tõlke pealkiri, tõlkija nimi ja tõlke avaldamise aasta).\n\n" +
                "   NB! Palun pööra tähelepanu õigekirjale (sh suur ja väike algustäht), et otsingut ilusti toimiks.");
        Label tühiRuumKeskele = new Label("");
        Button okButton = new Button("Sain aru!");
        Label tühiRuumAllapoole = new Label("");

        // sündmuse lisamine nupule "sain aru"
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                kusimus.hide();
                peaLava.show();
                abiAvatud = false;
            }
        });
        // nupu paika sättimine
        FlowPane pane = new FlowPane(10, 10);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(okButton);
        // teksti ja nuppude gruppi paigutamine
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(tühiRuumÜlespoole, label, juhised, tühiRuumKeskele, pane, tühiRuumAllapoole);
        //stseeni loomine ja näitamine
        Scene stseen2 = new Scene(vBox);
        kusimus.setScene(stseen2);
        kusimus.show();

        // kui pannakse aken ristist kinni, siis saab aru, et enam pole aken lahti
        kusimus.setOnHiding(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                kusimus.hide();
                abiAvatud = false;
            }
        });
    }

    // kui akent tahetakse sulgeda, siis küsib kasutajalt, kas on kindel, et tahab seda teha
    private void väljumiseKontroll(Stage peaLava) throws AkenAvatudErind {
        if (lõppAvatud) throw new AkenAvatudErind("Oled juba alustanud programmi töö lõpetamist!");
        lõppAvatud = true;

        // luuakse teine lava
        Stage kusimus = new Stage();
        // küsimuse ja kahe nupu loomine
        Label label = new Label("Kas soovite koduraamatukogust väljuda?");
        Button okButton = new Button("Jah");
        Button cancelButton = new Button("Ei");
        // sündmuse lisamine nupule Jah
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try { salvestaLogi(); }
                catch (IOException e) { e.printStackTrace(); }
                kusimus.hide();
                peaLava.hide();
                lõppAvatud = false;
            }
        });
        // sündmuse lisamine nupule Ei
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                peaLava.show();
                kusimus.hide();
            }
        });
        // nuppude grupeerimine
        FlowPane pane = new FlowPane(10, 10);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(okButton, cancelButton);
        // küsimuse ja nuppude gruppi paigutamine
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label, pane);
        //stseeni loomine ja näitamine
        Scene stseen2 = new Scene(vBox);
        kusimus.setScene(stseen2);
        kusimus.show();

        // kui pannakse aken ristist kinni, siis saab aru, et enam pole aken lahti
        kusimus.setOnHiding(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                kusimus.hide();
                lõppAvatud = false;
            }
        });
    }

    // salvestaLogi() kirjutab kõik kasutaja tegevused logifaili, mida inimene hiljem saab lugeda
    // see sisuline (s.t mitte otseselt graafikaga seotud) meetod on siin, mitte peaklassis, sest tegevuse logi list on seotud selle klassiga.
    private void salvestaLogi() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("logifail.txt")))) {
            bw.write("Lõpetamise aeg: " + new java.sql.Timestamp(System.currentTimeMillis()) + "\n");
            for (String tegevus : tegevusteLogi) {
                bw.write(tegevus + "\n");
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

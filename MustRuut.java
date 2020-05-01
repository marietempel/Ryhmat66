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

    private static boolean kasTahetiSulgeda = false;
    // tegevuste logi muutuja sisu kirjutab programmi töö lõpetamisel tekstifaili,
    // töö käigus salvestab sinna kasutaja tegevuse
    private static List<String> tegevusteLogi = new ArrayList<>();

    @Override
    public void start(Stage peaLava) throws IOException {

        Peaklass.ettevalmistus(); // loeb andmed tekstifailidest

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

        // alumise rea kaks nuppu
        BorderPane alumisedNupud = new BorderPane();
        alumisedNupud.setMinWidth(510);
        Button nupp6 = new Button("Lisa raamat"); //ma arvan, et on ok, kui me ei jõua seda valmis
        Button nupp7 = new Button("Lõpp");
        alumisedNupud.setRight(nupp7);
        alumisedNupud.setLeft(nupp6);
        nupudListis.add(nupp6);
        nupudListis.add(nupp7);
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
        ObservableList<String> info = FXCollections.observableArrayList();
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
        peaLava.show();

        //////////////TEGEVUS//////////////

        Peaklass.ettevalmistus();

        for (Button nupp : nupudListis) {
            nupp.setOnMouseClicked(event -> {
                String nupuTekst = nupp.getText();
                if (nupuTekst.equals("Kuva üks raamat")) {
                    tekst.setText("Sisestage raamatu pealkiri");
                    tegevusteLogi.add("Pealkirja järgi raamat");
                    tekst.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            list1.setItems(Peaklass.kõikVastavadPealkirjad(newValue));
                        }
                    });
                } else if (nupuTekst.equals("Kuva ühe autori teosed")) {
                    tekst.setText("Sisestage autor (Perenimi)");
                    tegevusteLogi.add("Autori teosed");
                    tekst.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                           list1.setItems(Peaklass.üheAutoriKõikRaamatud(newValue));
                        }
                    });

                } else if (nupuTekst.equals("Kuva üks riiul")) {
                    tekst.setText("Sisestage riiuli tunnus");
                    tegevusteLogi.add("Riiuli teosed");
                    tekst.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            list1.setItems(Peaklass.üheRiiuliKõikRaamatud(newValue));
                        }
                    });
                } else if (nupuTekst.equals("Kuva kindel keel")) {
                    tekst.setText("Sisestage keel (eesti, inglise)");
                    tegevusteLogi.add("Ühes keeles kõik teosed");
                    tekst.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            list1.setItems(Peaklass.üheKeeleKõikRaamatud(newValue));
                        }
                    });
                } else if (nupuTekst.equals("Kuva kõik")) {
                    tekst.setText("Kuvan kõik raamatud.");
                    tegevusteLogi.add("Kõik raamatud");
                    list1.setItems(Peaklass.väljastaKõikRaamatud());
                } else if (nupuTekst.equals("Lõpp")) {
                    tegevusteLogi.add("Lõpp");
                    väljumiseKontroll(peaLava);
                } else if (nupuTekst.equals("Lisa raamat")) {
                    tekst.setText("See funktsionaalsus veel ei tööta!");
                }
            });

            list1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                    list2.setItems(Peaklass.infoPealkirjaJärgi(newValue));
                }
            });
        }
        peaLava.setOnHiding(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                if (!kasTahetiSulgeda) väljumiseKontroll(peaLava);
            }
        });
    }

        // kui akent tahetakse sulgeda, siis küsib kasutajalt, kas on kindel, et tahab seda teha
        private static void väljumiseKontroll (Stage peaLava){
            // luuakse teine lava
            Stage kusimus = new Stage();
            // küsimuse ja kahe nupu loomine
            Label label = new Label("Kas soovite koduraamatukogust väljuda?");
            Button okButton = new Button("Jah");
            Button cancelButton = new Button("Ei");
            // sündmuse lisamine nupule Jah
            okButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    kasTahetiSulgeda = true;
                    try {
                        salvestaLogi();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    kusimus.hide();
                    peaLava.hide();
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
        }

        private static void salvestaLogi () throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("logifail.txt")))) {
                bw.write("Lõpetamise aeg: " + new java.sql.Timestamp(System.currentTimeMillis()));
                for (String tegevus : tegevusteLogi) {
                    bw.write(tegevus + "\n");
                }
            }
        }


        public static void main (String[]args){
            launch(args);
        }
    }

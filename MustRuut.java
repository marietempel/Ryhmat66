package oop;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MustRuut extends Application {

    @Override
    public void start(Stage peaLava) {
        FlowPane flow = new FlowPane();

        Button nupp1 = new Button("Kuva üks raamat");
        Button nupp2 = new Button("Kuva ühe autori teoosed");
        Button nupp3 = new Button("Kuva üks riiul");
        Button nupp4 = new Button("Kuva kindel keel");
        Button nupp5 = new Button("Kuva kõik");
        flow.getChildren().add(nupp1);
        flow.getChildren().add(nupp2);
        flow.getChildren().add(nupp3);
        flow.getChildren().add(nupp4);
        flow.getChildren().add(nupp5);

        BorderPane alumisedNupud = new BorderPane();
        alumisedNupud.setMinWidth(510);
        Button nupp6 = new Button("Lisa raamat"); //ma arvan, et on ok, kui me ei jõua seda valmis
        Button nupp7 = new Button("Lõpp");
        alumisedNupud.setRight(nupp7);
        alumisedNupud.setLeft(nupp6);
        flow.getChildren().add(alumisedNupud);

        BorderPane tekstiVäli = new BorderPane();
        tekstiVäli.setMinWidth(510);
        TextField tekst = new TextField();
        tekst.setText("Sisestage tekst siia");
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
        peaLava.setScene(stseen1);
        peaLava.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

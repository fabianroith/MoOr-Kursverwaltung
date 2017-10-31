/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moor_kursverwaltung;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class MoOR_Kursverwaltung extends Application {

    @Override
    public void start(Stage hauptview) {
        hauptstageErstellen(hauptview);
    }

    public void hauptstageErstellen(Stage hauptstage) {
        hauptstage.setTitle("Kursverwaltung");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));

        Button btn_aufgabeErst = new Button("Neue Aufgabe erstellen");
        btn_aufgabeErst.setMaxWidth(Double.MAX_VALUE);
        btn_aufgabeErst.setPrefHeight(50);
        btn_aufgabeErst.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startstageErstellen(hauptstage);
            }
        });

        Button btn_aufgabesuchen = new Button("Aufgabe suchen");
        btn_aufgabesuchen.setMaxWidth(Double.MAX_VALUE);
        btn_aufgabesuchen.setPrefHeight(50);

        grid.add(btn_aufgabeErst, 0, 0);
        grid.add(btn_aufgabesuchen, 0, 1);

        Scene scene = new Scene(grid, 400, 200);
        hauptstage.setScene(scene);
//        showStage(hauptview);
        hauptstage.show();
    }

    public void startstageErstellen(Stage vorher) {
        vorher.hide();
        Stage startstage = new Stage();
        startstage.setTitle("Neue Aufgabe");
        startstage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                vorher.show();
            }
        });
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));

        Label l_datum = new Label("Datum:");
        grid.add(l_datum, 0, 0);

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        Label l_autoDatum = new Label(dateFormat.format(date));
        grid.add(l_autoDatum, 1, 0);

        Button btn_musterloesungLaden = new Button("Musterlösung laden");
        btn_musterloesungLaden.setPrefWidth(200);

        grid.add(btn_musterloesungLaden, 2, 0);

        Button btn_zusatzmatLaden = new Button("Zusatzmaterial laden");
        btn_zusatzmatLaden.setPrefWidth(200);
        grid.add(btn_zusatzmatLaden, 3, 0);

        Label l_autor = new Label("Autor:");
        grid.add(l_autor, 0, 1);

        TextField tf_autor = new TextField();
        tf_autor.setPrefWidth(300);
        grid.add(tf_autor, 1, 1);

        TableView tv_musterloesung = new TableView();
        tv_musterloesung.setPrefHeight(200);
        tv_musterloesung.setPrefWidth(200);
        TableColumn tc_m = new TableColumn("geladene Dateien");
        tc_m.prefWidthProperty().bind(tv_musterloesung.widthProperty());
        tc_m.setCellValueFactory(new PropertyValueFactory<MyFile, String>("filename"));
        tv_musterloesung.getColumns().setAll(tc_m);
        ObservableList<MyFile> ol_musterloesung = FXCollections.observableArrayList();
        tv_musterloesung.setItems(ol_musterloesung);
        grid.add(tv_musterloesung, 2, 1, 1, 7);

        TableView tv_zusatzmat = new TableView();
        tv_zusatzmat.setPrefHeight(200);
        tv_zusatzmat.setPrefWidth(200);
        TableColumn tc_z = new TableColumn("geladene Dateien");
        tc_z.prefWidthProperty().bind(tv_zusatzmat.widthProperty());
        tc_z.setCellValueFactory(new PropertyValueFactory<MyFile, String>("filename"));
        tv_zusatzmat.getColumns().setAll(tc_z);
        ObservableList<MyFile> ol_zusatzmat = FXCollections.observableArrayList();
        tv_zusatzmat.setItems(ol_zusatzmat);
        grid.add(tv_zusatzmat, 3, 1, 1, 7);

        Label l_thema = new Label("Thema:");
        grid.add(l_thema, 0, 2);

        TextField tf_thema = new TextField();
        tf_thema.setPrefWidth(300);
        grid.add(tf_thema, 1, 2);

        Label l_beschreibung = new Label("Beschreibung:");
        grid.add(l_beschreibung, 0, 3);

        TextArea ta_beschreibung = new TextArea();
        ta_beschreibung.setPrefWidth(300);
        grid.add(ta_beschreibung, 1, 3, 1, 5);

        Button btn_hashtagHinz = new Button("Tag hinzufügen");
        btn_hashtagHinz.setPrefWidth(180);
        grid.add(btn_hashtagHinz, 0, 8);

        TableView tv_gewaehlteHashtags = new TableView();
        tv_gewaehlteHashtags.setPrefHeight(200);
        tv_gewaehlteHashtags.setPrefWidth(500);
        TableColumn tc_h = new TableColumn("gesp. Hashtags");
        tc_h.setCellValueFactory(new PropertyValueFactory<Hashtag, String>("tag"));
        tc_h.prefWidthProperty().bind(tv_gewaehlteHashtags.widthProperty());
        tv_gewaehlteHashtags.getColumns().addAll(tc_h);
        ObservableList<Hashtag> ol_gewaehlteHashtags = FXCollections.observableArrayList();
        tv_gewaehlteHashtags.setItems(ol_gewaehlteHashtags);
        grid.add(tv_gewaehlteHashtags, 1, 8, 1, 6);

        Button btn_neuerHashtag = new Button("Neuen Tag erstellen");
        btn_neuerHashtag.setPrefWidth(180);
        grid.add(btn_neuerHashtag, 0, 9);

        Button btn_aufgSpeichern = new Button("Neue Aufgabe speichern & erstellen");
        btn_aufgSpeichern.setPrefWidth(startstage.getMaxWidth());
        grid.add(btn_aufgSpeichern, 0, 14, 4, 1);

        btn_musterloesungLaden.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File file = openFileChooser(startstage);
                if (file != null) {

                    ol_musterloesung.add(new MyFile(file));
                }
            }
        });

        tv_musterloesung.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MyFile chosen_file = (MyFile) tv_musterloesung.getSelectionModel().getSelectedItem();
                if (chosen_file != null) {
                    int option = JOptionPane.showConfirmDialog(null, "Wollen Sie das File \"" + chosen_file.getFilename() + "\" wirklich aus der Liste löschen?", "File löschen", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (option == 0) {
                        for (int i = 0; i < ol_musterloesung.size(); i++) {
                            if (ol_musterloesung.get(i).getFilename() == chosen_file.getFilename()) {
                                ol_musterloesung.remove(i);
                                break;
                            }
                        }
                    } else if (option == 1) {

                    } else if (option == -1) {

                    }
                }
            }
        });

        btn_zusatzmatLaden.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File file = openFileChooser(startstage);
                if (file != null) {
                    ol_zusatzmat.add(new MyFile(file));
                }
            }
        });

        tv_zusatzmat.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MyFile chosen_file = (MyFile) tv_zusatzmat.getSelectionModel().getSelectedItem();
                if (chosen_file != null) {
                    int option = JOptionPane.showConfirmDialog(null, "Wollen Sie das File \"" + chosen_file.getFilename() + "\" wirklich aus der Liste löschen?", "File löschen", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (option == 0) {
                        for (int i = 0; i < ol_zusatzmat.size(); i++) {
                            if (ol_zusatzmat.get(i).getFilename() == chosen_file.getFilename()) {
                                ol_zusatzmat.remove(i);
                                break;
                            }
                        }
                    } else if (option == 1) {

                    } else if (option == -1) {

                    }
                }
            }
        });

        btn_hashtagHinz.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tagHinzufuegenStageErstellen(startstage, ol_gewaehlteHashtags);
            }
        });

        tv_gewaehlteHashtags.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Hashtag chosen_htg = (Hashtag) tv_gewaehlteHashtags.getSelectionModel().getSelectedItem();
                if (chosen_htg != null) {
                    int option = JOptionPane.showConfirmDialog(null, "Wollen Sie den Hashtag \"" + chosen_htg.getTag() + "\" wirklich aus der Liste löschen?", "Hashtag löschen", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (option == 0) {
                        for (int i = 0; i < ol_gewaehlteHashtags.size(); i++) {
                            if (ol_gewaehlteHashtags.get(i).getTag() == chosen_htg.getTag()) {
                                ol_gewaehlteHashtags.remove(i);
                                break;
                            }
                        }
                    } else if (option == 1) {

                    } else if (option == -1) {

                    }
                }
            }
        });

        btn_aufgSpeichern.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Date d = dateFormat.parse(l_autoDatum.getText());
                    Aufgabe aufgabe = new Aufgabe(d, tf_autor.getText(), tf_thema.getText(), ta_beschreibung.getText());
                    for(int i = 0;i<ol_gewaehlteHashtags.size();i++){
                        aufgabe.addHashtag(ol_gewaehlteHashtags.get(i));
                    }
                    for(int i = 0;i<ol_musterloesung.size();i++){
                        aufgabe.addMusterloesung(ol_musterloesung.get(i));
                    }
                    for(int i = 0;i<ol_zusatzmat.size();i++){
                        aufgabe.addZusatzmaterial(ol_zusatzmat.get(i));
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(MoOR_Kursverwaltung.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Scene scene = new Scene(grid, 1150, 600);
        startstage.setScene(scene);
        startstage.show();
    }

    public File openFileChooser(Stage vorher) {
        Stage fileChooserStage = new Stage();
        fileChooserStage.setTitle("Datei wählen");
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(vorher);

        return file;
    }

    public void tagHinzufuegenStageErstellen(Stage vorher, ObservableList<Hashtag> ol) {
        Stage tagHinzufuegenStage = new Stage();
        tagHinzufuegenStage.setTitle("Tag wählen");
        TableView tv_allHashtags = new TableView();
        tv_allHashtags.getSelectionModel().setCellSelectionEnabled(true);
        TableColumn tc_h = new TableColumn("alle Hashtags");
        tc_h.setCellValueFactory(new PropertyValueFactory<Hashtag, String>("tag"));
        tc_h.prefWidthProperty().bind(tv_allHashtags.widthProperty());
        tv_allHashtags.getColumns().addAll(tc_h);
        ObservableList<Hashtag> ol_hashtags = FXCollections.observableArrayList();
        ol_hashtags.add(new Hashtag("#htg1"));
        ol_hashtags.add(new Hashtag("#htg2"));
        tv_allHashtags.setItems(ol_hashtags);

        StackPane sp = new StackPane();
        sp.getChildren().add(tv_allHashtags);

        tv_allHashtags.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Hashtag chosen_tag = (Hashtag) tv_allHashtags.getSelectionModel().getSelectedItem();
                if (chosen_tag != null) {
                    ol.add(chosen_tag);
                    tagHinzufuegenStage.close();
                }
            }
        });

        Scene scene = new Scene(sp, 500, 500);
        tagHinzufuegenStage.setScene(scene);
        tagHinzufuegenStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

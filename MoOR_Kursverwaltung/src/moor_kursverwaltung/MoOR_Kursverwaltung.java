/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moor_kursverwaltung;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class MoOR_Kursverwaltung extends Application {
    
    @Override
    public void start(Stage hauptview) {
        hauptviewErstellen(hauptview);
    }
    
    public void hauptviewErstellen(Stage hauptview){
        hauptview.setTitle("Kursverwaltung");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));
        
        Button btn_aufgabeErst = new Button("neue Aufgabe erstellen");
        btn_aufgabeErst.setMaxWidth(Double.MAX_VALUE);
        btn_aufgabeErst.setPrefHeight(50);
        Button btn_aufgabesuchen = new Button("Aufgabe suchen");
        btn_aufgabesuchen.setMaxWidth(Double.MAX_VALUE);
        btn_aufgabesuchen.setPrefHeight(50);
        
        grid.add(btn_aufgabeErst, 0, 0);
        grid.add(btn_aufgabesuchen, 0, 1);
        
        Scene scene = new Scene(grid,300,200);
        hauptview.setScene(scene);
        showStage(hauptview);
    }
    
    public void showStage(Stage stage){
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

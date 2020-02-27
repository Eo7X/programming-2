/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oreizy.everest.analysiseo;

import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author eoreizy
 */
public class Analysis extends Application {

    @Override
    public void start(Stage stage){
        System.out.println("nope.");
    }
    
    public void start(Stage stage, TextAnalyzer a) throws Exception {
        
        stage.setTitle(a.getTitle() + " - TextAnalyzer");
        
        Label welcome = new Label("Analyzing \"" + a.getTitle() + "\"");
        welcome.setFont(new Font(20));
                
        PieChart regChart = makePieChart(a.getTop10Tuples(), "Most Frequent Words");
        PieChart secChart = makePieChart(a.getTop10TuplesAll(), "Most Frequent Words Including [*]");
        
        HBox chartContainer = new HBox();
        chartContainer.getChildren().addAll(regChart, secChart);
        chartContainer.setSpacing(10);
        
        Button goAgain = new Button("New Analysis (New Window)");
        goAgain.setOnAction((none) -> {
            try {
                new App().start(new Stage());
            } catch (IOException ex) {
            }
        });
        
        Button closeAndGoAgain = new Button("Close Window and New Analysis");
        closeAndGoAgain.setOnAction((none) -> {
            try {
                stage.hide();
                new App().start(new Stage());
            } catch (IOException ex) {
            }
        });
        
        Button closeWindow = new Button("Close Program");
        closeWindow.setOnAction((none) -> {
            System.exit(0);
        });
        
        HBox buttons = new HBox();
        buttons.getChildren().addAll(closeAndGoAgain, goAgain,  closeWindow);
        
        VBox menu = new VBox();
        menu.getChildren().addAll(welcome, chartContainer, buttons);
        menu.setSpacing(10);
        menu.setPadding(new Insets(15,15,15,15));
        
        StackPane root = new StackPane();
        root.getChildren().addAll(menu);

        Scene scene = new Scene(root, 800, 480);

        stage.setScene(scene);

        stage.show();
        
    }
    
    public static PieChart makePieChart(ArrayList<Tuple> arraylist, String title){
        ObservableList<PieChart.Data> regChartData = 
                FXCollections.observableArrayList();
        
        for (Tuple t : arraylist){
            regChartData.add(new PieChart.Data(t.word, t.count));
        }
        
        PieChart chart = new PieChart(regChartData);
        chart.setTitle(title);
        
        return chart;
    }

}

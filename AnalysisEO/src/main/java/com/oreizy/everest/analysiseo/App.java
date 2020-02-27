package com.oreizy.everest.analysiseo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    //I use these variables to remember user inputs so that when they click the "Analyze" button it works whatever file/method they choose
    Label filename;
    Label useless;
    
    TextField docTitle;
    
    File f1;
    File f2;
    InputStream f3;
    
    //use this to remember if the user wants an external, internal, or no file of useless words
    String uselessType;
    
    
    
    @Override
    public void start(Stage stage) throws FileNotFoundException, IOException {
                
        stage.setTitle("TextAnalyzer");
        
        Label title = new Label("Welcome to TextAnalyzer by EO");
        title.setFont(new Font(30));
        
        Button chooseFile = new Button("Choose file to analyze");
        chooseFile.setOnAction((none) -> {
            //open file dialog box and save file to var
            this.f1 = getFile("Choose file to analyze", stage);
            this.filename.setText(this.f1.getPath());
            docTitle.setText(this.f1.getName());
            
        });
        
        filename = new Label("Please choose a file");
        
        Button chooseUseless = new Button("Choose file of filter words");
        chooseUseless.setOnAction((none) -> {
            //open file dialog box and save file to var
            this.f2 = getFile("Choose file of filter words", stage);
            this.useless.setText(this.f2.getPath());
            this.uselessType = "ext";
        });
        
        useless = new Label("Please choose a file");
        
        Button noUseless = new Button("I don't want to filter words");
        noUseless.setOnAction((none) -> {
            //remember that the user doesn't want to filter words. this will be passed to the TextAnalyzer object.
            this.uselessType = "emp";
            this.useless.setText("Not filtering words");
        });
        
        Button ourUseless = new Button("Use system list of filter words");
        ourUseless.setOnAction((none) -> {
            //remember that the user wants to use the system useless.txt of words. this will be passed to the TextAnalyzer object.
            this.uselessType = "sys";
            this.useless.setText("Using system list");
        });
        
        
        Label docTitleL = new Label("Document Title:");
        docTitleL.setFont(new Font(15));
        
        docTitle = new TextField("My Document");
        
        Button go = new Button("Analyze");
        go.setOnAction((none) -> {
            //when the user clicks the magic button, create a new TextAnalyzer object, fill it, and feed it into the Analysis.java application.
            TextAnalyzer a;
            try {
                a = new TextAnalyzer(f1, f2, this.uselessType, docTitle.getText());
                stage.hide();
                new Analysis().start(new Stage(), a);
            } catch (IOException ex) {
            } catch (Exception ex) {
            }
        });
        
        //Organize and do UI layout with various HBoxes stacked ini a VBox
        HBox chooseFileContainer = new HBox();
        chooseFileContainer.getChildren().addAll(chooseFile, filename);
        chooseFileContainer.setSpacing(10);
        
        HBox chooseUselessContainer = new HBox();
        chooseUselessContainer.getChildren().addAll(chooseUseless, useless);
        chooseUselessContainer.setSpacing(10);
        
        HBox docTitleContainer = new HBox();
        docTitleContainer.getChildren().addAll(docTitleL, docTitle);
        docTitleContainer.setSpacing(20);
        
        HBox filteringContainer = new HBox();
        filteringContainer.getChildren().addAll(ourUseless, noUseless);
        filteringContainer.setSpacing(10);
        
        VBox container = new VBox();
        container.getChildren().addAll(title, chooseFileContainer, chooseUselessContainer, filteringContainer, docTitleContainer, go); 
        container.setSpacing(10);
        container.setPadding(new Insets(15,15,15,15));
        
        //Organize in root StackPane and display
        StackPane root = new StackPane();
        root.getChildren().addAll(container);

        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        
        stage.show();
        

    }

    public static void main(String[] args) {
        launch();
        
    }
    //code sourced from tutorial linked in Mr. Mein's assignment or at https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm
    public static File getFile(String title, Stage stage){
        //open a file dialog and return the file the user selects.
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text files (.txt)", "*.txt")
        );
        File file = fileChooser.showOpenDialog(stage);
        
        return file;
    }
    
}
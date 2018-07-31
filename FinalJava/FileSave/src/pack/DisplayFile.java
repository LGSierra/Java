package pack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.sun.javafx.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

//************************************************************************
//  DisplayFile.java       Author: Lewis/Loftus
//
//  Demonstrates the use of a file chooser dialog box and a text area.
//************************************************************************

public class DisplayFile extends Application
{
    //--------------------------------------------------------------------
    //  Presents a file chooser dialog, reads the selected file and
    //  loads it into a text area.
    //--------------------------------------------------------------------
	public FileChooser chooser = new FileChooser();
	public Button save = new Button("save");
	public TextArea content = new TextArea();
	public 	File file;
	
    public void start(Stage primaryStage) throws IOException
    {
        
    	
    	FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            chooser.getExtensionFilters().add(extFilter);
            
        File selectedFile = chooser.showOpenDialog(primaryStage);
        selectedFile.setWritable(true);
        
        content.setFont(new Font("Courier", 12));
        content.setEditable(true);
        
        
        FlowPane pane = new FlowPane(content, save);
        pane.setAlignment(Pos.CENTER);
        
        
        
        
        if (selectedFile == null)
            content.setText("No file chosen.");
        else
        {
            Scanner scan = new Scanner(selectedFile);
            
            String info = "";
            
            while (scan.hasNext())
                info += scan.nextLine() + "\n";
            
            content.setText(info);
           // content.onKeyTypedProperty().getValue();
            
            
            save.setOnAction((ActionEvent event)->{
             file= chooser.showSaveDialog(primaryStage);
             
             if(file!=null) {
            	 content.setText(content.getText());
            	 SaveFile(content.getText(), selectedFile);
             }
             
            });
           
        }
        
        Scene scene = new Scene(pane, 500, 700);
        
        primaryStage.setTitle("Display File");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
   
    private void SaveFile(String text, File selectedFile) {
		// TODO Auto-generated method stub
    	
    	try {
            FileWriter fileWriter;
              
            fileWriter = new FileWriter(file);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException ex) {
        	
        	System.out.println("Exception has occurred");
           // Logger.getLogger(JavaFXSaveText.class
           //     .getName()).log(Level.SEVERE, null, ex);
        }
		
	}
    
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    
    
}
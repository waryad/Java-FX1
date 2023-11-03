/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication4;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import java.util.HashMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
/**
 *
 * @author owner
 */
public class JavaFXApplication4 extends Application {
    
  public void start(Stage stage) throws Exception
    {
        GridPane                    pane            = new GridPane();
        ComboBox<String>            comboBox        = new ComboBox<>();
        Label                       idLabel         = new Label("ID:");
        TextField                   idTextFd        = new TextField();
        Label                       gpaLabel        = new Label("GPA:");
        TextField                   gpaTextFd       = new TextField();
        CheckBox                    editCBox        = new CheckBox("Edit");
        HashMap<String, Student>    students        = new HashMap<> ();
        Button                      deleteButton    = new Button("Delete Student");
        Button                      updateButton    = new Button("Update Database");
        Button                      addButton       = new Button("Add/Modify");
        Button                      saveButton      = new Button("Save Database");

        comboBox     .setPrefWidth(150);
        idLabel      .setPrefWidth( 50);
        idTextFd     .setPrefWidth( 50);
        gpaLabel     .setPrefWidth( 50);
        gpaTextFd    .setPrefWidth( 50);
        editCBox     .setPrefWidth(150);
        deleteButton .setPrefWidth(150);
        updateButton .setPrefWidth(150);
        addButton    .setPrefWidth(150);
        saveButton   .setPrefWidth(150);

        pane.setPadding(new Insets(20,20,20,20));
        pane.setHgap(20);
        pane.setVgap(20);

        Student jose      = new Student("Jose"   , 99, 4.9);
        Student william        = new Student("William"     , 98, 3.9);
        Student david          = new Student("David"       , 97, 3.2);

        students.put("Jose"  , jose);
        students.put("William"    , william  );
        students.put("David"      , david    );

        comboBox.getItems().addAll(students.keySet());

        //ComboBox Set 
        comboBox.setOnAction
        (
            e ->
            {
                String name = comboBox.getValue();
                if(null == name)
                {
                    return;
                }

                if(false == students.keySet().contains(name))
                {
                    return;
                }

                idTextFd .setText("" + students.get(name).id);
                gpaTextFd.setText("" + students.get(name).gpa);
                System.out.println("OK");
            }
        );
       
        //EditBox
        editCBox.setOnAction
        (
            e ->
            {
                boolean checked = editCBox.isSelected();
                if(checked)
                {
                    comboBox.setEditable(true);
                    addButton.setDisable(false); //enable it      
                }
                else
                {
                    comboBox.setEditable(false);
                    addButton.setDisable(true);// disable it
                }
            }
        );

        //AddButton
        addButton.setOnAction
        (
            e ->
            {
                String name = comboBox.getValue();

                if(students.keySet().contains(name))
                {
                    students.remove(name);
                }

                int     id      = Integer.valueOf(idTextFd.getText());
                double  gpa     = Double.valueOf(gpaTextFd.getText());
                Student student = new Student(name, id, gpa);

                students.put(name, student);

                comboBox.getItems().clear();
                comboBox.getItems().addAll(students.keySet());

                System.out.println(name + " " + id + " " + gpa);

            }
        );
        
        //deleteButton
        deleteButton.setOnAction
        (
            e ->
            {
                String name = comboBox.getValue();

                if(students.keySet().contains(name))
                {
                    students.remove(name);
                }

                comboBox.getItems().clear();
                comboBox.getItems().addAll(students.keySet());
            }
        );
         //saveButton
        saveButton.setOnAction
        (

            e ->
 
            {
                try 
                {
                   
                    File                    md     = new File("C:\\Users\\owner\\Desktop\\deep.bin");
                    FileOutputStream        stream = new FileOutputStream(md);
                    ObjectOutputStream      output = new ObjectOutputStream(stream);     
                    output.writeObject(students);  
                    output.close();
                    stream.close();  
                }
            
                catch(Exception pf)   
            
                {
                     
                }
           
            }
  
        );
        //UpdateButton
         updateButton.setOnAction 
        (

             e ->
 
            { 
                try
                {
      
                    File                    md      = new File("C:\\Users\\owner\\Desktop\\deep.bin");
                    FileInputStream         stream  = new FileInputStream(md);
                    ObjectInputStream       input   = new ObjectInputStream(stream);
      
                    for(String name: students.keySet())
                        {
                            Student student = students.get(name);
                            System.out.printf("%-16s by %-15s released %-16s\n", student.name, student.id, student.gpa);
                        }

                    input.close();
                    stream.close();
                      
                }
                catch(Exception df)   
                {
                     
                }
            }     
        );
        
        //StageShow
        stage.setOnShown
        (


             e ->
 
            { 
                try
                {
      
                    File                    md      = new File("C:\\Users\\owner\\Desktop\\deep.bin");
                    FileInputStream         stream  = new FileInputStream(md);
                    ObjectInputStream       input   = new ObjectInputStream(stream);
                
                    for(String name: students.keySet())
                    {
                        Student student = students.get(name);
                        System.out.printf("%-16s by %-15s released %-16s\n", student.name, student.id, student.gpa);
                    }

                    input.close();
                    stream.close();
      
            }
                catch(Exception df)   
            
                {
                     
                }
            }     
        );

        //StageClose
         stage.setOnCloseRequest
        (

            e ->
 
            {
                try 
                {         
                    File                    md     = new File("C:\\Users\\owner\\Desktop\\deep.bin");
                    FileOutputStream        stream = new FileOutputStream(md);
                    ObjectOutputStream      output = new ObjectOutputStream(stream);     
                    output.writeObject(students);  
                    output.close();
                    stream.close();      
                
                }
            
                catch(Exception gf)   
            
                {
                     
                }        
            }
        );


        pane.add(comboBox       ,       0, 0);
        pane.add(idLabel        ,       2, 0);
        pane.add(idTextFd       ,       3, 0);
        pane.add(gpaLabel       ,       2, 1);
        pane.add(gpaTextFd      ,       3, 1);
        pane.add(editCBox       ,       0, 2);
        pane.add(deleteButton   ,       0, 3);
        pane.add(updateButton   ,       1, 3);
        pane.add(addButton      ,       2, 3);
        pane.add(saveButton     ,       3, 3);
            
        Scene scene = new Scene(pane, 700, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}
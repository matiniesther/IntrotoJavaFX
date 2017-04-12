package smartrestuarant4;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

//The checklist for this assigment:
//1. Make a folder that has the resources and the images(CHECK)
//2. Use only one pane and when the action is invoked, reset everything to a new open
//3. Read 4 lines from the code and then after 4 lines, store the information in an array
//4. Set the X and Y components of the images to be able to fit the whole image

/**
 *
 * @author csc190
 */
public class SmartRestuarant4 extends Application {
    
    
    //works with changing the scenes
    Button btnScene1_2, btnScene1_3,btnScene1_4, btnScene2_1,btnScene2_3,btnScene2_4, btnScene3_1, btnScene3_2, btnScene3_4,btnScene4_1,btnScene4_2,btnScene4_3;
    Label label, label1, label2, label3, label4,label5,label6, label7;
    GridPane pane, pane1, pane2, pane3;
    Scene scene, scene1, scene2, scene3;
    Stage thestage;
   
    
    //works on inserting the images
    private ImageView Chocolate;
    private ImageView popcorn;
    private ImageView Steak;
    private ImageView carrotcake;
    
           
  
    @Override
    //stage is the top level container
    public void start(Stage primaryStage) {{
        try{
            //setting the stage so that we can call in out action handler
            thestage = primaryStage;
            
            //instantiating the labels for each scene
            label = new Label();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            label6 = new Label();
            label7 = new Label();
            
            //setting the buttons for the different scenes
            btnScene1_2 = new Button("< Previous");
            btnScene1_3 = new Button("Next >");
            btnScene1_4 = new Button("< Previous");
            btnScene2_1 = new Button("Next >");
            btnScene2_3 = new Button("< Previous");
            btnScene2_4 = new Button("Next >");
            btnScene3_1 = new Button("< Previous");
            btnScene3_2 = new Button("Next >");
            btnScene3_4 = new Button("< Previous");
            btnScene4_1 = new Button("Next >");
            btnScene4_2 = new Button("< Previous");
            btnScene4_3 = new Button("Next >");
            
            //setting all the actions for the buttons
            //button1_2 and 1_3 is for pane 1: Steak, scene
            //button2_1 and 2_3 are for pane 2: Chocolate, scene1
            //button3_1 and 3_2 are for pane 3: popcorn, scene2
            //button4_1 and 4_2 are for pane 4: carrot cane, scene3
            btnScene1_2.setOnAction(e -> thestage.setScene(scene1));
            btnScene1_3.setOnAction(e -> thestage.setScene(scene3));
            btnScene2_1.setOnAction(e -> thestage.setScene(scene2));
            btnScene2_3.setOnAction(e -> thestage.setScene(scene3));
            btnScene3_1.setOnAction(e -> thestage.setScene(scene1));
            btnScene3_2.setOnAction(e -> thestage.setScene(scene));
            btnScene4_1.setOnAction(e -> thestage.setScene(scene1));
            btnScene4_2.setOnAction(e -> thestage.setScene(scene));
            
            
            
           //getting the resources from the text file
            InputStream in = getClass().getResourceAsStream("resources/config.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            ArrayList<String> list = new ArrayList<String>();
            String[] tokens;
            for(String line= reader.readLine(); line != null; line= reader.readLine()){
                if(line.contains("Image:") || line.contains("Name:")){
                    continue;
                }
                tokens = line.split(":");
                list.add(tokens[1]);                
            }

            
            //putting the images from the resources
            Chocolate= new ImageView(new Image(SmartRestuarant4.class.getResourceAsStream("images/Chocolate.jpg")));
            popcorn= new ImageView(new Image(SmartRestuarant4.class.getResourceAsStream("images/popcorn.jpg")));
            Steak= new ImageView(new Image(SmartRestuarant4.class.getResourceAsStream("images/Steak.jpg")));
            carrotcake= new ImageView(new Image(SmartRestuarant4.class.getResourceAsStream("images/carrotcake.jpg")));
            
            //setting the image of the food to fit the plane
            popcorn.setFitHeight(250);
            popcorn.setFitWidth(300);
            Chocolate.setFitHeight(250);
            Chocolate.setFitWidth(300);
            carrotcake.setFitHeight(250);
            carrotcake.setFitWidth(300);
            Steak.setFitHeight(250);
            Steak.setFitWidth(300);
            
            //fitting the label with the contents stored in the array
            label.setText(list.get(0));
            label1.setText("Price: " + list.get(1));
            label2.setText(list.get(2));
            label3.setText("Price: " + list.get(3));
            label4.setText(list.get(4));
            label5.setText("Price: " + list.get(5));
            label6.setText(list.get(6));
            label7.setText("Price: " + list.get(7));
               
            
            //setting up all the gridPanes
            pane= new GridPane();
            pane1 = new GridPane();
            pane2 = new GridPane();
            pane3 = new GridPane();
               
            //setting the constraints of the label in the pane and the buttons      
            GridPane.setConstraints(label, 2, 0);
            GridPane.setConstraints(label1, 2,1);
            GridPane.setConstraints(label2, 2, 0);
            GridPane.setConstraints(label3, 2,1);
            GridPane.setConstraints(label4, 2, 0);
            GridPane.setConstraints(label5, 2,1);
            GridPane.setConstraints(label6, 2, 0);
            GridPane.setConstraints(label7, 2,1);
            
            GridPane.setHalignment(btnScene1_2, HPos.LEFT);
            GridPane.setConstraints(btnScene1_2, 0, 2);
            GridPane.setHalignment(btnScene1_3, HPos.RIGHT);
            GridPane.setConstraints(btnScene1_3, 2,2);
            GridPane.setHalignment(btnScene1_4, HPos.LEFT);
            GridPane.setConstraints(btnScene1_4, 0,2);
            GridPane.setHalignment(btnScene2_1, HPos.RIGHT);
            GridPane.setConstraints(btnScene2_1, 2,2);
            GridPane.setHalignment(btnScene2_3, HPos.LEFT);
            GridPane.setConstraints(btnScene2_3, 0,2);
            GridPane.setHalignment(btnScene2_4, HPos.RIGHT);
            GridPane.setConstraints(btnScene2_4, 2,2);
            GridPane.setHalignment(btnScene3_1, HPos.LEFT);
            GridPane.setConstraints(btnScene3_1, 0,2);
            GridPane.setHalignment(btnScene3_2, HPos.RIGHT);
            GridPane.setConstraints(btnScene3_2, 2,2);
            GridPane.setHalignment(btnScene3_4, HPos.LEFT);
            GridPane.setConstraints(btnScene3_4, 0,2);
            GridPane.setHalignment(btnScene4_1, HPos.RIGHT);
            GridPane.setConstraints(btnScene4_1, 2,2);
            GridPane.setHalignment(btnScene4_2, HPos.LEFT);
            GridPane.setConstraints(btnScene4_2, 0,2);
            GridPane.setHalignment(btnScene4_3, HPos.RIGHT);
            GridPane.setConstraints(btnScene4_3, 2,2);
            
               
            //setting the contents of each pane
            pane.getChildren().addAll(btnScene1_2,  label, label1, btnScene1_3, Steak);
            pane1.getChildren().addAll(btnScene2_1, label5, label4, btnScene2_3, Chocolate);
            pane2.getChildren().addAll(btnScene3_1, btnScene3_2, label2, label3, popcorn);
            pane3.getChildren().addAll(btnScene4_1, btnScene4_2, label6, label7, carrotcake);
               
            //setting the scenes   
            primaryStage.setTitle("Smart Restuarant");            
            scene = new Scene(pane, 500, 300);
            scene1 = new Scene(pane1, 500, 300);
            scene2 = new Scene(pane2, 500, 300);
            scene3 = new Scene(pane3, 500, 300);
            primaryStage.setScene(scene);
            primaryStage.show();
               
        }
        catch(Exception e) {
            System.err.println("Error: Target file cannot be read");
        }
       
        
    }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

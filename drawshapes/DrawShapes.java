package drawshapes;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/**
 *
 * @author hannah.goett
 * 11/20/2014
 */
public class DrawShapes extends Application {
    /**
     * @param color -- the color the file set
     * @return the color the file had
     * @throws Exception 
     */
    public static Color getColor(String color) throws Exception{
        if(color.equalsIgnoreCase("Blue")){
            return Color.BLUE;
        }else if(color.equalsIgnoreCase("Red")){
            return Color.RED;
        }else if(color.equalsIgnoreCase("Green")){
            return Color.GREEN;
        }else if(color.equalsIgnoreCase("Black")){
            return Color.BLACK;
        }else if(color.equalsIgnoreCase("None")){
            return null;
        }else{
            throw new Exception("Incorrect Color.");
        }
    }

    public void start(Stage primaryStage) {
        try{     
            Scanner input = new Scanner(new File("drawings/drawing.txt"));
 
            int paneWidth = input.nextInt();
            int paneHeight = input.nextInt();
            input.nextLine();
            
            String circle = input.next();
            int circleX = input.nextInt();
            int circleY = input.nextInt();
            int radius = input.nextInt();
            String colorOutLine = input.next();
            String colorFill = input.next();
            input.nextLine();
            
            String rectangle1 = input.next();
            int rectangleX = input.nextInt();
            int rectangleY = input.nextInt();
            int rectangleWidth = input.nextInt();
            int rectangleHeight = input.nextInt();
            String recOutline = input.next();
            String recFill = input.next();
            input.nextLine();
            
            String rectangle2 = input.next();
            int rectangle2X = input.nextInt();
            int rectangle2Y = input.nextInt();
            int rectangle2Width = input.nextInt();
            int rectangle2Height = input.nextInt();
            String rec2Outline = input.next();
            String rec2Fill = input.next();
            input.nextLine();
            
            String ln = input.next();
            int startX = input.nextInt();
            int startY = input.nextInt();
            int endX = input.nextInt();
            int endY = input.nextInt();
            String color = input.next();
            input.nextLine();
            
            Circle circ = new Circle();
            circ.setCenterX(circleX);
            circ.setCenterY(circleY);
            circ.setRadius(radius);
            circ.setStroke(getColor(colorOutLine));
            circ.setFill(getColor(colorFill));
            
            Rectangle rec1 = new Rectangle();
            rec1.setX(rectangleX);
            rec1.setY(rectangleY);
            rec1.setWidth(rectangleWidth);
            rec1.setHeight(rectangleHeight);
            rec1.setStroke(getColor(recOutline));
            rec1.setFill(getColor(recFill));
            
            Rectangle rec2 = new Rectangle();
            rec2.setX(rectangle2X);
            rec2.setY(rectangle2Y);
            rec2.setWidth(rectangle2Width);
            rec2.setHeight(rectangle2Height);
            rec2.setStroke(getColor(rec2Outline));
            rec2.setFill(getColor(rec2Fill));
            
            Line line = new Line();
            line.setStartX(startX);
            line.setStartY(startY);
            line.setEndX(endX);
            line.setEndY(endY);
            line.setStroke(getColor(color));
            
            // Create pane to hold the shapes
            Pane pane = new Pane();
            pane.getChildren().add(circ);
            pane.getChildren().add(rec1);
            pane.getChildren().add(rec2);
            pane.getChildren().add(line);
          
            Scene scene = new Scene(pane, paneWidth,paneHeight);
            primaryStage.setTitle("Show Drawings");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        }catch(IOException ioe) {
            System.err.println("Could not open file. Exiting now.");
            System.exit(1);   
        }catch(InputMismatchException ime){
            System.err.println("The input does not match");
            System.exit(1);
            
        }catch(Exception e){
            System.exit(1);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
        
    }
    
}

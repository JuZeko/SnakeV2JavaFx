package sample;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

import java.util.Timer;
import java.util.TimerTask;


public class Menu extends Application {

    final Timeline timeline = new Timeline();

    Snake snake = new Snake();

    private GridPane Grid = new GridPane(); //Layout

    private Label label = new Label();      // Label
    
    private int height = 600; private int width = 600;  private int pixel = 30;

    int score = 0;

    food f = new food();



    @Override
    public void start(Stage Stage) throws Exception {

        Stage.setTitle("SNAKE YOUR SCORE IS " + score);

        Scene scene = new Scene(Grid, width, height); // Add Layout to scene

        FillingLayoutWithLabels(width,height);

        addTetrominoes();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        snake.changeDirection("up"); break;

                    case LEFT:

                        snake.changeDirection("left");break;

                    case RIGHT:

                        snake.changeDirection("right");break;

                    case DOWN:
                        snake.changeDirection("down");
                        break;
                }
            }
        });

        Stage.setScene(scene);

        Stage.show();

        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(0.2), new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {

                try {

                    doSomething();

                    ((Label) getNodeFromGridPane(Grid, f.getY() , f.getX())).setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

                    if(snake.cordinates.get(snake.cordinates.size() - 1).getX() == f.getY() && snake.cordinates.get(snake.cordinates.size() - 1).getY() == f.getX()){

                        f.random();

                        snake.add();

                        score ++;

                        Stage.setTitle("SNAKE YOUR SCORE IS " + score);

                    }

                   if(snake.check() == true){



                       Stage.close();

                   }

                }
                catch (Exception e){

                Stage.close();
                    System.out.println("Your score " + score);

                }

            }

        }));

        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);

        fiveSecondsWonder.play();

    }



    private void doSomething() {

        int x = snake.cordinates.get(0).getX();
        int y = snake.cordinates.get(0).getY();

        snake.moveSnake();

        for (int i = 0; i < snake.cordinates.size(); i++) {


            ((Label) getNodeFromGridPane(Grid, snake.cordinates.get(i).x, snake.cordinates.get(i).y)).setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        }

        ((Label) getNodeFromGridPane(Grid, x , y)).setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));







    }

    private void addTetrominoes() {


        for(int i = 0;i<snake.cordinates.size();i++){

            ((Label) getNodeFromGridPane(Grid,snake.cordinates.get(i).x, snake.cordinates.get(i).y)).setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        }

    }



    private void FillingLayoutWithLabels(int width, int height) {

        for(int i = 0;i< width/pixel ;i++){

            for(int j = 0;j<height/pixel ; j++){

                addLabel(i,j);

            }
        }
    }

    public void addLabel(int columnIndex, int rowIndex) {

        Label label = new Label();
        
        label.setMinWidth(pixel);

        label.setMinHeight(pixel);

        label.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

        Grid.setColumnIndex(label, columnIndex);

        Grid.setRowIndex(label, rowIndex);

        label.setId(rowIndex+ " " + columnIndex);

        Grid.getChildren().add(label);
    }


    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {

        for (Node node : gridPane.getChildren()) {

            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {

                return node;
            }

        }

        return null;
    }



}

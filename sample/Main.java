package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class Main {



    public static void main(String[] args) {

        Timer myTimer = new Timer();
        Application.launch(Menu.class, args);



    }
}

package com.kodilla.intersection;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        final AnchorPane pane = getAnchorPane();
        final Scene scene = new Scene(pane, 512,512);
        Intersection intersection = new Intersection();
        IntersectionSimulation is = new IntersectionSimulation(intersection, pane);

        pane.setOnMouseClicked(event ->
                System.out.println("mouse pressed on (x - y): " + event.getSceneX() + " - "+ event.getSceneY()));


        is.run();
        
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch();
    }


    private AnchorPane getAnchorPane() {
        AnchorPane pane = new AnchorPane();
        Image bgImage = new Image("./images/intersection.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(512, 512, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        pane.setBackground(background);
        return pane;
    }


}
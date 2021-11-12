package com.kodilla.intersection;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        final AnchorPane pane = getAnchorPane();
        Intersection intersection = new Intersection();
        IntersectionSimulation is = new IntersectionSimulation(intersection, pane);

        final Scene scene = new Scene(pane, 512,512);
        is.run();


        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }


    private AnchorPane getAnchorPane() {
        final AnchorPane pane = new AnchorPane();
        Image bgImage = new Image("./images/intersection_small.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(512, 512, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        pane.setBackground(background);
        return pane;
    }


}
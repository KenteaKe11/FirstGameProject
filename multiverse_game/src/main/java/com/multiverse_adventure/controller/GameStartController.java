package com.multiverse_adventure.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.multiverse_adventure.App;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.util.Duration;

public class GameStartController implements Initializable{
  
  @FXML
  private Group title;
  @FXML
  private Button singlePlayer;
  @FXML
  private Button multiPlayer;
  @FXML
  private Button quit;

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    graphicAnimation();
    mouseAnimation();
  }
  
  private void graphicAnimation(){
    //Title
    TranslateTransition tt = new TranslateTransition(Duration.millis(800), title);
    tt.setFromY(-200);
    tt.setToY(0);
    tt.setCycleCount(1);
    tt.setAutoReverse(false);
    tt.play();
    tt.setOnFinished(e -> {
      singleAnimation();
      multiAnimation();
      quitAnimation();
    });
  }

  private void mouseAnimation(){
    singleMouseAnimation();
    multiMouseAnimation();
    quitMouseAnimation();
  }

  private void singleAnimation(){
    TranslateTransition tt = new TranslateTransition(Duration.millis(300), singlePlayer);
    tt.setFromX(0);
    tt.setToX(580);
    tt.setCycleCount(1);
    tt.setAutoReverse(false);
    tt.play();
  }

  private void multiAnimation(){
    TranslateTransition tt = new TranslateTransition(Duration.millis(300), multiPlayer);
    tt.setFromX(0);
    tt.setToX(-570);
    tt.setCycleCount(1);
    tt.setAutoReverse(false);
    tt.play();
  }

  private void quitAnimation(){
    TranslateTransition tt = new TranslateTransition(Duration.millis(300), quit);
    tt.setFromX(0);
    tt.setToX(580);
    tt.setCycleCount(1);
    tt.setAutoReverse(false);
    tt.play();
  }

  private void singleMouseAnimation(){
    singlePlayer.setOnMouseEntered(e -> {
      ScaleTransition st = new ScaleTransition(Duration.millis(200), singlePlayer);
      st.setToX(1.2);
      st.setToY(1.2);
      st.setCycleCount(1);
      st.setAutoReverse(false);
      st.play();
    });
    singlePlayer.setOnMouseExited(e -> {
      ScaleTransition st = new ScaleTransition(Duration.millis(200), singlePlayer);
      st.setToX(1.0);
      st.setToY(1.0);
      st.setCycleCount(1);
      st.setAutoReverse(false);
      st.play();
    });
    singlePlayer.setOnMousePressed(e ->{
      ColorAdjust ca = new ColorAdjust();
      singlePlayer.setEffect(ca);
      ca.setBrightness(-0.5);
    });
    singlePlayer.setOnMouseReleased(e ->{
      ColorAdjust ca = new ColorAdjust();
      singlePlayer.setEffect(ca);
      ca.setBrightness(0);
      launchSingle();
    });
  }

  private void multiMouseAnimation(){
    multiPlayer.setOnMouseEntered(e -> {
      ScaleTransition st = new ScaleTransition(Duration.millis(200), multiPlayer);
      st.setToX(1.2);
      st.setToY(1.2);
      st.setCycleCount(1);
      st.setAutoReverse(false);
      st.play();
    });
    multiPlayer.setOnMouseExited(e -> {
      ScaleTransition st = new ScaleTransition(Duration.millis(200), multiPlayer);
      st.setToX(1.0);
      st.setToY(1.0);
      st.setCycleCount(1);
      st.setAutoReverse(false);
      st.play();
    });
    multiPlayer.setOnMousePressed(e ->{
      ColorAdjust ca = new ColorAdjust();
      multiPlayer.setEffect(ca);
      ca.setBrightness(-0.5);
    });
    multiPlayer.setOnMouseReleased(e ->{
      ColorAdjust ca = new ColorAdjust();
      multiPlayer.setEffect(ca);
      ca.setBrightness(0);
      System.out.println("Played MultiPlayer");
    });
  }

  private void quitMouseAnimation(){
    quit.setOnMouseEntered(e -> {
      ScaleTransition st = new ScaleTransition(Duration.millis(200), quit);
      st.setToX(1.2);
      st.setToY(1.2);
      st.setCycleCount(1);
      st.setAutoReverse(false);
      st.play();
    });
    quit.setOnMouseExited(e -> {
      ScaleTransition st = new ScaleTransition(Duration.millis(200), quit);
      st.setToX(1.0);
      st.setToY(1.0);
      st.setCycleCount(1);
      st.setAutoReverse(false);
      st.play();
    });
    quit.setOnMousePressed(e ->{
      ColorAdjust ca = new ColorAdjust();
      quit.setEffect(ca);
      ca.setBrightness(-0.5);
    });
    quit.setOnMouseReleased(e ->{
      ColorAdjust ca = new ColorAdjust();
      quit.setEffect(ca);
      ca.setBrightness(0);
      Platform.exit();
    });
  }

  private void launchSingle(){
    App single = new App();
    single.launchSinglePlayer();
  }
}

package com.multiverse_adventure.display;

import java.io.IOException;

import com.multiverse_adventure.App;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class GameStartScene {

  @FXML
  public Scene startScene() throws IOException{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/multiverse_adventure/startScene.fxml"));
    return new Scene(loader.load(), App.width, App.height);
  }
}
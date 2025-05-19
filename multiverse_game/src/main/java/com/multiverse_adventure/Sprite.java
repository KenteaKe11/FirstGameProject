package com.multiverse_adventure;

import java.io.InputStream;

import javafx.scene.image.Image;

public class Sprite {
  private boolean isLoadImage = false;
  private String imgName;
  private InputStream is = null;
  private Image img = null;

  //Map1
  public static Sprite grass = new Sprite("grass");
  public static Sprite brick = new Sprite("brick");
  public static Sprite road = new Sprite("road");
  public static Sprite portal = new Sprite("portal");
  public static Sprite energyBrick = new Sprite("energyBrick");

  Sprite(String imgName){
    this.imgName = imgName;
    analyImage();
  }

  public void analyImage(){
    if(!isLoadImage){
      is = getClass().getResourceAsStream("/com/multiverse_adventure/mapImage/" + imgName + ".png");
      isLoadImage = true;
    }
    this.img = new Image(is); 
  }

  public Image getImage(){
    return img;
  }
}

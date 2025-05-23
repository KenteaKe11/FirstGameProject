package com.multiverse_adventure;

import java.io.InputStream;

import javafx.scene.image.Image;

public class Sprite {
  private boolean isLoadImage = false;
  private String imgName;
  private InputStream is = null;
  private Image img = null;

  /*
   * -------------------------------------------------------------------------
   * Entity loadMap
   * -------------------------------------------------------------------------
   */
  public static Sprite grass = new Sprite("grass");
  public static Sprite brick = new Sprite("brick");
  public static Sprite road = new Sprite("road");
  public static Sprite portal = new Sprite("portal");
  public static Sprite energyBrick = new Sprite("energyBrick");
  
  /*
   *--------------------------------------------------------------------------
   * Player_down
   * -------------------------------------------------------------------------
   */
  public static Sprite player_down = new Sprite("player_down");
  public static Sprite player_down1 = new Sprite("player_down1");
  public static Sprite player_down2 = new Sprite("player_down2");
  public static Sprite player_down3 = new Sprite("player_down3");
  public static Sprite player_down4 = new Sprite("player_down4");

    /*
   *--------------------------------------------------------------------------
   * Player_up
   * -------------------------------------------------------------------------
   */
  public static Sprite player_up = new Sprite("player_up");
  public static Sprite player_up1 = new Sprite("player_up1");
  public static Sprite player_up2 = new Sprite("player_up2");
  public static Sprite player_up3 = new Sprite("player_up3");
  public static Sprite player_up4 = new Sprite("player_up4");


  Sprite(String imgName){
    this.imgName = imgName;
    analyImage();
  }

  public void analyImage(){
    if(!isLoadImage){
      is = getClass().getResourceAsStream("/com/multiverse_adventure/entitiesImage/" + imgName + ".png");
      isLoadImage = true;
    }
    this.img = new Image(is); 
  }

  public Image getImage(){
    return img;
  }
}

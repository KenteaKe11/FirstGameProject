package com.multiverse_adventure.entities;

import com.multiverse_adventure.App;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Entity {

  protected int x;
  protected int y;
  protected Image img;

  public Entity(int origX, int origY, Image img){
    this.x = origX * App.tileSize;
    this.y = origY * App.tileSize;
    this.img = img;
  }

  public abstract void update();

  public int getX(){
    return x;
  }
  
  public int getY(){
    return y;
  }

  public void render(GraphicsContext gc){
    gc.drawImage(img, x - App.camX, y - App.camY);
  }
}

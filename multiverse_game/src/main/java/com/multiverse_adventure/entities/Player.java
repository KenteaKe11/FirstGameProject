package com.multiverse_adventure.entities;

import java.util.ArrayList;
import java.util.List;

import com.multiverse_adventure.App;
import com.multiverse_adventure.Sprite;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Player extends Entity{
  private double speed = 64/App.fps;
  private int directionX = 0; //vector x
  private int directionY = 0; //vector y
  private List<Image> downAnimation = new ArrayList<>();
  private List<Image> upAnimation = new ArrayList<>();
  private List<KeyCode> keyConsist = new ArrayList<>();

  private int Frame = 0;//tổng số frame đã chạy qua (0 -> fps * timeDuration * Listsize)
  private double timeDuration = 1.0/6; //tgian chạy 1 vòng animation

  public Player(int origX, int origY, Image img){
    super(origX, origY, img);

    downAnimation.add(Sprite.player_down.getImage());
    downAnimation.add(Sprite.player_down1.getImage());
    downAnimation.add(Sprite.player_down2.getImage());
    downAnimation.add(Sprite.player_down1.getImage());
    downAnimation.add(Sprite.player_down.getImage());
    downAnimation.add(Sprite.player_down3.getImage());
    downAnimation.add(Sprite.player_down4.getImage());
    downAnimation.add(Sprite.player_down3.getImage());

    upAnimation.add(Sprite.player_up.getImage());
    upAnimation.add(Sprite.player_up1.getImage());
    upAnimation.add(Sprite.player_up2.getImage());
    upAnimation.add(Sprite.player_up1.getImage());
    upAnimation.add(Sprite.player_up.getImage());
    upAnimation.add(Sprite.player_up3.getImage());
    upAnimation.add(Sprite.player_up4.getImage());
    upAnimation.add(Sprite.player_up3.getImage());
  }

  private void setImage(Image img){
    super.img = img;
  }

  private void downAni(){
    Frame = (int) ((Frame + 1) % (App.fps * timeDuration * downAnimation.size()));
    setImage(downAnimation.get((int) (Frame/(App.fps * timeDuration))));
  }

  private void upAni(){
    Frame = (int) ((Frame + 1) % (App.fps * timeDuration * upAnimation.size()));
    setImage(upAnimation.get((int) (Frame/(App.fps * timeDuration))));
  }

  //Nhận key
  public void KeyPressed(KeyEvent e){
    for(KeyCode key: keyConsist){
      if(key == e.getCode()){
        return;
      }
    }
    keyConsist.add(e.getCode());
  }
  public void KeyRelease(KeyEvent e){
    keyConsist.removeIf(k -> k == e.getCode());
  }

  //Thực hiện di chuyển
  private void move(){
    for(KeyCode e: keyConsist){
      switch (e) {
        case W:
          directionY = -1;
          upAni();
          break;
        case D:
          directionX = 1;
          break;
        case S:
          directionY = 1;
          downAni();
          break;
        case A:
          directionX = -1;
          break;
        default:
          break;
      }
    }

    if(keyConsist.isEmpty()){
      setImage(Sprite.player_down.getImage());
    }

    super.x += directionX * speed;
    super.y += directionY * speed;
    directionX = 0;
    directionY = 0;
  }

  @Override
  public void update() {
    move();
  }
}

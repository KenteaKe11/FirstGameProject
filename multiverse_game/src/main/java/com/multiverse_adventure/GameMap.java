package com.multiverse_adventure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameMap {
  private char[][] map;
  private String up;
  private String down;
  private String left;
  private String right;
  private int mapIdx = 1;

  GameMap(String fileName){
    mapMatrix(fileName);
  }

  private void mapMatrix(String fileName){
    try(BufferedReader bf = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/com/multiverse_adventure/maps/map" + mapIdx + "/"+ fileName + ".txt")))){

      String line1 = bf.readLine();
      int mapSize = Integer.parseInt(line1);
      map = new char[mapSize][mapSize];

      //set map char[][]
      for(int i = 0; i < mapSize; i++){
        String line = bf.readLine().substring(1, mapSize + 1);
        for(int j = 0; j < mapSize; j++){
          map[i][j] = line.charAt(j);
        }
      }

      //set direction
      up = bf.readLine();
      right = bf.readLine();
      down = bf.readLine();
      left = bf.readLine();

    }catch(IOException e){
      e.printStackTrace();
    }
  }

  public String getUp(){
    return up;
  }
  
  public String getDown(){
    return down;
  }
  
  public String getRight(){
    return right;
  }
  
  public String getLeft(){
    return left;
  }

  public char[][] getMap(){
    return map;
  }
}

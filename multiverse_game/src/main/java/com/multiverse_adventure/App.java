package com.multiverse_adventure;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.multiverse_adventure.display.GameStartScene;
import com.multiverse_adventure.entities.*;

public class App extends Application {
    public static final int tileSize = 64;
    public static final int rowCnt = 10;
    public static final int columnCnt = 12;
    public static int height = rowCnt * tileSize;
    public static int width = columnCnt * tileSize;
    private GameMap gameMap = null;
    private List<Entity> entities = new ArrayList<>();
    private char[][] map = new char[31][31];

    private Canvas canvas = new Canvas(width, height);
    private GraphicsContext gc = canvas.getGraphicsContext2D();
    
    public static Scene scene;

    //màn hình start ban đầu
    @Override
    public void start(Stage stage) throws IOException {
        GameStartScene startGame = new GameStartScene();
        scene = startGame.startScene();
        stage.setTitle("Multiverse Adventure Game.");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public static int camX = 0;
    public static int camY = 0;
    
    public void launchSinglePlayer(){
        //Đổi scene
        Pane root = new Pane(canvas);
        scene.setRoot(root);

        gameMap = new GameMap("hall");
        map = gameMap.getMap();

        AnimationTimer time = new AnimationTimer() {
            @Override
            public void handle(long arg0) {      
                cameraTest();
                update();
                render();
            }
        };
        time.start();
    }

    private void cameraTest(){
        //Load map
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case A:
                    if(camX > 0){
                        camX -= 8;
                    }
                    break;
                case D:
                    if(camX  < (31 - columnCnt) * tileSize){
                        camX += 8;
                    }
                    break;
                case W:
                    if(camY > 0){
                        camY -= 8;
                    }
                    break;
                case S:
                    if(camY < (31 - rowCnt) * tileSize){
                        camY += 8;
                    }
                    break;
                default:
                    break;
            }
        });

        for(int i = camY/tileSize; i <= camY/tileSize + rowCnt && i < 31; i++){
            for(int j = camX/tileSize; j <= camX/tileSize + columnCnt && j < 31; j++){
                Entity object = null;
                boolean isAdded = false;
                switch (map[i][j]) {
                    case ' ':
                        for(Entity entity: entities){
                            if(entity.getX()/tileSize == j && entity.getY()/tileSize == i){
                                isAdded = true;
                                break; 
                            }
                        }
                        if(!isAdded){
                            object = new Grass(j, i, Sprite.grass.getImage());
                            entities.add(object); 
                        }
                        break;
                    case '#':
                        for(Entity entity: entities){
                            if(entity.getX()/tileSize == j && entity.getY()/tileSize == i){
                                isAdded = true; 
                                break; 
                            }
                        }
                        if(!isAdded){
                            object = new Brick(j, i, Sprite.brick.getImage());
                            entities.add(object); 
                        }
                        break;
                    case '0':
                        for(Entity entity: entities){
                            if(entity.getX()/tileSize == j && entity.getY()/tileSize == i){
                                isAdded = true;
                                break; 
                            }
                        }
                        if(!isAdded){
                            object = new Portal(j, i, Sprite.portal.getImage());
                            entities.add(object);  
                        }
                        break;
                    case '+':
                        for(Entity entity: entities){
                            if(entity.getX()/tileSize == j && entity.getY()/tileSize == i){
                                isAdded = true;
                                break; 
                            }
                        }
                        if(!isAdded){
                            object = new EnergyBrick(j, i, Sprite.energyBrick.getImage());
                            entities.add(object);   
                        } 
                        break;
                    default:
                        for(Entity entity: entities){
                            if(entity.getX()/tileSize == j && entity.getY()/tileSize == i){
                                isAdded = true;
                                break; 
                            }
                        }
                        if(!isAdded){
                           object = new Road(j, i, Sprite.road.getImage());
                            entities.add(object);  
                        }
                        break;
                }
            }
        }
    }

    public void launchMultiPlayer(){

    }

    //Main
    public static void main(String[] args) {
        launch();
    }

    public void update(){
        entities.forEach(e -> e.update());
    }

    public void render(){
        gc.clearRect(0, 0, width, height);
        entities.forEach(e -> e.render(gc));
    }

}
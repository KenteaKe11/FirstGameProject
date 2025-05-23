package com.multiverse_adventure;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
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
    private long previousTime = 0;
    public static final int fps = 60;
    private List<Entity> entities = new ArrayList<>();

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


    public static int camX = (int) (9.5 * tileSize);
    public static int camY = (int) (10.5 * tileSize);
    
    public void launchSinglePlayer(){
        //Đổi scene
        Pane root = new Pane(canvas);
        scene.setRoot(root);
        
        AnimationTimer time = new AnimationTimer() {
            
            @Override
            public void handle(long now) {
                long timeFrame = 1_000_000_000/fps;
                long delta = now - previousTime;
                previousTime = now;
                delta += timeFrame;

                if(delta > timeFrame){
                    update();
                    render();
                    delta -= timeFrame;
                }
            }
        };
        time.start();

        //Xử lý sự kiện bàn phím
        Entity player = new Player(15, 15, Sprite.player_down.getImage());
        entities.add(player);

        scene.setOnKeyPressed(e ->{
            ((Player)player).KeyPressed(e);
        });
        scene.setOnKeyReleased(e ->{
            ((Player)player).KeyRelease(e);
        });
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
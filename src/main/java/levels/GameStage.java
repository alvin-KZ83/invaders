/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levels;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author alvin
 */
public abstract class GameStage extends Application
{
    GridPane layout = new GridPane();
    Board board = new Board(layout, "Earth Invaders");
    PlayButton play = new PlayButton();
    Level level;

    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        layout.setAlignment(Pos.CENTER);
        
        level = new Level(600,900);
        level_init();

        play.setOnAction(e -> 
        {
            level = new Level(600,900);
            level_init();    
        });
        
        layout.add(play,0,1);
        board.show();
    }

    public void setLevel(Level level) 
    {
        this.level = level;
    }
    
    private void level_init()
    {
        customize(level);
        layout.add(level.create(),0,0);
    }
    
    public abstract void customize(Level level);
}

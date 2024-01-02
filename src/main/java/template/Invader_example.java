package template;
/**
 * Imports the necessary packages to run the program
 * DO NOT IMPORT ANYTHING ELSE
 */
import javafx.scene.paint.Color;
import levels.GameStage;
import levels.Level;
/**
 * MAKE SURE TO EXTEND THE GameStage CLASS AS IT REPLACES THE APPLICATION
 */
public class Invader_example extends GameStage 
{      
    /**
     * LEVEL CUSTOMIZATION
     * TODO: insert all the customizations you would like for the level
     * 
     * THIS IS OPTIONAL, THE PROGRAM WILL RUN AT DEFAULT SETTINGS WITHOUT CUSTOMIZATION
     * @param level 
     */
    @Override
    public void customize(Level level) 
    {   
        /**
         * All the customizations for the level is done in this method
         * Use the level.set___() for any customization here.
         */
        
        /**
         * The functions here set the enemy delay, enemy lives amount
         */
        level.setPlayerImage("sample2.png");
        level.setEnemyImage("sample3.png");
        level.setBackground("sample1.jpg");
        level.setEnemyDelay(2);
        level.setEnemyLives(3);
        /**
         * You can add more customizations as you like
         */
    }
    
    /**
     * DO NOT CHANGE ANYTHING IN THIS FUNCTION
     * THE PARAMETER SHOULDN'T BE CHANGED AS WELL
     * 
     * This function will cause the program to start.
     * @param args 
     */
    public static void main(String[] args) 
    {
        GameStage.launch(args);
    }
}

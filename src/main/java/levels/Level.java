package levels;

import java.util.List;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import sprites.Player;
import sprites.Ship;
import sprites.Sprite;
import sprites.bullets.Bullet;

/**
 *
 * @author alvin
 */

public final class Level extends AnimationTimer
{
    Player player;
    Ship enemy;
    Pane field;
    GridPane scoreboard;
    StackPane playingField;
    BorderPane playingInterface;
    Space space;
    Bullet seeker;
    Score score = new Score(60);
    Score highscore = new Score(30);
    //Text game_over = new Text("GAME\nOVER");

    double width, height;
    
    double timeLoop = 0;
    double enemyTimer = 0;
    double seekerTimer = 0;
    
    double delay;
    double enemyDelay;
    double seekerDelay;
    
    int enemyAmount; 
    int enemyCount;
    
    int enemyPoint;
    int seekerPoint;
    
    int points;
    int maxPoints;

    Level(double width, double height)
    {
        this.player = new Player("PlayerShipX.png", 5);
        this.enemy = new Ship("enemyShip", "EvilShipX.png", 5, false);
        this.seeker = new Bullet("bullet", enemy, Color.BLACK, "seeker");
        this.field = new Pane();
        this.space = new Space(width, height);
        this.scoreboard = new GridPane();
        this.scoreboard.setAlignment(Pos.CENTER);
        this.playingField = new StackPane();
        this.playingInterface = new BorderPane();
        this.width = width;
        this.height = height;
        this.delay = 0.1;
        this.enemyDelay = 3;
        this.seekerDelay = 0.5;
    
        this.enemyAmount = 0; 
        this.enemyCount = 0;
    
        this.enemyPoint = 1500;
        this.seekerPoint = 500;
        this.points = 0;
        this.maxPoints = 0;
        
        this.setLevelSize(this.width, this.height);
        
        BorderPane.setAlignment(score, Pos.CENTER);
    }
    
    Level(Level level)
    {
        this.player = new Player("PlayerShipX.png", 5);
        this.enemy = new Ship("enemyShip", "EvilShipX.png", 5, false);
        this.seeker = new Bullet("bullet", enemy, Color.BLACK, "seeker");
        this.space = new Space(this.getWidth(), this.getHeight());
        
        this.field = new Pane();
        this.scoreboard = new GridPane();
        this.scoreboard.setAlignment(Pos.CENTER);
        this.playingField = new StackPane();
        this.playingInterface = new BorderPane();
        
        this.width = level.getWidth();
        this.height = level.getHeight();
        this.delay = level.delay;
        this.enemyDelay = level.enemyDelay;
        this.seekerDelay = level.seekerDelay;
    
        this.enemyAmount = level.enemyAmount; 
        this.enemyCount = 0;
    
        this.enemyPoint = level.enemyPoint;
        this.seekerPoint = level.seekerPoint;
        this.points = 0;
        this.maxPoints = level.maxPoints;
        
        this.setLevelSize(this.width, this.height);
        
        BorderPane.setAlignment(score, Pos.CENTER);
    } 
    
    /**
     * Sets the image for the player's ship.
     * @param imgLocation The image file name. You don't have to specify the specific path, just the name. Make sure its in the src\images folder..
     */
    public void setPlayerImage(String imgLocation)
    {
        player.setImage(imgLocation);
    }
    
    /**
     * Sets the image for the player's ship using a link
     * @param url The link for the image. Use the copy address option in a website after hovering on an image.
     */
    public void setPlayerImageURL(String url)
    {
        player.setImagefromURL(url);
    }
    
    /**
     * Sets the amount of times the player needs to be hit before it dies
     * @param lives The amount of lives
     */
    public void setPlayerLives(int lives)
    {
        player.setLives(lives);
    }
    
    /**
     * Sets the maximum number of enemies that can exist in a single session
     * @param amount The amount of enemies 
     */
    public void setEnemyAmount(int amount)
    {
        this.enemyAmount = amount;
    }
    
    /**
     * Sets the time between enemy ship spawn. The higher the number the longer the delay
     * @param delay The integer value for the amount of delay. This is in seconds.
     */
    public void setEnemyDelay(int delay)
    {
        this.enemyDelay = delay;
    }
    
    /**
     * Sets the image for the enemy's ship.
     * @param imgLocation The image file name. You don't have to specify the specific path, just the name. Make sure its in the src\images folder..
     */
    public void setEnemyImage(String imgLocation)
    {
        enemy.setImage(imgLocation);
    }
    
    /**
     * Sets the image for the enemy's ship using a link
     * @param url The link for the image. Use the copy address option in a website after hovering on an image.
     */
    public void setEnemyImageURL(String url)
    {
        enemy.setImagefromURL(url);
    }
    
    /**
     * Sets the amount of times the enemy needs to be hit before it dies
     * @param lives The amount of lives
     */
    public void setEnemyLives(int lives)
    {
        enemy.setLives(lives);
    }
    
    /**
     * Sets the number of points the player gets for destroying an enemy
     * @param points the number of points
     */
    public void setEnemyPoints(int points)
    {
        this.enemyPoint = points;
    }
    
    /**
     * Sets the time between seeker spawn. The higher the number the longer the delay
     * @param delay The integer value for the amount of delay. This is in seconds.
     */
    public void setSeekerDelay(double delay)
    {
        this.seekerDelay = delay;
    }
    
    /**
     * Sets the number of points the player gets for destroying a seeker
     * @param points the number of points
     */
    public void setSeekerPoints(int points)
    {
        this.seekerPoint = points;
    }
    
    /**
     * Sets the image for the level background.
     * @param imgLocation The image file name. You don't have to specify the specific path, just the name. Make sure its in the src\images folder..
     */
    public void setBackground(String imgLocation)
    {
        space.setImage("file:src//images//" + imgLocation, this.width, this.height);
    }
    
    /**
     * Sets the image for the level background using a link
     * @param url The link for the image. Use the copy address option in a website after hovering on an image.
     */
    public void setBackgroundURL(String url)
    {
        space.setImage(url, this.width, this.height);
    }
    
    /**
     * Sets the type of the player bullet. Alternates between "normal" and "pierce"
     * - Normal bullet: destroyed upon impact
     * - Pierce bullet: not destroyed upon impact
     * - Default is normal bullet
     * @param type The type of the bullet.
     */
    public void setPlayerBullet(String type)
    {
        player.setBulletType(type);
    }
    
    /**
     * Set the size of the level
     * @param width The width of the level
     * @param height The height of the level
     */
    public void setLevelSize(double width, double height)
    {
        this.width = width;
        this.height = height;
        this.field.setPrefSize(width, height);
    }

    double getWidth()
    {
        return this.width;
    }

    double getHeight()
    {
        return this.height;
    }
    
    /**
     * Sets the delay for player bullets and enemy ship bullets. The higher this value is the slower the rate they will shoot at.
     * @param delay 
     */
    public void setLevelDelay(double delay)
    {
        this.delay = delay;
    }
    
    /**
     * Sets the color of the score text color
     * @param color 
     */
    public void setScoreColor(Color color)
    {
        this.score.setColor(color);
    }
    
    /**
     * Sets the color of the high score text color
     * @param color 
     */
    public void setHighScoreColor(Color color)
    {
        this.highscore.setColor(color);
    }
    
//    /**
//     * Sets the color of the text that is shown when the player dies.
//     * @param color The color of the text
//     */
//    public void setGameTextColor(Color color)
//    {
//    }
//
//    /**
//     * Sets the text that is shown when the player dies.
//     * @param text The text that you want shown.
//     */
//    public void setGameText(String text)
//    {
//        this.game_over.setText(text);
//    }
    
    void update()
    {        
        if(!this.player.Exists())
        {
            this.stop();
            //playingField.getChildren().add(game_over);
            maxPoints = points;
            return;
        }
        
        if(points > maxPoints)
        {
            highscore.setText("High" + highscore.toScore(points));
        }
        else
        {

        }
        
        points += 1;
        
        timeLoop += 0.016;
        enemyTimer += 0.016;
        seekerTimer += 0.016;
        
        if(enemyAmount <= 0)
        {
            if(enemyTimer > enemyDelay)
            {
                enemy.insert(this.field);
                enemyTimer = 0;
            }
        }
        else
        {
            if(enemyTimer > enemyDelay && enemyCount < enemyAmount)
            {
                enemy.insert(this.field);
                enemyCount++;
                enemyTimer = 0;
            }
        }
        
        if(seekerTimer > seekerDelay)
        {
            seeker.insert(this.field);
            seekerTimer = 0;
        }
        
        sprites().forEach(sprite -> 
        {
        
            switch(sprite.getType())
            {
                /**
                 * 
                 */
                case "playerShip":
                {
                    if(!sprite.Exists())
                    {
                        sprite.remove(field);
                        points += seekerPoint;
                        break;
                    }
                    
                    if(timeLoop > delay)
                    {
                        sprite.shoot(this.field);
                    }
                    
                    break;
                }
                /**
                 * 
                 */
                case "playerBullet":
                {
                    if(sprite.getCenterY() <= 0)
                    {
                        this.field.getChildren().remove(sprite);
                    }
                    else
                    {
                        sprite.move(this.player, sprites(), this.field);
                    }
                    break;
                }
                /**
                 * 
                 */
                case "enemyBullet":
                {
                    if(sprite.getCenterY() >= this.height)
                    {
                        this.field.getChildren().remove(sprite);
                    }
                    else
                    {
                        sprite.move(this.player, sprites(), this.field);
                    }
                    break;
                }
                /**
                 * 
                 */
                case "enemyShip":
                {
                    if(!sprite.Exists())
                    {
                        sprite.remove(field);
                        points += seekerPoint;
                        break;
                    }
                    
                    if(sprite.getCenterY() >= this.height)
                    {                  this.field.getChildren().remove(sprite);
                    }
                    
                    sprite.move(this.player, sprites(), this.field);
                    if(timeLoop > delay)
                    {
                        if(Math.random()*15 < 3)
                        {
                           sprite.shoot(this.field);
                        }
                    }
                    break;
                }
                /**
                 * 
                 */
                case "bullet":
                {
                    if(!sprite.Exists())
                    {
                        sprite.remove(field);
                        points += enemyPoint;
                        break;
                    }
                    
                    sprite.move(this.player, sprites(), this.field);
                    break;
                }
            }
        });
        
        score.update(this);
        
        if(timeLoop > delay)
        {
            timeLoop = 0;
        }
    }
    
    int getPoints()
    {
        return points;
    }
    
    List<Sprite> sprites()
    {
        return field.getChildren().stream().map(n -> (Sprite)n).collect((Collectors.toList()));
    }

    Parent create()
    {   
        player.insert(field);
        player.setBulletType("normal");

        space.setSize(width, height);
        
        field.setCursor(Cursor.NONE);
        
        highscore.setText("High" + highscore.toScore(maxPoints));
        highscore.setColor(Color.AQUAMARINE);
        
        scoreboard.add(score, 0, 0);
        scoreboard.add(highscore, 0, 1);
        
        playingInterface.setTop(scoreboard);

        playingField.getChildren().add(space);
        playingField.getChildren().add(playingInterface);
        playingField.getChildren().add(field);  
        
        this.start();
               
        field.addEventHandler(MouseEvent.MOUSE_MOVED, move -> 
        {   
            if(player.Exists())
            {
                player.move(move, this.player, sprites(), field);
            }
        });
        
        return playingField;
    }

    @Override
    public void handle(long now) 
    {
        update();
    } 
}

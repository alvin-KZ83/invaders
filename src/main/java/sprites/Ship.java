package sprites;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import sprites.bullets.Bullet;
/**
 *
 * @author alvin
 */
public class Ship extends Sprite
{ 
    int lives;
    boolean playable;
    
    double time = 0;
    
    Timer timer = new Timer();
    
    class iFrame extends TimerTask
    {
        Sprite s;
        public iFrame(Sprite s)
        {
           this.s = s; 
        }

        @Override
        public void run() 
        {
            s.setVisible(true);
        }   
    }
    
    public Ship(String type, String imgLocation, int lives, boolean playable) 
    {
        super(type, Color.ALICEBLUE, 1.5);
        this.imgLocation = imgLocation;
        this.lives = lives;
        this.playable = playable;
        this.setImage(imgLocation);
        
        if(playable)
        {
            /**
             * THE SHIP IS PLAYABLE AND SPEED IS SET TO 0
             */
            this.spriteType = "playerShip";
            this.bulletType = "normal";
            this.hitzone = new Hitzone(Color.AQUA);
            this.speed = 0.0;
            this.lives = lives;
        }
        else
        {
            /**
             * THE SHIP IS AN ENEMY
             */
            this.spriteType = "enemyShip";
            this.bulletType = "enemy";
            this.hitzone = new Hitzone(Color.CRIMSON);
            this.lives = lives;
        }
        
        this.setSize(64);
    }
    
    public void setSize(double size)
    {
        this.setRadius(size);
        this.hitzone.setRadius(Math.sqrt(size));
    }
    
    public void setLives(int lives)
    {
        this.lives = lives;
    }
    
    public void takenDmg(long frames)
    {
        this.lives -= 1;
        this.hitzone.setVisible(false);
        timer.schedule(new iFrame(this.hitzone), frames); 
    }
    
    @Override
    public void insert(Pane field) 
    {
        Ship ship = new Ship(this.getType(), this.imgLocation, this.lives, this.playable);
        field.getChildren().add(ship.hitzone);
        field.getChildren().add(ship);
        ship.setCenterX((Math.random() * (field.getWidth() - (3 * ship.getRadius())))  + 2 * ship.getRadius());
        ship.setCenterY(ship.getRadius());
    }

    /**
     * This moves the ship in a default manner, spawning them at the top of the field
     * Then it will move horizontally to the edge o the field before shifting down
     * @param ref
     * @param sprites
     * @param field 
     */
    @Override
    public void move(Sprite ref, List<Sprite> sprites, Pane field) 
    {
       if(this.getCenterX() >= field.getWidth() - this.getRadius() || this.getCenterX() <= this.getRadius())
       {
           this.setCenterY(this.getCenterY() + 2 * this.getRadius());
           this.setSpeed(0 - this.getSpeed());
       }
       else{}
       
       this.move("right");
       this.hitzone.move(this, sprites, field);
       
       effect(sprites, field);
    }

    /**
     * THIS IS A METHOD THAT YOU SHOULD NOT CHANGE, 
     * UNLESS YOU ARE ADDING A NEW CASE FOR A NEW BULLTER
     * @param sprites a list containing all the sprites in the field.
     * @param field the field referenced
     */
    @Override
    public void effect(List<Sprite> sprites, Pane field) 
    {
        sprites.forEach(sprite -> {
        
            switch(sprite.getType())
            {
                case "playerBullet":
                {
                    if(this.hitzone.detectCollision(sprite) && this.hitzone.isVisible())
                    {
                        if(this.lives <= 0)
                        {
                           this.setExist(false);
                        }
                        else
                        {
                            this.takenDmg(200);
                        }
                        
                        switch(sprite.getBulletType())
                        {
                            case "pierce":
                            {
                                break;
                            }
                            default:
                            {
                                field.getChildren().remove(sprite);
                                break;
                            }
                        }
                    }
                    else{}
                    break;
                }
            }
        });
    }

    @Override
    public void shoot(Pane field) 
    {
        Bullet bullet;
        if(this.getType().equalsIgnoreCase("playerShip"))
        {
            bullet = new Bullet("playerBullet", this, Color.AQUA, this.bulletType);
        }
        else
        {
            bullet = new Bullet("enemyBullet", this, Color.CRIMSON, this.bulletType);
        }
        field.getChildren().add(bullet);
    }
    
}

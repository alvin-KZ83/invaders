package sprites;

import java.util.List;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author alvin
 */
public class Player extends Ship
{
    
    public Player(String imgLocation, int lives) 
    {
        super("playerShip", imgLocation, lives, true);
        this.setSize(55);
    }
    
    public void move(MouseEvent move, Sprite ref, List<Sprite> sprites, Pane field) 
    {
        this.setCenterX(move.getX());
        this.setCenterY(move.getY());
        this.hitzone.move(this, sprites, field);
        effect(sprites, field);
    }

    public void insert(Pane field) 
    {
        field.getChildren().add(this.hitzone);
        field.getChildren().add(this);
    }
    
    @Override
    public void effect(List<Sprite> sprites, Pane field)
    {
        sprites.forEach(sprite -> {
        
            switch(sprite.getType())
            {
                case "enemyBullet":
                {
                    if(this.hitzone.detectCollision(sprite) && this.hitzone.isVisible())
                    {
                        if(this.lives <= 0)
                        {
                           field.getChildren().remove(this);
                           field.getChildren().remove(this.hitzone);
                           this.setExist(false);
                           System.out.println("You have been killed!");
                        }
                        else
                        {
                            this.takenDmg(500);
                            System.out.println("You have been hit! Remaining lives: " + this.lives);
                        }
                        field.getChildren().remove(sprite);
                    }
                    else{}
                    break;       
                }
                
                case "bullet":
                {
                    if(this.hitzone.detectCollision(sprite) && this.hitzone.isVisible())
                    {
                        if(this.lives <= 0)
                        {
                           field.getChildren().remove(this);
                           field.getChildren().remove(this.hitzone);
                           this.setExist(false);
                           System.out.println("You have been killed!");
                        }
                        else
                        {
                            this.takenDmg(500);
                            System.out.println("You have been hit! Remaining lives: " + this.lives);
                        }
                        field.getChildren().remove(sprite);
                    }
                    else{}
                    break; 
                }
            }
        });
    }
    
}

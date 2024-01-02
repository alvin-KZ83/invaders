
package sprites.bullets;

import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sprites.Ship;
import sprites.Sprite;

/**
 *
 * @author alvin
 */
public class Bullet extends Sprite
{
    Ship ship;
    
    public Bullet(String type, Ship owner, Color color, String bulletType) 
    {
        super(type, color, 5.0);
        
        this.ship = owner;
        this.setBulletType(bulletType);
        
        switch(type)
        {
            case "playerBullet":
            {
                this.setSpeed(10.0);
                this.setCenterX(this.ship.getCenterX());
                this.setCenterY(this.ship.getCenterY() - owner.getRadius());
                break;
            }
            case "enemyBullet":
            {
                this.setSpeed(-5.0);
                this.setCenterX(this.ship.getCenterX());
                this.setCenterY(this.ship.getCenterY() + owner.getRadius());
                break;
            }
            default:
            {
                break;
            }
        }
        
        switch(this.getBulletType())
        {
            case "pierce":
            {
                this.setFill(Color.ALICEBLUE);
                break;
            }
            case "seeker":
            {
                this.setRadius(8);
                this.setFill(Color.HOTPINK);
                break;
            }
            default:
            {
                break;
            }
        }
    }
    
    public Ship getShip()
    {
        return this.ship;
    }

    @Override
    public void move(Sprite ref, List<Sprite> sprites, Pane field) 
    {
        switch(this.getBulletType())
        {
            case "seeker":
            {
                if(this.getCenterX() > ref.getCenterX()){
                    this.setCenterX(this.getCenterX() - 1.5);
                }
                else if(this.getCenterX() < ref.getCenterX()){
                    this.setCenterX(this.getCenterX() + 1.5);
                }
                else{}

                if(this.getCenterY() > ref.getCenterY()){
                    this.setCenterY(this.getCenterY() - 1.5);
                }
                else if(this.getCenterY() < ref.getCenterY()){
                    this.setCenterY(this.getCenterY() + 1.5);
                }
                else{}
                
                effect(sprites, field);
                break;
            }
            
            default:
            {
                this.setCenterY(this.getCenterY() - this.getSpeed());
                effect(sprites, field);
                break;
            }
        }
    }

    @Override
    public void effect(List<Sprite> sprites, Pane field) 
    {
        sprites.forEach(sprite -> {
        
            switch(sprite.getType())
            {
                case "playerBullet":
                {
                    switch(this.getBulletType())
                    {
                        case "seeker":
                        {
                            if(!detectCollision(sprite)){}
                            else
                            {
                                this.setExist(false);
                            }
                            break;
                        }
                    }
                }
            }
        });
    }

    /**
     * THE FUNCTIONS BELOW WILL DO NOTHING 
     * DO NOT CHANGE OR ALTER
     * THEM IN ANY WAY!
     */
    
    /**
     * 
     * @param field ---
     */
    @Override
    public void shoot(Pane field) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @param field ---
     */
    @Override
    public void insert(Pane field) 
    {
        Bullet bullet;
        //String type, Ship owner, Color color, String bulletType
        bullet = new Bullet(this.getType(), this.ship, Color.BLACK, this.getBulletType());
        field.getChildren().add(bullet);
        bullet.setCenterX(Math.random() * field.getWidth());
        bullet.setCenterY(Math.random() * field.getHeight()/2);
    }
    
}

package sprites;

import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 *
 * @author alvin
 */

public abstract class Sprite extends Circle
{
    String spriteType;
    String bulletType;
    String imgLocation;
    final int color;
    boolean exist;
    double speed;
    
    Hitzone hitzone;
    
    public Sprite(String type, Color color, double speed)
    {
        this.spriteType = type;
        this.color = color.hashCode();
        this.exist = true;
        this.speed = speed;
        
        this.setFill(color);
        this.setRadius(5);
    }
    
    /**
     * Setters and Getters
     */
    
    public Sprite getHitzone(){
        return hitzone;
    }
    
    /**
     * Returns the type of the sprite
     * @return 
     */
    public String getType() {
        return spriteType;
    }
    
    /**
     * Sets the type of the sprite
     * @param type the type of the sprite
     */
    public void setType(String type) {
        this.spriteType = type;
    }
    
    /**
     * Returns the bullet type
     * @return 
     */
    public String getBulletType(){
        return this.bulletType;
    }
    
    /**
     * Sets the bullet type of the bullet
     * @param bulletType type of the bullet, "normal", "seeker", "pierce", etc.
     */
    public void setBulletType(String bulletType) {
        this.bulletType = bulletType;
    }
    
    /**
     * Returns if this sprite still exists
     * @return 
     */
    public boolean Exists() {
        return exist;
    }
    
    /**
     * Sets the exist value of the sprite
     * @param exist true or false value for exist property
     */
    public void setExist(boolean exist) {
        this.exist = exist;
    }

    /**
     * Returns the speed of the sprite
     * @return 
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of the sprite
     * @param speed the desired speed, up to 1 decimal point is much desired
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    /**
     * Sets the sprite to an image. Only works with files inside the images folder in the source package
     * @param imgLocation the file name "image.png"
     */
    public void setImage(String imgLocation)
    {
        this.imgLocation = imgLocation;
        this.setFill(new ImagePattern(new Image("E:\\Files\\Files\\Invaders\\"
                + "src\\main\\java\\images\\" + this.imgLocation)));
    }
    
    /**
     * Sets the sprite to an image using an URL.
     * @param url url for the image
     */
    public void setImagefromURL(String url)
    {
        this.imgLocation = url;
        this.setFill(new ImagePattern(new Image(url)));
    }
    
    /**
     * Moves the sprite in a single direction
     * @param direction Takes in a directional input ( exclusive: "UP", "DOWN", "LEFT", "RIGHT" )
     */
    public void move(String direction)
    {
        switch(direction.toUpperCase())
        {
            case "UP":
            {
                this.setCenterY(this.getCenterY() - this.speed);
                break;
            }
            case "DOWN":
            {
                this.setCenterY(this.getCenterY() + this.speed);
                break;
            }
            case "LEFT":
            {
                this.setCenterX(this.getCenterX() - this.speed);
                break;
            }
            case "RIGHT":
            {
                this.setCenterX(this.getCenterX() + this.speed);
                break;
            }
            default:
            {
                break;
            }
        }
    }
    
    /**
     * This checks whether or not the sprite collides with another sprite
     * @param ref The referenced sprite for collision detection 
     * @return 
     */
    public boolean detectCollision(Sprite ref)
    {
        return ref.getBoundsInParent().intersects(this.getBoundsInParent());
    }
    
    public void remove(Pane field)
    {
        field.getChildren().remove(this);
        field.getChildren().remove(this.hitzone);
    }
    
    public abstract void insert(Pane field);
    
    public abstract void move(Sprite ref, List<Sprite> sprites, Pane field);
    
    public abstract void effect(List<Sprite> sprites, Pane field);
    
    public abstract void shoot(Pane field);
}

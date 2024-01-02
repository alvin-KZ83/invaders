package levels;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author alvin
 */
public class Space extends ImageView
{
    public Space(double width, double height)
    {
        this.setImage(new Image("E:\\Files\\Files\\Invaders\\src\\main\\java\\images\\bg.gif", width, height, false, true));
    }
    
    public void setSize(double width, double height)
    {
        this.setFitWidth(width);
        this.setFitHeight(height);
    }
    
    public void setImage(String imgLocation, double width, double height)
    {
        this.setImage(new Image(imgLocation, width, height, false, true));
        this.setX(width/2);
        this.setY(height/2);
    }
}

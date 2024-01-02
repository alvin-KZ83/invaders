package sprites;

import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author alvin
 */
public class Hitzone extends Sprite
{

    public Hitzone(Color color) 
    {
        super("hitzone", color, 0.0);
        this.setRadius(8);
    }
    
    /**
     * This function sets the hit zone to stay with the referenced ship
     * @param ref Takes in the ship that owns this hit zone
     * @param sprites ---
     * @param field ---
     */
    @Override
    public void move(Sprite ref, List<Sprite> sprites, Pane field) 
    {
        this.setCenterX(ref.getCenterX());
        this.setCenterY(ref.getCenterY());
    }
    
    /**
     * THE FUNCTIONS BELOW WILL DO NOTHING 
     * DO NOT CHANGE OR ALTER
     * THEM IN ANY WAY!
     */

    /**
     * This function will do nothing
     * @param field ---
     */
    @Override
    public void insert(Pane field) {}
    
    /**
     * This function will do nothing
     * @param sprites ---
     * @param field ---
     */
    @Override
    public void effect(List<Sprite> sprites, Pane field) {}

    /**
     * This function will do nothing
     * @param field ---
     */
    @Override
    public void shoot(Pane field) {}
    
}

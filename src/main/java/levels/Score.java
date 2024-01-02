package levels;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author alvin
 */
public class Score extends Text
{
    //Font font;
    Color color = Color.ALICEBLUE;
    public Score(int size)
    {
        //font = Font.loadFont("file:src//fonts//ARCADECLASSIC.ttf", size);
        //this.setFont(font);
    }
    
    public void update(Level level)
    {
        this.setText(this.toScore(level.getPoints()));
        this.setFill(this.color);
    }
    
    public void setColor(Color color)
    {
        this.setFill(color);
    }
    
    public void setSize(int size)
    {
        //font = Font.loadFont("file:src//fonts//ARCADECLASSIC.ttf", size);
    }
    
    public String toScore(int points)
    {
        StringBuilder build = new StringBuilder();
        for(int i = 10; i < (10 * 1000000000); i *= 10)
        {
            int digit = points % i;
            points -= digit;
            build.append(digit / ( i / 10 ));
        }
        return "Score  " + build.reverse().toString();
    }
            
}

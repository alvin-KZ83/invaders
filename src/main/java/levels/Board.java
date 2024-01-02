package levels;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author alvin
 */
public class Board extends Stage
{
    Scene scene;
    GridPane grid;
    
    public Board(GridPane layout)
    {
        this.scene = new Scene(layout);
        this.grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        
        this.setTitle("Default Title");
        this.setScene(scene);
        this.setResizable(false);
    }
    
    public Board(GridPane layout, String windowName)
    {
        this.scene = new Scene(layout);
        this.setTitle(windowName);
        this.setScene(scene);
        this.setResizable(false);
    }
    
    public void setWindowName(String windowName)
    {
        this.setTitle(windowName);
    }
    
    public void showBoard()
    {
        this.show();
    }
}

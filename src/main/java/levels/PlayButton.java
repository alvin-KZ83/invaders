/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levels;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

/**
 *
 * @author alvin
 */
public class PlayButton extends Button
{
    public PlayButton()
    {
        //this.setFont(Font.loadFont("file:src//fonts//ARCADECLASSIC.ttf", 30));
        this.setText("START");
    }
    
    public PlayButton(String buttonName)
    {
        //this.setFont(Font.loadFont("file:src//fonts//ARCADECLASSIC.ttf", 30));
        this.setText(buttonName);
    }
}

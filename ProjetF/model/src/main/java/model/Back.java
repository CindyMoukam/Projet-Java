package model;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 *		The class Character, it is the class that manages every character in the video game
 */

public class Back extends Objet{
    /**
     *
     * @param x
     * the x coordinate
     * @param y
     * the y coordinate
     * @see Objet
     */

    public Back(int x, int y) {
        super(x, y,32,32);
        try {
            BufferedImage bigImg = ImageIO.read(new File("ProjetF/model/images/solnoir.png"));
        }
        catch(IOException e){

        }
        //super.icoObj=new ImageIcon(getClass().getResource("/images/solnoir.png"));
        //super.imgObj=super.icoObj.getImage();

    }

}
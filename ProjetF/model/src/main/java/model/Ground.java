package model;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 *
 *		This class manages all about ground object
 */

public class Ground extends Objet{

    /**
     *
     * @param x
     * the x coordinate
     * @param y
     * the x coordinate
     * @see Objet
     */

    public Ground(int x, int y) {
        super(x, y, 32,32);
        try {
            BufferedImage bigImg = ImageIO.read(new File("ProjetF/model/images/sol.png"));
        }
        catch(IOException e){

        }
        //super.icoObj=new ImageIcon(getClass().getResource("/images/sol.png"));
        //super.imgObj=super.icoObj.getImage();
    }

}
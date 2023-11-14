package model;

import javax.swing.ImageIcon;

/**
 *

 *		the class Objet
 */
public class Wall extends Objet{
    /**
     *
     * @param x
     * the x coordinate
     * @param y
     * the y coordinate
     */
    public Wall(int x, int y) {
        super(x, y, 32, 32);
        super.icoObj=new ImageIcon("/images/mur.png");
        super.imgObj=super.icoObj.getImage();
    }

}
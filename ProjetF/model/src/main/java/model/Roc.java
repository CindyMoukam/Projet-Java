package model;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;


/**
 *

 *		the class Roc
 */
public class Roc extends Objet{


    public Roc(int x, int y) {
        super(x, y, 32,32);
        super.icoObj=new ImageIcon("/images/roche.png");
        super.imgObj=super.icoObj.getImage();
        super.falling=false;
        super.velocity=0;

        Timer time =new Timer();
        TimerTask task= new TimerTask() {

            @Override
            public void run() {
                if(falling==false) {

                    setImgObj2("rocher_droite");
                    try {Thread.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}
                    setImgObj2("rocher_gauche");
                    try {Thread.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}

                }

            }
        };
        time.schedule(task, 10,640);

    }
    /**
     *
     * @param nom
     * the name of the image for the roc animation
     */
    public void setImgObj2(String nom) {
        String str="/images/" +nom+ ".png";
        super.icoObj=new ImageIcon(str);
        super.imgObj = super.icoObj.getImage();

    }

}
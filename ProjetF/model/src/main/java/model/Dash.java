package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 *
 *		This class manages the heros of the video game
 */

public class Dash extends Character{

    /**Tell if the character is walking down or left or right or up down*/
    private boolean walksright,walksleft,walksdown,walksup;

    private int compteur;
    /**The score of the character */
    private int score;
    /**Tells if the character is doing nothing*/
    private boolean rest;

    Image image;
    int countanimation=0;
    /**
     *
     * @param x
     * the x coordinate
     * @param y
     * the y coordinate
     * @see Character
     */

    public Dash(int x, int y)  {
        super(x, y,32,32);
        this.score=0;
        try {
            BufferedImage bigImg = ImageIO.read(new File("ProjetF/model/images/Dash.png"));
        }
        catch(IOException e){

        }
        //super.icoChar = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/Dash.png")));
        //super.icoChar=new ImageIcon(Objects.requireNonNull(getClass().getResource("ProjetF/model/images/Dash.png")));
        //super.imgChar=super.icoChar.getImage();
        super.walks=false;
        this.walksleft=false;
        this.walksright=false;
        this.walksup=false;
        this.walksdown=false;
        this.rest=true;
        this.compteur=0;
        Timer time=new Timer();
        TimerTask task=new TimerTask() {

            @Override
            public void run() {
                if(death==true) {
                    setImgObj("1");
                    try {Thread.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}
                    setImgObj("2");
                    try {Thread.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}
                }
            }

        };
        time.schedule(task,10,640);

        Timer time2=new Timer();
        TimerTask task2=new TimerTask() {

            @Override
            public void run() {

                if(death==true) {

                    if(countanimation<7) {
                        setY(getY()-10);
                        countanimation++;
                    }else {
                        setY(getY()+10);
                    }

                }

            }

        };
        time2.schedule(task2,10,100);

        Timer time3=new Timer();
        TimerTask task3=new TimerTask() {

            @Override
            public void run() {
                if(rest==true && death==false) {
                    setImgObj2("Dash");
                    try {Thread.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}
                    setImgObj2("persoface2");
                    try {Thread.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}

                }
            }

        };
        time3.schedule(task3,10,640);
    }

    /**
     *
     * @param num
     * 		to put an image
     */

    public void setImgObj(String num) {
        String str="/images/persomort" + num+ ".png";
        super.icoChar=new ImageIcon(getClass().getResource(str));
        super.imgChar = super.icoChar.getImage();

    }
    /**
     *
     * @param nom
     * 		to put an image also
     */

    public void setImgObj2(String nom) {
        String str="/images/" +nom+ ".png";
        //super.icoChar=new ImageIcon(getClass().getResource(str));
        //super.imgChar = super.icoChar.getImage();

    }

    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }
    /**
     *
     * @return walksright
     *
     */

    public boolean getWalksright() {
        return walksright;
    }

    /**
     *
     * @param walksright
     * setter for walksright
     */
    public void setWalksright(boolean walksright) {
        this.walksright = walksright;
    }

    /**
     *
     * @return walksleft
     *
     */

    public boolean getWalksleft() {
        return walksleft;
    }
    /**
     *
     * @param walksleft
     * setter for walksleft
     */
    public void setWalksleft(boolean walksleft) {
        this.walksleft = walksleft;
    }

    /**
     *
     * @return walksdown
     *
     */

    public boolean getWalksdown() {
        return walksdown;
    }
    /**
     *
     * @param walksdown
     * setter for walksdown
     */
    public void setWalksdown(boolean walksdown) {
        this.walksdown = walksdown;
    }

    /**
     *
     * @return walksup
     *
     */

    public boolean getWalksup() {
        return walksup;
    }
    /**
     *
     * @param walksup
     * setter for walksup
     */
    public void setWalksup(boolean walksup) {
        this.walksup = walksup;
    }

    /**
     *
     * @return score
     *
     */

    public int getScore() {
        return score;
    }

    /**
     *
     * @param score
     * setter for the score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @param frequence the value of the frequence
     * @return
     */

    // public Image Imagewalk(int frequence) {
        //String str ="C:/Users/SOFT/Desktop/Projet Java/ProjetF/model/images/Dash.png";
        //Image img;
        //ImageIcon ico = new ImageIcon(getClass().getResource(str));
        //img =ico.getImage();

    public BufferedImage Imagewalk(int frequence) {
        String str = "C:/Users/SOFT/Desktop/Projet Java/ProjetF/model/images/Dash.png";
        Image img;
        File file = new File(str);
        try {
            URL url = file.toURI().toURL();
            ImageIcon ico = new ImageIcon(url);
            img = ico.getImage();
        } catch (MalformedURLException e) {
            // Gérer l'exception si l'URL est mal formée
            e.printStackTrace();
            // Ou lancer une nouvelle exception appropriée
        }
        //return img;

        if(this.walks==false) {
            //str="C:/Users/SOFT/Desktop/Projet Java/ProjetF/model/images/Dash.png";
        }else {
            this.compteur++;
            if(this.compteur/frequence==0) {
                if(this.walksright) {
                    str="/images/Dasharretdroit.png";
                }else if(this.walksleft) {
                    str="/images/Dasharretgauche.png";
                }else if(this.walksup) {
                    str="/images/Dashcreusegauche.png";
                }else if(this.walksdown){
                    str="/images/Dashcreusegauchebas.png";
                }

            }else {
                if(this.walksright) {
                    str="/images/Dashmarchedroitemain.png";
                }else if(this.walksleft) {
                    str="/images/Dashmarchegauchemain.png";
                }else if(this.walksup) {
                    str="/images/DashcreuseDroite.png";
                }else if(this.walksdown) {
                    str="/images/Dashcreusedroitebas.png";
                }
                if(this.compteur==2*frequence) {
                    this.compteur=0;
                }
            }
        }

        //return img;
        return null;
    }


    /**
     *
     * @return rest
     * 		when the heros don't move
     */

    public boolean isRest() {
        return rest;
    }
    /**
     *
     * @param rest
     * setter for rest
     */
    public void setRest(boolean rest) {
        this.rest = rest;
    }
    /**
     *
     * @param objet
     * the object to test the collison with
     * @return true or false if the heros is in life or death
     */

    public boolean verifyDashLife(Objet objet) {
        if(this.x==objet.getX() && this.y-32==objet.getY()  && objet.velocity>0) {
            return true;
        }else {
            return false;
        }
    }
}
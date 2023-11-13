package view;

/**

 * The Class Refresh5.

 */

public class Refresh5 implements Runnable{

    /**
     * @see Refresh
     */

    private final int PAUSE=3;
    @Override
    public void run() {
        while(true) {
            ViewFrame.panel5.repaint();
            try {Thread.sleep(PAUSE);} catch (InterruptedException e) {e.printStackTrace();}

        }
    }

}
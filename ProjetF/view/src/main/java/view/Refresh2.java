package view;

/**

 * The Class Refresh2.

 */

public class Refresh2 implements Runnable{

    /**
     * @see Refresh
     */

    private final int PAUSE=3;

    @Override
    public void run() {
        while(true) {
            ViewFrame.panel2.repaint();
            try {Thread.sleep(PAUSE);} catch (InterruptedException e) {	e.printStackTrace();}

        }
    }
}
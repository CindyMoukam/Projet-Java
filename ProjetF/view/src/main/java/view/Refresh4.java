package view;

/**

 * The Class Refresh4.

 */

public class Refresh4 implements Runnable{

    /**
     * @see Refresh
     */

    private final int PAUSE=3;
    @Override
    public void run() {
        while(true) {
            ViewFrame.panel4.repaint();
            try {Thread.sleep(PAUSE);} catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}
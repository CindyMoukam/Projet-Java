package view;

/**

 * The Class Refresh.

 */
public class Refresh implements Runnable{

    /**
     * The pause parameter defines the delay of refreshment
     */

    private final int PAUSE=3;


    @Override
    public void run() {
        while(true) {
            ViewFrame.panel1.repaint();
            try {Thread.sleep(PAUSE);} catch (InterruptedException e) {e.printStackTrace();}

        }
    }
}
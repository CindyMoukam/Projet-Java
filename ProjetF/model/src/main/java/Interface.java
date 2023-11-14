import model.DAOTest;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Interface extends JFrame {

    int WIDTH = 830;
    int HEIGHT = 645;

    DAOTest dao = new DAOTest();
    List<Tuile> tuiles = dao.open();
    JPanel mapPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));

    public Interface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Demo");
        setSize(WIDTH, HEIGHT);

        for(Tuile tuile : tuiles){
            JLabel label = new JLabel(new ImageIcon(tuile.getImage()),SwingConstants.CENTER);
            mapPanel.add(label);
        }

        add(mapPanel);

        setLocationRelativeTo(null);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            Interface interface1 = new Interface();
            interface1.setVisible(true);
        });
    }
}

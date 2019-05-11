import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class BoardPanel extends JPanel {

    private Board brd;

    public BoardPanel() {
        setBounds(0, 0, 600, 400);
    }

    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double rec;
        for (int i = 0; i < Board.getHEIGHT(); i++)
            for (int j = 0; j < Board.getWIDTH(); j++) {
                switch (this.brd.getBoard()[i][j].getStatus()) {
                    case 1:
                        g2.setPaint(Color.DARK_GRAY);
                        break;
                    case 2:
                        g2.setPaint(Color.CYAN);
                        break;
                    case 3:
                        g2.setPaint(Color.red);
                        break;
                    case 4:
                        g2.setPaint(Color.yellow);
                        break;
                }
                rec = new Rectangle2D.Double(100 + 27 * j, 100 + 26 * i, 25, 25);
                g2.fill(rec);
            }
    }

    public Board getBrd() {
        return brd;
    }

    public void setBrd(Board brd) {
        this.brd = brd;
    }


}

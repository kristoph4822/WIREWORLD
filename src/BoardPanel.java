import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class BoardPanel extends JPanel {

    private Board brd;

    private static final int CELL_SIZE = 20;
    private static final int BOARD_PANEL_BOARDERS = 40;

    //wysokość i szerokość panelu w pikselach
    private static final int BOARD_PANEL_WIDTH = Board.getWIDTH()*(CELL_SIZE+2) + BOARD_PANEL_BOARDERS;
    private static final int BOARD_PANEL_HEIGHT = (Board.getHEIGHT()+1)*(CELL_SIZE+2) + BOARD_PANEL_BOARDERS*2;


    public BoardPanel() {
        setBounds(0, 0, BOARD_PANEL_WIDTH, BOARD_PANEL_HEIGHT);
    }

    //rysowanie planszy
    public void paintComponent(Graphics g) {
        setBackground(Color.BLACK);

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
                rec = new Rectangle2D.Double(BOARD_PANEL_BOARDERS + (CELL_SIZE+2) * j,  BOARD_PANEL_BOARDERS + (CELL_SIZE+2) * i, CELL_SIZE, CELL_SIZE);
                g2.fill(rec);
            }
    }

    public Board getBrd() {
        return brd;
    }

    public void setBrd(Board brd) {
        this.brd = brd;
    }

    public static int getBoardPanelBoarders() {
        return BOARD_PANEL_BOARDERS;
    }


    public static int getBoardPanelWidth() {
        return BOARD_PANEL_WIDTH;
    }

    public static int getBoardPanelHeight() {
        return BOARD_PANEL_HEIGHT;
    }


    public static int getCellSize() {
        return CELL_SIZE;
    }




}

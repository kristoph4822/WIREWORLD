import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ContainerPanel extends JPanel implements ActionListener, MouseListener {

    private ButtonPanel btnpanel = new ButtonPanel();
    private BoardPanel brdpanel = new BoardPanel();

    public ContainerPanel(){

        setBackground(getBackground());
        setBounds(0,0,1000,550);
        setLayout(null);

        btnpanel.getNextGen().addActionListener(this);
        btnpanel.getSave2File().addActionListener(this);
        btnpanel.getClear().addActionListener(this);
        btnpanel.getTypeBTN().addActionListener(this);
        brdpanel.addMouseListener(this);

        this.add(btnpanel);
        this.add(brdpanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnpanel.getSave2File()) {
            brdpanel.getBrd().print2file("Saved_Generation.txt");
        }
        else if (e.getSource() == btnpanel.getNextGen()) {
            genGenerator.generateNext(brdpanel.getBrd());
            brdpanel.paintComponent(getGraphics());

        }
        else if (e.getSource() == btnpanel.getClear()) {
            for (int i = 0; i < Board.getHEIGHT(); i++)
                for (int j = 0; j < Board.getWIDTH(); j++)
                    brdpanel.getBrd().setCell(new Cell(), i, j);
            brdpanel.paintComponent(getGraphics());
        }
        else if (e.getSource() == btnpanel.getTypeBTN()) {

            if (btnpanel.getTypeBTN().getText() == "Electron Head") {
                btnpanel.getTypeBTN().setText("Connector");
                btnpanel.getTypeBTN().setBackground(Color.YELLOW);

            } else if (btnpanel.getTypeBTN().getText() == "Connector") {
                btnpanel.getTypeBTN().setText("Electron Tail");
                btnpanel.getTypeBTN().setBackground(Color.red);

            } else if (btnpanel.getTypeBTN().getText() == "Electron Tail") {
                btnpanel.getTypeBTN().setText("Electron Head");
                btnpanel.getTypeBTN().setBackground(Color.cyan);
            }


        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < Board.getWIDTH(); i++) {
            if (e.getX() >= BoardPanel.getBoardPanelBoarders() + (BoardPanel.getCellSize()+2) * i && e.getX() <= BoardPanel.getBoardPanelBoarders() + (BoardPanel.getCellSize()+2) * i + BoardPanel.getCellSize()) {
                for (int j = 0; j < Board.getHEIGHT(); j++) {
                    if (e.getY() >= BoardPanel.getBoardPanelBoarders() + (BoardPanel.getCellSize()+2) * j && e.getY() <= BoardPanel.getBoardPanelBoarders() + (BoardPanel.getCellSize()+2) * j + BoardPanel.getCellSize()) {
                        int st = brdpanel.getBrd().getCell(j, i).getStatus();
                        if (st == 1) {
                            switch(btnpanel.getTypeBTN().getText()){
                                case "Connector": brdpanel.getBrd().setCell(new Cell(4), j, i); break;
                                case "Electron Tail": brdpanel.getBrd().setCell(new Cell(3), j, i); break;
                                case "Electron Head": brdpanel.getBrd().setCell(new Cell(2), j, i); break;
                            }
                        } else {
                            brdpanel.getBrd().setCell(new Cell(1), j, i);
                        }
                    }
                }
            }
        }
        brdpanel.paintComponent(getGraphics());
    }

    public BoardPanel getBrdpanel() {
        return brdpanel;
    }


}

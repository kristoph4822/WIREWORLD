import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

public class Container extends JPanel implements ActionListener, MouseListener {

    Board brd;
    public JButton NextGen = new JButton("Next Generation");
    public JButton Save2File = new JButton("Save to file");
    public JButton Clear = new JButton("Clear");
    public JButton TypeBTN = new JButton("Connector");

    public Container(Board b) {
        this.brd = b;
        NextGen.addActionListener(brd);
        NextGen.addActionListener(this);
        Save2File.addActionListener(this);
        addMouseListener(this);
        Clear.addActionListener(this);
        TypeBTN.addActionListener(this);
    }
    public void paintComponent(Graphics g) {

        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double rec;
        for (int i = 0; i < brd.getHEIGHT(); i++)
            for (int j = 0; j < brd.getWIDTH(); j++) {
                switch (brd.getBoard()[i][j].getStatus()) {
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
                        g2.setPaint(Color.YELLOW);
                        break;
                }
                rec = new Rectangle2D.Double(100 + 27 * j, 100 + 26 * i, 25, 25);
                g2.fill(rec);
            }

        NextGen.setBounds(750, 100, 150, 50);
        this.add(NextGen);
        Save2File.setBounds(750, 175, 150, 50);
        this.add(Save2File);
        Clear.setBounds(750, 250, 150, 50);
        this.add(Clear);
        TypeBTN.setBounds(750,325, 150, 50);
        this.add(TypeBTN);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Save2File) {
            this.brd.print2file("Saved_Generation.txt");
        } else if (e.getSource() == NextGen) {
            this.repaint();
        } else if (e.getSource() == Clear) {
            for (int i = 0; i < Board.getHEIGHT(); i++)
                for (int j = 0; j < Board.getWIDTH(); j++)
                    brd.setCell(new Cell(), i, j);
        repaint();
        }
        else if (e.getSource() == TypeBTN) {

            if (TypeBTN.getText() == "Electron Head") {
                TypeBTN.setText("Connector");

            }
            else if (TypeBTN.getText() == "Connector") {
                TypeBTN.setText("Electron Tail");
            }

            else if (TypeBTN.getText() == "Electron Tail") {
                TypeBTN.setText("Electron Head");
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
            if (e.getX() >= 100 + 27 * i && e.getX() <= 100 + 27 * i + 25) {
                for (int j = 0; j < Board.getHEIGHT(); j++) {
                    if (e.getY() >= 100 + 26 * j && e.getY() <= 100+ 26 * j + 25) {
                        int st = brd.getCell(j, i).getStatus();
                        if (st == 1) {
                            switch(TypeBTN.getText()){
                                case "Connector": brd.setCell(new Cell(4), j, i); break;
                                case "Electron Tail": brd.setCell(new Cell(3), j, i); break;
                                case "Electron Head": brd.setCell(new Cell(2), j, i); break;
                            }
                        } else {
                            brd.setCell(new Cell(1), j, i);
                        }
                    }
                }
            }
        }
        this.repaint();
    }

}



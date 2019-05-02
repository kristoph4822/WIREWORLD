import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class WWPanel extends JPanel implements ActionListener {

    Board brd;
    public JButton NextGen = new JButton("Next Generation");
    public JButton Save2File = new JButton("Save to file");

    public WWPanel(Board b){
        this.brd = b;
        this.setBackground(Color.GRAY);
    }

    public void paintComponent (Graphics g){

        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        Graphics2D g2 = (Graphics2D)g;
        Rectangle2D.Double rec;
        for(int i=0; i<brd.getHEIGHT(); i++)
            for(int j = 0; j<brd.getWIDTH(); j++){
                switch(brd.getBoard()[i][j].getStatus()){
                    case 1: g2.setPaint(Color.BLACK); break;
                    case 2: g2.setPaint(Color.CYAN); break;
                    case 3: g2.setPaint(Color.red); break;
                    case 4: g2.setPaint(Color.YELLOW); break;
                }
                rec = new Rectangle2D.Double(100+27*j, 100+26*i, 25,25 );
                g2.fill(rec);}

        NextGen.setBounds(750,150, 150, 50);
        this.add(NextGen);
        Save2File.setBounds(750, 250, 150, 50);
        this.add(Save2File);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.brd.print2file("Saved_Generation.txt");
    }
}



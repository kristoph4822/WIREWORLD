import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WWFrame extends JFrame implements ActionListener {

    public WWFrame(Board brd){

        WWPanel panel = new WWPanel(brd);
        panel.setBackground(Color.GRAY);
        add(panel);

        setTitle("Wire World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1000,600);

        panel.NextGen.addActionListener(brd);
        panel.NextGen.addActionListener(this);
        panel.Save2File.addActionListener(panel);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }
}

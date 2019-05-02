import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WWFrame extends JFrame {

    WWPanel panel;

    public WWFrame(Board brd){

        panel = new WWPanel(brd);
        panel.setBackground(Color.BLACK);
        add(panel);

        setTitle("Wire World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1000,550);

    }
}

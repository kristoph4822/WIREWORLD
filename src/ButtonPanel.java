import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private JButton NextGen = new JButton("Next Generation");
    private JButton Save2File = new JButton("Save to file");
    private JButton Clear = new JButton("Clear");
    private JButton TypeBTN = new JButton("Connector");


    public ButtonPanel() {

        setBackground(Color.lightGray);
        setBounds(700, 50, 250, 400);
        setLayout(new FlowLayout());

        this.add(NextGen);
        this.add(Save2File);
        this.add(Clear);
        this.add(TypeBTN);

    }

    public JButton getNextGen() {
        return NextGen;
    }

    public JButton getSave2File() {
        return Save2File;
    }

    public JButton getClear() {
        return Clear;
    }

    public JButton getTypeBTN() {
        return TypeBTN;
    }

}

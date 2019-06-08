import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class ButtonPanel extends JPanel {

    private WWButton NextGen;
    private WWButton Save2File;
    private WWButton Clear;
    private WWButton TypeBTN;

    private BufferedImage image;

    private static final int BUTTON_PANEL_BOARDERS = 100;
    private static final int BUTTON_PANEL_WIDTH = WWButton.getButtonWidth()+(2*BUTTON_PANEL_BOARDERS);


    public ButtonPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBounds(WWFrame.getWindowWidth() - BUTTON_PANEL_WIDTH, 0 , BUTTON_PANEL_WIDTH , BoardPanel.getBoardPanelHeight());
        setBackground(Color.BLACK);

        int x = WWFrame.getWindowWidth() - ButtonPanel.getButtonPanelWidth() + 50;

        add(Box.createRigidArea(new Dimension(BUTTON_PANEL_BOARDERS + 15, 200)));
        this.add(NextGen = new WWButton("Next Generation", x, 100));

        add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(Save2File = new WWButton("Save to file",x , 200));

        add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(Clear = new WWButton("Clear", x, 300));

        add(Box.createRigidArea(new Dimension(0, 50)));
        TypeBTN = new WWButton("Connector", x , 400);
        TypeBTN.setBackground(Color.YELLOW);
        TypeBTN.setMinimumSize(new Dimension(150, 50));
        this.add(TypeBTN);

        add(Box.createRigidArea(new Dimension(0, 100)));

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            image = ImageIO.read(this.getClass().getResource("resources/wireworld.png"));
            Image scaledImage = image.getScaledInstance(this.getWidth()-40, 55 ,Image.SCALE_SMOOTH);
            g.drawImage(scaledImage, 15, 80, this);
        } catch (IOException ex) {
            System.exit(-6);
        }


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

    public static int getButtonPanelWidth() {
        return BUTTON_PANEL_WIDTH;
    }

}

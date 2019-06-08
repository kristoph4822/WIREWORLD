
import javax.swing.*;
import java.awt.*;

public class WWFrame extends JFrame {

    ContainerPanel container;

    private static final int WINDOW_WIDTH = BoardPanel.getBoardPanelWidth() + ButtonPanel.getButtonPanelWidth();
    private static final int WINDOW_HEIGHT = BoardPanel.getBoardPanelHeight();


    public WWFrame() {

        setTitle("Wire World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setVisible(true);
        this.container = new ContainerPanel();
    }

    public void start(){
        container.setBackground(Color.BLACK);
        add(container);
    }

    public ContainerPanel getContainer() {
        return container;
    }

    public static int getWindowWidth() {
        return WINDOW_WIDTH;
    }

    public static int getWindowHeight() {
        return WINDOW_HEIGHT;
    }
}

import javax.swing.*;
import java.awt.*;

public class WWButton extends JButton {

    private static final int BUTTON_WIDTH = 155;
    private static final int BUTTON_HEIGHT = 50;

    public WWButton(String txt, int x, int y){

        setBackground(Color.WHITE);
        setFont(new Font("Consolas", Font.BOLD, 14));
        setBorderPainted(true);
        setBounds(x, y, BUTTON_WIDTH, BUTTON_HEIGHT );
        setHorizontalAlignment(SwingConstants.CENTER);
        setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

        setText(txt);

    }


    public static int getButtonWidth() {
        return BUTTON_WIDTH;
    }

}

import javax.swing.*;
import java.awt.*;

public class WWFrame extends JFrame {

    Container2 container;

    public WWFrame() {

        setTitle("Wire World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 550);
        this.setVisible(true);
        this.container = new Container2();
    }

        public void start(){
            container.setBackground(Color.BLACK);
            add(container);
        }

    public Container2 getContainer() {
        return container;
    }
}


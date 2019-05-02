import java.awt.*;

public class Test {

    public static void main(String[] args) {

        Board x;

        if(args.length > 0 ) x = new Board(args[0]);
        else x = new Board("resources/" + "plik.txt");

        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                WWFrame game = new WWFrame(x);
            }
        });

    }



}

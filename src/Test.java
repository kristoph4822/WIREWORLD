import java.awt.*;

public class Test {

    public static void main(String[] args) {

        Board initial_board;

        if(args.length > 0 ) initial_board = new Board(args[0]);
        else initial_board = new Board("resources/" + "plik.txt");

        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                WWFrame game = new WWFrame();
                game.getContainer().getBrdpanel().setBrd(initial_board);
                game.start();
            }

        });

    }



}

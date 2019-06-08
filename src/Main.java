import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Board initial_board;

        if (args.length > 0) initial_board = new Board(args[0]);//wczytywanie tablicy początkowej
        else initial_board = new Board("resources/" + "file.txt");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                WWFrame game = new WWFrame();
                game.getContainer().getBrdpanel().setBrd(initial_board);
                //dodajemy tablicę początkową do gui.BoardPanel
                game.start();
            }

        });
    }
}

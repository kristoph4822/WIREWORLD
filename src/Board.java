import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Board {

    private final int WIDTH = 7;
    private final int HEIGHT = 3;

    private Cell[][] board = new Cell[getHEIGHT()][getWIDTH()];

    public Board(String file_name) throws FileNotFoundException {

        Scanner in = new Scanner(new File(file_name));

        for (int i = 0; i < getHEIGHT(); i++)
            for (int j = 0; j < getWIDTH(); j++) {
                this.setCell(new Cell(), i, j);
            }

        String line;
        String[] tokens;

        while (in.hasNextLine()) {
            line = in.nextLine();
            tokens = line.split(" ");

            if (tokens.length != 3 || Integer.parseInt(tokens[0]) < 1 || Integer.parseInt(tokens[0]) > 4) {
                throw new NoSuchElementException();
            }
            this.setCell(new Cell(Integer.parseInt(tokens[0])), Integer.parseInt(tokens[1]) - 1, Integer.parseInt(tokens[2]) - 1);
        }
    }

    public void print2screen() {

        for (int i = 0; i < getHEIGHT(); i++) {
            for (int j = 0; j < getWIDTH(); j++)
                System.out.printf("%4d", this.getBoard()[i][j].getStatus());
            System.out.println("\n");
        }
    }

    public Cell getCell(int x, int y) {
        return this.getBoard()[x][y];
    }

    public void setCell(Cell cell, int x, int y) {
        this.getBoard()[x][y] = cell;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }
}


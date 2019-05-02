import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Board implements ActionListener{

    private final int WIDTH = 20;
    private final int HEIGHT = 10;

    private Cell[][] board = new Cell[getHEIGHT()][getWIDTH()];

    public Board(String file_name) {

        try {

            InputStream ins = this.getClass().getClassLoader().getResourceAsStream(file_name);

            Scanner in = new Scanner(ins);

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

        catch (NullPointerException e) {
            System.out.println("Nie znaleziono pliku do odczytu.");
            System.exit(-1);}

        catch (NoSuchElementException e) {
        System.out.println("Zły format danych w pliku.");
        System.exit(-2);}

        catch (NumberFormatException e) {
        System.out.println("Nieprawidłowe dane w pliku.");
        System.exit(-3);}

        catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Współrzędne punktów w pliku nie zgadzają się z wymiarami tablicy.");
        System.exit(-4);}
}


    public void print2file(String filename) {
        try {

        FileWriter prt = new FileWriter(filename);

        for (int i = 0; i < getHEIGHT(); i++) {
            for (int j = 0; j < getWIDTH(); j++) {
                if (this.board[i][j].getStatus() != 1) {
                    prt.write(this.getCell(i, j).getStatus() + " " + (i+1) + " " + (j+1) + "\n");
                }
            }
        }
         prt.close();

        }
        catch(IOException e){
            System.out.println("Nie można otworzyć pliku do zapisu.");
            System.exit(-5);}

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

    @Override
    public void actionPerformed(ActionEvent e) {
        genGenerator.generateNext(this);
    }
}


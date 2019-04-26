import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class Test {

    public static void main(String[] args) {

        try {
            Board x = new Board("src/plik1");
            genGenerator.nextGeneration(x);
            genGenerator.nextGeneration(x);
            genGenerator.nextGeneration(x);
            genGenerator.nextGeneration(x);

            x.print2screen();


        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku do odczytu.");
        }

        catch (NoSuchElementException e) {
            System.out.println("Zły format danych w pliku do odczytu.");}

    }
}

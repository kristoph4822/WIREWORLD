import org.junit.Assert;
import org.junit.Test;

public class CellTest extends Cell {

    @org.junit.Test
    public void TestsetStatus() {
        Cell TestCell = new Cell();
        TestCell.setStatus(3);
        Assert.assertEquals(3,TestCell.getStatus());
    }
    @Test
    public void TestgetStatus() {
        Cell TestCell = new Cell(2);
        Assert.assertEquals(2,TestCell.getStatus());
    }
}
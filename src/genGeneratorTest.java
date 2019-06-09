import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class genGeneratorTest extends genGenerator {

    @Test
    public void TestgenerateNext() {
    Board TestBoard;
    TestBoard = new Board("resources/" + "TestBoard.txt");
    Cell Cell_4 = new Cell(4);
    Cell Cell_1 = new Cell(1);
    Cell Cell_2 = new Cell(2);
    Cell Cell_3 = new Cell(3);
    TestBoard.getBoard()[1][1] = Cell_1;
    TestBoard.getBoard()[3][3] = Cell_2;
    TestBoard.getBoard()[5][5] = Cell_3;
    TestBoard.getBoard()[7][7] = Cell_4;
    generateNext(TestBoard);
    Assert.assertEquals(1, TestBoard.getCell(1,1).getStatus());
    Assert.assertEquals(3, TestBoard.getCell(3,3).getStatus());
    Assert.assertEquals(4, TestBoard.getCell(5,5).getStatus());
    Assert.assertEquals(4, TestBoard.getCell(7,7).getStatus());
    Assert.assertEquals(0, TestBoard.getCell(10,10).getStatus());
    }
}
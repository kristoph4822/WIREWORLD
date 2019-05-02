public class genGenerator {

    private static int nextStatus(Board b, int x, int y) {

        switch (b.getCell(x, y).getStatus()) {
            case 1:
                return 1;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                if (headNeighbours(b, x, y)== 1 || headNeighbours(b, x, y)== 2)
                    return 2;
                else
                    return 4;
            default:
                return 0;
        }
    }

    private static int headNeighbours(Board b, int x, int y){

        int i=0;
        if(x<b.getHEIGHT()-1) {
            if (b.getCell(x + 1, y).getStatus() == 2) i++;
            if (y<b.getWIDTH()-1) {
                if (b.getCell(x + 1, y + 1).getStatus() == 2) i++;
            }
            if (y>0) {
                if (b.getCell(x + 1, y - 1).getStatus() == 2) i++;
            }
            }
        if(y>0) {
            if (b.getCell(x, y - 1).getStatus() == 2) i++;
        }
        if(y<b.getWIDTH()-1) {
            if (b.getCell(x, y + 1).getStatus() == 2) i++;
        }
        if(x>0) {
            if (b.getCell(x -1, y).getStatus() == 2) i++;
            if (y<b.getWIDTH()-1) {
                if (b.getCell(x -1, y + 1).getStatus() == 2) i++;
            }
            if (y>0) {
                if (b.getCell(x -1, y - 1).getStatus() == 2) i++;
            }
        }
        return i;

    }

    public static void generateNext (Board b){

        Cell[][] tmp = new Cell[b.getHEIGHT()][b.getWIDTH()];

        for(int i=0; i< b.getHEIGHT();i++)
            for(int j=0; j< b.getWIDTH();j++){
                Cell c = new Cell (nextStatus(b, i, j));
                tmp[i][j] = c;
            }

        b.setBoard(tmp);


    }

}

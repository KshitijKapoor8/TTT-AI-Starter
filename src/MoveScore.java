
public class MoveScore {
    private int x;
    private int y;
    private int z;
    private int board;

    public MoveScore(int x, int y, int z, int board) {

    }

    public void gradeMove(int x, int y, int z, Board board, char player)
    {
        int count = 1;

        for (int i = 0; i < board.numCols(); i++)
        {
            if (board.getData()[new Location(x, y, z).getSheet()][new Location(x, y, z).getRow()][i] == player)
            {
                count++;
            }
        }
    }
}

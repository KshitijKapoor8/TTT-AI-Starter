public class MoveScore {
    private int x;
    private int y;
    private int z;
    private int board;

    public MoveScore(int x, int y, int z, int board) {

    }

    public int gradeMove(int x, int y, int z, Board board, char player, char opponent)
    {
        int my4s = 0;
        int count = 1;

        for (int i = 0; i < board.numCols(); i++)
        {
            if (board.getData()[new Location(x, y, z).getSheet()][new Location(x, y, z).getRow()][i] == player)
            {
                count++;
            }
            else if (board.getData()[new Location(x, y, z).getSheet()][new Location(x, y, z).getRow()][i] == opponent)
            {
                count = 0;
                break;
            }
        }
        if (count == 3)
        {
            my4s++;
        }
        return my4s;

    }
}

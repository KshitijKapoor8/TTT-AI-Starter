import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Test_AI_3 implements PlayerInt
{
    private char letter;
    private String name;

    // Pre:		receives a char letter
    // Post: 	sets the name to "Random AI" and the letter to the letter received
    Test_AI_3(char letter)
    {
        name 		= "ScoreTest1";
        this.letter	= letter;
    }

    public char getLetter()
    {
        return letter;
    }

    // Pre:		method is called
    // Post: 	returns the Location where the player wants to move
    public Location getMove(Board board)
    {
        Location l;
        Location greatest = new Location(0, 0, 0);
        Random rand = new Random();
        int[][][] compare = new int[4][4][4];
        for (int x = 0; x < board.getData().length; x++)
        {
            for (int y = 0; y < board.getData()[0].length; y++)
            {
                for (int z = 0 ; z < board.getData()[0][0].length; z++)
                {
                    compare[x][y][z] = gradeMove(x, y, z, board, 'x', 'o');
                }
            }
        }

        for (int x = 0; x < compare.length; x++)
        {
            for (int y = 0; y < compare[0].length; y++)
            {
                for (int z = 0 ; z < compare[0][0].length; z++)
                {

                }
            }
        }
        return l;
    }

    // Pre:		method is called
    // Post: 	returns the name of the player
    public String getName()
    {
        return name;
    }

    public PlayerInt freshCopy()
    {
        return new Test_AI_1(letter);
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
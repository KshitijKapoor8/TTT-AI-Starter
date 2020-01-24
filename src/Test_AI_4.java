import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Test_AI_4 implements PlayerInt
{
    private char letter;
    private String name;

    // Pre:		receives a char letter
    // Post: 	sets the name to "Random AI" and the letter to the letter received
    Test_AI_4(char letter)
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
//        Random rand = new Random();
//        ArrayList<Integer> test = new ArrayList<>();
//
//        System.out.println(greatest);
//        System.out.println(compare[greatest.getSheet()][greatest.getRow()][greatest.getCol()]);
        l = greatest;
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

    public Board gradeBoard(Board board)
    {

        int[][][] compare = new int[4][4][4];
        Location greatest = new Location(0, 0, 0);
        for (int x = 0; x < board.getData().length; x++)
        {
            for (int y = 0; y < board.getData()[0].length; y++)
            {
                for (int z = 0 ; z < board.getData()[0][0].length; z++) {
                    if (board.getData()[x][y][z] == 'x' || board.getData()[x][y][z] == 'o')
                    {
                        continue;
                    }
                    compare[x][y][z] = gradeMove(new Location(x, y, z), board, 'x', 'o');
                }
            }
        }

        for (int x = 0; x < compare.length; x++)
        {
            for (int y = 0; y < compare[0].length; y++)
            {
                for (int z = 0 ; z < compare[0][0].length; z++)
                {
                    if (compare[x][y][z] >= compare[greatest.getCol()][greatest.getRow()][greatest.getSheet()] && (board.getData()[x][y][z] != 'x' || board.getData()[x][y][z] != 'o'))
                    {
                        System.out.println(board.getData()[x][y][z]);
                        greatest = new Location(x, y, z);
                    }
                }
            }
        }

        return board;
    }
    public int gradeMove(Location l, Board board, char player, char opponent)
    {
        if (board.getData()[l.getSheet()][l.getRow()][l.getCol()] == '-')
        {
            int my4s = 0;
            int my3s = 0;
            int my2s = 0;
            int count = 1;
            int totalScore = 0;

            for (int i = 0; i < board.numCols(); i++) {
                if (board.getData()[l.getSheet()][l.getRow()][i] == player) {
                    System.out.println("here");
                    count++;
                } else if (board.getData()[l.getSheet()][l.getRow()][i] == opponent) {
                    System.out.println("bad");
                    count = 0;
                    break;
                }
                if (count == 3) {
                    my4s++;
                } else if (count == 2) {
                    my3s++;
                } else if (count == 1) {
                    my2s++;
                }
            }

            for (int i = 0; i < board.numRows(); i++) {
                if (board.getData()[l.getSheet()][i][l.getCol()] == player) {
                    System.out.println("here");
                    count++;
                } else if (board.getData()[l.getSheet()][i][l.getCol()] == opponent) {
                    System.out.println("bad");
                    count = 0;
                    break;
                }
                if (count == 3) {
                    my4s++;
                } else if (count == 2) {
                    my3s++;
                } else if (count == 1) {
                    my2s++;
                }
            }



            return (my4s * 100) + (my3s * 10) + (my2s * 3);
        }
        else
        {
            return 0;
        }
    }
}
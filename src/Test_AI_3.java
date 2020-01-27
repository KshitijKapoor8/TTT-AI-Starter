import javax.rmi.ssl.SslRMIClientSocketFactory;
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
        ArrayList<Integer> test = new ArrayList<>();
        int[][][] compare = new int[4][4][4];

        int count = 0;
        for (int x = 0; x < board.getData().length; x++)
        {
            for (int y = 0; y < board.getData()[0].length; y++)
            {
                for (int z = 0 ; z < board.getData()[0][0].length; z++) {
                    if (board.getData()[x][y][z] != '-')
                    {
                        count++;
                    }
                }
            }
        }
        if (count == 0)
        {
            return new Location(1,2,3);
        }

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
                    test.add(compare[x][y][z]);
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
                        greatest = new Location(x, y, z);
                    }
                }
            }
        }

        System.out.println(greatest);
        System.out.println(compare[greatest.getSheet()][greatest.getRow()][greatest.getCol()]);
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

    public int gradeMove(Location l, Board board, char player, char opponent)
    {
        if (board.getData()[l.getSheet()][l.getRow()][l.getCol()] == '-')
        {
            int my4s = 0;
            int my3s = 0;
            int my2s = 0;
            int count1 = 1;
            int count2 = 1;
            int count3 = 1;
            int totalScore = 0;

            for (int i = 0; i < board.numCols(); i++) {
                if (board.getData()[l.getSheet()][l.getRow()][i] == player) {
                    System.out.println("here");
                    count1++;

                } else if (board.getData()[l.getSheet()][l.getRow()][i] == opponent) {
                    count1 = 0;
                    break;
                }

            }

            for (int i = 0; i < board.numRows(); i++) {
                if (board.getData()[l.getSheet()][i][l.getCol()] == player) {
                    System.out.println("here");
                    count2++;

                } else if (board.getData()[l.getSheet()][i][l.getCol()] == opponent) {
                    System.out.println("bad");
                    count2 = 0;
                    break;
                }

            }

            for (int i = 0; i < board.numSheets(); i++) {
                if (board.getData()[i][l.getRow()][l.getCol()] == player) {
                    System.out.println("here");
                    count3++;

                } else if (board.getData()[i][l.getRow()][l.getCol()] == opponent) {
                    System.out.println("bad");
                    count3 = 0;
                    break;
                }
            }
            if (count1 == 4) {
                my4s++;
            } else if (count1 == 3) {
                my3s++;
            } else if (count1 == 2) {
                my2s++;
            }
            if (count2 == 4) {
                my4s++;
            } else if (count2 == 3) {
                my3s++;
            } else if (count2 == 2) {
                my2s++;
            }
            if (count3 == 4) {
                my4s++;
            } else if (count3 == 3) {
                my3s++;
            } else if (count3 == 2) {
                my2s++;
            }
            return (my4s * 100) + (my3s * 20) + (my2s * 7);
        }
        else
        {
            return -1;
        }
    }
}
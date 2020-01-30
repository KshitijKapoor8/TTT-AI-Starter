import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.nio.file.ClosedWatchServiceException;
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
        return lookAhead(board, 0);
//        Location l;
//        Location greatest = new Location(0, 0, 0);
//        Random rand = new Random();
//        ArrayList<Integer> test = new ArrayList<>();
//        int[][][] compare = new int[4][4][4];
//
//        int count = 0;
//        for (int x = 0; x < board.getData().length; x++)
//        {
//            for (int y = 0; y < board.getData()[0].length; y++)
//            {
//                for (int z = 0 ; z < board.getData()[0][0].length; z++) {
//                    if (board.getData()[x][y][z] != '-')
//                    {
//                        count++;
//                    }
//                }
//            }
//        }
//        if (count == 0)
//        {
//            return new Location(1,2,3);
//        }
//
//        for (int x = 0; x < board.getData().length; x++)
//        {
//            for (int y = 0; y < board.getData()[0].length; y++)
//            {
//                for (int z = 0 ; z < board.getData()[0][0].length; z++) {
//                    if (board.getData()[x][y][z] == 'X' || board.getData()[x][y][z] == 'O')
//                    {
//                        continue;
//                    }
//                    compare[x][y][z] = gradeMove(new Location(x, y, z), board, getLetter(), 'O');
//                    test.add(compare[x][y][z]);
//                }
//            }
//        }
//
//        for (int x = 0; x < compare.length; x++)
//        {
//            for (int y = 0; y < compare[0].length; y++)
//            {
//                for (int z = 0 ; z < compare[0][0].length; z++)
//                {
//                    if (compare[x][y][z] >= compare[greatest.getCol()][greatest.getRow()][greatest.getSheet()] && (board.getData()[x][y][z] != 'X' || board.getData()[x][y][z] != 'O'))
//                    {
//                        greatest = new Location(x, y, z);
//                    }
//                }
//            }
//        }
//
//        System.out.println(greatest);
//        System.out.println(compare[greatest.getSheet()][greatest.getRow()][greatest.getCol()]);
//        l = greatest;
//        return l;
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

    public int gradeBoard(Board board)
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
//        if (count == 0)
//        {
//            return new Location(1,2,3);
//        }

        for (int x = 0; x < board.getData().length; x++)
        {
            for (int y = 0; y < board.getData()[0].length; y++)
            {
                for (int z = 0 ; z < board.getData()[0][0].length; z++) {
                    if (board.getData()[x][y][z] == 'X' || board.getData()[x][y][z] == 'O')
                    {
                        continue;
                    }
                    if (getLetter() == 'X')
                        compare[x][y][z] = gradeMove(new Location(x, y, z), board, getLetter(), 'O');
                    else
                        compare[x][y][z] = gradeMove(new Location(x, y, z), board, getLetter(), 'X');

                    test.add(compare[x][y][z]);
                }
            }
        }
        int score = 0;
        for (int i = 0; i < test.size(); i++)
        {
            score += test.get(i);
        }
        return score;
    }

    public Location gradeBoardHighest(Board board)
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
                    if (board.getData()[x][y][z] == 'X' || board.getData()[x][y][z] == 'O')
                    {
                        continue;
                    }
                    compare[x][y][z] = gradeMove(new Location(x, y, z), board, getLetter(), 'O');
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
                    if (compare[x][y][z] >= compare[greatest.getCol()][greatest.getRow()][greatest.getSheet()] && (board.getData()[x][y][z] != 'X' || board.getData()[x][y][z] != 'O'))
                    {
                        greatest = new Location(x, y, z);
                    }
                }
            }
        }


        l = greatest;
        return l;
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
                    count1++;
                } else if (board.getData()[l.getSheet()][l.getRow()][i] == opponent) {
                    count1 = 0;
                    break;
                }

            }

            for (int i = 0; i < board.numRows(); i++) {
                if (board.getData()[l.getSheet()][i][l.getCol()] == player) {
                    count2++;
                    my2s++;
                } else if (board.getData()[l.getSheet()][i][l.getCol()] == opponent) {
                    count2 = 0;
                    break;
                }

            }

            for (int i = 0; i < board.numSheets(); i++) {
                if (board.getData()[i][l.getRow()][l.getCol()] == player) {
                    count3++;

                } else if (board.getData()[i][l.getRow()][l.getCol()] == opponent) {
                    count3 = 0;
                    break;
                }

            }

            System.out.println(my4s);

            if (my4s >= 1)
            {
                System.out.println("FOUND A 4\n" + my4s);

            }
            return (my4s * 1000) + (my3s * 100) + (my2s * 10);
        }
        else
        {
            return -1;
        }
    }

    public Location lookAhead(Board board, int num)
    {
        // Grade all possible moves
        Board clone;
        Board greatestBoard = board;
        Board leastBoard = board;
        int greatestBoardValue = gradeBoard(greatestBoard);
        int leastBoardValue = gradeBoard(leastBoard);


        for (int x = 0; x < board.getData().length; x++)
        {
            for (int y = 0; y < board.getData()[0].length; y++)
            {
                for (int z = 0; z < board.getData()[0][0].length; z++)
                {
                    if (board.getData()[x][y][z] == '-')
                    {
                        clone = (Board)board.clone();
                        clone.setLocation(new Location(z, y, x), getLetter());
                        int i = gradeBoard(clone);
                        if (i > greatestBoardValue)
                        {
                            greatestBoard = clone;
                            greatestBoardValue = i;
                        }
                        if (i < leastBoardValue)
                        {
                            leastBoard = clone;
                            leastBoardValue = i;
                        }
                    }
                }
            }
        }
        if (num == 6)
        {
            return gradeBoardHighest(greatestBoard);
        }
        return lookAhead(greatestBoard, num + 1);
    }
}
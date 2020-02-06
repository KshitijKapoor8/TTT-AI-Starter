import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Test_AI_5 implements PlayerInt
{
    private char letter;
    private String name;

    // Pre:		receives a char letter
    // Post: 	sets the name to "Random AI" and the letter to the letter received
    Test_AI_5(char letter)
    {
        name 		= "Shield_And_Spear";
        this.letter	= letter;
    }

    public char getLetter()
    {
        return letter;
    }

    // Pre:		method is called
    // Post: 	returns the Location where the player wants to move

    // Checks for two in a rows and returns the next move.
    public Location getMove(Board board)
    {
        boolean[] checkSpot = new boolean[26];
        Arrays.fill(checkSpot, true);
        boolean done = false;
        Location l = null;
        Random rand = new Random();
        do
        {

            if(l == null || !board.isEmpty(l) || losable(board) != null || dualWin(board) != null || dualLose(board) != null) {
                if(winnable(board) != null) {
                    l = winnable(board);
                }
                else if(losable(board) != null) {
                    l = losable(board);
                }
                else if(dualWin(board) != null) {
                    l = dualWin(board);
                }
                else if(dualLose(board) != null) {
                    l = dualLose(board);
                }
                else {
                   l = gradeBoardHighest(board);
                }
            }
            done=false;
        } while (!board.isEmpty(l));
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
        return new Test_AI_2(letter);
    }

    // returns location for specific spot.
    public Location checkSpotAnalyzer(int spot, Location origin) {
        // Origin is the one that it checks all the spots around.
        Location output = null;
        if(spot == 0) {
            output = new Location(origin.getCol()-1,origin.getRow()-1,origin.getSheet()+1);

        }
        else if(spot == 1) {
            output = new Location(origin.getCol(),origin.getRow()-1,origin.getSheet()+1);
        }
        else if(spot == 2) {
            output = new Location(origin.getCol()+1,origin.getRow()-1,origin.getSheet()+1);
        }
        else if(spot == 3) {
            output = new Location(origin.getCol()-1,origin.getRow()-1,origin.getSheet());
        }
        else if(spot == 4) {
            output = new Location(origin.getCol(),origin.getRow()-1,origin.getSheet());
        }
        else if(spot == 5) {
            output = new Location(origin.getCol()+1,origin.getRow()-1,origin.getSheet());
        }
        else if(spot == 6) {
            output = new Location(origin.getCol()-1,origin.getRow()-1,origin.getSheet()-1);
        }
        else if(spot == 7) {
            output = new Location(origin.getCol(),origin.getRow()-1,origin.getSheet()-1);
        }
        else if(spot == 8) {
            output = new Location(origin.getCol()+1,origin.getRow()-1,origin.getSheet()-1);
        }
        else if(spot == 9) {
            output = new Location(origin.getCol()-1,origin.getRow(),origin.getSheet()+1);
        }
        else if(spot == 10) {
            output = new Location(origin.getCol(),origin.getRow(),origin.getSheet()+1);
        }
        else if(spot == 11) {
            output = new Location(origin.getCol()+1,origin.getRow(),origin.getSheet()+1);
        }
        else if(spot == 12) {
            output = new Location(origin.getCol()-1,origin.getRow(),origin.getSheet());
        }
        else if(spot == 13) {
            output = new Location(origin.getCol()+1,origin.getRow(),origin.getSheet());
        }
        else if(spot == 14) {
            output = new Location(origin.getCol()-1,origin.getRow(),origin.getSheet()-1);
        }
        else if(spot == 15) {
            output = new Location(origin.getCol(),origin.getRow(),origin.getSheet()-1);
        }
        else if(spot == 16) {
            output = new Location(origin.getCol()+1,origin.getRow(),origin.getSheet()-1);
        }
        else if(spot == 17) {
            output = new Location(origin.getCol()-1,origin.getRow()+1,origin.getSheet()+1);
        }
        else if(spot == 18) {
            output = new Location(origin.getCol(),origin.getRow()+1,origin.getSheet()+1);
        }
        else if(spot == 19) {
            output = new Location(origin.getCol()+1,origin.getRow()+1,origin.getSheet()+1);
        }
        else if(spot == 20) {
            output = new Location(origin.getCol()-1,origin.getRow()+1,origin.getSheet());
        }
        else if(spot == 21) {
            output = new Location(origin.getCol(),origin.getRow()+1,origin.getSheet());
        }
        else if(spot == 22) {
            output = new Location(origin.getCol()+1,origin.getRow()+1,origin.getSheet());
        }
        else if(spot == 23) {
            output = new Location(origin.getCol()-1,origin.getRow()+1,origin.getSheet()-1);
        }
        else if(spot == 24) {
            output = new Location(origin.getCol(),origin.getRow()+1,origin.getSheet()-1);
        }
        else {
            output = new Location(origin.getCol()+1,origin.getRow()+1,origin.getSheet()-1);
        }
        return output;
    }

    public boolean[] checkSpot(int c, int r, int d) {
        boolean[] checkSpot = new boolean[26];
        Arrays.fill(checkSpot, true);
        if (r == 0) {
            for (int x = 0; x < 9; x++) {
                checkSpot[x] = false;
            }
        } else if (r == 3) {
            for (int x = 17; x < 26; x++) {
                checkSpot[x] = false;
            }
        }
        if (c == 0) {
            for (int x = 0; x < 24; x += 3) {
                if (x == 15) {
                    --x;
                }
                checkSpot[x] = false;
            }
        } else if (c == 3) {
            for (int x = 2; x < 26; x += 3) {
                if (x == 14) {
                    x--;
                }
                checkSpot[x] = false;
            }
        }
        if (d == 3) {
            for (int x = 0; x < 20; x++) {
                if (x == 3) {
                    x = 9;
                } else if (x == 12) {
                    x = 17;
                }
                checkSpot[x] = false;
            }
        } else if (d == 0) {
            for (int x = 6; x < 26; x++) {
                if (x == 9) {
                    x = 14;
                } else if (x == 17) {
                    x = 23;
                }
                checkSpot[x] = false;
            }
        }
        return checkSpot;
    }

    // Checks if opponents two in a row can become a four in a row, is not already blocked, if I cant win on this turn. If all true , return true.
    public boolean worthBlocking(Location origin, Location check, Board board, int x) {
        int inRow = 3;
        boolean blocked = false;
        boolean[] checkSpot1 = checkSpot(check.getCol(), check.getRow(), check.getSheet());
        boolean[] checkSpot2 = checkSpot(origin.getCol(), origin.getRow(), origin.getSheet());
        if(checkSpot1[x]) {
            check = new Location(check.getCol(), check.getRow(), check.getSheet());
            Location a = checkSpotAnalyzer(x, check);
            inRow++;
            if(board.getLocation(a) == getLetter()) {
                blocked = true;
            }
        }
        else if(checkSpot2[25-x]) {
            origin = new Location(origin.getCol(), origin.getRow(), origin.getSheet());
            Location a = checkSpotAnalyzer(x, origin);
            inRow++;
            if(board.getLocation(a) == getLetter()) {
                blocked = true;
            }
        }
        if(blocked || inRow < 4 || winnable(board) != null) {
            return false;
        }
        else {
            return true;
        }
    }

    // Can I win on this turn.
    public Location winnable(Board board) {
        for(int c = 0 ; c < 4 ; c++) {
            for(int r = 0 ; r < 4 ; r++) {
                for(int d = 0 ; d < 4 ; d++) {
                    if(board.getLocation(new Location(c, r, d)) == getLetter()) {
                        for(int a = 0 ; a < 26 ; a++) {
                            boolean[] checkSpot1 = checkSpot(c, r, d);
                            if(checkSpot1[a]) {

                                if(board.getLocation(checkSpotAnalyzer(a, new Location(c, r, d))) == getLetter()) {
                                    Location next = checkSpotAnalyzer(a, new Location(c, r, d));
                                    checkSpot1 = checkSpot(next.getCol(), next.getRow(), next.getSheet());
                                    if(checkSpot1[a]) {
                                        if(board.getLocation(checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet()))) == getLetter()) {
                                            next = checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet()));
                                            checkSpot1 = checkSpot(next.getCol(), next.getRow(), next.getSheet());
                                            boolean[] checkSpot2 = checkSpot(c, r, d);
                                            if(checkSpot1[a] && board.isEmpty(checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet())))) {
                                                return checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet()));
                                            }
                                            else if(checkSpot2[25-a] && board.isEmpty(checkSpotAnalyzer(25-a, new Location(c, r, d)))) {
                                                return checkSpotAnalyzer(25-a, new Location(c, r, d));
                                            }
                                        }
                                        else if(board.isEmpty(checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet())))) {
                                            next = checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet()));
                                            checkSpot1 = checkSpot(next.getCol(), next.getRow(), next.getSheet());
                                            if(checkSpot1[a] && board.getLocation(checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet()))) == getLetter()) {
                                                return next;
                                            }
                                        }
                                    }
                                }
                                else if(board.isEmpty(checkSpotAnalyzer(a, new Location(c, r, d)))) {
                                    Location next = checkSpotAnalyzer(a, new Location(c, r, d));
                                    checkSpot1 = checkSpot(next.getCol(), next.getRow(), next.getSheet());
                                    if(checkSpot1[a]) {
                                        if (board.getLocation(checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet()))) == getLetter()) {
                                            next = checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet()));
                                            checkSpot1 = checkSpot(next.getCol(), next.getRow(), next.getSheet());
                                            if(checkSpot1[a] && board.getLocation(checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet()))) == getLetter()) {
                                                return checkSpotAnalyzer(a, new Location(c, r, d));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    // Can opponent win on the next turn.
    public Location losable(Board board) {
        for(int c = 0 ; c < 4 ; c++) {
            for(int r = 0 ; r < 4 ; r++) {
                for(int d = 0 ; d < 4 ; d++) {
                    if(board.getLocation(new Location(c, r, d)) != getLetter() && !board.isEmpty(new Location(c, r, d))) {
                        for(int a = 0 ; a < 26 ; a++) {
                            boolean[] checkSpot1 = checkSpot(c, r, d);
                            if(checkSpot1[a]) {
                                if(board.getLocation(checkSpotAnalyzer(a, new Location(c, r, d))) != getLetter() && !board.isEmpty(checkSpotAnalyzer(a, new Location(c, r, d)))) {
                                    Location next = checkSpotAnalyzer(a, new Location(c, r, d));
                                    checkSpot1 = checkSpot(next.getCol(), next.getRow(), next.getSheet());
                                    if(checkSpot1[a]) {
                                        if(board.getLocation(checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet()))) != getLetter() && !board.isEmpty(checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet())))) {
                                            next = checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet()));
                                            checkSpot1 = checkSpot(next.getCol(), next.getRow(), next.getSheet());
                                            boolean[] checkSpot2 = checkSpot(c, r, d);
                                            if(checkSpot1[a] && board.isEmpty(checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet())))) {
                                                return checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet()));
                                            }
                                            else if(checkSpot2[25-a] && board.isEmpty(checkSpotAnalyzer(25-a, new Location(c, r, d)))) {
                                                return checkSpotAnalyzer(25-a, new Location(c, r, d));
                                            }
                                        }
                                        else if(board.isEmpty(checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet())))) {
                                            next = checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet()));
                                            checkSpot1 = checkSpot(next.getCol(), next.getRow(), next.getSheet());
                                            if(checkSpot1[a] && board.getLocation(checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet()))) != getLetter() && !board.isEmpty(checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet())))) {
                                                return next;
                                            }
                                        }
                                    }
                                }
                                else if(board.isEmpty(checkSpotAnalyzer(a, new Location(c, r, d)))) {
                                    Location next = checkSpotAnalyzer(a, new Location(c, r, d));
                                    checkSpot1 = checkSpot(next.getCol(), next.getRow(), next.getSheet());
                                    if(checkSpot1[a]) {
                                        if (board.getLocation(checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet()))) != getLetter() && !board.isEmpty(checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet())))) {
                                            next = checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet()));
                                            checkSpot1 = checkSpot(next.getCol(), next.getRow(), next.getSheet());
                                            if(checkSpot1[a] && board.getLocation(checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet()))) != getLetter() && !board.isEmpty(checkSpotAnalyzer(a, new Location(next.getCol(), next.getRow(), next.getSheet())))) {
                                                return checkSpotAnalyzer(a, new Location(c, r, d));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public Location gradeBoardHighest(Board board)
    {
        Location l;
        Location greatest = new Location(0, 0, 0);
        Random rand = new Random();
        ArrayList<Integer> test = new ArrayList<>();
        int[][][] compare = new int[4][4][4];
        int count = 0;
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

        for (int x = 0; x < 4; x++)
        {
            for (int y = 0; y < 4; y++)
            {
                for (int z = 0 ; z < 4; z++)
                {
                    if (compare[x][y][z] >= compare[greatest.getSheet()][greatest.getRow()][greatest.getCol()] && (board.getData()[z][y][x] != 'X' || board.getData()[z][y][x] != 'O') && board.isEmpty(new Location(x, y, z)))
                    {
                        greatest = new Location(x, y, z);
                    }
                }
            }
        }

        l = greatest;
        return l;
    }

    public boolean canBeFour(Location check, int a) {
        int inRow = 1;
        Location origin = check;
        boolean[] checkSpot1 = checkSpot(check.getCol(), check.getRow(), check.getSheet());
        boolean[] checkSpot2 = checkSpot(check.getCol(), check.getRow(), check.getSheet());
        if(checkSpot1[a]) {
            inRow++;
            check = checkSpotAnalyzer(a, check);
            checkSpot1 = checkSpot(check.getCol(), check.getRow(), check.getSheet());
            if(checkSpot1[a]) {
                inRow++;
                check = checkSpotAnalyzer(a, check);
                checkSpot1 = checkSpot(check.getCol(), check.getRow(), check.getSheet());
                if(checkSpot1[a]) {
                    inRow++;
                }
            }
        }
        if(checkSpot2[25-a] && inRow != 4) {
            inRow++;
            check = checkSpotAnalyzer(25-a, origin);
            checkSpot2 = checkSpot(check.getCol(), check.getRow(), check.getSheet());
            if(checkSpot2[25-a]) {
                inRow++;
                check = checkSpotAnalyzer(25-a, check);
                checkSpot2 = checkSpot(check.getCol(), check.getRow(), check.getSheet());
                if(checkSpot2[25-a]) {
                    inRow++;
                }
            }
        }
        return inRow == 4;
    }

    public Location dualWin(Board board) {
        for(int c = 0 ; c < 4 ; c++) {
            for(int r = 0 ; r < 4 ; r++) {
                for(int d = 0 ; d < 4 ; d++) {
                    int threeRows = 0;
                    Location check = new Location(c, r, d);
                    Location origin = check;
                    if(board.isEmpty(check)) {
                        boolean[] checkSpot1 = checkSpot(c, r, d);
                        for(int a = 0 ; a < 26 ; a++) {
                            if(checkSpot1[a]) {
                                if (canBeFour(check, a)) {
                                    boolean[] cS = checkSpot(check.getCol(), check.getRow(), check.getSheet());
                                    do {
                                        check = checkSpotAnalyzer(a, check);
                                        cS = checkSpot(check.getCol(), check.getRow(), check.getSheet());
                                    }while(cS[a]);
                                    int inRow = 0;
                                    for(int x = 0 ; x < 4 ; x++) {
                                        if(board.getLocation(check) == getLetter()) {
                                            inRow++;
                                        }
                                        else if(board.getLocation(check) != getLetter() && !board.isEmpty(check)) {
                                            inRow--;
                                        }
                                        check = checkSpotAnalyzer(25-a, check);
                                    }
                                    if(inRow == 2) {
                                        threeRows++;
                                    }
                                    check = origin;
                                }
                            }
                        }
                    }
                    if(threeRows >= 2) {
                        return origin;
                    }
                }
            }
        }
        return null;
    }

    public Location dualLose(Board board) {
        for(int c = 0 ; c < 4 ; c++) {
            for(int r = 0 ; r < 4 ; r++) {
                for(int d = 0 ; d < 4 ; d++) {
                    int threeRows = 0;
                    Location check = new Location(c, r, d);
                    Location origin = check;
                    if(board.isEmpty(check)) {
                        boolean[] checkSpot1 = checkSpot(c, r, d);
                        for(int a = 0 ; a < 26 ; a++) {
                            if(checkSpot1[a]) {
                                if (canBeFour(check, a)) {
                                    boolean[] cS = checkSpot(check.getCol(), check.getRow(), check.getSheet());
                                    do {
                                        check = checkSpotAnalyzer(a, check);
                                        cS = checkSpot(check.getCol(), check.getRow(), check.getSheet());
                                    }while(cS[a]);
                                    int inRow = 0;
                                    for(int x = 0 ; x < 4 ; x++) {
                                        if(board.getLocation(check) != getLetter() && !board.isEmpty(check)) {
                                            inRow++;
                                        }
                                        else if(board.getLocation(check) == getLetter()) {
                                            inRow--;
                                        }
                                        check = checkSpotAnalyzer(25-a, check);
                                    }
                                    if(inRow == 2) {
                                        threeRows++;
                                    }
                                    check = origin;
                                }
                            }
                        }
                    }
                    if(threeRows >= 2) {
                        return origin;
                    }
                }
            }
        }
        return null;
    }

    public int gradeMove(Location l, Board board, char player, char opponent)
    {
        if (board.getData()[l.getSheet()][l.getRow()][l.getCol()] == '-')
        {
            int my4s = 0;
            int my3s = 0;
            int my2s = 0;
            int my1s = 0;
            int count = 1;
            int totalScore = 0;

            for (int i = 0; i < board.numCols(); i++) {
                if (board.getData()[l.getSheet()][l.getRow()][i] == player) {
                    count++;
                } else if (board.getData()[l.getSheet()][l.getRow()][i] == opponent) {
                    count = 0;
                    break;
                }

            }
            if (count == 4)
            {
                my4s++;
            }
            if (count == 3)
            {
                my3s++;
            }
            if (count == 2)
            {
                my2s++;
            }
            if (count == 1) {
                my1s++;
            }
            count = 1;

            for (int i = 0; i < board.numRows(); i++) {
                if (board.getData()[l.getSheet()][i][l.getCol()] == player) {
                    count++;
                    my2s++;
                } else if (board.getData()[l.getSheet()][i][l.getCol()] == opponent) {
                    count = 0;
                    break;
                }

            }
            if (count == 4)
            {
                my4s++;
            }
            if (count == 3)
            {
                my3s++;
            }
            if (count == 2)
            {
                my2s++;
            }
            if (count == 1) {
                my1s++;
            }
            count = 1;
            for (int i = 0; i < board.numSheets(); i++) {
                if (board.getData()[i][l.getRow()][l.getCol()] == player) {
                    count++;

                } else if (board.getData()[i][l.getRow()][l.getCol()] == opponent) {
                    count = 0;
                    break;
                }

            }

            if (count == 4)
            {
                my4s++;
            }
            if (count == 3)
            {
                my3s++;
            }
            if (count == 2)
            {
                my2s++;
            }
            if (count == 1) {
                my1s++;
            }
            count = 1;
//            for (int i = 0; i < board.numSheets(); i++) {
//                if (board.getData()[i][i][l.getCol()] == player) {
//                    count++;
//
//                } else if (board.getData()[i][i][l.getCol()] == opponent) {
//                    count = 0;
//                    break;
//                }
//
//            }
//            if (count == 4)
//            {
//                my4s++;
//            }
//            if (count == 3)
//            {
//                my3s++;
//            }
//            if (count == 2)
//            {
//                my2s++;
//            }
//            if (count == 1) {
//                my1s++;
//            }
//            count = 1;
//            for (int i = 0; i < board.numSheets(); i++) {
//                if (board.getData()[i][l.getRow()][i] == player) {
//                    count++;
//
//                } else if (board.getData()[i][l.getRow()][i] == opponent) {
//                    count = 0;
//                    break;
//                }
//
//            }
//            if (count == 4)
//            {
//                my4s++;
//            }
//            if (count == 3)
//            {
//                my3s++;
//            }
//            if (count == 2)
//            {
//                my2s++;
//            }
//            if (count == 1) {
//                my1s++;
//            }
            count = 1;
//            for (int i = 0; i < board.numSheets(); i++) {
//                if (board.getData()[i][i][i] == player) {
//                    count++;
//
//                } else if (board.getData()[i][i][i] == opponent) {
//                    count = 0;
//                    break;
//                }
//            }
//            if (count == 4)
//            {
//                my4s++;
//            }
//            if (count == 3)
//            {
//                my3s++;
//            }
//            if (count == 2)
//            {
//                my2s++;
//            }
//            if (count == 1) {
//                my1s++;
//            }
            //---------------------------------------------
            count = 1;
            int op4s = 0;
            int op3s = 0;
            int op2s = 0;
            int op1s = 0;
            count = 1;


            for (int i = 0; i < board.numCols(); i++) {
                if (board.getData()[l.getSheet()][l.getRow()][i] == opponent) {
                    count++;
                } else if (board.getData()[l.getSheet()][l.getRow()][i] == player) {
                    count = 0;
                    break;
                }

            }
            if (count == 4)
            {
                op4s++;
            }
            if (count == 3)
            {
                op3s++;
            }
            if (count == 2)
            {
                op2s++;
            }
            if (count == 1) {
                op1s++;
            }
            count = 1;

            for (int i = 0; i < board.numRows(); i++) {
                if (board.getData()[l.getSheet()][i][l.getCol()] == opponent) {
                    count++;
                    op2s++;
                } else if (board.getData()[l.getSheet()][i][l.getCol()] == player) {
                    count = 0;
                    break;
                }

            }
            if (count == 4)
            {
                op4s++;
            }
            if (count == 3)
            {
                op3s++;
            }
            if (count == 2)
            {
                op2s++;
            }
            if (count == 1) {
                op1s++;
            }
            count = 1;
            for (int i = 0; i < board.numSheets(); i++) {
                if (board.getData()[i][l.getRow()][l.getCol()] == opponent) {
                    count++;

                } else if (board.getData()[i][l.getRow()][l.getCol()] == player) {
                    count = 0;
                    break;
                }

            }

            if (count == 4)
            {
                op4s++;
            }
            if (count == 3)
            {
                op3s++;
            }
            if (count == 2)
            {
                op2s++;
            }
            if (count == 1) {
                op1s++;
            }
            count = 1;
//            for (int i = 0; i < board.numSheets(); i++) {
//                if (board.getData()[i][i][l.getCol()] == opponent) {
//                    count++;
//
//                } else if (board.getData()[i][i][l.getCol()] == player) {
//                    count = 0;
//                    break;
//                }
//
//            }
//            if (count == 4)
//            {
//                op4s++;
//            }
//            if (count == 3)
//            {
//                op3s++;
//            }
//            if (count == 2)
//            {
//                op2s++;
//            }
//            if (count == 1) {
//                op1s++;
//            }
//            count = 1;
//            for (int i = 0; i < board.numSheets(); i++) {
//                if (board.getData()[i][l.getRow()][i] == opponent) {
//                    count++;
//
//                } else if (board.getData()[i][l.getRow()][i] == player) {
//                    count = 0;
//                    break;
//                }
//
//            }
//            if (count == 4)
//            {
//                op4s++;
//            }
//            if (count == 3)
//            {
//                op3s++;
//            }
//            if (count == 2)
//            {
//                op2s++;
//            }
//            if (count == 1) {
//                op1s++;
//            }
            count = 1;
//            for (int i = 0; i < board.numSheets(); i++) {
//                if (board.getData()[i][i][i] == opponent) {
//                    count++;
//
//                } else if (board.getData()[i][i][i] == player) {
//                    count = 0;
//                    break;
//                }
//
//            }
//            if (count == 4)
//            {
//                op4s++;
//            }
//            if (count == 3)
//            {
//                op3s++;
//            }
//            if (count == 2)
//            {
//                op2s++;
//            }
//            if (count == 1) {
//                op1s++;
//            }
            count = 1;
           // System.out.println("-------------------" + my4s);

            if (my4s >= 1)
            {
                return 1000;
            }
            //return my3s * 100 + my2s * 25;
            return ((my3s - -op3s) * 100) + ((my2s- -op2s) * 40) + ((my1s - -op1s));
        }
        else
        {
            return -1;
        }
    }

}
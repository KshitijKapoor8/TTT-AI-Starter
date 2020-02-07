import java.util.Arrays;
import java.util.Random;

public class Test_AI_6 implements PlayerInt
{
	private char letter;
	private String name;

	// Pre:		receives a char letter
	// Post: 	sets the name to "Random AI" and the letter to the letter received
	Test_AI_6(char letter)
	{
		name 		= "Paper Blade";
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
		Location l = null;
		Random rand = new Random();
		do
		{
			int myMove = 0;
			boolean firstMove = true;
			for(int c = 0 ; c < 4 ; c++) {
				for (int r = 0; r < 4; r++) {
					for (int d = 0; d < 4; d++) {
						if(board.getLocation(new Location(c, r, d)) == getLetter()) {
							myMove++;
						}
					}
				}
			}
			if(myMove == 0) {
				l = new Location(0, 0, 0);
			}
			if(!board.isEmpty(l)) {
				myMove++;
			}
			if(myMove == 1) {
				l = new Location(0, 1, 0);
			}
			if(!board.isEmpty(l)) {
				myMove++;
			}
			if(myMove == 2) {
				l = new Location(1, 1, 1);
			}
			if(!board.isEmpty(l)) {
				myMove++;
			}
			if(myMove == 3) {
				l = new Location(0, 1, 1);
			}
			if(!board.isEmpty(l)) {
				myMove++;
			}
			if(myMove == 4) {
				l = new Location(1, 1, 0);
			}
			if(!board.isEmpty(l)) {
				l = null;
			}
			if(l == null) {
				if(board.isEmpty(new Location(2, 1, 1))) {
					l = new Location(2, 1, 1);
				}
				else if(winnable(board) != null) {
					l = winnable(board);
				}
				else if(losable(board) != null) {
					l = losable(board);
				}
				else if(dualWin(board) != null) {
					l = dualWin(board);
				}
				else if(board.isEmpty(new Location(1, 1, 2))) {
					l = new Location(1, 1, 2);
				}
				else {
					l = new Location(rand.nextInt(4),rand.nextInt(4),rand.nextInt(4));
				}
			}
		}while(!board.isEmpty(l));
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
		return new Test_AI_6(letter);
	}

	public Location checkSpotAnalyzer(int spot, Location origin) {
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
}
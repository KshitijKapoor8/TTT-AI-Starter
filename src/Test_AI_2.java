import java.util.ArrayList;
import java.util.Random;

public class Test_AI_2 implements PlayerInt
{
	private char letter;
	private String name;

	// Pre:		receives a char letter
	// Post: 	sets the name to "Random AI" and the letter to the letter received
	Test_AI_2(char letter)
	{
		name 		= "Test AI";
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
		boolean[] checkSpot = new boolean[26];
		for (boolean x : checkSpot) {
			x = true;
		}
		Location l = null;
		Random rand = new Random();
		do
		{
				for(int r = 0 ; r < board.numRows() ; r++) {
					for(int c = 0 ; c < board.numCols() ; c++) {
						for(int d = 0 ; d < board.numSheets() ; d++) {
							if(board.getLocation(new Location(c, r, d)) != getLetter() && !board.isEmpty(new Location(c, r, d))) {
								if(r == 0) {
									for(int x = 0 ; x < 9 ; x++) {
										checkSpot[x] = false;
									}
								}
								else if(r == 3) {
									for(int x = 17 ; x < 26 ; x++) {
										checkSpot[x] = false;
									}
								}
								if(c == 0) {
									for(int x = 0 ; x < 24 ; x+=3) {
										if(x == 15) {
											x--;
										}
										checkSpot[x] = false;
									}
								}
								else if(c == 3) {
									for(int x = 2 ; x < 26 ; x+=3) {
										if(x == 14) {
											x--;
										}
										checkSpot[x] = false;
									}
								}
								if(d == 3) {
									for(int x = 0 ; x < 20 ; x++) {
										if(x == 3) {
											x = 9;
										}
										else if(x == 12) {
											x = 17;
										}
										checkSpot[x] = false;
									}
								}
								else if(d == 0) {
									for(int x = 6 ; x < 26 ; x++) {
										if(x == 9) {
											x = 14;
										}
										else if(x == 17) {
											x = 23;
										}
										checkSpot[x] = false;
									}
								}
								for (int x = 0 ; x < checkSpot.length ; x++) {
									if(checkSpot[x]) {
										if(board.getLocation(checkSpotAnalyzer(x,new Location(c, r, d))) != getLetter() && !board.isEmpty(checkSpotAnalyzer(x,new Location(c, r, d)))) {
											Location yert = checkSpotAnalyzer(x,new Location(c, r, d));
											l = checkSpotAnalyzer(x,checkSpotAnalyzer(x,new Location(c, r, d)));
										}
									}
								}
							}
						}
					}
			}
			if(l == null) {
				l = new Location(rand.nextInt(4),rand.nextInt(4),rand.nextInt(4));
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
		return new Test_AI_2(letter);
	}

	public Location checkSpotAnalyzer(int spot, Location origin) {
		if(spot == 0) {
			return new Location(origin.getCol()-1,origin.getRow()+1,origin.getSheet()-1);
		}
		else if(spot == 1) {
			return new Location(origin.getCol(),origin.getRow()+1,origin.getSheet()-1);
		}
		else if(spot == 2) {
			return new Location(origin.getCol()+1,origin.getRow()+1,origin.getSheet()-1);
		}
		else if(spot == 3) {
			return new Location(origin.getCol()-1,origin.getRow()+1,origin.getSheet());
		}
		else if(spot == 4) {
			return new Location(origin.getCol(),origin.getRow()+1,origin.getSheet());
		}
		else if(spot == 5) {
			return new Location(origin.getCol()+1,origin.getRow()+1,origin.getSheet());
		}
		else if(spot == 6) {
			return new Location(origin.getCol()-1,origin.getRow()+1,origin.getSheet()+1);
		}
		else if(spot == 7) {
			return new Location(origin.getCol(),origin.getRow()+1,origin.getSheet()+1);
		}
		else if(spot == 8) {
			return new Location(origin.getCol()+1,origin.getRow()+1,origin.getSheet()+1);
		}
		else if(spot == 9) {
			return new Location(origin.getCol()-1,origin.getRow(),origin.getSheet()-1);
		}
		else if(spot == 10) {
			return new Location(origin.getCol(),origin.getRow(),origin.getSheet()-1);
		}
		else if(spot == 11) {
			return new Location(origin.getCol()+1,origin.getRow(),origin.getSheet()-1);
		}
		else if(spot == 12) {
			return new Location(origin.getCol()-1,origin.getRow(),origin.getSheet());
		}
		else if(spot == 13) {
			return new Location(origin.getCol()+1,origin.getRow(),origin.getSheet());
		}
		else if(spot == 14) {
			return new Location(origin.getCol()-1,origin.getRow(),origin.getSheet()+1);
		}
		else if(spot == 15) {
			return new Location(origin.getCol(),origin.getRow(),origin.getSheet()+1);
		}
		else if(spot == 16) {
			return new Location(origin.getCol()+1,origin.getRow(),origin.getSheet()+1);
		}
		else if(spot == 17) {
			return new Location(origin.getCol()-1,origin.getRow()-1,origin.getSheet()-1);
		}
		else if(spot == 18) {
			return new Location(origin.getCol(),origin.getRow()-1,origin.getSheet()-1);
		}
		else if(spot == 19) {
			return new Location(origin.getCol()+1,origin.getRow()-1,origin.getSheet()-1);
		}
		else if(spot == 20) {
			return new Location(origin.getCol()-1,origin.getRow()-1,origin.getSheet());
		}
		else if(spot == 21) {
			return new Location(origin.getCol(),origin.getRow()-1,origin.getSheet());
		}
		else if(spot == 22) {
			return new Location(origin.getCol()+1,origin.getRow()-1,origin.getSheet());
		}
		else if(spot == 23) {
			return new Location(origin.getCol()-1,origin.getRow()-1,origin.getSheet()+1);
		}
		else if(spot == 24) {
			return new Location(origin.getCol(),origin.getRow()-1,origin.getSheet()+1);
		}
		else {
			return new Location(origin.getCol()+1,origin.getRow()-1,origin.getSheet()+1);
		}
	}

	public boolean[] checkSpot(Board board, int c, int r, int d) {
		boolean[] checkSpot = new boolean[26];
		for (boolean x : checkSpot) {
			x = true;
		}
		if (board.getLocation(new Location(c, r, d)) != getLetter() && !board.isEmpty(new Location(c, r, d))) {
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
						x--;
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
		}
		return checkSpot;
	}
}
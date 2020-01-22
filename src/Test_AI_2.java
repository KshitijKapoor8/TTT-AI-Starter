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
		Location l = null;
		Random rand = new Random();
		do
		{
			for(int r = 0 ; r < board.numRows() ; r++) {
				for(int c = 0 ; c < board.numCols() ; c++) {
					for(int d = 0 ; d < board.numSheets() ; d++) {
						if(board.getLocation(new Location(r, c, d)) != getLetter()) {
							if(r == 3 || c == 3 || d == 3) {
								l = new Location(r-1, c-1, d-1);
							}
							else {
								l = new Location(r+1, c, d+1);
							}
							break;
						}
						else {
							l = new Location(rand.nextInt(4),rand.nextInt(4),rand.nextInt(4));
							break;
						}
					}
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
		return new Test_AI_2(letter);
	} 
}
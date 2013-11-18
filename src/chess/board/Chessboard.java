package chess.board;

public class Chessboard 
{
	//Chessboard will be a 2D array of Tiles
	private final int BOARD_LENGTH = 8;
	private final int BOARD_WIDTH = 8;
	
	public void printBoard()
	{
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			for(int j = 0; j < BOARD_WIDTH; j++)
			{
				//If no piece here, print x, otherwise, print out piece type
				//Example: Print rook as R, print bishop as B, etc.
				System.out.println("x");
			}
			System.out.println("");
		}
	}
}

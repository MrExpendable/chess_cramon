package chess.board;

public class Chessboard 
{
	private final int BOARD_LENGTH = 8;
	private final int BOARD_WIDTH = 8;
	
	public void printBoard()
	{
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			for(int j = 0; j < BOARD_WIDTH; j++)
			{
				System.out.println("x");
			}
			System.out.println("");
		}
	}
}

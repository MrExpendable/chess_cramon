package chess.board;

public class Chessboard 
{
	//Chessboard will be a 2D array of Tiles
	private final int BOARD_LENGTH = 8;
	private final int BOARD_WIDTH = 8;
	Tile[][] board;
	
	/*
	 * Instantiates the 2D Tile array(the board)
	 */
	public Chessboard()
	{
		board = new Tile[BOARD_LENGTH][BOARD_LENGTH];
	}
	
	/*
	 * 
	 */
	public void fillBoard(String column, String row)
	{
		
	}
	
	/*
	 * Prints the board
	 */
	public void printBoard()
	{
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			System.out.print(BOARD_LENGTH - i + "   ");
			for(int j = 0; j < BOARD_WIDTH; j++)
			{
				//If no piece here, print -, otherwise, print out piece type
				//Example: Print rook as R, print bishop as B, etc.
				if(board[i][j] == null)
				{
					System.out.print("- ");
				}
				else
				{
					System.out.print(board[i][j].checkName() + " ");
				}
			}
			System.out.println("");
		}
		System.out.println("    a b c d e f g h");
	}
}

package chess.board;

public class Chessboard 
{
	//Chessboard will be a 2D array of Tiles
	private final int BOARD_LENGTH = 8;
	private final int BOARD_WIDTH = 8;
	private Tile[][] board;
	
	/*
	 * Instantiates the 2D Tile array(the board)
	 */
	public Chessboard()
	{
		board = new Tile[BOARD_LENGTH][BOARD_LENGTH];
	}
	
	/*
	 * Fills the board
	 */
	public void fillBoard(String pieceColor, String pieceType, String position)
	{
		char char1 = position.charAt(0);
		char char2 = position.charAt(1);
		int column = Character.getNumericValue(char1) - 10;
		int row = Character.getNumericValue(char2) - 1;
		
		System.out.println(pieceType + pieceColor);
		
		if(board[row][column] == null)
		{
			System.out.println("Null space");
			board[row][column].setPiece(pieceType, pieceColor);
		}
		else
		{
			board[row][column].setPiece(pieceType, pieceColor);
		}
		
		////YOU SHOULD PROBABLY MAKE THE COLOR A BOOLEAN, LIKE ISWHITE
		//PEOPLE SAY THAT USING CAPS IS LIKE YELLING
		//I SAY THAT IT'S A WAY OF SECURING SOMEONE'S ATTENTION
		//System.out.printf("Column: %s%nRow: %s%n", column, row);
	}
	
	/*
	 * Prints the board
	 */
	public void printBoard()
	{
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			//System.out.print(BOARD_LENGTH - i + "   ");
			System.out.print(i + 1 + "   ");
			
			for(int j = 0; j < BOARD_WIDTH; j++)
			{
				//If no piece here, print -, otherwise, print out piece type
				//Example: Print rook as R, print bishop as B, etc.
				if(board[i][j] == null)
				{
					System.out.print("-  ");
				}
				else
				{
					System.out.print(board[i][j].getPieceName() + " ");
				}
			}
			System.out.println("");
		}
		System.out.println("    a  b  c  d  e  f  g  h");
	}
}

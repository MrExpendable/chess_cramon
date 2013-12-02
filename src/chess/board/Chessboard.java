package chess.board;
import chess.pieces.*;

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
		board = new Tile[BOARD_LENGTH][BOARD_WIDTH];
	}
	
	/*
	 * Fills specific rows of the board with pawns
	 */
	public void fillPawns()
	{
		//Using constant number to represent either dark or light row that the pawns can fill
		final int DARKPAWNROW = 1;
		final int LIGHTPAWNROW = 6;
		
		//Fill board with pawns
		for(int i = 0; i < BOARD_WIDTH; i++)
		{
			board[i][LIGHTPAWNROW] = new Tile(new Pawn("P", true));
		}
		for(int i = 0; i < BOARD_WIDTH; i++)
		{
			board[i][DARKPAWNROW] = new Tile(new Pawn("P", false));
		}
	}
	
	/*
	 * Fills the ends of the board with special pieces(rook, knight, bishop, queen, king)
	 */
	public void fillSpecialPieces()
	{
		//Represents the row in which special pieces will be placed
		final int DARK_SPECIAL_ROW = 0;
		final int LIGHT_SPECIAL_ROW = 7;
		
		//Rooks
		board[0][DARK_SPECIAL_ROW] = new Tile(new Rook("R", false));
		board[7][DARK_SPECIAL_ROW] = new Tile(new Rook("R", false));
		board[0][LIGHT_SPECIAL_ROW] = new Tile(new Rook("R", true));
		board[7][LIGHT_SPECIAL_ROW] = new Tile(new Rook("R", true));
		
		//Knights
		board[1][DARK_SPECIAL_ROW] = new Tile(new Knight("N", false));
		board[6][DARK_SPECIAL_ROW] = new Tile(new Knight("N", false));
		board[1][LIGHT_SPECIAL_ROW] = new Tile(new Knight("N", true));
		board[6][LIGHT_SPECIAL_ROW] = new Tile(new Knight("N", true));
		
		//Bishops
		board[2][DARK_SPECIAL_ROW] = new Tile(new Bishop("B", false));
		board[5][DARK_SPECIAL_ROW] = new Tile(new Bishop("B", false));
		board[2][LIGHT_SPECIAL_ROW] = new Tile(new Bishop("B", true));
		board[5][LIGHT_SPECIAL_ROW] = new Tile(new Bishop("B", true));
		
		//Queens
		board[3][DARK_SPECIAL_ROW] = new Tile(new Queen("Q", false));
		board[3][LIGHT_SPECIAL_ROW] = new Tile(new Queen("Q", true));
		
		//Kings
		board[4][DARK_SPECIAL_ROW] = new Tile(new King("K", false));
		board[4][LIGHT_SPECIAL_ROW] = new Tile(new King("K", true));
	}
	
	public void movePiece(Location init, Location fin)
	{
		
	}
	
//	/*
//	 * Fills the board
//	 */
//	public void fillBoard(String pieceColor, String pieceType, String position)
//	{
//		char char1 = position.charAt(0);
//		char char2 = position.charAt(1);
//		int column = Character.getNumericValue(char1) - 10;
//		int row = Character.getNumericValue(char2) - 1;
//		
//		/*
//		 * I don't know what to do with Location yet, to be honest
//		 * I'm just trying to implement a system that will allow for easier use of piece location
//		Location newPiece = new Location(column, row);
//		System.out.println(newPiece.toString());
//		*/
//		
//		if(board[row][column] == null)
//		{
//			System.out.println("Null space");
////			board[row][column].getPieceName();
//			board[row][column].setPiece(pieceType, pieceColor);
//		}
//		else
//		{
////			board[row][column].setPiece(pieceType, pieceColor);
//		}
//		
//		////YOU SHOULD PROBABLY MAKE THE COLOR A BOOLEAN, LIKE ISWHITE
//		//PEOPLE SAY THAT USING CAPS IS LIKE YELLING
//		//I SAY THAT IT'S A WAY OF SECURING SOMEONE'S ATTENTION
//		//System.out.printf("Column: %s%nRow: %s%n", column, row);
//	}
	
	/*
	 * Prints the board
	 */
	public void printBoard()
	{
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			//Prints out the numbers on the side of the board to signify one of the axes
			System.out.print(BOARD_LENGTH - i + "      ");
			for(int j = 0; j < BOARD_WIDTH; j++)
			{
				if(board[j][i] == null)
				{
					//If the element is null, print x instead to signify an empty space
					System.out.print("-   ");
				}
				else
				{
					//Else, check the type of the piece in the array, and print it out
					System.out.print(board[j][i].getPieceName() + "  ");
				}
			}
			System.out.println("");
		}
		//Prints out the other axis of the board on the bottom of the board
		System.out.println("\n       a   b   c   d   e   f   g   h");
		System.out.println("\n\n");
	}
}

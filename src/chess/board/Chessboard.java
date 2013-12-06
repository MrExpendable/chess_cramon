package chess.board;
import chess.pieces.*;

public class Chessboard 
{
	//Chessboard will be a 2D array of Tiles
	private final int BOARD_LENGTH = 8;
	private final int BOARD_WIDTH = 8;
	private Tile[][] board;
	private boolean isWhiteTurn = true;
	
	/*
	 * Instantiates the 2D Tile array(the board)
	 */
	public Chessboard()
	{
		board = new Tile[BOARD_LENGTH][BOARD_WIDTH];
	}
	
	public Tile[][] getBoard()
	{
		return board;
	}
	
	public Location getPieceLocation(Piece p)
	{
		return p.getLocation();
	}
	
	/*
	 * Fills specific rows of the board with pawns
	 */
	public void fillPawns()
	{
		//Using constant number to represent either dark or light row that the pawns can fill
		final int LIGHTPAWNROW = 1;
		final int DARKPAWNROW = 6;
		
		
		//Fill board with pawns
		for(int i = 0; i < BOARD_WIDTH; i++)
		{
			board[i][LIGHTPAWNROW] = new Tile(new Pawn("P", true, new Location(i, LIGHTPAWNROW)));
			board[i][DARKPAWNROW] = new Tile(new Pawn("P", false, new Location(i, DARKPAWNROW)));
		}
	}
	
	/*
	 * Fills the ends of the board with special pieces(rook, knight, bishop, queen, king)
	 */
	public void fillSpecialPieces()
	{
		//Represents the row in which special pieces will be placed
		final int LIGHT_SPECIAL_ROW = 0;
		final int DARK_SPECIAL_ROW = 7;
		
		//Rooks
		board[0][DARK_SPECIAL_ROW] = new Tile(new Rook("R", false, new Location(0, DARK_SPECIAL_ROW)));
		board[7][DARK_SPECIAL_ROW] = new Tile(new Rook("R", false, new Location(7, DARK_SPECIAL_ROW)));
		board[0][LIGHT_SPECIAL_ROW] = new Tile(new Rook("R", true, new Location(0, LIGHT_SPECIAL_ROW)));
		board[7][LIGHT_SPECIAL_ROW] = new Tile(new Rook("R", true, new Location(7, LIGHT_SPECIAL_ROW)));
		
		//Knights
		board[1][DARK_SPECIAL_ROW] = new Tile(new Knight("N", false, new Location(1, DARK_SPECIAL_ROW)));
		board[6][DARK_SPECIAL_ROW] = new Tile(new Knight("N", false, new Location(6, DARK_SPECIAL_ROW)));
		board[1][LIGHT_SPECIAL_ROW] = new Tile(new Knight("N", true, new Location(1, LIGHT_SPECIAL_ROW)));
		board[6][LIGHT_SPECIAL_ROW] = new Tile(new Knight("N", true, new Location(6, LIGHT_SPECIAL_ROW)));
		
		//Bishops
		board[2][DARK_SPECIAL_ROW] = new Tile(new Bishop("B", false, new Location(2, DARK_SPECIAL_ROW)));
		board[5][DARK_SPECIAL_ROW] = new Tile(new Bishop("B", false, new Location(5, DARK_SPECIAL_ROW)));
		board[2][LIGHT_SPECIAL_ROW] = new Tile(new Bishop("B", true, new Location(2, LIGHT_SPECIAL_ROW)));
		board[5][LIGHT_SPECIAL_ROW] = new Tile(new Bishop("B", true, new Location(5, LIGHT_SPECIAL_ROW)));
		
		//Queens
		board[3][DARK_SPECIAL_ROW] = new Tile(new Queen("Q", false, new Location(3, DARK_SPECIAL_ROW)));
		board[3][LIGHT_SPECIAL_ROW] = new Tile(new Queen("Q", true, new Location(3, LIGHT_SPECIAL_ROW)));
		
		//Kings
		board[4][DARK_SPECIAL_ROW] = new Tile(new King("K", false, new Location(4, DARK_SPECIAL_ROW)));
		board[4][LIGHT_SPECIAL_ROW] = new Tile(new King("K", true, new Location(4, LIGHT_SPECIAL_ROW)));
	}
	
	public void changePlayerTurn()
	{
		isWhiteTurn = !isWhiteTurn;
	}
	
	  /*
	  * Fills the board
	  */
	 public void fillBoard(boolean pieceIsWhite, String pieceType, String position)
	 {
	     char char1 = position.charAt(0);
	     char char2 = position.charAt(1);
	     int column = Character.getNumericValue(char1) - 10;
	     int row = Character.getNumericValue(char2) - 1;
	     
	     if(board[row][column] == null)
	     {
             System.out.println("Null space to be filled");
//             board[row][column] = new Tile(new Piece(pieceType, pieceIsWhite, new Location(column, row)));
//             board[row][column].setPiece(pieceType, pieceIsWhite, new Location(column, row));
	     }
	     
	     ////YOU SHOULD PROBABLY MAKE THE COLOR A BOOLEAN, LIKE ISWHITE
	     //PEOPLE SAY THAT USING CAPS IS LIKE YELLING
	     //I SAY THAT IT'S A WAY OF SECURING SOMEONE'S ATTENTION
	     //System.out.printf("Column: %s%nRow: %s%n", column, row);
	 }
	
	public boolean movePiece(Location init, Location fin)
	{
		int initCol = init.getColumn();
		int initRow = init.getRow();
		int finCol = fin.getColumn();
		int finRow = fin.getRow();
		boolean isPieceWhite = board[initCol][initRow].getPiece().isPieceWhite();
		Tile currentSpace = board[initCol][initRow];
		
		//If the space is occupied by a piece(isn't null)
		if(currentSpace != null)
		{
			//If white turn and white piece or dark turn and dark piece
			if(isPieceWhite == isWhiteTurn)
			{
				//Get the piece and if the locations sent indicate a valid move
				if(currentSpace.getPiece().isValidMove(initCol, initRow, finCol, finRow))
				{
					//Set the piece's new location
					currentSpace.getPiece().setLocation(new Location(finCol, finRow));
					
					//Move the piece and set the old space to null
					board[finCol][finRow] = board[initCol][initRow];
					board[initCol][initRow] = null;
					changePlayerTurn();
					
					System.out.printf("Moved piece from %s to %s%n", init.toString(), fin.toString());
					
					return true;
				}
				else
				{
					System.out.println("Move is invalid, try again.");
					return false;
				}
			}
			else
			{
				System.out.println("It's not your turn.");
				return false;
			}
		}
		else
		{
			System.out.println("No piece here.\n");
			return false;
		}
	}
	
	/*
	 * Prints the board
	 */
	public void printBoard()
	{
		System.out.println("\n       a   b   c   d   e   f   g   h\n");
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			//Prints out the numbers on the side of the board to signify one of the axes
			System.out.print(i + 1 + "      ");
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
	}
}

//isPieceWhite && isWhiteTurn || 

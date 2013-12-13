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
		
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			for(int j = 0; j < BOARD_WIDTH; j++)
			{
				if(board[i][j] == null)
				{
					board[i][j] = new Tile();
				}
			}
		}
	}
	
	//Copy constructor
	public Chessboard(Chessboard toCopy)
	{
		board = new Tile[BOARD_LENGTH][BOARD_WIDTH];
		
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			for(int j = 0; j < BOARD_WIDTH; j++)
			{
				board[i][j] = toCopy.board[i][j];
			}
		}
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
	 * Returns a piece from the board if the location sent in matches the piece's location
	 */
	public Piece getPieceAtLocation(Location pieceLoc)
	{
		Piece pieceToReturn = null;
		
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			for(int j = 0; j < BOARD_WIDTH; j++)
			{
				if(board[j][i].getPiece().getLocation() == pieceLoc)
				{
					pieceToReturn = board[j][i].getPiece();
				}
			}
		}
		
		return pieceToReturn;
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

	  /*
	  * Gets piece info, creates a location for the piece, and sends it to fillBoard to fill the board
	  */
	 public void parsePieceInfo(boolean pieceIsWhite, String pieceType, String position)
	 {
		 int column = Character.getNumericValue(position.charAt(0)) - 10;
		 int row = Character.getNumericValue(position.charAt(1)) - 1;
		 
		 fillBoard(pieceIsWhite, pieceType, new Location(column, row));
	}
	 
	 /*
	  * Fills the board
	  */
	public void fillBoard(boolean pieceIsWhite, String pieceType, Location loc)
	{
		int column = loc.getColumn();
		int row = loc.getRow();
		
		if(board[row][column].getPiece() == null)
	     {
			//Bishop
			if(pieceType.contains("B"))
			{
				board[row][column] = new Tile(new Bishop(pieceType, pieceIsWhite, loc));
			}
			//King
			else if(pieceType.contains("K"))
			{
				board[row][column] = new Tile(new King(pieceType, pieceIsWhite, loc));
			}
			//Knight
			else if(pieceType.contains("N"))
			{
				board[row][column] = new Tile(new Knight(pieceType, pieceIsWhite, loc));
			}
			//Queen
			else if(pieceType.contains("Q"))
			{
				board[row][column] = new Tile(new Queen(pieceType, pieceIsWhite, loc));
			}
			//Rook
			else if(pieceType.contains("R"))
			{
				board[row][column] = new Tile(new Rook(pieceType, pieceIsWhite, loc));
			}
			//Pawn
			else if(pieceType.contains("P"))
			{
				board[row][column] = new Tile(new Pawn(pieceType, pieceIsWhite, loc));
			}
//            board[row][column] = new Tile(new Pawn(pieceType, pieceIsWhite, new Location(column, row)));
//            board[row][column].setPiece(pieceType, pieceIsWhite, new Location(column, row));
	     }
	}
	
	//Method that will move pieces around based on copies of the board
	//Purpose is to not modify the original board
	public boolean testMovePiece(Location init, Location fin, Tile[][] copyBoard)
	{
		int initCol = init.getColumn();
		int initRow = init.getRow();
		int finCol = fin.getColumn();
		int finRow = fin.getRow();
		Tile currentSpace = copyBoard[initRow][initCol];
		
		if(currentSpace != null && currentSpace.getPiece() != null)
		{
			if(currentSpace.getPiece().isValidMove(initCol, initRow, finCol, finRow))
			{
				currentSpace.getPiece().setLocation(new Location(finCol, finRow));
				
				copyBoard[finRow][finCol] = copyBoard[initRow][initCol];
				copyBoard[initRow][initCol] = new Tile();
				
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	/*
	 * Moves a piece
	 */
	public boolean movePiece(Location init, Location fin)
	{
		int initCol = init.getColumn();
		int initRow = init.getRow();
		int finCol = fin.getColumn();
		int finRow = fin.getRow();
		Tile currentSpace = board[initRow][initCol];
		
		//If the space is occupied by a piece(isn't null)
		if(currentSpace != null && currentSpace.getPiece() != null)
		{
			//Get the piece and if the locations sent indicate a valid move
			if(currentSpace.getPiece().isValidMove(initCol, initRow, finCol, finRow))
			{
				//If no obstructions or piece is a knight
				if(currentSpace.getPiece() instanceof Knight || !checkForObstruction(init, fin, board, currentSpace.getPiece()))
				{
					currentSpace.getPiece().setLocation(new Location(finCol, finRow));
					
					//Move the piece and set the old space to null
					board[finRow][finCol] = board[initRow][initCol];
					board[initRow][initCol] = new Tile();
					
					return true;
				}
				else
				{
					System.out.println("There's a piece in the way, try a different move.\n");
					return false;
				}
			}
			else
			{
				System.out.println("Move is invalid, try again.\n");
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
	 * Checks for obstructions along a piece's move path
	 */
	public boolean checkForObstruction(Location init, Location fin, Tile[][] obstructedBoard, Piece pieceToCheck)
	{
		//I'm thinking that I should take the locations, subtract the columns and rows from final and initial positions, then iterate over the differences
		//Once I'm iterating over the differences, I check if there's a piece in a specific space
		//If there's a piece, return true, but if it's empty, return false
		
		Location greaterLoc, lesserLoc;
		
		if((init.getColumn() + init.getRow()) > (fin.getColumn() + fin.getRow()))
		{
			greaterLoc = init;
			lesserLoc = fin;
		}
		else
		{
			greaterLoc = fin;
			lesserLoc = init;
		}
		
		int colDif = Math.abs(greaterLoc.getColumn() - lesserLoc.getColumn());
		int rowDif = Math.abs(greaterLoc.getRow() - lesserLoc.getRow());
		boolean isObstructed = false;
		
		if(colDif > 0)
		{
			for(int i = 1; i < colDif; i++)
			{
				if(obstructedBoard[greaterLoc.getColumn() - i][greaterLoc.getRow()].getPiece() != null
						&& obstructedBoard[greaterLoc.getColumn() - i][greaterLoc.getRow()].getPiece() != pieceToCheck)
				{
					isObstructed = true;
				}
			}
		}
		
		if(rowDif > 0)
		{
			for(int i = 1; i < rowDif; i++)
			{
				if((obstructedBoard[greaterLoc.getColumn()][greaterLoc.getRow() - i].getPiece() != null)
						&& (obstructedBoard[greaterLoc.getColumn() - i][greaterLoc.getRow()].getPiece() != pieceToCheck))
				{
					isObstructed = true;
				}
			}
		}
		
		return isObstructed;
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
				if(board[i][j].getPiece() == null)
				{
					//If the element is null, print x instead to signify an empty space
					System.out.print("-   ");
				}
				else
				{
					//Else, check the type of the piece in the array, and print it out
					System.out.print(board[i][j].getPieceName() + "  ");
				}
			}
			System.out.println("");
		}
	}
}

//isPieceWhite && isWhiteTurn || 
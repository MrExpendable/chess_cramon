package chess.board;

import chess.pieces.*;

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
	public void fillBoard(String pieceColor, String pieceType, String position)
	{
		char char1 = position.charAt(0);
		char char2 = position.charAt(1);
		int column = Character.getNumericValue(char1) - 10;
		int row = Character.getNumericValue(char2) - 1;
		
		board[row][column].setPiece(pieceType, pieceColor);
//		//Bishop
//		if(pieceType.contains("B"))
//		{
//			board[row][column] = new Tile(new Bishop(pieceColor));
//		}
//		//King
//		else if(pieceType.contains("K"))
//		{
//			board[row][column] = new Tile(new King(pieceColor));
//		}
//		//Knight
//		else if(pieceType.contains("N"))
//		{
//			board[row][column] = new Tile(new Knight(pieceColor));
//		}
//		//Queen
//		else if(pieceType.contains("Q"))
//		{
//			board[row][column] = new Tile(new Queen(pieceColor));
//		}
//		//Rook
//		else if(pieceType.contains("R"))
//		{
//			board[row][column] = new Tile(new Rook(pieceColor));
//		}
//		//Pawn
//		else if(pieceType.contains("P"))
//		{
//			board[row][column] = new Tile(new Pawn(pieceColor));
//		}
		
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
					System.out.print(board[i][j].checkName() + " ");
				}
			}
			System.out.println("");
		}
		System.out.println("    a  b  c  d  e  f  g  h");
	}
}

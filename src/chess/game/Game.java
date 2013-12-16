package chess.game;
import chess.IO.FileIO;
import chess.board.Chessboard;
import chess.board.Location;
import chess.board.Tile;
import chess.pieces.Piece;

import java.util.Scanner;
import java.util.ArrayList;

public class Game 
{
	private Chessboard board;
	private boolean isPlayer1Turn = true;
	private boolean player1InCheck = false;
	private boolean player2InCheck = false;
	private boolean player1Checkmated = false;
	private boolean player2Checkmated = false;
	
	public Game()
	{
		board = new Chessboard();
	}
	
	/*
	 * Sets up the game
	 */
	public void setUpGame(String filePath)
	{
		FileIO fileRead = new FileIO();
		
		fileRead.startPiecePlacement(board, filePath);
		playGame();
	}
	
	/*
	 * Where the game is played
	 */
	public void playGame()
	{
		while(!player1Checkmated || !player2Checkmated)
		{
			takeTurn();
		}
		
		if(player1Checkmated)
		{
			System.out.println("Player 1 is in checkmate. Player 2 wins.");
		}
		else if(player2Checkmated)
		{
			System.out.println("Player 2 is in checkmate. Player 1 wins.");
		}
	}
	
	/*
	 * Where the player takes their turn
	 */
	public void takeTurn()
	{
		Scanner playerInput = new Scanner(System.in);
		
		if(isPlayer1Turn)
		{
			player1InCheck = evaluateLightCheck(board) ? true : false;
			player1Checkmated = evaluateLightCheckmate(board) ? true : false;
			
			if(player1InCheck)
			{
				System.out.println("Player 1, you're in check.");
			}
			
			board.printBoard();
			System.out.println("It's player 1's turn. Choose a piece.");
			String p1PieceSelect = playerInput.nextLine();
			Location lightPieceSelected = new Location(p1PieceSelect);
			
			System.out.println("Enter a location on the board to move the piece.");
			String p1PieceMove = playerInput.nextLine();
			Location lightToMove = new Location(p1PieceMove);
			
			if(lightPieceSelected != null && lightToMove != null)
			{
//				if(board.getPieceAtLocation(lightPieceSelected).isPieceWhite() == isPlayer1Turn)
//				{
					if(board.movePiece(lightPieceSelected, lightToMove))
					{
						changePlayerTurn();
					}
//				}
			}
		}
		else
		{
			player2InCheck = evaluateDarkCheck(board) ? true : false;
			player2Checkmated = evaluateDarkCheckmate(board) ? true : false;
			
			//Check 
			if(player2InCheck)
			{
				System.out.println("Player 2, you're in check.");
			}
			
			board.printBoard();
			System.out.println("It's player 2's turn. Choose a piece.");
			String p2PieceSelect = playerInput.nextLine();
			Location darkPieceSelected = new Location(p2PieceSelect);
			
			System.out.println("Enter a location on the board to move the piece.");
			String p2PieceMove = playerInput.nextLine();
			Location darkToMove = new Location(p2PieceMove);
			
			if(darkPieceSelected != null && darkToMove != null)
			{
//				if(board.getPieceAtLocation(darkPieceSelected).isPieceWhite() == isPlayer1Turn)
//				{
					if(board.movePiece(darkPieceSelected, darkToMove))
					{
						changePlayerTurn();
					}
//				}
			}
		}
	}
	
	/*
	 * Checks if light king is in check
	 */
	public boolean evaluateLightCheck(Chessboard board)
	{
		//Create copies of the board at its current state so that I'm not modifying the game
		Chessboard chessboardCopy = new Chessboard(board);
		Tile[][] tileBoardCopy = chessboardCopy.getBoard();
		
		//Get king and king location
		Piece lightKing = getLightKing(tileBoardCopy, true);
		Location lightKingLoc = lightKing.getLocation();
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				//When in doubt, switch i and j once more
				if(tileBoardCopy[i][j].getPiece() != null)
				{
					Location pieceLoc = tileBoardCopy[i][j].getPiece().getLocation();
					
					//if piece and king are not same color
					if(tileBoardCopy[i][j].getPiece().isPieceWhite() != lightKing.isPieceWhite())
					{
						//if piece can move to king
						if(chessboardCopy.testMovePiece(pieceLoc, lightKingLoc, tileBoardCopy))
						{
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	/*
	 * Checks if dark king is in check
	 */
	public boolean evaluateDarkCheck(Chessboard board)
	{
		//Create copies of the board at its current state so that I'm not modifying the game
		Chessboard chessboardCopy = new Chessboard(board);
		Tile[][] tileBoardCopy = chessboardCopy.getBoard();
		
		//Get king and king location
		Piece darkKing = getDarkKing(tileBoardCopy, false);
		Location darkKingLoc = darkKing.getLocation();
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				//When in doubt, switch i and j once more
				if(tileBoardCopy[i][j].getPiece() != null)
				{
					Location pieceLoc = tileBoardCopy[i][j].getPiece().getLocation();
					
					//if piece and king are not same color
					if(tileBoardCopy[i][j].getPiece().isPieceWhite() != darkKing.isPieceWhite())
					{
						//if piece can move to king
						if(chessboardCopy.testMovePiece(pieceLoc, darkKingLoc, tileBoardCopy))
						{
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	/*
	 * Check for light checkmate
	 */
	public boolean evaluateLightCheckmate(Chessboard boardToCheck)
	{
		return true;
	}
	
	/*
	 * Check for dark checkmate
	 */
	public boolean evaluateDarkCheckmate(Chessboard boardToCheck)
	{
		return true;
	}
	
	/*
	 * Gets the white king from the board
	 */
	public Piece getLightKing(Tile[][] board, boolean isWhite)
	{
		Piece lightKing = null;
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				//If the space isn't null
				if(board[j][i] != null && board[j][i].getPiece() != null)
				{
					//Get a piece with the name "K" (which should be a king)
					if(board[j][i].getPiece().getName().contains("K") && board[j][i].getPiece().isPieceWhite())
					{
						lightKing = board[j][i].getPiece();
					}
				}
			}
		}
		
		return lightKing;
	}
	
	/*
	 * Gets the dark king from the board
	 */
	public Piece getDarkKing(Tile[][] board, boolean isWhite)
	{
		Piece darkKing = null;
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				//If the space isn't null
				if(board[j][i] != null && board[j][i].getPiece() != null)
				{
					//Get a piece with the name "K" (which should be a king)
					if(board[j][i].getPiece().getName().contains("K") && !board[j][i].getPiece().isPieceWhite())
					{
						darkKing = board[j][i].getPiece();
					}
				}
			}
		}
		
		return darkKing;
	}
	
	/*
	 * Changes the player's turn
	 */
	public void changePlayerTurn()
	{
		isPlayer1Turn = !isPlayer1Turn;
	}
	
	/*
	 * No need for this method at the moment, just leaving it here in the event that I reimplement it later
	 * 
	public Location getKingLocation(Tile[][] board)
	{
		Location kingLoc = null;
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				//If the space isn't null
				if(board[j][i] != null)
				{
					//Get a piece with the name "K"
					if(board[j][i].getPiece().getName().contains("K"))
					{
						System.out.println("There's a king here");
						kingLoc = board[j][i].getPiece().getLocation();
					}
				}
			}
		}
		
		return kingLoc;
	}
	*/
}

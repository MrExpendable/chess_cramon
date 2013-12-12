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
	private Player player1, player2;
	private boolean isPlayer1Turn = true;
	private boolean player1InCheck = false;
	private boolean player2InCheck = false;
	
	public Game()
	{
		board = new Chessboard();
	}
	
	public void setUpGame(String filePath)
	{
		FileIO fileRead = new FileIO();
		player1 = new Player();
		player2 = new Player();
		
		fileRead.startPiecePlacement(board, filePath);
		playGame();
	}
	
	public void playGame()
	{
		Scanner playerInput = new Scanner(System.in);
		
		while(true)
		{
			//checkmate:
			//create boolean playerXInCheck
			//If (playerXInCheck && evaluateForCheck(board))
			// game over
			//Author note: This is a really easy way out.. but it doesn't cover everything (what if the king can't move anywhere without getting capped?)
			//I should design some other way to do this
			if(isPlayer1Turn)
			{
				player1InCheck = evaluateLightCheck(board) ? true : false;
				
				//Check
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
					if(board.movePiece(lightPieceSelected, lightToMove))
					{
						changePlayerTurn();
					}
				}
			}
			else
			{
				player2InCheck = evaluateDarkCheck(board) ? true : false;
				
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
					if(board.movePiece(darkPieceSelected, darkToMove))
					{
						changePlayerTurn();
					}
				}
			}
		}
	}
	
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

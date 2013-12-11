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
			if(isPlayer1Turn)
			{
				player1InCheck = evaluateForCheck(board) ? true : false;
				
				if(player1InCheck)
				{
					System.err.println("Player 1, you're in check.");
				}
				
				board.printBoard();
				System.out.println("It's player 1's turn. Choose a piece.");
				String p1PieceSelect = playerInput.nextLine();
				Location pieceSelected = new Location(p1PieceSelect);
				
				System.out.println("Enter a location on the board to move the piece.");
				String p1PieceMove = playerInput.nextLine();
				Location toMove = new Location(p1PieceMove);
				
				if(pieceSelected != null && toMove != null)
				{
					if(board.movePiece(pieceSelected, toMove))
					{
						changePlayerTurn();
					}
				}
			}
			else
			{
				player2InCheck = evaluateForCheck(board) ? true : false;
				
				if(player2InCheck)
				{
					System.err.println("Player 2, you're in check.");
				}
				
				board.printBoard();
				System.out.println("It's player 2's turn. Choose a piece.");
				String p2PieceSelect = playerInput.nextLine();
				Location pieceSelected = new Location(p2PieceSelect);
				
				System.out.println("Enter a location on the board to move the piece.");
				String p2PieceMove = playerInput.nextLine();
				Location toMove = new Location(p2PieceMove);
				
				if(pieceSelected != null && toMove != null)
				{
					if(board.movePiece(pieceSelected, toMove))
					{
						changePlayerTurn();
					}
				}
			}
		}
	}
	
	public boolean evaluateForCheck(Chessboard board)
	{
		//Create copies of the board at its current state so that I'm not modifying the game
		Chessboard chessboardCopy = board;
		Tile[][] tileBoardCopy = chessboardCopy.getBoard();
		
		//Get king and king location
		Piece kingToCheck = getKingFromBoard(tileBoardCopy);
		Location kingLoc = kingToCheck.getLocation();
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				//When in doubt, switch i and j once more
				if(tileBoardCopy[i][j].getPiece() != null)
				{
					Location pieceLoc = tileBoardCopy[i][j].getPiece().getLocation();
					
					//if piece and king are not same color
					if(tileBoardCopy[i][j].getPiece().isPieceWhite() != kingToCheck.isPieceWhite())
					{
						//if piece can move to king
						if(chessboardCopy.testMovePiece(pieceLoc, kingLoc, tileBoardCopy))
						{
							changePlayerTurn();
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public Piece getKingFromBoard(Tile[][] board)
	{
		Piece king = null;
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				//If the space isn't null
				if(board[j][i] != null && board[j][i].getPiece() != null)
				{
					//Get a piece with the name "K" (which should be a king)
					if(board[j][i].getPiece().getName().contains("K"))
					{
						king = board[j][i].getPiece();
					}
				}
			}
		}
		
		return king;
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

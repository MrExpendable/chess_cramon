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
	ArrayList<Location> checkMovesForCheck = null;
	
	public Game()
	{
		board = new Chessboard();
	}
	
	public void setUpGame(String filePath)
	{
		FileIO fileRead = new FileIO();
		player1 = new Player();
		player2 = new Player();
		
		fileRead.readFile(board, filePath);
		playGame();
	}
	
	public void playGame()
	{
		Scanner playerInput = new Scanner(System.in);
		
		while(true)
		{
			if(isPlayer1Turn)
			{
				if(evaluateForCheck(board))
				{
					System.err.println("Player 1, your king is in check.");
				}
				
				System.out.println("It's player 1's turn.");
				String p1Input = playerInput.nextLine();
				changePlayerTurn();
			}
			else
			{
				if(evaluateForCheck(board))
				{
					System.err.println("Player 2, your king is in check.");
				}
				
				System.out.println("It's player 2's turn.");
				String p2Input = playerInput.nextLine();
				changePlayerTurn();
			}
		}
	}
	
	public Location getKingLocation(Tile[][] board)
	{
		Location kingLoc = null;
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(board[j][i].getPiece().getName().contains("K"))
				{
					System.out.println("lol");
					kingLoc = board[j][i].getPiece().getLocation();
				}
			}
		}
		
		return kingLoc;
	}
	
	public boolean evaluateForCheck(Chessboard board)
	{
		Tile[][] boardCopy = new Tile[8][8];
		boardCopy = board.getBoard();
		Location kingLoc = getKingLocation(boardCopy);
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(boardCopy[j][i] != null)
				{
					Location pieceLoc = boardCopy[j][i].getPiece().getLocation();
					
					if(board.movePiece(pieceLoc, kingLoc))
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void changePlayerTurn()
	{
		isPlayer1Turn = !isPlayer1Turn;
	}
}

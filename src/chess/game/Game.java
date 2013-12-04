package chess.game;
import chess.IO.FileIO;
import chess.board.Chessboard;
import chess.board.Location;

import java.util.ArrayList;

public class Game 
{
	private Chessboard board;
	private Player player1, player2;
	private boolean isPlayer1Turn = true;
	ArrayList<Location> moves = null;
	
	public Game()
	{
		board = new Chessboard();
	}
	
	public void setUpGame(String filePath)
	{
		FileIO fileRead = new FileIO();
		player1 = new Player();
		player2 = new Player();
		
		board.fillSpecialPieces();
		board.printBoard();
		
		//fileRead.readFile(board, filePath);
		
		//moves = fileRead.readFile(filePath);
	}
	
	public void playGame()
	{
		
//		for(int i = 0; i < moves.size(); i++)
//		{
//			board.movePiece(moves.get(i), moves.get(i+1));
//			changePlayerTurn();
//		}
	}
	
//	public void changePlayerTurn()
//	{
//		isPlayer1Turn = !isPlayer1Turn;
//	}
}

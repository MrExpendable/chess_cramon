package chess.game;
import chess.IO.FileIO;
import chess.board.Chessboard;

public class Game 
{
	private Chessboard board;
	
	public void startGame(String filePath)
	{
		FileIO fileRead = new FileIO();
		board = new Chessboard();
		
		//fileRead.printPath();
		
		//making sure that command line arguments are correct
		System.out.println(filePath);
		
		fileRead.readFile(board, filePath);
		board.printBoard();
	}
}

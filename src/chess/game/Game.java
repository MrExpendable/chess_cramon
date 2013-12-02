package chess.game;
import chess.IO.FileIO;
import chess.board.Chessboard;

public class Game 
{
	private Chessboard board;
	
	public Game()
	{
		board = new Chessboard();
	}
	
	public void startGame(String filePath)
	{
		FileIO fileRead = new FileIO();
		
		//board.fillPawns();
		board.fillSpecialPieces();
		board.printBoard();
		
		fileRead.readFile(board, filePath);
	}
}

package chess.IO;
import chess.board.Chessboard;

public class RunIO 
{
	public static void main(String[] args)
	{
		FileIO fileRead = new FileIO();
		Chessboard board = new Chessboard();
		
		fileRead.readFile(board, args[0]);
		board.printBoard();
	}
}

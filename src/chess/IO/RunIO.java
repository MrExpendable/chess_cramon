package chess.IO;
import chess.board.Chessboard;

public class RunIO 
{
	public static void main(String[] args)
	{
		FileIO work = new FileIO();
		Chessboard board = new Chessboard();
		
		String[] myArgs = new String[1];
		
		if(args.length == 0)
		{
			myArgs[0] = "module1";
		}
		else
		{
			myArgs = args;
		}
		
		work.readFile(board, myArgs[0]);
		board.printBoard();
	}
}

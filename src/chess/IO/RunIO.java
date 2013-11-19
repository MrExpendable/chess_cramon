package chess.IO;
import chess.board.Chessboard;

import java.util.ArrayList;

public class RunIO 
{
	public static void main(String[] args)
	{
		String[] myArgs = new String[1];
		
		if(args.length == 0)
		{
			myArgs[0] = "module1";
		}
		else
		{
			myArgs = args;
		}
		
		FileIO work = new FileIO();
		FileParser parser = new FileParser();
		
		ArrayList<String> fileContents = work.readFile(myArgs[0]);
		
		parser.pieceCapture(fileContents);
		parser.pieceMovement(fileContents);
		parser.piecePlacement(fileContents);
		parser.checkCastle(fileContents);
		
		Chessboard board = new Chessboard();
		board.printBoard();
	}
}

package chess.IO;
import chess.board.Chessboard;
import chess.board.Location;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser
{
	//Checks for piece movement
	public void pieceMovement(Chessboard board, String toRead)
	{
		Pattern movement = Pattern.compile("(?<initPos>[a-h][1-8])\\s(?<finalPos>[a-h][1-8])");
		Matcher matcher = movement.matcher(toRead);
		
//		ArrayList<Location> movesToReturn = null;
		
		if(matcher.find())
		{
			Location initPos = new Location(matcher.group("initPos"));
			Location finalPos = new Location(matcher.group("finalPos"));
			
//			movesToReturn.add(initPos);
//			movesToReturn.add(finalPos);
			//board.movePiece(initPos, finalPos);
			board.printBoard();
		}
		
//		return movesToReturn;
	}
	
	//Checks for piece capturing
	public void pieceCapture(Chessboard board, String toRead)
	{
		System.out.println("Piece capture\n");
		Pattern capture = Pattern.compile("(?<initPos>[a-h][1-8])\\s(?<finalPos>[a-h][1-8])\\*");
		Matcher matcher = capture.matcher(toRead);
		
		if(matcher.find())
		{
			System.out.printf("Moved piece from %s to %s and captured piece%n", matcher.group("initPos"), matcher.group("finalPos"), matcher.group("finalPos"));
		}
		
		System.out.println("");
	}
	
	//Checks that pieces are placed
	public void piecePlacement(Chessboard boardToFill, String toRead)
	{
		//System.out.println("Piece placement\n");
		
		Pattern placement = Pattern.compile("(?<piece>[BKNPQR][dl])(?<position>[a-h][1-8])");
		Matcher matcher = placement.matcher(toRead);
		
		if(matcher.find())
		{
			String pieceType = matcher.group("piece");
			String position = matcher.group("position");
			boolean pieceIsWhite = (pieceType.contains("l") ? true : false);
			String pieceName = pieceType.substring(0, 1);
			
			System.out.printf("%s %s to be placed at: %s%n", pieceIsWhite, pieceName, position);
			
			boardToFill.parsePieceInfo(pieceIsWhite, pieceName, position);
		}
	}
	
	//Checks for castling
	public void checkCastle(Chessboard board, String toRead)
	{
		System.out.println("Check castle\n");
		Pattern castle = Pattern.compile("([a-h][18])\\s([a-h][18])\\s([a-h][18])\\s([a-h][18])");
		Matcher matcher = castle.matcher(toRead);
		
		if(matcher.find())
		{
			System.out.printf("Switched rook and king on positions %s and %s, and positions %s and %s%n", matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
		}
		System.out.println("");
	}
}

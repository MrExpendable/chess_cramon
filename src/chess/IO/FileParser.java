package chess.IO;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser
{
	//Checks for piece movement
	public void pieceMovement(ArrayList<String> toRead)
	{
		System.out.println("Piece movement\n");
		for(String toMatch : toRead)
		{
			Pattern movement = Pattern.compile("(?<initPos>[a-h][1-8])\\s(?<finalPos>[a-h][1-8])");
			Matcher matcher = movement.matcher(toMatch);
			
			if(matcher.find())
			{
				System.out.printf("Moved piece from %s to %s%n", matcher.group("initPos"), matcher.group("finalPos"));
			}
		}
		System.out.println("");
	}
	
	//Checks for piece capturing
	public void pieceCapture(ArrayList<String> toRead)
	{
		System.out.println("Piece capture\n");
		for(String toMatch : toRead)
		{
			Pattern capture = Pattern.compile("(?<initPos>[a-h][1-8])\\s(?<finalPos>[a-h][1-8])\\*");
			Matcher matcher = capture.matcher(toMatch);
			
			if(matcher.find())
			{
				System.out.printf("Moved piece from %s to %s and captured piece%n", matcher.group("initPos"), matcher.group("finalPos"), matcher.group("finalPos"));
			}
		}
		
		System.out.println("");
	}
	
	//Checks that pieces are placed
	public void piecePlacement(ArrayList<String> toRead)
	{
		System.out.println("Piece placement\n");
		for(String toMatch : toRead)
		{
			Pattern placement = Pattern.compile("(?<piece>[BKNPQR][dl])(?<position>[a-h][1-8])");
			Matcher matcher = placement.matcher(toMatch);
			
			if(matcher.find())
			{
				String pieceType = matcher.group("piece");
				String position = matcher.group("position");
				String pieceColor = (pieceType.contains("l") ? "light" : "dark");
				String pieceName = null;
				
				//Bishop
				if(pieceType.contains("B"))
				{
					pieceName = "bishop";
				}
				//King
				else if(pieceType.contains("K"))
				{
					pieceName = "king";
				}
				//Knight
				else if(pieceType.contains("N"))
				{
					pieceName = "knight";
				}
				//Queen
				else if(pieceType.contains("Q"))
				{
					pieceName = "queen";
				}
				//Rook
				else if(pieceType.contains("R"))
				{
					pieceName = "rook";
				}
				//Pawn
				else if(pieceType.contains("P"))
				{
					pieceName = "pawn";
				}
				
				System.out.printf("%s %s placed at: %s%n", pieceColor, pieceName, position);
			}
		}
		System.out.println("");
	}
	
	//Checks for castling
	public void checkCastle(ArrayList<String> toRead)
	{
		System.out.println("Check castle\n");
		for(String toMatch : toRead)
		{
			//(?<piece1InitPos>[a-h][18])\\s(?<piece1FinalPos>[a-h][18])\\s(?<piece2InitPos>[a-h][18])\\s(?<piece2FinalPos>[a-h][18])
			
			Pattern castle = Pattern.compile("([a-h][18])\\s([a-h][18])\\s([a-h][18])\\s([a-h][18])");
			Matcher matcher = castle.matcher(toMatch);
			
			//DOESN'T WORK
//			String piece1InitPos = matcher.group("piece1Init");
//			String piece1FinalPos = matcher.group("piece1FinalPos");
//			String piece2InitPos = matcher.group("piece2InitPos");
//			String piece2FinalPos = matcher.group("piece2FinalPos");
			
			if(matcher.find())
			{
				System.out.printf("Switched rook and king on positions %s and %s, and positions %s and %s%n", matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
			}
		}
		System.out.println("");
	}
}

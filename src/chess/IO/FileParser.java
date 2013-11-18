package chess.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser
{
	String nextLine;
	
	//Checks for piece movement
	public void pieceMovement(BufferedReader reader)
	{
		System.out.println("Piece movement\n");
		try
		{
			//If input invalid, include error message that includes attempted input
			nextLine = "";
			
			while(reader.ready())
			{
				nextLine = reader.readLine();
				Pattern movement = Pattern.compile("(?<initPos>[a-h][1-8])\\s(?<finalPos>[a-h][1-8])");
				Matcher matcher = movement.matcher(nextLine);
				
				while(matcher.find())
				{
					System.out.printf("Moved piece from %s to %s%n", matcher.group("initPos"), matcher.group("finalPos"));
				}
			}
			System.out.println("");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Error reading file");
		}
	}
	
	//Checks for piece capturing
	public void pieceCapture(BufferedReader reader)
	{
		System.out.println("Piece capture\n");
		try
		{
			//If input invalid, include error message that includes attempted input
			nextLine = "";
			
			while(reader.ready())
			{
				nextLine = reader.readLine();
				Pattern capture = Pattern.compile("(?<initPos>[a-h][1-8])\\s(?<finalPos>[a-h][1-8])\\*");
				Matcher matcher = capture.matcher(nextLine);
				
				if(matcher.find())
				{
					System.out.printf("Moved piece from %s to %s and captured piece%n", matcher.group("initPos"), matcher.group("finalPos"), matcher.group("finalPos"));
				}
			}
			
			System.out.println("");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Error reading file");
		}
	}
	
	//Checks that pieces are placed
	public void piecePlacement(BufferedReader reader)
	{
		System.out.println("Piece placement\n");
		try
		{
			//If input invalid, include error message that includes attempted input
			nextLine = "";
			
			while(reader.ready())
			{
				nextLine = reader.readLine();
				Pattern placement = Pattern.compile("(?<piece>[BKNPQR][dl])(?<position>[a-h][1-8])");
				Matcher matcher = placement.matcher(nextLine);
				
				while(matcher.find())
				{
					String pieceType = matcher.group("piece");
					String position = matcher.group("position");
					
					//Bishop
					if(pieceType.contains("B"))
					{
						if(pieceType.contains("l"))
						{
							System.out.println("Light bishop placed at: " + position);
						}
						else if(pieceType.contains("d"))
						{
							System.out.println("Dark bishop placed at: " + position);
						}
					}
					//King
					else if(pieceType.contains("K"))
					{
						if(pieceType.contains("l"))
						{
							System.out.println("Light king placed at: " + position);
						}
						else if(pieceType.contains("d"))
						{
							System.out.println("Dark king placed at: " + position);
						}
					}
					//Knight
					else if(pieceType.contains("N"))
					{
						if(pieceType.contains("l"))
						{
							System.out.println("Light knight placed at: " + position);
						}
						else if(pieceType.contains("d"))
						{
							System.out.println("Batman placed at: " + position);
						}
					}
					//Queen
					else if(pieceType.contains("Q"))
					{
						if(pieceType.contains("l"))
						{
							System.out.println("Light queen placed at: " + position);
						}
						else if(pieceType.contains("d"))
						{
							System.out.println("Dark queen placed at: " + position);
						}
					}
					//Rook
					else if(pieceType.contains("R"))
					{
						if(pieceType.contains("l"))
						{
							System.out.println("Light rook placed at: " + position);
						}
						else if(pieceType.contains("d"))
						{
							System.out.println("Dark rook placed at: " + position);
						}
					}
					//Pawn
					else if(pieceType.contains("P"))
					{
						if(pieceType.contains("l"))
						{
							System.out.println("Light pawn placed at: " + position);
						}
						else if(pieceType.contains("d"))
						{
							System.out.println("Dark pawn placed at: " + position);
						}
					}
				}
			}
			System.out.println("");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Error reading file");
		}
	}
	
	//Checks for castling
	public void checkCastle(BufferedReader reader)
	{
		System.out.println("Check castle\n");
		try
		{
			//If input invalid, include error message that includes attempted input
			nextLine = "";
			
			while(reader.ready())
			{
				nextLine = reader.readLine();
				Pattern castle = Pattern.compile("(?<piece1InitPos>[a-h][18])\\s(?<piece1FinalPos>[a-h][18])\\s(?<piece2InitPos>[a-h][18])\\s(?<piece2FinalPos>[a-h][18])");
				Matcher matcher = castle.matcher(nextLine);
				
				String piece1InitPos = matcher.group("piece1InitPos");
				String piece1FinalPos = matcher.group("piece1FinalPos");
				String piece2InitPos = matcher.group("piece2InitPos");
				String piece2FinalPos = matcher.group("piece2FinalPos");
				
				if(matcher.find())
				{
					System.out.printf("Switched rook and king on positions %s and %s, and positions %s and %s%n", piece1InitPos, piece1FinalPos, piece2InitPos, piece2FinalPos);
				}
			}
			System.out.println("");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Error reading file");
		}
	}
}

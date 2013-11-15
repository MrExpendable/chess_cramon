package chess.IO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FileIO 
{
	BufferedReader bReader = null;
	String nextLine;
	
	//Checks for piece movement
	public void pieceMovement(String fileName)
	{
		try
		{
			//If input invalid, include error message that includes attempted input
			bReader = new BufferedReader(new FileReader(fileName));
			nextLine = "";
			
			while(bReader.ready())
			{
				nextLine = bReader.readLine();
				Pattern movement = Pattern.compile("([a-h][1-8])\\s([a-h][1-8])");
				Matcher matcher = movement.matcher(nextLine);
				
				while(matcher.find())
				{
					System.out.printf("Moved piece from %s to %s%n", matcher.group(1), matcher.group(2));
				}
			}
			System.out.println("");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Error reading file");
		}
		finally
		{
			//Close the buffered reader stream
			try 
			{
				bReader.close();
			} 
			catch (IOException e) 
			{
				System.out.println("Couldn't close buffered reader stream");
			}
		}
	}
	
	//Checks for piece capturing
	public void pieceCapture(String fileName)
	{
		try
		{
			//If input invalid, include error message that includes attempted input
			bReader = new BufferedReader(new FileReader(fileName));
			nextLine = "";
			
			while(bReader.ready())
			{
				nextLine = bReader.readLine();
				Pattern capture = Pattern.compile("([a-h][1-8])\\s([a-h][1-8])\\*");
				Matcher matcher = capture.matcher(nextLine);
				
				if(matcher.find())
				{
					System.out.printf("Moved piece from %s to %s and captured piece%n", matcher.group(1), matcher.group(2), matcher.group(2));
				}
				else
				{
					System.err.println(nextLine + " is invalid input");
				}
			}
			
			System.out.println("");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Error reading file");
		}
		finally
		{
			//Close the buffered reader stream
			try 
			{
				bReader.close();
			} 
			catch (IOException e) 
			{
				System.out.println("Couldn't close buffered reader stream");
			}
		}
	}
	
	//Checks that pieces are placed
	public void piecePlacement(String fileName)
	{
		try
		{
			//If input invalid, include error message that includes attempted input
			bReader = new BufferedReader(new FileReader(fileName));
			nextLine = "";
			
			while(bReader.ready())
			{
				nextLine = bReader.readLine();
				Pattern placement = Pattern.compile("([BKNPQR][dl])([a-h][1-8])");
				Matcher matcher = placement.matcher(nextLine);
				
				while(matcher.find())
				{
					String pieceType = matcher.group(1);
					String position = matcher.group(2);
					
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
		finally
		{
			//Close the buffered reader stream
			try 
			{
				bReader.close();
			} 
			catch (IOException e) 
			{
				System.out.println("Couldn't close buffered reader stream");
			}
		}
	}
	
	//Checks for castling
	public void checkCastle(String fileName)
	{
		try
		{
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Error reading file");
		}
		finally
		{
			//Close the buffered reader stream
			try 
			{
				bReader.close();
			} 
			catch (IOException e) 
			{
				System.out.println("Couldn't close buffered reader stream");
			}
		}
	}
}

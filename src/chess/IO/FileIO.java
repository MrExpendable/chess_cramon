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
				Pattern newPattern = Pattern.compile("([BKNPQR][dl])([a-h][1-8])");
				Matcher matcher = newPattern.matcher(nextLine);
				
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
							System.out.println("Dark knight(lol) placed at: " + position);
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
	
	public static void main(String[] args)
	{
		String[] myArgs = new String[1];
		
		if(args.length == 0)
		{
			myArgs[0] = "module1_piecePlacement.txt";
		}
		else
		{
			myArgs = args;
		}
		
		FileIO work = new FileIO();
		work.piecePlacement(myArgs[0]);
	}
}

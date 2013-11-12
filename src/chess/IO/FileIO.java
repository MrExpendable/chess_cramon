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
				Pattern newPattern = Pattern.compile("([BKNPQR])([dl])([a-h][1-8])");
				Matcher matcher = newPattern.matcher(nextLine);
				
				while(matcher.find())
				{
					System.out.printf("Piece: %s\nColor: %s\nPosition: %s%n", matcher.group(1), matcher.group(2), matcher.group(3));
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

package chess.IO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FileIO 
{
	BufferedReader bReader = null;
	
	public void readFile(String fileName)
	{
		ArrayList<String> fileContents = new ArrayList<>();
		try
		{
			FileParser parser = new FileParser();
			bReader = new BufferedReader(new FileReader(fileName));
			
			while(bReader.ready())
			{
				String nextLine = bReader.readLine();
				
				fileContents.add(nextLine);
			}
			
			parser.pieceCapture(fileContents);
			parser.pieceMovement(fileContents);
			parser.piecePlacement(fileContents);
			parser.checkCastle(fileContents);
		}
		catch(IOException e)
		{
			System.err.println("Couldn't read file");
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
				System.err.println("Couldn't close buffered reader stream");
			}
		}
	}
}

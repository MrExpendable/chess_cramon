package chess.IO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FileIO 
{
	BufferedReader bReader = null;
	
	public void readFile(String fileName)
	{
		try
		{
			FileParser parser = new FileParser();
			bReader = new BufferedReader(new FileReader(fileName));
			
			parser.pieceCapture(bReader);
			parser.pieceMovement(bReader);
			parser.piecePlacement(bReader);
			parser.checkCastle(bReader);
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

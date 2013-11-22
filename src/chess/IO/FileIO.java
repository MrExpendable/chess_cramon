package chess.IO;
import chess.board.Chessboard;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileIO 
{
	//InputStream is used to read the file
	//BufferedReader is used to read the stream and translate it to a readable format
	FileParser parser;
	InputStream input;
	String nextLine;
	
	public void readFile(Chessboard boardToFill, String fileName)
	{
		parser = new FileParser();
		try
		{
			input = getClass().getResourceAsStream("/resources/module1");
			BufferedReader bReader = new BufferedReader(new InputStreamReader(input));
			
			try 
			{
				while(bReader.ready())
				{
					nextLine = bReader.readLine();
					
					parser.piecePlacement(boardToFill, nextLine);
					//CALL THE MATCHING METHODS DIRECTLY FROM HERE
				}
			}
			catch(IOException e) 
			{
			    e.printStackTrace();
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
		catch(Exception e)
		{
			System.err.println("Couldn't read file");
		}
		finally
		{
			//Close the InputStream
			try
			{
				input.close();
			}
			catch(IOException e)
			{
				System.err.println("Couldn't close input stream");
			}
		}
	}
}

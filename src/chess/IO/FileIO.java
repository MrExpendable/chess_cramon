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
	private FileParser parser;
	private InputStream input;
	String nextLine;
	
	public void readFile(Chessboard boardToFill, String filePath)
	{
		parser = new FileParser();
		try
		{
			System.out.println(filePath);
			input = getClass().getResourceAsStream("module1");
			BufferedReader bReader = new BufferedReader(new InputStreamReader(input));
			System.out.println("Work already");
			try 
			{
				System.out.println("Get inside this try catch");
				while(bReader.ready())
				{
					System.out.println("Fucking read this next line: " + nextLine);
					nextLine = bReader.readLine();
					
					parser.piecePlacement(boardToFill, nextLine);
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
			System.err.println("Unable to read file");
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
	
	public void printPath()
	{
		String path = getClass().getClassLoader().getResource("chess/io/module1").getPath();
		System.out.println(path);
	}
}

package chess.IO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileIO 
{
	InputStream input;
	
	public ArrayList<String> readFile(String fileName)
	{
		ArrayList<String> file = new ArrayList<>();
		try
		{
			input = getClass().getResourceAsStream("/resources/module1");
			BufferedReader bReader = new BufferedReader(new InputStreamReader(input));
			
			try 
			{
				while(bReader.ready())
				{
					String nextLine = bReader.readLine();
					
					file.add(nextLine);
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
			try
			{
				input.close();
			}
			catch(IOException e)
			{
				System.err.println("Couldn't close input stream");
			}
		}
		
		return file;
	}
}

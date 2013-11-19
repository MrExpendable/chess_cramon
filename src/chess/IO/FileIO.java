package chess.IO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class FileIO 
{
	//BufferedReader bReader = null;
	
	public ArrayList<String> readFile(String fileName)
	{
		ArrayList<String> file = new ArrayList<>();
		try
		{
			InputStream input = getClass().getResourceAsStream("/resources/module1");
			
			BufferedReader bReader = new BufferedReader(new InputStreamReader(input));
			try 
			{
			    while(bReader.readLine() != null) 
			    {
			        file.add(bReader.readLine());
			    }  
			} 
			catch(IOException e) 
			{
			    e.printStackTrace();
			}
//			bReader = new BufferedReader(new FileReader(fileName));
//			
//			while(bReader.ready())
//			{
//				String nextLine = bReader.readLine();
//				
//				file.add(nextLine);
//			}
		}
		catch(Exception e)
		{
			System.err.println("Couldn't read file");
		}
//		finally
//		{
//			//Close the buffered reader stream
//			try 
//			{
//				bReader.close();
//			} 
//			catch (IOException e) 
//			{
//				System.err.println("Couldn't close buffered reader stream");
//			}
//		}
		
		return file;
	}
}

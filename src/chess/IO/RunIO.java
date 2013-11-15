package chess.IO;

public class RunIO 
{
	public static void main(String[] args)
	{
		String[] myArgs = new String[1];
		
		if(args.length == 0)
		{
			myArgs[0] = "module1";
		}
		else
		{
			myArgs = args;
		}
		
		FileIO work = new FileIO();
		
		work.readFile(myArgs[0]);
	}
}

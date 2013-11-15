package chess.IO;

public class RunIO 
{
	public static void main(String[] args)
	{
		String[] txtList = 
		{
			"module1_piecePlacement",
			"module1_pieceMovement",
			"module1_pieceCapture",
			"module1_castle"
		};
		
		FileIO work = new FileIO();
		
		work.piecePlacement(txtList[0]);
		work.pieceMovement(txtList[1]);
		work.pieceCapture(txtList[2]);
	}
}

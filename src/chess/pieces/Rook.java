package chess.pieces;

public class Rook extends Piece
{
	public Rook(String c, String n)
	{
		super(c, n);
	}
	
	public String getColor()
	{
		return color;
	}
	
	public String getName()
	{
		return name;
	}
	
//	public boolean isValidMove()
//	{
//		if((startRow == endRow && Math.abs(startCol - endCol) <= maxBounds)
//				|| (startCol == endCol && Math.abs(startRow - endRow) <= maxBounds))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
//		
//		//Do something like "return logic here that comes to either true or false" instead of this if else stuff for EVERYTHING
//	}
	
	@Override
	public String toString()
	{
		return color + name;
	}
}

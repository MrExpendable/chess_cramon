package chess.pieces;

public class Rook extends Piece
{
	public Rook(String c, boolean b)
	{
		super(c, b);
	}
	
	public boolean isPieceWhite()
	{
		return isWhite;
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public String toString()
	{
		if(isWhite)
		{
			return "l" + name;
		}
		else
		{
			return "d" + name;
		}
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
}

package chess.pieces;

public class King extends Piece
{
	public King(String c, boolean b)
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
	
	public boolean isValidMove(int startCol, int startRow, int endCol, int endRow)
	{
		//Works
		return ((startRow == endRow && Math.abs(startCol - endCol) <= 1) || (startCol == endCol && Math.abs(startRow - endRow) <= 1) || 
				(endCol != startCol && startRow != endRow && ((Math.abs(startRow - endRow) == 1 && Math.abs(startCol - endCol) == 1))));
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
}

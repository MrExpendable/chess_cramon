package chess.pieces;

public class Bishop extends Piece
{
	public Bishop(String c, boolean b)
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
		return (endCol != startCol && startRow != endRow && ((Math.abs(endRow - startRow) == Math.abs(endCol - startCol)) || Math.abs(startRow - endRow) == Math.abs(startCol - endCol)));
		
		//Do not use
		//return (endCol != startCol && startRow != endRow && ((Math.abs(startRow - endRow) == 1 && Math.abs(startCol - endCol) == 1)));
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

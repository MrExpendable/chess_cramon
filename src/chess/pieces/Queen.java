package chess.pieces;

public class Queen extends Piece
{
	public Queen(String c, boolean b)
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
		final int MAXBOUNDS = 8;
		
		return ((startRow == endRow && Math.abs(startCol - endCol) <= MAXBOUNDS) || (startCol == endCol && Math.abs(startRow - endRow) <= MAXBOUNDS) ||
				(endCol != startCol && startRow != endRow && (Math.abs(endRow - startRow) == Math.abs(endCol - startCol))));
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

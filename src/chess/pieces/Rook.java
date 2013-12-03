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
	
	public boolean isValidMove(int startCol, int startRow, int endCol, int endRow)
	{
		final int MAXBOUNDS = 8;
		
		return (startRow == endRow && Math.abs(startCol - endCol) <= MAXBOUNDS) || (startCol == endCol && Math.abs(startRow - endRow) <= MAXBOUNDS);
	}
}

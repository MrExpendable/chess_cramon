package chess.pieces;

public class Knight extends Piece
{
	public Knight(String c, boolean b)
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
		return ((Math.abs(startCol - endCol) == 2 && Math.abs(startRow - endRow) == 1) ||
					(Math.abs(startCol - endCol) == 1 && Math.abs(startRow - endRow) == 2));
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

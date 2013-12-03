package chess.pieces;

public abstract class Piece 
{
	boolean isWhite;
	String name;
	
	public Piece(String n, boolean b)
	{
		name = n;
		isWhite = b;
	}
	
	public boolean isPieceWhite()
	{
		return isWhite;
	}
	
	public String getName()
	{
		return name;
	}
	
	//public boolean isValidMove(Location old, Location new) { }
	public boolean isValidMove(int fromCol, int fromRow, int toCol, int toRow)
	{
		return false;
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

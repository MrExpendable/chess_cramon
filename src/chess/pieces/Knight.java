package chess.pieces;

public class Knight extends Piece
{
	public Knight(String c, String n)
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
	
	@Override
	public String toString()
	{
		return color + name;
	}
}

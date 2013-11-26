package chess.pieces;

public class King extends Piece
{
	public King(String c, String n)
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

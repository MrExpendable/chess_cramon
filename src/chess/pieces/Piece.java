package chess.pieces;

public abstract class Piece 
{
	String color;
	String name;
	
	public Piece(String c)
	{
		color = c;
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

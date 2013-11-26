package chess.pieces;

public abstract class Piece 
{
	String color;
	String name;
	
	public Piece(String c, String n)
	{
		color = c;
		name = n;
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

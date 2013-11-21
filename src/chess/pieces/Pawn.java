package chess.pieces;

public class Pawn extends Piece
{
	String name;
	String color;
	
	//Make sure that color is being set!
	public Pawn(String c)
	{
		super(c);
		color = c;
		name = "P";
	}
	
	public String getColor()
	{
		return color;
	}
	
	@Override
	public String toString()
	{
		return color + name;
	}
}

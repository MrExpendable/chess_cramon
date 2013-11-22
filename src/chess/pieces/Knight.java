package chess.pieces;

public class Knight extends Piece
{
	String name;
//	String color;
	
	public Knight(String c)
	{
		super(c);
//		color = c;
		name = "N";
	}
	
	@Override
	public String toString()
	{
		return color + name;
	}
}

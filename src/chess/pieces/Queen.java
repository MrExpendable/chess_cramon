package chess.pieces;

public class Queen extends Piece
{
	String name;
//	String color;
	
	public Queen(String c)
	{
		super(c);
//		color = c;
		name = "Q";
	}
	
	@Override
	public String toString()
	{
		return color + name;
	}
}

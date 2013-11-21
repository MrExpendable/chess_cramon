package chess.pieces;

public class Rook extends Piece
{
	String name;
	String color;
	
	public Rook(String c)
	{
		super(c);
		color = c;
		name = "R";
	}
	
	@Override
	public String toString()
	{
		return color + name;
	}
}

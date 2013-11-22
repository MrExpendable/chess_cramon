package chess.pieces;

public class King extends Piece
{
	String name;
	//String color;
	
	public King(String c)
	{
		super(c);
		//color = c;
		name = "K";
	}
	
	@Override
	public String toString()
	{
		return color + name;
	}
}

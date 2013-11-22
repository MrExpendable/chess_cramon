package chess.pieces;

public class Bishop extends Piece
{
	String name;
	//String color;
	
	public Bishop(String c)
	{
		super(c);
		//color = c;
		name = "B";
	}
	
	@Override
	public String toString()
	{
		return color + name;
	}
}

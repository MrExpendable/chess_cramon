package chess.pieces;

public class Rook extends Piece
{
	String name;
	
	public Rook(String c)
	{
		super(c);
		name = "R";
	}
	
	@Override
	public String toString()
	{
		return color + name;
	}
}

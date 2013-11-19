package chess.pieces;

public class Piece 
{
	String color;
	String type;
	
	private void setColor(String set)
	{
		color = set;
	}
	
//	private void setType(String set)
//	{
//		type = set;
//	}
	
	public String getColor()
	{
		return color;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String checkType()
	{
		return color + type;
	}
}

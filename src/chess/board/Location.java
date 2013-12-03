package chess.board;

public class Location
{
	private int row, col;
	
	public Location(int c, int r)
	{
		col = c;
		row = r;
	}
	
	public Location(String pos)
	{
		//The general idea is that this constructor can parse a String position and convert it to a Location
		//Example: A1 would be converted to 0, 0, C4 would be converted to 2, 3
		
		//Converts the chars to ints
		char char1 = pos.charAt(0);
		char char2 = pos.charAt(1);
		col = Character.getNumericValue(char1) - 10;
		row = Character.getNumericValue(char2) - 1;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getColumn()
	{
		return col;
	}
	
	@Override
	public String toString()
	{
		return col + ", " + row;
	}
}
package chess.board;

public class Location
{
	private int row, col;
	
	public Location(int r, int c)
	{
		row = r;
		col = c;
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
		return row + ", " + col;
	}
}
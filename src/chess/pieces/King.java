package chess.pieces;

import chess.board.Location;

public class King extends Piece
{
	public King(String c, boolean b, Location l)
	{
		super(c, b, l);
	}
	
	public boolean isPieceWhite()
	{
		return isWhite;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Location getLocation()
	{
		return pieceLoc;
	}
	
	public void setLocation(Location pieceLoc) 
	{
		this.pieceLoc = pieceLoc;
	}
	
	public boolean isValidMove(int startCol, int startRow, int endCol, int endRow)
	{
		//Works
		return ((startRow == endRow && Math.abs(startCol - endCol) <= 1) || (startCol == endCol && Math.abs(startRow - endRow) <= 1) || 
				(endCol != startCol && startRow != endRow && ((Math.abs(startRow - endRow) == 1 && Math.abs(startCol - endCol) == 1))));
	}
	
	
	@Override
	public String toString()
	{
		if(isWhite)
		{
			return "l" + name;
		}
		else
		{
			return "d" + name;
		}
	}
}

package chess.pieces;

import chess.board.Location;

public class Knight extends Piece
{
	public Knight(String c, boolean b, Location l)
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
		return ((Math.abs(startCol - endCol) == 2 && Math.abs(startRow - endRow) == 1) ||
					(Math.abs(startCol - endCol) == 1 && Math.abs(startRow - endRow) == 2));
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

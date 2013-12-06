package chess.pieces;

import chess.board.Location;

public class Bishop extends Piece
{
	public Bishop(String c, boolean b, Location l)
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
		return (endCol != startCol && startRow != endRow && ((Math.abs(endRow - startRow) == Math.abs(endCol - startCol)) || Math.abs(startRow - endRow) == Math.abs(startCol - endCol)));
		
		//Do not use
		//return (endCol != startCol && startRow != endRow && ((Math.abs(startRow - endRow) == 1 && Math.abs(startCol - endCol) == 1)));
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

package chess.pieces;

import chess.board.Location;

public class Rook extends Piece
{
	public Rook(String c, boolean b, Location l)
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
	
	public boolean isValidMove(int startCol, int startRow, int endCol, int endRow)
	{
		final int MAXBOUNDS = 8;
		
		//works
		return (startRow == endRow && Math.abs(startCol - endCol) <= MAXBOUNDS) || (startCol == endCol && Math.abs(startRow - endRow) <= MAXBOUNDS);
	}
}

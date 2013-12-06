package chess.pieces;

import chess.board.Location;

public abstract class Piece 
{
	protected Location pieceLoc;
	boolean isWhite;
	String name;
	
	public Piece(String n, boolean b, Location l)
	{
		name = n;
		isWhite = b;
		pieceLoc = l;
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
	
	//public boolean isValidMove(Location old, Location new) { }
	public boolean isValidMove(int fromCol, int fromRow, int toCol, int toRow)
	{
		return false;
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

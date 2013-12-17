package chess.pieces;

import chess.board.Location;

public class Pawn extends Piece
{
	private boolean hasMoved = false;
	
	//Make sure that color is being set!
	public Pawn(String c, boolean b, Location l)
	{
		super(c, b, l);
	}
	
	public boolean hasPawnMoved()
	{
		return hasMoved;
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
		if(!hasMoved)
		{
			//If first move was successful
			if((startCol == endCol && endRow - startRow <= 2) 
					|| (startCol == endCol && startRow - endRow <= 2))
			{
				hasMoved = true;
				System.out.println("this pawn has moved: hasMoved = " + hasMoved);
				return true;
			}
			
			//If first move was not successful
			return false;
		}
		else
		{
			//Check for successful subsequent moves
			return (startCol == endCol && Math.abs(startRow - endRow) <= 1) 
					|| (startCol == endCol && Math.abs(startRow + endRow) <= 1);
		}
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

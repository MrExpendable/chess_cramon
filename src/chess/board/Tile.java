package chess.board;
import chess.pieces.*;

public class Tile 
{
	private Piece piece;
	private boolean isVacant;
	
	public Tile(Piece p)
	{
		piece = p;
		isVacant = false;
	}
	
	public void setPiece(String pieceName, boolean isPieceWhite, Location pieceLoc)
	{
		//Bishop
		if(pieceName.contains("B"))
		{
			piece = new Bishop(pieceName, isPieceWhite, pieceLoc);
		}
		//King
		else if(pieceName.contains("K"))
		{
			piece = new King(pieceName, isPieceWhite, pieceLoc);
		}
		//Knight
		else if(pieceName.contains("N"))
		{
			piece = new Knight(pieceName, isPieceWhite, pieceLoc);
		}
		//Queen
		else if(pieceName.contains("Q"))
		{
			piece = new Queen(pieceName, isPieceWhite, pieceLoc);
		}
		//Rook
		else if(pieceName.contains("R"))
		{
			piece = new Rook(pieceName, isPieceWhite, pieceLoc);
		}
		//Pawn
		else if(pieceName.contains("P"))
		{
			piece = new Pawn(pieceName, isPieceWhite, pieceLoc);
		}
		
		isVacant = true;
	}
	
	public Piece getPiece()
	{
		return piece;
	}
	
	public void setVacancy(boolean b)
	{
		isVacant = b;
	}
	
	public boolean getVacancy()
	{
		return isVacant;
	}
	
	public String getPieceName()
	{
		return piece.toString();
	}
}

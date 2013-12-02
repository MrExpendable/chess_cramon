package chess.board;
import chess.pieces.*;

public class Tile 
{
	private Piece piece;
	private boolean isVacant;
	
	public Tile(Piece p)
	{
		piece = p;
		isVacant = true;
	}
	
	public void setPiece(String pieceName, boolean isPieceWhite)
	{
		//Bishop
		if(pieceName.contains("B"))
		{
			piece = new Bishop(pieceName, isPieceWhite);
		}
		//King
		else if(pieceName.contains("K"))
		{
			piece = new King(pieceName, isPieceWhite);
		}
		//Knight
		else if(pieceName.contains("N"))
		{
			piece = new Knight(pieceName, isPieceWhite);
		}
		//Queen
		else if(pieceName.contains("Q"))
		{
			piece = new Queen(pieceName, isPieceWhite);
		}
		//Rook
		else if(pieceName.contains("R"))
		{
			piece = new Rook(pieceName, isPieceWhite);
		}
		//Pawn
		else if(pieceName.contains("P"))
		{
			piece = new Pawn(pieceName, isPieceWhite);
		}
		
		isVacant = false;
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

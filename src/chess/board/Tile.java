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
	
	public void setPiece(String pieceName, String pieceColor)
	{
		//Bishop
		if(pieceName.contains("B"))
		{
			piece = new Bishop(pieceColor, pieceName);
		}
		//King
		else if(pieceName.contains("K"))
		{
			piece = new King(pieceColor, pieceName);
		}
		//Knight
		else if(pieceName.contains("N"))
		{
			piece = new Knight(pieceColor, pieceName);
		}
		//Queen
		else if(pieceName.contains("Q"))
		{
			piece = new Queen(pieceColor, pieceName);
		}
		//Rook
		else if(pieceName.contains("R"))
		{
			piece = new Rook(pieceColor, pieceName);
		}
		//Pawn
		else if(pieceName.contains("P"))
		{
			piece = new Pawn(pieceColor, pieceName);
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

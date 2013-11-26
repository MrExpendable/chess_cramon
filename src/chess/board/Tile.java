package chess.board;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class Tile 
{
	Piece piece;
	
	public Tile(Piece p)
	{
		piece = p;
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
	}
	
	public Piece getPiece()
	{
		return piece;
	}
	
	public String checkName()
	{
		return piece.toString();
	}
}

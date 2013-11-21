package chess.board;
import chess.pieces.Piece;

public class Tile 
{
	Piece piece;
	
	public Tile(Piece p)
	{
		piece = p;
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

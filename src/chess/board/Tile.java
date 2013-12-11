package chess.board;
import chess.pieces.*;

public class Tile 
{
	private Piece piece;
	
	public Tile()
	{
		
	}
	
	public Tile(Piece p)
	{
		piece = p;
	}

	public Piece getPiece()
	{
		return piece;
	}
	
	public String getPieceName()
	{
		return piece.toString();
	}
}

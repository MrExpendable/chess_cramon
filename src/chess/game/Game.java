package chess.game;
import chess.IO.FileIO;
import chess.board.Chessboard;
import chess.board.Tile;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class Game 
{
	private Chessboard board;
	
	public Game()
	{
		board = new Chessboard();
	}
	
	public void startGame(String filePath)
	{
		FileIO fileRead = new FileIO();
		
		//board.fillPawns();
		board.fillSpecialPieces();
		board.printBoard();
		
		fileRead.readFile(board, filePath);
	}
}

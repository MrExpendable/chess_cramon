package chess.gui;
import chess.board.Chessboard;
import chess.board.Location;
import chess.board.Tile;

public class GuiInterpreter 
{
	private Chessboard interpreterBoard;
	private Tile[][] interpreterTileBoard;
	final int BOARD_LENGTH = 8;
	
	public GuiInterpreter()
	{
		
	}
	
	/*
	 * Copy constructor
	 */
	public GuiInterpreter(Chessboard board)
	{
		interpreterBoard = board;
		interpreterTileBoard = new Tile[BOARD_LENGTH][BOARD_LENGTH];
		
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			for(int j = 0; j < BOARD_LENGTH; j++)
			{
				//This may break because of the last bit of code here
				interpreterTileBoard[i][j] = board.getBoard()[i][j];
			}
		}
	}
	
	/*
	 * Translates input from gui and takes a turn
	 */
	public void takeTurn()
	{
		
	}
	
	/*
	 * Gets available moves for a piece at a specific location and returns them to the gui
	 */
	public void getAvailableMoves(Location loc)
	{
		//Returns location arraylist
		//ArrayList<Location> availableMoves = something like chessboard.getAvailableMoves()
	}
}

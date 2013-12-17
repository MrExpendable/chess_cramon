package chess.game;
import chess.IO.FileIO;
import chess.board.Chessboard;
import chess.board.Location;
import chess.board.Tile;
import chess.pieces.Piece;

import java.util.Scanner;
import java.util.ArrayList;

public class Game 
{
	private Chessboard board;
	final int BOARD_LENGTH = 8;
	private boolean isPlayer1Turn = true;
	private boolean player1InCheck = false;
	private boolean player2InCheck = false;
	private boolean player1Checkmated = false;
	private boolean player2Checkmated = false;
	
	public Game()
	{
		board = new Chessboard();
	}
	
	/*
	 * Sets up the game
	 */
	public void setUpGame(String filePath)
	{
		FileIO fileRead = new FileIO();
		
		fileRead.startPiecePlacement(board, filePath);
		playGame();
	}
	
	/*
	 * Where the game is played
	 */
	public void playGame()
	{
		while(!player1Checkmated || !player2Checkmated)
		{
			takeTurn();
		}
		
		board.printBoard();
		
		if(player1Checkmated)
		{
			System.out.println("Player 1 is in checkmate. Player 2 wins.");
		}
		else if(player2Checkmated)
		{
			System.out.println("Player 2 is in checkmate. Player 1 wins.");
		}
	}
	
	/*
	 * Where the player takes their turn
	 */
	public void takeTurn()
	{
		Scanner playerInput = new Scanner(System.in);
		player1InCheck = evaluateLightCheck(board) ? true : false;
//		player2InCheck = evaluateDarkCheck(board) ? true : false;
		player1Checkmated = evaluateLightCheckmate(board) ? true : false;
//		player2Checkmated = evaluateDarkCheckmate(board) ? true : false;
		
		if(isPlayer1Turn)
		{
			ArrayList<Location> p1PossibleMoves = new ArrayList<>();
			
			
			
			//Check
			if(player1InCheck)
			{
				System.out.println("Player 1, you're in check.");
			}
			
			board.printBoard();
			
			//User input
			System.out.println("It's player 1's turn. Choose a piece.");
			String p1PieceSelect = playerInput.nextLine();
			Location lightPieceSelected = new Location(p1PieceSelect);
//			p1PossibleMoves = getPossibleMoves(board, lightPieceSelected);
			
//			System.out.println("Available moves for this piece: ");
//			for(Location l : p1PossibleMoves)
//			{
//				System.out.println(l);
//			}
//			p1PossibleMoves.clear();
			
			System.out.println("Enter a location on the board to move the piece.\n");
			String p1PieceMove = playerInput.nextLine();
			Location lightToMove = new Location(p1PieceMove);
			
			//Change turn if move valid
			if(lightPieceSelected != null && lightToMove != null)
			{
				if(board.getPieceAtLocation(lightPieceSelected).isPieceWhite() == isPlayer1Turn)
				{
					if(board.movePiece(lightPieceSelected, lightToMove))
					{
						changePlayerTurn();
					}
				}
				else
				{
					System.out.println("That's not your piece. \n");
					takeTurn();
				}
			}
		}
		else
		{
			ArrayList<Location> p2PossibleMoves = new ArrayList<>();
			player2InCheck = evaluateDarkCheck(board) ? true : false;
			
			//Check 
			if(player2InCheck)
			{
				System.out.println("Player 2, you're in check.");
			}
			
			board.printBoard();
			
			//Get user input
			System.out.println("It's player 2's turn. Choose a piece.");
			String p2PieceSelect = playerInput.nextLine();
			Location darkPieceSelected = new Location(p2PieceSelect);
			p2PossibleMoves = getPossibleMoves(board, darkPieceSelected);
			p2PossibleMoves.clear();
			
			System.out.println("Enter a location on the board to move the piece.\n");
			String p2PieceMove = playerInput.nextLine();
			Location darkToMove = new Location(p2PieceMove);
			
			//Change turn if move valid
			if(darkPieceSelected != null && darkToMove != null)
			{
				if(board.getPieceAtLocation(darkPieceSelected).isPieceWhite() == isPlayer1Turn)
				{
					if(board.movePiece(darkPieceSelected, darkToMove))
					{
						changePlayerTurn();
					}
				}
				else
				{
					System.out.println("That's not your piece. \n");
					takeTurn();
				}
			}
		}
	}
	
	/*
	 * Gets all possible moves for a piece
	 */
	public ArrayList<Location> getPossibleMoves(Chessboard boardToCheck, Location pieceLoc)
	{
		ArrayList<Location> possibleMoves = new ArrayList<>();
		Chessboard chessboardCopy = new Chessboard(boardToCheck);
		Tile[][] tileBoardCopy = chessboardCopy.getBoard();
		//Piece pieceToCheck = tileBoardCopy[pieceLoc.getRow()][pieceLoc.getColumn()].getPiece();
		
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			for(int j = 0; j < BOARD_LENGTH; j++)
			{
				Location possibleMove = new Location(i, j);
				if(chessboardCopy.testMovePiece(pieceLoc, possibleMove, tileBoardCopy))
				{
					possibleMoves.add(possibleMove);
				}
			}
		}
		
		System.out.println("Available moves for this piece: ");
		for(Location l : possibleMoves)
		{
			System.out.println(l);
		}
		
		return possibleMoves;
	}
	
	/*
	 * Checks if light king is in check
	 */
	public boolean evaluateLightCheck(Chessboard board)
	{
		//Create copies of the board at its current state so that I'm not modifying the game
		Chessboard chessboardCopy = new Chessboard(board);
		Tile[][] tileBoardCopy = chessboardCopy.getBoard();
		
		//Get king and king location
		Piece lightKing = getLightKing(tileBoardCopy, true);
		Location lightKingLoc = lightKing.getLocation();
		
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			for(int j = 0; j < BOARD_LENGTH; j++)
			{
				//When in doubt, switch i and j once more
				if(tileBoardCopy[i][j].getPiece() != null)
				{
					Location pieceLoc = tileBoardCopy[i][j].getPiece().getLocation();
					
					//if piece and king are not same color
					if(tileBoardCopy[i][j].getPiece().isPieceWhite() != lightKing.isPieceWhite())
					{
						//if piece can move to king
						if(chessboardCopy.testMovePiece(pieceLoc, lightKingLoc, tileBoardCopy))
						{
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	/*
	 * Checks if dark king is in check
	 */
	public boolean evaluateDarkCheck(Chessboard board)
	{
		//Create copies of the board at its current state so that I'm not modifying the game
		Chessboard chessboardCopy = new Chessboard(board);
		Tile[][] tileBoardCopy = chessboardCopy.getBoard();
		
		//Get king and king location
		Piece darkKing = getDarkKing(tileBoardCopy, false);
		Location darkKingLoc = darkKing.getLocation();
		
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			for(int j = 0; j < BOARD_LENGTH; j++)
			{
				//When in doubt, switch i and j once more
				if(tileBoardCopy[i][j].getPiece() != null)
				{
					Location pieceLoc = tileBoardCopy[i][j].getPiece().getLocation();
					
					//if piece and king are not same color
					if(tileBoardCopy[i][j].getPiece().isPieceWhite() != darkKing.isPieceWhite())
					{
						//if piece can move to king
						if(chessboardCopy.testMovePiece(pieceLoc, darkKingLoc, tileBoardCopy))
						{
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	/*
	 * Check for light checkmate
	 */
	public boolean evaluateLightCheckmate(Chessboard boardToCheck)
	{
		boolean isInCheckmate = false;
		
		Chessboard chessboardCopy = new Chessboard(boardToCheck);
		Tile[][] tileBoardCopy = chessboardCopy.getBoard();
		
		ArrayList<Piece> offendingPieces = new ArrayList<>();
		ArrayList<Location> safeAreas = new ArrayList<>();
		Piece lightKing = getLightKing(tileBoardCopy, false);
		Location lightKingLoc = lightKing.getLocation();
		//ArrayList<Location> lightKingMoves;
		
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			for(int j = 0; j < BOARD_LENGTH; j++)
			{
				//If each piece is not null
				if(tileBoardCopy[i][j].getPiece() != null)
				{
					Piece currentOffendingPiece = tileBoardCopy[i][j].getPiece();
					
					//If in check
					if(evaluateLightCheck(board))
					{
						//If offending piece is not same color as light king
						if(currentOffendingPiece.isPieceWhite() != lightKing.isPieceWhite())
						{
							offendingPieces.add(currentOffendingPiece);
							
							//Loop through array and for each location, if offending piece can't move there
							//See if king can move there
							//If not, checkmate
							for(Piece p : offendingPieces)
							{
								Location potentialSafeArea = new Location(i, j);
								if(chessboardCopy.testMovePiece(p.getLocation(), potentialSafeArea, tileBoardCopy))
								{
									safeAreas.add(potentialSafeArea);
								}
							}
							
							for(Location l : safeAreas)
							{
								if(chessboardCopy.testMovePiece(lightKingLoc, l, tileBoardCopy))
								{
									isInCheckmate = false;
								}
								else
								{
									isInCheckmate = true;
								}
							}
						}
					}
				}
			}
		}
		
		return isInCheckmate;
	}
	
	/*
	 * Check for dark checkmate
	 */
	public boolean evaluateDarkCheckmate(Chessboard boardToCheck)
	{
		Chessboard chessboardCopy = new Chessboard(boardToCheck);
		Tile[][] tileBoardCopy = chessboardCopy.getBoard();
		
		boolean isInCheckmate = false;
		ArrayList<Piece> offendingPieces = new ArrayList<>();
		ArrayList<Location> safeAreas = new ArrayList<>();
		Piece darkKing = getDarkKing(tileBoardCopy, false);
		Location darkKingLoc = darkKing.getLocation();
//		ArrayList<Location> darkKingMoves;
		
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			for(int j = 0; j < BOARD_LENGTH; j++)
			{
				if(tileBoardCopy[i][j].getPiece() != null)
				{
					Piece currentOffendingPiece = tileBoardCopy[i][j].getPiece();
					
					if(evaluateDarkCheck(board))
					{
						//If offending piece is not same color as light king
						if(currentOffendingPiece.isPieceWhite() != darkKing.isPieceWhite())
						{
							offendingPieces.add(currentOffendingPiece);
							
							//Loop through array and for each location, if offending piece can't move there
							//See if king can move there
							//If not, checkmate
							for(Piece p : offendingPieces)
							{
								Location potentialSafeArea = new Location(i, j);
								if(chessboardCopy.testMovePiece(p.getLocation(), potentialSafeArea, tileBoardCopy))
								{
									safeAreas.add(potentialSafeArea);
								}
							}
							
							for(Location l : safeAreas)
							{
								if(chessboardCopy.testMovePiece(darkKingLoc, l, tileBoardCopy))
								{
									System.out.println("KING IS SAFE FOR NOW");
									isInCheckmate = false;
								}
								else
								{
									System.out.println("GAME OVER MAN");
									isInCheckmate = true;
								}
							}
						}
					}
				}
			}
		}
		return isInCheckmate;
	}
	
	/*
	 * Gets the white king from the board
	 */
	public Piece getLightKing(Tile[][] board, boolean isWhite)
	{
		Piece lightKing = null;
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				//If the space isn't null
				if(board[j][i] != null && board[j][i].getPiece() != null)
				{
					//Get a piece with the name "K" (which should be a king)
					if(board[j][i].getPiece().getName().contains("K") && board[j][i].getPiece().isPieceWhite())
					{
						lightKing = board[j][i].getPiece();
					}
				}
			}
		}
		
		return lightKing;
	}
	
	/*
	 * Gets the dark king from the board
	 */
	public Piece getDarkKing(Tile[][] board, boolean isWhite)
	{
		Piece darkKing = null;
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				//If the space isn't null
				if(board[j][i] != null && board[j][i].getPiece() != null)
				{
					//Get a piece with the name "K" (which should be a king)
					if(board[j][i].getPiece().getName().contains("K") && !board[j][i].getPiece().isPieceWhite())
					{
						darkKing = board[j][i].getPiece();
					}
				}
			}
		}
		
		return darkKing;
	}
	
	/*
	 * Changes the player's turn
	 */
	public void changePlayerTurn()
	{
		isPlayer1Turn = !isPlayer1Turn;
	}
	
	/*
	 * No need for this method at the moment, just leaving it here in the event that I reimplement it later
	 * 
	public Location getKingLocation(Tile[][] board)
	{
		Location kingLoc = null;
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				//If the space isn't null
				if(board[j][i] != null)
				{
					//Get a piece with the name "K"
					if(board[j][i].getPiece().getName().contains("K"))
					{
						System.out.println("There's a king here");
						kingLoc = board[j][i].getPiece().getLocation();
					}
				}
			}
		}
		
		return kingLoc;
	}
	*/
}

package chess.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;

import chess.board.Chessboard;

/*
 * Probably best not to use this class unless I know what I'm doing
 * It doesn't seem to display pictures
 */
public class ChessGameWindow extends JFrame
{
	ImageIcon[][] iconBoard = new ImageIcon[BOARD_WIDTH][BOARD_LENGTH];
	private JButton[][] buttonBoard = new JButton[BOARD_WIDTH][BOARD_LENGTH];
	JPanel chessboardPanel;
	GuiInterpreter interpreter;
	Chessboard guiChessboard;
	private static final int BOARD_LENGTH = 8;
	private static final int BOARD_WIDTH = 8;
	
	/*
	 * Creates window and sets size
	 */
	public ChessGameWindow()
	{
		super("Chess");
		setPreferredSize(new Dimension(1024,768));
		interpreter = new GuiInterpreter();
		guiChessboard = new Chessboard();
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * Creates the components of the gui
	 */
	public void createWindowComponents(final Container con)
	{
		chessboardPanel = new JPanel();
		chessboardPanel.setLayout(new GridLayout(8,8));
		
		Color a = Color.LIGHT_GRAY;
		Color b = Color.DARK_GRAY;
		
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			for(int j = 0; j < BOARD_WIDTH; j++)
			{		
				buttonBoard[i][j] = new JButton();
				buttonBoard[i][j].addActionListener(new ButtonListener(this, i, j));
				
				if((i%2 == 0) && (j%2 == 1))
				{
					chessboardPanel.add(buttonBoard[i][j]).setBackground(a);
				}
				else if((i%2 == 1) && (j%2 == 0))
				{
					chessboardPanel.add(buttonBoard[i][j]).setBackground(a);
				}
				else
				{
					chessboardPanel.add(buttonBoard[i][j]).setBackground(b);
				}
			}
		}
		con.add(chessboardPanel);
	}
	
	/*
	 * Get the panel
	 */
	public JPanel getPanel()
	{
		return chessboardPanel;
	}
	
	/*
	 * Gets the 2d array of buttons
	 */
	public JButton[][] getButtonBoard()
	{
		return buttonBoard;
	}
	
	/*
	 * Adds pawn images to buttons
	 */
	public void addPawns()
	{
		for(int i = 0; i < iconBoard.length; i++)
		{
			try
			{
				Image darkPawn = ImageIO.read(getClass().getResource("/resources/ChessPiecePictures/darkPawn.png"));
			    buttonBoard[1][i].setIcon(new ImageIcon(darkPawn));
			    
			    Image lightPawn = ImageIO.read(getClass().getResource("/resources/ChessPiecePictures/lightPawn.png"));
			    buttonBoard[6][i].setIcon(new ImageIcon(lightPawn));
			}
			catch(Exception e)
			{
				System.out.println("Can't find or read that image");
			}
		}
	}
	
	/*
	 * Adds the other piece images to the buttons
	 */
	public void addSpecialPieces()
	{
		try
		{
			//Rook
			Image darkRook = ImageIO.read(getClass().getResource("/resources/ChessPiecePictures/darkRook.png"));
		    buttonBoard[0][0].setIcon(new ImageIcon(darkRook));
		    buttonBoard[0][7].setIcon(new ImageIcon(darkRook));
		    
		    Image lightRook = ImageIO.read(getClass().getResource("/resources/ChessPiecePictures/lightRook.png"));
		    buttonBoard[7][0].setIcon(new ImageIcon(lightRook));
		    buttonBoard[7][7].setIcon(new ImageIcon(lightRook));
		    
		    //Knight
		    Image darkKnight = ImageIO.read(getClass().getResource("/resources/ChessPiecePictures/darkKnight.png"));
		    buttonBoard[0][1].setIcon(new ImageIcon(darkKnight));
		    buttonBoard[0][6].setIcon(new ImageIcon(darkKnight));
		    
		    Image lightKnight = ImageIO.read(getClass().getResource("/resources/ChessPiecePictures/lightKnight.png"));
		    buttonBoard[7][1].setIcon(new ImageIcon(lightKnight));
		    buttonBoard[7][6].setIcon(new ImageIcon(lightKnight));
		    
		    //Bishop
		    Image darkBishop = ImageIO.read(getClass().getResource("/resources/ChessPiecePictures/darkBishop.png"));
		    buttonBoard[0][2].setIcon(new ImageIcon(darkBishop));
		    buttonBoard[0][5].setIcon(new ImageIcon(darkBishop));
		    
		    Image lightBishop = ImageIO.read(getClass().getResource("/resources/ChessPiecePictures/lightBishop.png"));
		    buttonBoard[7][2].setIcon(new ImageIcon(lightBishop));
		    buttonBoard[7][5].setIcon(new ImageIcon(lightBishop));
		    
		    //Queen
		    Image darkQueen = ImageIO.read(getClass().getResource("/resources/ChessPiecePictures/darkQueen.png"));
		    buttonBoard[0][3].setIcon(new ImageIcon(darkQueen));
		    
		    Image lightQueen = ImageIO.read(getClass().getResource("/resources/ChessPiecePictures/lightQueen.png"));
		    buttonBoard[7][3].setIcon(new ImageIcon(lightQueen));
		    
		    //King
		    Image darkKing = ImageIO.read(getClass().getResource("/resources/ChessPiecePictures/darkKing.png"));
		    buttonBoard[0][4].setIcon(new ImageIcon(darkKing));
		    
		    Image lightKing = ImageIO.read(getClass().getResource("/resources/ChessPiecePictures/lightKing.png"));
		    buttonBoard[7][4].setIcon(new ImageIcon(lightKing));
		}
		catch(Exception e)
		{
			System.out.println("Can't find or read that image");
		}
		
		//Add queen
		iconBoard[0][3] = new ImageIcon("resources/ChessPiecePictures/darkQueen.png");
		iconBoard[7][3] = new ImageIcon("resources/ChessPiecePictures/lightQueen.png");
		
		//Add king
		iconBoard[0][4] = new ImageIcon("resources/ChessPiecePictures/darkKing.png");
		iconBoard[7][4] = new ImageIcon("resources/ChessPiecePictures/lightKing.png");
	}
	
	/*
	 * Creates the gui
	 */
	public static void main(String[] args)
	{
		ChessGameWindow gui = new ChessGameWindow();
		
		gui.createWindowComponents(gui.getContentPane());
		gui.addPawns();
		gui.addSpecialPieces();
		gui.pack();
		
//		Scanner scan = new Scanner(System.in);
		
//		guiChessboard.fillPawns();
//		guiChessboard.fillSpecialPieces();
//		newChessboard.printBoard();
//		newChessboard.fillLocationList("sampleMoves_module4.txt");
	}
}

/*
 * Class that listens for events from the buttons on the gui
 */
class ButtonListener implements ActionListener
{
	ChessGameWindow window;
	int col;
	int row;
	
	public ButtonListener(ChessGameWindow window, int col, int row)
	{
		this.window = window;
		this.col = col;
		this.row = row;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//interpreter gets coordinates of button clicked
		//gets available moves for that piece
		//displays it on screen, repaint
		//user clicks end location
		//move the piece
		
		
		//Orange is currently selected piece
		//Pink is available moves
		Color orange = Color.ORANGE;
		Color pink = Color.PINK;
		
		if(window.getPanel().getBackground() != orange)
		{
			window.getPanel().add(window.getButtonBoard()[col][row]).setBackground(orange);
		}
	}
}
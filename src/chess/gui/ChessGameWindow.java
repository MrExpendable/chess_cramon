package chess.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;
import javax.swing.*;

import chess.board.Chessboard;

public class ChessGameWindow extends JFrame implements MouseListener
{
	ImageIcon[][] iconBoard = new ImageIcon[BOARD_WIDTH][BOARD_LENGTH];
	JPanel chessboardPanel;
	private static final int BOARD_LENGTH = 8;
	private static final int BOARD_WIDTH = 8;
	
	public ChessGameWindow()
	{
		super("Chess");
		setPreferredSize(new Dimension(1024,768));
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
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
				final JButton button = new JButton(iconBoard[i][j]);
//				button.addActionListener(new ActionListener()
//				{
//					//Orange is currently selected piece
//					//Pink is available moves
//					Color c = Color.ORANGE;
//					@Override
//					public void actionPerformed(ActionEvent arg0) 
//					{
//						chessboardPanel.add(button).setBackground(c);
//					}
//				});
				
				if((i%2 == 0) && (j%2 == 1))
				{
					chessboardPanel.add(button).setBackground(a);
				}
				else if((i%2 == 1) && (j%2 == 0))
				{
					chessboardPanel.add(button).setBackground(a);
				}
				else
				{
					chessboardPanel.add(button).setBackground(b);
				}
			}
		}
		con.add(chessboardPanel);
	}
	
	public void addToImageBoard()
	{
		for(int i = 0; i < iconBoard.length; i++)
		{
			//Add pawn pictures
			iconBoard[1][i] = new ImageIcon("resources/ChessPiecePictures/darkPawn.png");
			iconBoard[6][i] = new ImageIcon("resources/ChessPiecePictures/lightPawn.png");
		}
		
		//Add rook
		iconBoard[0][0] = new ImageIcon("resources/ChessPiecePictures/darkRook.png");
		iconBoard[0][7] = new ImageIcon("resources/ChessPiecePictures/darkRook.png");
		iconBoard[7][0] = new ImageIcon("resources/ChessPiecePictures/lightRook.png");
		iconBoard[7][7] = new ImageIcon("resources/ChessPiecePictures/lightRook.png");
		
		//Add knight
		iconBoard[0][1] = new ImageIcon("resources/ChessPiecePictures/darkKnight.png");
		iconBoard[0][6] = new ImageIcon("resources/ChessPiecePictures/darkKnight.png");
		iconBoard[7][1] = new ImageIcon("resources/ChessPiecePictures/lightKnight.png");
		iconBoard[7][6] = new ImageIcon("resources/ChessPiecePictures/lightKnight.png");
		
		//Add bishop
		iconBoard[0][2] = new ImageIcon("resources/ChessPiecePictures/darkBishop.png");
		iconBoard[0][5] = new ImageIcon("resources/ChessPiecePictures/darkBishop.png");
		iconBoard[7][2] = new ImageIcon("resources/ChessPiecePictures/lightBishop.png");
		iconBoard[7][5] = new ImageIcon("resources/ChessPiecePictures/lightBishop.png");
		
		//Add queen
		iconBoard[0][3] = new ImageIcon("resources/ChessPiecePictures/darkQueen.png");
		iconBoard[7][3] = new ImageIcon("resources/ChessPiecePictures/lightQueen.png");
		
		//Add king
		iconBoard[0][4] = new ImageIcon("resources/ChessPiecePictures/darkKing.png");
		iconBoard[7][4] = new ImageIcon("resources/ChessPiecePictures/lightKing.png");
	}
	
	public static void main(String[] args)
	{
		ChessGameWindow gui = new ChessGameWindow();
		gui.addToImageBoard();
		gui.createWindowComponents(gui.getContentPane());
		gui.pack();
		
//		Scanner scan = new Scanner(System.in);
		Chessboard guiChessboard = new Chessboard();
		
//		guiChessboard.fillPawns();
//		guiChessboard.fillSpecialPieces();
//		newChessboard.printBoard();
//		newChessboard.fillLocationList("sampleMoves_module4.txt");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		System.out.println("fuck this and everything that ever existed.");
	}
	public void mouseEntered(MouseEvent e) 
	{
		System.out.println("I'll take your mother out for a lovely seafood dinner, and never call her again!");
	}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}

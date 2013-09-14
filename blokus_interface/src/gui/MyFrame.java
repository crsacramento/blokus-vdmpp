package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import quotes.TRIO_LINE;

import jp.co.csk.vdm.toolbox.VDM.CGException;

import VDM.*;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private MyPanel panel = null;
	private JLabel status = null;
	private Game game;
	
	public MyFrame(Game game) throws CGException {
		super();
		// frame setup
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.game = game;
		status = new JLabel("Current player: " + game.getCurrentPlayer().getName() + " | Score: " + game.getCurrentPlayer().getScore());
		setupMenu();
		getContentPane().add(status, BorderLayout.SOUTH);
		setTitle("Blokus");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		panel = new MyPanel(game, this);
		getContentPane().add(panel);
		pack();
	}
	
	private void setupMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Options");
		JMenuItem play = new JMenuItem("Play piece");
		play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {	
				try {
					int piece = Integer.parseInt(JOptionPane.showInputDialog("Piece to place", 0));
					double x = Double.parseDouble(JOptionPane.showInputDialog("Horizontal coordinate", 0));
					double y = Double.parseDouble(JOptionPane.showInputDialog("Vertical coordinate", 0));
					if(piece < 1 || piece > game.getCurrentPlayer().getPieces().size() || x < 1 || x > 20 || y < 1 || y > 20) {
						changeStatus("Invalid input");
						return;
					}
					game.getCurrentPlayer().choosePiece(piece);
					boolean valid = game.play(game.getCurrentPlayer(), game.getCurrentPlayer().getCurrentPiece(), new Piece.Coord(x, y));
					if(valid) {
						game.getNextPlayerToPlay();
						changeStatus("Current player: " + game.getCurrentPlayer().getName() + " | Score: " + game.getCurrentPlayer().getScore());
						MyFrame.this.repaint();
					} else {
						changeStatus("Invalid play");
						return;
					}
				} catch(Exception e) {
					changeStatus("Invalid input");
					return;
				}
			}
		});
		JMenuItem rotate = new JMenuItem("Rotate piece");
		rotate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = JOptionPane.showInputDialog("Piece to rotate", 0);
				int piece = 1;
				try {
					piece = Integer.parseInt(result);
				} catch(Exception e1) {
					changeStatus("Invalid input");
					return;
				}
				try {
					if(piece < 1 || piece > game.getCurrentPlayer().getPieces().size()) {
						changeStatus("Invalid input");
						return;
					}
					game.getCurrentPlayer().choosePiece(piece);
					game.rotatePiece(game.getCurrentPlayer(), 1);
					MyFrame.this.repaint();
				} catch (CGException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JMenuItem flip = new JMenuItem("Flip piece");
		flip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = JOptionPane.showInputDialog("Piece to flip", 0);
				int piece = 1;
				try {
					piece = Integer.parseInt(result);
				} catch(Exception e1) {
					changeStatus("Invalid input");
					return;
				}
				try {
					if(piece < 1 || piece > game.getCurrentPlayer().getPieces().size()) {
						changeStatus("Invalid input");
						return;
					}
					game.getCurrentPlayer().choosePiece(piece);
					game.flipPiece(game.getCurrentPlayer(), 1);
					MyFrame.this.repaint();
				} catch (CGException e1) {
					e1.printStackTrace();
				}
			}
		});
		JMenuItem pass = new JMenuItem("Pass turn");
		pass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					game.getNextPlayerToPlay();
					changeStatus("Current player: " + game.getCurrentPlayer().getName() + " | Score: " + game.getCurrentPlayer().getScore());
					panel.repaint();
				} catch (CGException e1) {
					e1.printStackTrace();
				}
			}
		});
		menu.add(play);
		menu.add(rotate);
		menu.add(flip);
		menu.add(pass);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
	
	public static void main(String[] args) throws CGException {
		Game game = new Game();
		game.init();
		game.getNextPlayerToPlay();
		//game.getBoard().drawPiece(new Piece(new quotes.RED(), new quotes.TRIO_CORNER()), new Piece.Coord(1.0, 1.0));
		//game.getBoard().drawPiece(new Piece(new quotes.BLUE(), new TRIO_LINE()), new Piece.Coord(3.0, 3.0));
		//game.getBoard().drawPiece(new Piece(new quotes.GREEN(), new quotes.TETRA_SQUARE()), new Piece.Coord(7.0, 7.0));
		//game.getBoard().drawPiece(new Piece(new quotes.YELLOW(), new quotes.PENTA_LINE_T()), new Piece.Coord(11.0, 11.0));
		
		new MyFrame(game).setVisible(true);
	}
	
	public void changeStatus(String msg) {
		status.setText(msg);
	}

}
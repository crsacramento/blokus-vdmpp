package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Vector;

import javax.swing.JPanel;

import jp.co.csk.vdm.toolbox.VDM.CGException;
import jp.co.csk.vdm.toolbox.VDM.UTIL;

import VDM.Game;
import VDM.Piece;
import VDM.Player;
import VDM.Board;
import VDM.Piece.Coord;

public class MyPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Game game = null;
	private MyFrame parent = null;
	public static int SQUARE_SIZE = 20;
	public static int MARGIN = 5;
	
	public MyPanel(Game game, MyFrame parent) {
		this.game = game;
		this.parent = parent;
		setPreferredSize(new Dimension(SQUARE_SIZE * 60, SQUARE_SIZE * 20 + 50));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// pintar board;
		try {
			Iterator it = game.getBoard().board.entrySet().iterator();
			while(it.hasNext()){
				Entry entry = (Entry) it.next();
				Coord coord = (Coord) entry.getKey();
				if(UTIL.equals(entry.getValue(), new quotes.BLUE()))
					g.setColor(Color.cyan);
				else if(UTIL.equals(entry.getValue(), new quotes.RED()))
					g.setColor(Color.RED);
				else if(UTIL.equals(entry.getValue(), new quotes.YELLOW()))
					g.setColor(Color.yellow);
				else if(UTIL.equals(entry.getValue(), new quotes.GREEN()))
					g.setColor(Color.green);
				else
					g.setColor(Color.lightGray);
				g.fillRect(coord.x.intValue() * SQUARE_SIZE, coord.y.intValue() * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
				g.setColor(Color.black);
				g.drawRect(coord.x.intValue() * SQUARE_SIZE, coord.y.intValue() * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
			}
			
			// pintar mao
			Player p = game.getCurrentPlayer();
			Vector hand = p.getPieces();
			//System.out.println("HANDSIZE="+hand.size());
			int x = 0, y = 0;
			for(int i = 0; i < hand.size(); ++i) {
				if(i % 3 == 0) {
					x++;
					y = 0;
				}
				Piece piece = (Piece) hand.get(i);
				Color color = null;
				Vector coords = (Vector) piece.getPositionsToDraw().get(piece.getCurrDirection());
				if(UTIL.equals(piece.getColor(), new quotes.BLUE()))
					color = Color.cyan;
				else if(UTIL.equals(piece.getColor(), new quotes.RED()))
					color = Color.red;
				else if(UTIL.equals(piece.getColor(), new quotes.YELLOW()))
					color = Color.yellow;
				else if(UTIL.equals(piece.getColor(), new quotes.GREEN()))
					color = Color.green;
				else
					color = Color.lightGray;
				for(int j = 0; j < coords.size(); ++j) {
					Coord coord = (Coord) coords.get(j);
					g.setColor(color);
					g.fillRect(16 * SQUARE_SIZE + 5 * SQUARE_SIZE * x + (coord.x.intValue() + 3) * SQUARE_SIZE, y * SQUARE_SIZE * 7 + (coord.y.intValue() + 3) * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
					g.setColor(Color.black);
					g.drawRect(16 * SQUARE_SIZE + 5 * SQUARE_SIZE * x + (coord.x.intValue() + 3) * SQUARE_SIZE, y * SQUARE_SIZE * 7 + (coord.y.intValue() + 3) * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
					g.drawString(i + 1 + "", 16 * SQUARE_SIZE + 5 * SQUARE_SIZE * x + (coord.x.intValue() + 3) * SQUARE_SIZE + SQUARE_SIZE / 4, y * SQUARE_SIZE * 7 + (coord.y.intValue() + 3) * SQUARE_SIZE + SQUARE_SIZE / 2);
				}
				++y;
			}
			g.dispose();
		} catch (CGException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

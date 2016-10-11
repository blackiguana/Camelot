import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameBoard extends JPanel implements MouseListener {
	public static final int ROWS = 16;
	public static final int COLS = 12;
	public static final Color BORDERCOLOR;
	private GameWindow gwindow;
	private CoreLogic model;

	static {
		BORDERCOLOR = Color.BLACK;
	}

	public GameBoard(GameWindow gwindow, CoreLogic model) {
		this.gwindow = gwindow;
		this.model = model;
		this.setBackground(Color.WHITE);
		this.setLayout(new GridLayout(16, 12));

		for (int i = 15; i >= 0; --i) {
			for (int j = 0; j < 12; ++j) {
				Square s = new Square(i, j);
				s.addMouseListener(this);
				this.add(s);
			}
		}

	}

	public void mouseClicked(MouseEvent e) {
		this.refresh();
		if (!this.model.checkEndGame()) {
			WavPlayer sFSound = new WavPlayer("smw_jump.wav");
			sFSound.start();
		}

	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void refresh() {
		Component[] squares = this.getComponents();
		boolean isWhite = true;
		Component[] arg5 = squares;
		int arg4 = squares.length;

		for (int arg3 = 0; arg3 < arg4; ++arg3) {
			Component c = arg5[arg3];
			Square s = (Square) c;
			if (isWhite) {
				s.setColor(new Color(212, 190, 144), BORDERCOLOR);
			} else {
				s.setColor(new Color(115, 92, 42), BORDERCOLOR);
			}

			if (s.getCol() != 11) {
				isWhite = !isWhite;
			}

			switch (s.getRow()) {
			case 0:
			case 15:
				if (s.getCol() != 5 && s.getCol() != 6) {
					s.setColor(Color.WHITE, Color.WHITE);
				}
				break;
			case 1:
			case 14:
				if (s.getCol() < 2 || s.getCol() > 9) {
					s.setColor(Color.WHITE, Color.WHITE);
				}
				break;
			case 2:
			case 13:
				if (s.getCol() == 0 || s.getCol() == 11) {
					s.setColor(Color.WHITE, Color.WHITE);
				}
			}
		}

		this.repaint();
	}
}
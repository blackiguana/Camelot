import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Square extends JPanel {
	private int row;
	private int col;
	private Color color;
	private Color border;

	public Square(int row, int col) {
		this.row = row;
		this.col = col;
		this.color = Color.WHITE;
	}

	public int getRow() {
		return this.row;
	}

	public int getCol() {
		return this.col;
	}

	public void setColor(Color color, Color border) {
		this.color = color;
		this.border = border;
	}

	public void paintComponent(Graphics g) {
		g.setColor(this.border);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(this.color);
		g.fillRect(2, 2, this.getWidth() - 4, this.getHeight() - 4);
	}
}
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame implements ActionListener {
	private static final int WIDTH = 550;
	private static final int HEIGHT = 700;
	public static final Color BACKGROUND_COLOR;
	public static final Color BOARD_COLOR;
	public static final int BORDER = 5;
	public static final int FONT_SIZE = 20;
	private CoreLogic model;
	private GameBoard board;

	static {
		BACKGROUND_COLOR = Color.BLACK;
		BOARD_COLOR = Color.WHITE;
	}

	public GameWindow() {
		this.setTitle("CAMELOT!!!!!!");
		this.setDefaultCloseOperation(3);
		this.setSize(550, 700);
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());
		this.setContentPane(root);
		this.model = new CoreLogic(16, 12);
		this.board = new GameBoard(this, this.model);
		root.add(this.board, "Center");
		JPanel scores = new JPanel();
		scores.setLayout(new BorderLayout());
		root.add(scores, "North");
		JPanel southButtons = new JPanel(new GridLayout(1, 2));
		JButton newGame = new JButton();
		newGame.setFont(new Font("SansSerif", 1, 20));
		newGame.setForeground(Color.BLACK);
		newGame.setBackground(BACKGROUND_COLOR);
		newGame.setActionCommand("NewGame");
		newGame.addActionListener(this);
		southButtons.add(newGame);
		root.add(southButtons, "South");
		this.setResizable(false);
		this.board.refresh();
	}

	public void actionPerformed(ActionEvent arg0) {
		this.model.newGame();
		this.board.refresh();
	}
}
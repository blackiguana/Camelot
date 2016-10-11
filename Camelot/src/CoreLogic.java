public class CoreLogic {
	//Player player1 = new Player();
	private int[][] boardArray;
	int movesEntered;
	int numSquaresAltered;
	private boolean bEndGame;

	public CoreLogic(int rows, int cols) {
		try {
			if (rows <= 0 || cols <= 0) {
				throw new IllegalArgumentException(
						"Rows and Columns can\'t be negative or zero, setting default values of 5");
			}
		} catch (IllegalArgumentException arg3) {
			rows = 5;
			cols = 5;
		}

		this.numSquaresAltered = 7;
		this.movesEntered = 0;
		this.boardArray = new int[rows][cols];
		this.bEndGame = false;
		this.movesEntered = 0;
	}

	public void newGame() {
	}

	public int getOccupant(int row, int col) {
		return 0;
	}

	public boolean checkEndGame() {
		return false;
	}
}
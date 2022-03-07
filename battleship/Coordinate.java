package battleship;

public class Coordinate {
	int x;
	int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean isValid() {
		return (this.x >= 0 && this.x < Board.N_ROWS && this.y >= 0 && this.y < Board.N_COLLUMS);
	}
	
}
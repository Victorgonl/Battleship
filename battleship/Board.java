package battleship;

class Board {

	final static int N_ROWS = 10;
	final static int N_COLLUMS = 10;
	int[][] board = new int[N_ROWS][N_COLLUMS];

	public Board() {
	// 0: water available, 1: water not available, 2: missed, 3: boat, 4: hited boat
		for (int i = 0; i < N_COLLUMS; i++) {
			for (int j = 0; j < N_COLLUMS; j++) {
				this.board[i][j] = 0;
			}
		}
	}

	public void printBoard() {
		System.out.println("  1 2 3 4 5 6 7 8 9 10");
		char row = 'A';
		for (int i = 0; i < N_ROWS; i ++) {
			System.out.print(row++);
			for (int j = 0; j < N_ROWS; j ++) {
				if(this.board[i][j] == 0 || this.board[i][j] == 1) {
					System.out.print(" ~");
				} else if(this.board[i][j] == 2) {
					System.out.print(" M");
				} else if(this.board[i][j] == 3) {
					System.out.print(" O");
				} else if(this.board[i][j] == 4) {
					System.out.print(" X");
				} 
			}
			System.out.println("");
		}
	}

	private boolean validPosition(Boat boat) {
		if (boat.p.x < 0 || boat.p.x >= N_ROWS) {
			RuntimeException exception = new RuntimeException("Error! You placed it out of the board. Try again:");
			throw exception;
		}
		if (boat.p.y < 0 || boat.p.y >= N_COLLUMS) {
			RuntimeException exception = new RuntimeException("Error! You placed it out of the board. Try again:");
			throw exception;
		}
		if (boat.p.x == boat.q.x) {
			for (int i = boat.p.y; i <= boat.q.y; i++) {
				if (board[boat.p.x][i] == 1 || board[boat.p.x][i] == 3) {
					RuntimeException exception = new RuntimeException("Error! You placed it too close to another one. Try again:");
					throw exception;
				}
			}
		} else if (boat.p.y == boat.q.y) {
			for (int i = boat.p.x; i <= boat.q.x; i++) {
				if (board[i][boat.p.y] == 1 || board[i][boat.p.y] == 3) {
					RuntimeException exception = new RuntimeException("Error! You placed it too close to another one. Try again:");
					throw exception;
				}
			}
		}
		return true;
	}

	public boolean hitBoat(Coordinate r) {
		if(r.x < 0 || r.y < 0 || r.x >= N_ROWS || r.y >= N_COLLUMS) {
			RuntimeException exception = new RuntimeException("Error! You entered the wrong coordinates! Try again:");
			throw exception;
		}
		if(board[r.x][r.y] == 3){
			board[r.x][r.y] = 4;
			return true;
		}
		else {
			board[r.x][r.y] = 2;
			return false;
		}
	}

	public void insertBoat(Boat boat) {
		if(validPosition(boat)) {
			if (boat.p.x == boat.q.x) {
				int i = boat.p.y;
				if (i > 0) {
					board[boat.p.x][i - 1] = 1;
				}
				while (i <= boat.q.y){
					board[boat.p.x][i] = 3;
					if (boat.p.x + 1 < N_ROWS) {
						board[boat.p.x + 1][i] = 1;
					}
					if (boat.p.x - 1 >= 0) {
						board[boat.p.x - 1][i] = 1;
					}
					i++;
				}
				if (i < N_COLLUMS - 1) {
					board[boat.p.x][i] = 1;
				}
			} else if (boat.p.y == boat.q.y) {
				int i = boat.p.x;
				if (i > 0) {
					board[i - 1][boat.p.y] = 1;
				}
				while (i <= boat.q.x){
					board[i][boat.p.y] = 3;
					if (boat.p.y + 1 < N_COLLUMS) {
						board[i][boat.p.y + 1] = 1;
					}
					if (boat.p.y - 1 >= 0) {
						board[i][boat.p.y - 1] = 1;
					}
					i++;
				}
				if (i < N_ROWS - 1) {
					board[i][boat.p.y] = 1;
				}
			}
		}
	}
}



package battleship;

public class Boat {
	int size;
	Coordinate p;
	Coordinate q;
	int id;
	String name;
	
	public Boat(Coordinate p, Coordinate q, int id) { 
		this.p = p;
		this.q = q;
		switch (id) {
			case 0:
				this.name = "Aircraft Carrier";
				this.size = 5;
				break;
			case 1:
				this.name = "Battleship";
				this.size = 4;
				break;
			case 2:
				this.name = "Submarine";
				this.size = 3;
				break;
			case 3:
				this.name = "Cruiser";
				this.size = 3;
				break;
			case 4:
				this.name = "Destroyer";
				this.size = 2;
				break;
		}
		validBoat();
		fixCoordinates();
	}
	private void fixCoordinates() {
		if (this.p.x == this.q.x) {
			if (this.p.y > this.q.y) {
				int temp = this.p.y;
				this.p.y = this.q.y;
				this.q.y = temp;
			}
		}
		else if (this.p.y == this.q.y) {
			if (this.p.x > this.q.x) {
				int temp = this.p.x;
				this.p.x = this.q.x;
				this.q.x = temp;
			}
		}
	}
	private void validBoat() {
		if (this.p.x == this.q.x) {
			if (Math.abs(this.p.y - this.q.y) + 1 != this.size) {
				RuntimeException exception = new RuntimeException("Error! Wrong length of the " + this.name + "! Try again:");
				throw exception;
			}
		}
		else if (this.p.y == this.q.y) {
			if (Math.abs(this.p.x - this.q.x) + 1 != this.size) {
				RuntimeException exception = new RuntimeException("Error! Wrong length of the " + this.name + "! Try again:");
				throw exception;
			}
		}
		else {
			RuntimeException exception = new RuntimeException("Error! Wrong ship location! Try again:");
			throw exception;
		}
	}
}

// Victorgonl - Battleship - 20220303

package battleship;

import java.util.Scanner;

public class Main {

	static Coordinate p = null;
	static Coordinate q = null;
	static Coordinate r = null;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		String[] boat_names = new String[5];
		boat_names[0] = "Aircraft Carrier";
		boat_names[1] = "Battleship";
		boat_names[2] = "Submarine";
		boat_names[3] = "Cruiser";
		boat_names[4] = "Destroyer";

		int[] boat_cells = new int[5];
		boat_cells[0] = 5;
		boat_cells[1] = 4;
		boat_cells[2] = 3;
		boat_cells[3] = 3;
		boat_cells[4] = 2;

		Boat[] boats = new Boat[5];

		Board board = new Board();
		board.printBoard(true);

		int i = 0;
		while(i < 5) {
			System.out.println("\nEnter the coordinates of the " + boat_names[i] + " (" + boat_cells[i] + " cells):\n");
			while(true) {
				try {
					readCoordenates();
					boats[i] = new Boat(p, q, i);
					board.insertBoat(boats[i]);
					System.out.println();
					board.printBoard(true);
					i++;
					break;
				} catch (Exception exception) {
					System.out.println("\n" + exception.getMessage() + "\n");
				}
			}
		}

		System.out.println("\nThe game starts!\n");
		board.printBoard(false);
		System.out.println("\nTake a shot!\n");

		while(true) {
			try {
				readCoordenate();
				
				if(board.hitBoat(r)) {
					System.out.println();
					board.printBoard(false);
					System.out.println("\nYou hit a ship!\n");
				} else {
					System.out.println();
					board.printBoard(false);
					System.out.println("\nYou missed!\n");
				}
				break;
			} catch (Exception exception) {
				System.out.println("\n" + exception.getMessage() + "\n");
			}
		}

		board.printBoard(true);

		input.close();

	}

	public static void readCoordenate() {
		final int ASCII_POSITION = 17;
		String temp = input.next();
		int x = temp.charAt(0) - ASCII_POSITION - '0';
		int y = Integer.valueOf(temp.substring(1)) - 1;
		r = new Coordinate(x, y);
	}

	public static void readCoordenates() {
		final int ASCII_POSITION = 17;
		String temp = input.next();
		int x = temp.charAt(0) - ASCII_POSITION - '0';
		int y = Integer.valueOf(temp.substring(1)) - 1;
		p = new Coordinate(x, y);
		temp = input.next();
		x = temp.charAt(0) - ASCII_POSITION - '0';
		y = Integer.valueOf(temp.substring(1)) - 1;
		q = new Coordinate(x, y);
	}
}

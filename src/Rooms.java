import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Rooms {

	// Global variable to store the rooms travelled
	static ArrayList<Integer> path = new ArrayList<>();

	public static void main(String[] args) {

		// Variable to store the room number as key and 
		// array list of doors that room number can go to
		HashMap<Integer, ArrayList<Integer>> mapToRooms = new HashMap<>();

		/* Arraylists to insert in above variable
		  Note: I tried to use single variable like after adding 
		  toRoom to mapToRoom, I cleared toRoom using toRoom.clear() but
		  it gives empty list and so I have to make 
	      eight arraylist for 8 room numbers*/
		ArrayList<Integer> toRoom = new ArrayList<>();
		ArrayList<Integer> toRoom2 = new ArrayList<>();
		ArrayList<Integer> toRoom3 = new ArrayList<>();

		// adding door to each room
		toRoom.add(2);
		mapToRooms.put(1, toRoom);

		toRoom2.add(1);
		toRoom2.add(3);
		toRoom2.add(4);
		mapToRooms.put(2, toRoom2);

		toRoom3.add(2);
		toRoom3.add(2);
		mapToRooms.put(3, toRoom3);

		// end of adding doors to all rooms

		String input = null;
		Scanner scan = new Scanner(System.in);

		do{
			System.out.print("Enter 1 to go to the house: ");
			input= scan.next();

			if (input.equals("1")) {
				roomOne(mapToRooms, Integer.parseInt(input));
			}

			else if (input.equals("Q")) {
				System.out.print("YOu exited\n");
				break;
			} 

		} while (!input.equals("1"));



		// Displaying all the visited rooms
		// I used ifelse inside for loop because I didn't want -> in the end
		// Displayed in this way : 1->2->3->2......

		String displayPath = null;
		int i = 1;
		displayPath = "The path of visited rooms is ";
		int length = path.size();

		for (int a: path) {
			if (i < length) {
				displayPath += a + "->";
				i++;
			} else {
				displayPath += a;
			}		
		}	
		System.out.print(displayPath);
	}



	private static void roomOne(HashMap<Integer, ArrayList<Integer>> mapsToRoom,
			int from) {
		// As this method is called, 1 is added to the path variable
		path.add(1);

		String input3 = null;
		Scanner sc= new Scanner(System.in);

		// Checking if 1 exists in hashmap
		if(mapsToRoom.containsKey(from)) {
			System.out.print("You are in foyer & you see dead scorpion\n");
			
			//repeat until valid door no is inserted
			do {
			System.out.print("{You can (1)exit to the north or press Q to quit}\n");
			input3=sc.nextLine();
			} while (!(input3.equals("1") || input3.equals("Q")));

			if (input3.equals("1")) {
				roomTwo(mapsToRoom);
			} else if (input3.equals("Q")){
				System.out.print("You exited from the system");
			} else {
				System.out.print("There are no doors from 1 to " + input3);
			}
		} 
	}


	private static void roomTwo(HashMap<Integer, ArrayList<Integer>> mapsToRoom) {
		// As this method is called, 2 is added to the path variable
		path.add(2);

		String input3 = null;
		Scanner sc= new Scanner(System.in);

		// This line returns the values of room number 2.
		// like mapsToRoom.get(2) = [1,3,4]
		ArrayList<Integer> roomValues = mapsToRoom.get(2);

		System.out.print("You are in front room now & you see piano\n");

		//Repeat until valid input is inserted
		do {
			System.out.print("{You can (1)exit to the south or (2) to west or"

				+ " (3) to  east or press Q to quit}\n");
			input3=sc.nextLine();
		} while (!(input3.equals("1") || input3.equals("2") || input3.equals("3") || input3.equals("Q")));

		// You have choices of 1, 2, 3, Q
		if (!input3.equals("Q")) {

			// Go to getElement below
			int to = getElement(roomValues, input3);

			// So as we know doors that 2 can go is 1, 3, 4, so we use if else to go to respective methods
			if (to == 1) {
				roomOne(mapsToRoom, to);
			} else if (to == 3) {
				roomThree(mapsToRoom);
			}
			else if (to == 4) {
				//roomFour(mapsToRoom);
			}
		} else {
			System.out.print("You exited from the system\n");
		}

	} 


	private static void roomThree(HashMap<Integer, ArrayList<Integer>> mapsToRoom) {
		path.add(3);

		String input3 = null;
		Scanner sc= new Scanner(System.in);

		ArrayList<Integer> roomValues = mapsToRoom.get(3);

		do{
			System.out.print("You are in library now & you see spiders\n");

			System.out.print("{You can (1)exit to the east or (2) to north or press Q to quit}\n");
			input3=sc.nextLine();
		} while (!(input3.equals("1") || input3.equals("2") || input3.equals("Q")));
		
			if (!input3.equals("Q")) {
				int to1 = getElement(roomValues, input3);

				if (to1 == 2) {
					roomTwo(mapsToRoom);
				} else if (to1 == 5) {
					roomFive(mapsToRoom, to1);
				}
			} else {
				System.out.print("You exited from the system\n");
			}
		
	}

	private static void roomFive(HashMap<Integer, ArrayList<Integer>> mapsToRoom, int to1) {
		// TODO Auto-generated method stub

	}

	// Actually u don't need this method; we could have done like if input 1 bhaye go to this method bla bla
	// This method takes mathi bata aako input choices from 1, 2, 3
	// if choice 1 bhaye, you need to get 0 index so index = value - 1;
	// list.get(index) returns element on that index
	// Note: use of get in list and hashmap is different

	private static int getElement(ArrayList<Integer> list, String input) {
		int value = Integer.parseInt(input);
		int index = value - 1;

		return list.get(index);



	}
}

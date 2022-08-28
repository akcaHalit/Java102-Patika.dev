
import java.util.Scanner;
public class Game {

	private Scanner in = new Scanner(System.in);
	private boolean isWin = false;
	public void start() {
		System.out.println("Welcome to the Advanture Game !");
		
		System.out.println("Please give a name to your character: ");
		String playerName = in.nextLine();
		Player player = new Player(playerName);
		System.out.println("Your character's name has been saved as: " + player.getName() );
		System.out.println("Please choose your character's type: ");
		player.selectChar();
		
		Location location = null;
		while(true) {
			player.printInfo();
			printMenu();

			int selectLoc = in.nextInt();
			switch(selectLoc) {
				case 0:
					location = null;
					break;
				case 1:
					location = new SafeHouse(player);
					if(player.getInventory().isFood() == true && player.getInventory().isWater() == true && player.getInventory().isFirewood() == true) {
						isWin = true;
						break;
					}
					break;
				case 2:
					location = new ToolStore(player);
					break;
				case 3:
					location = new Cave(player);
					if(player.getInventory().isFood() == true) {
						System.out.println("########## You have already collected foods.\n ----------You are being led to Safe House");
						location = new SafeHouse(player);
					}
					break;
				case 4:
					location = new Forest(player);
					if(player.getInventory().isFirewood() == true) {
						System.out.println("########## You have already collected firewoods.\n ----------You are being led to Safe House");
						location = new SafeHouse(player);
					}
					break;
				case 5:
					location = new River(player);
					if(player.getInventory().isWater() == true) {
						System.out.println("########## You have already collected water.\n ----------You are being led to Safe House");
						location = new SafeHouse(player);
					}
					break;
				default:
					System.out.println("INVALID CHOICE !\nWe automatically send you to Safe House! ");
					location = new SafeHouse(player);
			}
			if(location == null ) {
				System.out.println("Huh, COWARD !");
				break;
			}
			
			if(!location.onLocation()) {
				System.out.println("Game Over");
				break;
			}
			if(isWin) {
				System.out.println("\n\n\n");
				System.out.println("####################### MISSION COMPLETED #######################");
				System.out.println("####################### You collected every loot #######################");
				System.out.println("####################### You have succesfully finished the game!!! #######################");
				break;
			}
			
		}
		
	}
	public void printMenu() {
	     	System.out.println();	
	        System.out.println(" ######## Locations ########");
	        System.out.println();
			System.out.println("1- Safe House --> This is your safe house, there is no enemy!");
			System.out.println("2- Tool Store --> You can buy weapons or armors here!");
			System.out.println("3- Cave --> Award<food> There are zombies, Be careful!");
			System.out.println("4- Forest --> Award<firewood> There are vampires, Be careful!");
			System.out.println("5- River --> Award<*water> There are bears, Be careful!");
			System.out.println("0- Quit the Game");
	        System.out.println(" Where you want to go: ");
	}
		
}

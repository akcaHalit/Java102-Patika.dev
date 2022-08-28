import java.util.Scanner;

public class Player {
	
	private Inventory inventory;
	private String name;
	private String charName;
	private int ID;
	private int money;
	private int health;
	private int defaultHealth;
	private int damage;
	private Scanner in = new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
		this.inventory = new Inventory();
	}
	
	
	public void selectChar() {
		
		GameChar[] charList = {new Samurai(),new Archer(),new Knight()};
		System.out.println("------Characters------");
		for(GameChar gameChar : charList) {
			System.out.println("Char: "+ gameChar.getCharName() + "\t Damage: " + gameChar.getDamage() + "\t Health: "+ gameChar.getHealth() + "\t Money: "+gameChar.getMoney());
		}
		System.out.println("-------------------");
		System.out.print("ID-1: Samurai\nID-2: Archer\nID-3: Knight\nYour choice?: ");
		int selectChar = in.nextInt();
		switch(selectChar) {
		case 1:
			initPlayer(new Samurai());
			break;
		case 2:
			initPlayer(new Archer());
			break;
		case 3:
			initPlayer(new Knight());
			break;
		default:
			System.out.println("Invalid Choice: We automatically set your char as Knight.");
			initPlayer(new Knight());
		}
		//System.out.println("Karakteriniz: " + this.getCharName());
	}
	

	
	public void initPlayer(GameChar gameChar) {
		this.setDamage(gameChar.getDamage());
		this.setHealth(gameChar.getHealth());
		this.setMoney(gameChar.getMoney());
		this.setDefaultHealth(gameChar.getHealth());
		this.setCharName(gameChar.getCharName());
		this.setID(gameChar.getId());
	}

	
	public void printInfo() {
		System.out.println("Your weapon: "+this.getInventory().getWeapon().getName()+"\tYour Armor: "+this.getInventory().getArmor().getName()+"\tYour damage: "+this.getInventory().getWeapon().getDamage()+"\tYour Defence: "+this.getInventory().getArmor().getDefence()+" \tYour Health: "+this.getHealth()+ "\tYour money: "+this.getMoney());

	}
	public Weapon getWeapon() {
		return this.getInventory().getWeapon();
	}
	public Armor getArmor() {	
		return this.getInventory().getArmor();
	}
	
	public int getTotalDamage() {
		return damage + this.getInventory().getWeapon().getDamage();
	}
	
	
	
	public int getDefaultHealth() {
		return defaultHealth;
	}
	public void setDefaultHealth(int defaultHealth) {
		this.defaultHealth = defaultHealth;
	}


	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public String getCharName() {
		return charName;
	}
	public void setCharName(String charName) {
		this.charName = charName;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health < 0) {
			health = 0;
		}
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	
}

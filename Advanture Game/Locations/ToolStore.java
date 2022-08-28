
public class ToolStore extends NormalLoc{

	public ToolStore(Player player) {
		super(player,"Tool Store");
	}
	
	@Override
	public boolean onLocation() {
		System.out.println("Welcome to the tool store! ");
		boolean showMenu = true;
		while(showMenu) {
			System.out.println("1- Weapons\n2- Armors\n3- Exit");
			int selectCase = in.nextInt();
			while(selectCase < 1 || selectCase > 3) {
				System.out.print("INVALID CHOICE !");
				selectCase = in.nextInt();
			}
			switch(selectCase) {
				case 1:
					printWeapon();
					buyWeapon();
					break;
				case 2:
					printArmor();
					buyArmor();
					break;
				case 3:
					System.out.println("Yine bekleriz...");
					showMenu = false;
					break;
			}
		}
		
		return true;
	}
	
	
	public void printWeapon() {
		System.out.println("-----Weapons-----");
		for(Weapon w: Weapon.weapons() ) {
			System.out.println(w.getId()+ "-" + w.getName()+" <<Price: "+w.getPrice()+" ,Damage: "+w.getDamage());
		}
		System.out.println("0- Çýkýþ yap!");
	}
	
	public void buyWeapon() {
		System.out.print("Your choice?: ");
		int selectWeaponID = in.nextInt();
		while(selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
			System.out.print("INVALID CHOICE !");
			selectWeaponID = in.nextInt();
		}
		if(selectWeaponID != 0) {
			Weapon selectedWeapon = Weapon.getWeaponByID(selectWeaponID);
			if(selectedWeapon != null) {
				if(selectedWeapon.getPrice() > this.getPlayer().getMoney()) {  
					System.out.println("You don't have enough money !");
				}else {
					System.out.println("You earned the weapon: "+ selectedWeapon.getName());
					int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
					this.getPlayer().setMoney(balance);
					System.out.println("Now you have: " +this.getPlayer().getMoney() +" cash");
					System.out.println("Your previous weapon: "+this.getPlayer().getInventory().getWeapon().getName());
					this.getPlayer().getInventory().setWeapon(selectedWeapon);
					System.out.println("Your current weapon: " + this.getPlayer().getInventory().getWeapon().getName());
				}
			} 
		}
		  
	}
	public void printArmor() {
		System.out.println("------Armors------");
		for(Armor a : Armor.armors()) {
			System.out.println(a.getId()+"-"+a.getName()+"<< Price: "+a.getPrice()+" ,Defence: "+a.getDefence());
		}	
		System.out.println("0- Çýkýþ yap!");

	}
	
	public void buyArmor() {
		System.out.print("Your choice?: ");
		int selectedArmorID = in.nextInt();
		while(selectedArmorID < 0 || selectedArmorID > Armor.armors().length) {
			System.out.println("INVALID CHOICE");
			selectedArmorID = in.nextInt();
		}
		if(selectedArmorID != 0) {
			Armor selectedArmor = Armor.getArmorByID(selectedArmorID);
			if(selectedArmor != null) {
				if(selectedArmor.getPrice() > this.getPlayer().getMoney()) {
					System.out.println("You don't have enough money");
				}else {
					System.out.println("You earned the Armor: "+selectedArmor.getName());
					int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
					this.getPlayer().setMoney(balance);
					System.out.println("Now, you have "+this.getPlayer().getMoney() +" cash");
					System.out.println("Your previous armor: "+ this.getPlayer().getInventory().getArmor().getName());
					this.getPlayer().getInventory().setArmor(selectedArmor);
					System.out.println("Your current armor: "+ this.getPlayer().getInventory().getArmor().getName());
				}
			}
		}
	}
	
}

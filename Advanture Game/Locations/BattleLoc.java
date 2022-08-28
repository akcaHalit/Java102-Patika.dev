import java.util.Random;

public abstract class BattleLoc extends Location{
	
	private Monster monster;
	private String award;
	private int maxMonster;

	public BattleLoc(Player player,String name,Monster monster,String award,int maxMonster){
		super(player,name);
		this.award = award;
		this.monster = monster;
		this.maxMonster = maxMonster;
	}
	
	@Override
	public boolean onLocation() {
		int monsterNumber = this.randomMonsterNumber();
		System.out.println("You are at "+this.getName()+" now.");
		System.out.println("Be careful ! There are "+monsterNumber+" "+this.getMonster().getName()+"s here");
		System.out.println("<F>ight or <R>un ?");
		String selectCase = in.nextLine();
		selectCase = selectCase.toUpperCase();
		if(selectCase.equals("F") && combat(monsterNumber)) {
			if(combat(monsterNumber)) {
				System.out.println(this.getName()+ " has been cleaned from monsters...");
				return true; 
			}
		}
		if(this.getPlayer().getHealth() <= 0) {
			System.out.println("Game Over! You are dead!! ");
			return false;
		}
		
		return true;
	}
	
	public boolean combat(int monsterNumber) {
		if(this.getMonster().getName().equals("Snake")) {
			this.getMonster().setDamage(snakeDamage());
		}
		for(int i = 1; i <=monsterNumber; i++) {
			this.getMonster().setHealth(this.getMonster().getDefaultHealth());

			playerStats();
			monsterStats(i);
			int firstHitter = firstHitter();

			while(this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
				System.out.println("<H>it or <D>odge");
				String selectCase = in.nextLine().toUpperCase();
				
				if(selectCase.equals("H")) {
					if(firstHitter <=4 ) {
						System.out.println("You hit the monster");
						int hitDamage = this.getPlayer().getWeapon().getDamage();
						this.getMonster().setHealth(this.getMonster().getHealth()-hitDamage);
						afterHit();
						
						if(this.getMonster().getHealth() > 0 ) {
							System.out.println("The monster hit you!");
							int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getArmor().getDefence();
							if(monsterDamage < 0) {
								monsterDamage = 0;
							}
							this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
							afterHit();
						}		
					}else {
						if(this.getMonster().getHealth() > 0 ) {
							System.out.println("The monster hit you!");
							int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getArmor().getDefence();
							if(monsterDamage < 0) {
								monsterDamage = 0;
							}
							this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
							afterHit();
						}
						System.out.println("You hit the monster!");
						int hitDamage = this.getPlayer().getWeapon().getDamage();
						this.getMonster().setHealth(this.getMonster().getHealth()-hitDamage);
						afterHit();
					}
				}else {
					return false;
				}
			}
		
		if(this.getMonster().getHealth() < this.getPlayer().getHealth()) {
			System.out.println("You beat the monsters!!");
			if(this.getMonster().getName().equals("Snake")) {
				lootDrop();
			}else {
				System.out.println("You collected " +this.getMonster().getAward()+" cashes!");
				this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
				if(this.getMonster().getName().equals("Zombie")) {
					this.getPlayer().getInventory().setFood(true);
					System.out.println("################# You have collected foods.. #################");
				}else if(this.getMonster().getName().equals("Vampire")) {
					this.getPlayer().getInventory().setFirewoord(true);
					System.out.println("################# You have collected firewoods... #################");
				}else if(this.getMonster().getName().equals("Bear")) {
					this.getPlayer().getInventory().setWater(true);
					System.out.println("################# You have collected water... #################");
				}else {
					System.out.println("ERROR!!!");
				}
			}
			System.out.println("Your current money: "+this.getPlayer().getMoney());		
		}
		//else {
			//return false;
		//}
	}
		return false;
	}
	public void afterHit() {
		System.out.println("Your health: "+this.getPlayer().getHealth());
		System.out.println("Enemy's health: "+this.getMonster().getHealth());
		System.out.println("----------------------");
	}
	
	public void playerStats() {
		System.out.println("----------Player stats-------");
		System.out.println("Health: "+this.getPlayer().getHealth());
		System.out.println("Weapon: "+this.getPlayer().getWeapon().getName()+"\tArmor: "+this.getPlayer().getArmor().getName());
		//System.out.println("Armor: " +this.getPlayer().getArmor().getName());
		System.out.println("Damage: "+this.getPlayer().getWeapon().getDamage()+"\tBlock: "+this.getPlayer().getArmor().getDefence()+"\t\tMoney:"+this.getPlayer().getMoney());
		//System.out.println("Block: " +this.getPlayer().getArmor().getDefence());
		//System.out.print("\t\tMoney: " +this.getPlayer().getMoney());
	}
	public void monsterStats(int i) {
		if(i==1) {
			System.out.println(this.getMonster().getName()+"------Stats------");
			System.out.println("Health: "+this.getMonster().getHealth());
			System.out.println("Damage: "+this.getMonster().getDamage());
			System.out.println("Award: " +this.getMonster().getAward());
		}else {
			System.out.println("you killed-----------\n"+i+"."+this.getMonster().getName()+" ----Stats-----");
			System.out.println("Health: "+this.getMonster().getHealth());
			System.out.println("Damage: "+this.getMonster().getDamage());
			System.out.println("Award: " +this.getMonster().getAward());
		}
	
	}
	
	public int firstHitter() {
		Random rand = new Random();
		return rand.nextInt(10);
	}
	public int randomMonsterNumber() {
		Random rand = new Random();
		return rand.nextInt(this.getMaxMonster())+1;
	}
	
	public int snakeDamage() {
		Random rand = new Random();
		return rand.nextInt(4)+3;
	}
	
	public void lootDrop() {
		Random random = new Random();
        int chance = random.nextInt()*100;

        if(chance < 55){
            Random r = new Random();
            int itemchance = r.nextInt()*100;
            if(itemchance <= 30){
                Random rw = new Random();
                int weaponeChance = rw.nextInt()*100;
                if(weaponeChance <= 20){
                    getPlayer().getInventory().setWeapon(Weapon.getWeaponByID(3));
                    System.out.println("You earned "+ getPlayer().getInventory().getWeapon().getName());
                }if(20 < weaponeChance && weaponeChance <= 50){
                    getPlayer().getInventory().setWeapon(Weapon.getWeaponByID(2));
                    System.out.println("You earned " +getPlayer().getInventory().getWeapon().getName());
                }if( 50 < weaponeChance){
                    getPlayer().getInventory().setWeapon(Weapon.getWeaponByID(1));
                    System.out.println("You earned "+getPlayer().getInventory().getWeapon().getName());
                }

            }if(30 < itemchance && itemchance <= 60){
                Random ra = new Random();
                int armorChance = ra.nextInt()*100;
                if(armorChance <= 20 ){
                    getPlayer().getInventory().setArmor(Armor.getArmorByID(3));
                    System.out.println("You earned "+ getPlayer().getInventory().getArmor().getName());
                }if(20 < armorChance && armorChance <= 50 ){
                    getPlayer().getInventory().setArmor(Armor.getArmorByID(2));
                    System.out.println("You earned "+ getPlayer().getInventory().getArmor().getName());
                }if(50 < armorChance){
                    getPlayer().getInventory().setArmor(Armor.getArmorByID(1));
                    System.out.println("You earned "+ getPlayer().getInventory().getArmor().getName());
                }
            }if (60 < itemchance){
                Random rg = new Random();
                int goldChance = rg.nextInt()*100;
                if(goldChance <= 20){
                    getPlayer().setMoney(getPlayer().getMoney() + 10);
                    System.out.println("You earned 10 Gold ");
                }if(20 < goldChance && goldChance <= 50){
                    getPlayer().setMoney(getPlayer().getMoney() + 5);
                    System.out.println("You earned 5 Gold");
                }if(50 < goldChance){
                    getPlayer().setMoney(getPlayer().getMoney() + 1);
                    System.out.println("You earned 1 Gold ");
                }
            }
        }else{
            System.out.println("Sorry, you collected nothing...");
        }
    }
	
	public int getMaxMonster() {
		return maxMonster;
	}
	public void setMaxMonster(int maxMonster) {
		this.maxMonster = maxMonster;
	}

	public Monster getMonster() {
		return monster;
	}
	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}
	
	
	
}

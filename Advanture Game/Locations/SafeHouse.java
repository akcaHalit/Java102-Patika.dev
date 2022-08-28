
public class SafeHouse extends NormalLoc{
	
	public SafeHouse(Player player) {
		super(player,"Safe House");
	}
	
	@Override
	public boolean onLocation() {
		System.out.println("Güvenli evdesiniz. ");
		System.out.println("Canýnýz yenilendi. ");
		this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
		return true;
	}
	
	
	
}

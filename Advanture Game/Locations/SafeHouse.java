
public class SafeHouse extends NormalLoc{
	
	public SafeHouse(Player player) {
		super(player,"Safe House");
	}
	
	@Override
	public boolean onLocation() {
		System.out.println("G�venli evdesiniz. ");
		System.out.println("Can�n�z yenilendi. ");
		this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
		return true;
	}
	
	
	
}

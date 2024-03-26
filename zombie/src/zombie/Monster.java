package zombie;

public abstract class Monster extends Unit {

	public Monster(int location, String name, int hp, int power) {
		super(location, name, hp, power);
	}

	abstract void attack(Unit enenmy);


}

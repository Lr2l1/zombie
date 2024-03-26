package zombie;

interface Move {
	public void move();

}

interface Recovery {
	public void recover();
}

public abstract class Human extends Unit {

	public Human(int location, String name, int hp, int power) {
		super(location, name, hp, power);
	}

	abstract void attack(Unit enenmy);


}

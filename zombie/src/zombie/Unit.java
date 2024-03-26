package zombie;

interface Move {
	public void move();

}

interface Recovery {
	public void recover();
}

public abstract class Unit {
	public final int MAX_HP;
	private int location;
	private String name;
	private int hp;
	private int power;
	private boolean isDead;

	public Unit(int location, String name, int hp, int power) {
		this.location = location;
		this.name = name;
		this.hp = hp;
		this.power = power;
		this.MAX_HP = hp;
		this.isDead = false;
	}

	public int getLocation() {
		return this.location;
	}

	public void setLocation() {
		this.location += location;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getPower() {
		return this.power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean isDead() {
		return this.isDead;
	}

	abstract void attack(Unit enenmy);

	abstract void Damageable(Unit enenmy);

	@Override
	public String toString() {

		return isDead ? String.format("[%s] 사망", name) : String.format("[%s hp] %d/%d", name, hp, MAX_HP);
	}

	public void recover() {
		// TODO Auto-generated method stub

	}

}

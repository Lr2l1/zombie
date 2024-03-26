package zombie;

public class Unit {
	public final int MAX_HP;
	public final int MAX_POWER;
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
		this.MAX_POWER = power;
		this.isDead = false;
	}

	public int getLocation() {
		return this.location;
	}

	public void setLocation() {
		this.location += 1;
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

	public void setIsDead() {
		this.isDead = !isDead;
	}

	@Override
	public String toString() {

		return isDead ? String.format("[%s] 사망", name) : String.format("[%s hp] %d/%d", name, hp, MAX_HP);
	}

}

package zombie;

interface Recovery {
	public void recover(int recoveredHp);
}

interface Move {
	public void move();

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

	public void setHpPlus() {
		if (this.hp < this.MAX_HP)
			hp++;
	}

	public void setHpMinus() {
		if (this.hp > 0) {
			this.hp--;
			if (this.hp == 0)
				this.isDead = true;
		}
	}

	public int getPower() {
		return this.power;
	}

	public boolean isDead() {
		return this.isDead;
	}

	abstract void attack(Unit enenmy);

	abstract void Damageable(Unit enenmy);

}

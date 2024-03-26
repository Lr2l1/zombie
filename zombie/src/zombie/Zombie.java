package zombie;

import java.util.Random;

public class Zombie extends Monster {
	private Random ran = new Random();

	public Zombie() {
		super(5, "좀비", 100, 10);
	}

	@Override
	void attack(Unit hero) {
		int ranPower = ran.nextInt(super.getPower());
		hero.setHp(hero.getHp() - ranPower);
		System.out.printf("좀비의 %d 데미지의 공격!\n", super.getPower());

	}

	@Override
	void Damageable(Unit hero) {
		super.setHp(super.getHp() - hero.getPower());

		if (super.getHp() < 0) {
			super.setHp(0);
			super.setIsDead();
		}
		System.out.println(hero);
	}
}

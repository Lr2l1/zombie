package zombie;

import java.util.Random;

public class Boss extends Monster {
	private Random ran = new Random();

	public Boss() {
		super(9, "보스", 300, 20);
	}

	@Override
	void attack(Unit hero) {
		int ranPower = ran.nextInt(super.getPower());
		hero.setHp(hero.getHp() - ranPower);
		System.out.printf("좀비의 %d 데미지의 공격!\n", super.getPower());
		System.out.println(hero);
	}

	@Override
	void Damageable(Unit hero) {
		super.setHp(super.getHp() - hero.getPower());

		if (super.getHp() < 0) {
			super.setHp(0);
			super.setIsDead();
		}
	}

}

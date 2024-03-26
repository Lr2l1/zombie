package zombie;

import java.util.Random;

public class Zombie extends Monster {
	private Random ran = new Random();

	public Zombie() {
		super(5, "좀비", 100, 10);
	}

	@Override
	void attack(Unit hero) {
		super.setPower(ran.nextInt(super.MAX_POWER));
		hero.setHp(hero.getHp() - super.getPower());
		System.out.printf("좀비의 %d 데미지의 공격! ", super.getPower());

		if (hero.getHp() < 0) {
			hero.setHp(0);
			hero.setIsDead();
		}

		System.out.println(hero);
	}

	
}

package zombie;

import java.util.Random;

public class Zombie extends Monster {
	private Random ran = new Random();

	public Zombie() {
		super(5, "좀비", 100, 10);
	}

	public Zombie(int location, String name, int hp, int power) {
		super(location, name, hp, power);
	}

	@Override
	void attack(Unit hero) {
		super.setPower(ran.nextInt(super.MAX_POWER));
		hero.setHp(hero.getHp() - super.getPower());
		System.out.printf("%s의 %d 데미지의 공격! , %d만큼 체력회복 되었습니다. ", super.getName(), super.getPower(),
				super.getPower() / 2);

		if (hero.getHp() < 0) {
			hero.setHp(0);
			hero.setIsDead();
		}
		super.setHp(super.getHp() + super.getPower() / 2);

		System.out.println(hero);
	}

	@Override
	void berserk(Human hero) {

		super.setPower(ran.nextInt(super.MAX_POWER));
		System.out.printf("[광폭화 모드] %s의 %d 데미지의 공격! , %d만큼 체력회복 되었습니다. ", super.getName(), super.getPower(),
				super.getPower() / 2);
		super.setHp(super.getHp() + super.getPower() / 2);

		int ranDice = ran.nextInt(3);
		if (ranDice == 2) {
			System.out.println();
			System.err.println("광폭화 추가타!");
			super.setPower(ran.nextInt(super.MAX_POWER));
			System.out.printf("%s의 %d 데미지의 공격! , %d만큼 체력회복 되었습니다. ", super.getName(), super.getPower(),
					super.getPower() / 2);
			super.setHp(super.getHp() + super.getPower() / 2);
		}

		if (hero.getHp() < 0) {
			hero.setHp(0);
			hero.setIsDead();
		}

		System.out.println(hero);
	}

}

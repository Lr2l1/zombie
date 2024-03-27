package zombie;

import java.util.Random;

public class Zombie extends Monster {
	private Random ran = new Random();

	public Zombie() {
		super(5, "좀비", 100, 10);
	}

	@Override
	void attack(Human hero) {
		super.setPower(ran.nextInt(super.MAX_POWER));
		hero.setHp(hero.getHp() - super.getPower());
		System.out.printf("좀비의 %d 데미지의 공격! , %d만큼 체력회복 되었습니다. ", super.getPower(), super.getPower()/2);

		if (hero.getHp() < 0) {
			hero.setHp(0);
			hero.setIsDead();
		}
		super.setHp(super.getHp() + super.getPower()/2);
		
		

		System.out.println(hero);
	}

	
}

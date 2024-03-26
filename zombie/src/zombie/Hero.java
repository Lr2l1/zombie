package zombie;

import java.util.Random;

public class Hero extends Human implements Move, Recovery {
	private Random ran = new Random();
	int portion;

	public Hero() {
		super(1, "용사님", 200, 20);
		this.portion = 5;
	}

	@Override
	void attack(Unit zombie) {

		super.setPower(ran.nextInt(super.MAX_POWER));
		zombie.setHp(zombie.getHp() - super.getPower());
		System.out.printf("용사의 %d 데미지의 공격!\n", super.getPower());

	}

	@Override
	void Damageable(Unit zombie) {
		super.setHp(super.getHp() - zombie.getPower());

		if (super.getHp() < 0) {
			super.setHp(0);
			super.setIsDead();
		}

		System.out.println(zombie);

	}

	@Override
	public void move() {
		super.setLocation();
		System.out.printf("현재위치 [%d]\n", super.getLocation());
	}

	@Override
	public void recover() {
		if (portion > 0 && super.getHp() <= 100) {
			super.setHp(super.getHp() + 100);
			System.out.println("HP가 100 회복되었습니다.");
		} else
			System.err.println("회복이 불가능합니다!");

	}

}

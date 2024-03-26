package zombie;

import java.util.Random;

public class Hero extends Unit implements Move, Recovery {
	private Random ran = new Random();
	private int portion;

	public Hero(int location, String name, int hp, int power, int portion) {
		super(1, "용사님", 200, 20);
		this.portion = 5;

	}

	@Override
	void attack(Unit zombie) {
		int ranPower = ran.nextInt(super.getPower());
		zombie.setHp(zombie.getHp() - ranPower);
		
	}

	@Override
	void Damageable(Unit zombie) {
		System.out.printf("%d의 데미지를 받았습니다.", zombie.getPower());
		super.setHp(super.getHp() - zombie.getPower());

	}

	@Override
	public void move() {
		super.setLocation();
	}

	@Override
	public void recover() {
		if (portion > 0) {
			super.setHp(super.getHp() + 100);
			System.out.println("HP가 100 회복되었습니다.");
		} else
			System.err.println("포션이 모두 떨어졌습니다.");

	}

}

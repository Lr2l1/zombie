package zombie;

import java.util.Scanner;

public class ZombieGame {
	public static void run() {
		Scanner scan = new Scanner(System.in);
		Hero hero = new Hero();
		Zombie zombie = new Zombie();
		Boss boss = new Boss();
		

		while (!hero.isDead()) {

			System.out.print("[1]이동하기 [2]종료하기 : ");
			int select = scan.nextInt();

			if (select == 1) {
				hero.move();

				if (hero.getLocation() == zombie.getLocation()) {
					System.out.println("좀비와 대결!");
					System.out.println(zombie);
					while (true) {
						System.out.printf("[1]공격하기 [2]체력회복 (%d/5)\n", hero.portion);
						int sel = scan.nextInt();

						if (sel == 1) {
							hero.attack(zombie);
							hero.Damageable(zombie);

							zombie.attack(hero);
							zombie.Damageable(hero);

						}

						else if (sel == 2) {
							hero.recover();
						}

						if (zombie.isDead()) {
							System.out.println("좀비를 처치하였습니다.");
							break;
						}

						if (hero.isDead()) {
							System.out.println("사망하였습니다.");
							break;
						}
					}
				}
			} else if (select == 2)
				break;
		}
	}

	public static void main(String[] args) {
		ZombieGame.run();
	}

}

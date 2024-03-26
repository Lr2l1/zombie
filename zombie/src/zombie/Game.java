package zombie;

import java.util.Scanner;

public class Game {
	private final int MOVE = 1;
	private final int FINISH = 2;

	private final int FIGHT = 1;
	private final int RECOVER = 2;

	Scanner scan = new Scanner(System.in);
	Hero hero = new Hero();
	Zombie zombie = new Zombie();
	Boss boss = new Boss();

	private boolean isGoal;;

	private Game() {

		this.isGoal = false;
	}

	private static Game instance = new Game();

	public static Game getInstance() {
		return instance;
	}

	private int inputNumber() {
		int number = -1;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자를 입력해주세요.");
		}
		return number;
	}

	private void printMenu() {
		System.out.print("[1]이동하기 [2]종료하기 : ");
	}

	private void runMenu(int select) {
		if (select == MOVE)
			move();
		else if (select == FINISH)
			finish();
	}

	private void move() {
		hero.move();

	}

	private void meetEnemy() {
		if (hero.getLocation() == zombie.getLocation()) {
			System.out.println("좀비와 대결!");
			System.out.println(zombie);
			while (!hero.isDead() && !zombie.isDead()) {
				printSubMenu();
				runSubMenu(inputNumber());

				if (zombie.isDead())
					System.out.println("좀비를 쓰러트렸어!");
				if (hero.isDead())
					System.out.println("사망했습니다.");
			}

		} else if (hero.getLocation() == boss.getLocation()) {
			System.out.println("보스와의 대결");
			System.out.println(boss);
			while (!hero.isDead() && !boss.isDead()) {
				printSubMenu();
				runSubMenu(inputNumber());

				if (boss.isDead())
					System.out.println("보스를 쓰러트렸어!");
				if (hero.isDead()) {
					System.out.println("사망했습니다.");

				}
			}
		}
	}

	private void printSubMenu() {
		System.out.printf("[1]공격하기 [2]체력회복 (%d/5) : ", hero.portion);
	}

	private void runSubMenu(int select) {
		if (select == FIGHT) {
			if (hero.getLocation() == zombie.getLocation())
				fightZombie();
			else if (hero.getLocation() == boss.getLocation())
				fightBoss();
		} else if (select == RECOVER)
			recover();

	}

	private void fightZombie() {
		hero.attack(zombie);
		zombie.attack(hero);
	}

	private void fightBoss() {
		hero.attack(boss);
		boss.attack(hero);
	}

	private void recover() {
		hero.recover();
	}

	private void finish() {
		isGoal = true;
	}

	private boolean isRun() {
		return isGoal || hero.getLocation() == 10 || hero.isDead() ? false : true;

	}

	private void printResult() {
		if (!hero.isDead())
			System.out.println("괴물들을 무찌르고 무사히 도착했어!");
		else
			System.out.println("괴물들을 퇴치하는데 실패했어..");
	}

	public void run() {
		while (isRun()) {
			printMenu();
			int sel = inputNumber();
			runMenu(sel);
			meetEnemy();
		}
		printResult();
	}

}

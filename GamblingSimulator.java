package gamblingsimulator;

public class GamblingSimulator {
	static int stake = 100;
	static int cash = stake;
	static int bets = 0;

	static void placeBet() {
		bets++;
		if (Math.random() < 0.5) {
			cash++;
			System.out.println("Bet won.");
		} else {
			cash--;
			System.out.println("Bet lost.");
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Gambling Simulator Program!");
		placeBet();
	}

}

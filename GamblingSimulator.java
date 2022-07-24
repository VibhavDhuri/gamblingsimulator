package gamblingsimulator;

public class GamblingSimulator {
	static int stake = 100;
	static int upperStakeLimit = 150;
	static int lowerStakeLimit = 50;
	static int cash = stake;
	static int bets = 0;
	static int betsWon = 0;

	static void placeBet() {
		bets++;
		if (Math.random() < 0.5) {
			cash++;
			betsWon++;
			System.out.println("Bet no. " + bets + ": Bet won.");
		} else {
			cash--;
			System.out.println("Bet no. " + bets + ": Bet lost.");
		}
	}

	static void dailyPlay() {
		while (cash < upperStakeLimit && cash > lowerStakeLimit) {
			placeBet();
		}
		checkDailyLimit();
		System.out.println("Stake at the end of the day is: " + cash);
		System.out.println("Total Bets: " + bets);
		System.out.println("Bets Won: " + betsWon);
	}

	static void checkDailyLimit() {
		if (cash == upperStakeLimit)
			System.out.println("Upper limit reached! Resigning for the day...");
		else
			System.out.println("Lower limit reached! Resigning for the day...");
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Gambling Simulator Program!");
		dailyPlay();
	}

}

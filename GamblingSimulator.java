package gamblingsimulator;

public class GamblingSimulator {
	static int stake = 100;
	static int upperStakeLimit = 150;
	static int lowerStakeLimit = 50;
	static int cash = stake;
	static int bets = 0;
	static int betsWon = 0;
	static int profitOrLoss = 0;
	static int totalProfitOrLoss = 0;

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
		profitOrLoss = cash - 100;
		{
			if (profitOrLoss == -50)
				System.out.println("There is loss of 50.");
			else
				System.out.println("There is profit of 50.");
		}
		System.out.println("Total Bets: " + bets);
		System.out.println("Bets Won: " + betsWon);
		cash = 100;
	}

	static void checkDailyLimit() {
		if (cash == upperStakeLimit)
			System.out.println("Upper limit reached! Resigning for the day...");
		else
			System.out.println("Lower limit reached! Resigning for the day...");
	}

	static void playTwentyDays() {
		for (int i = 0; i < 2; i++) {
			dailyPlay();
			totalProfitOrLoss = totalProfitOrLoss + profitOrLoss;
		}
		if (totalProfitOrLoss < 0)
			System.out.println("Total loss is: " + totalProfitOrLoss);
		else if (totalProfitOrLoss == 0)
			System.out.println("There is no profit or loss.");
		else
			System.out.println("The profit is: " + totalProfitOrLoss);

	}

	public static void main(String[] args) {
		System.out.println("Welcome to Gambling Simulator Program!");
		playTwentyDays();
	}

}

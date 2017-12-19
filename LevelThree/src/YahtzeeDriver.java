import java.util.Scanner;

public class YahtzeeDriver
{
	/*
	1. Creates a new instance of the YahtzeeGame class
	2. Calls the playGame method on the Yahtzee object
	3. Asks user if they would like to play again
	4. When the user is done playing, prints the number of games played, min, max, and average score
	*/
	public static void main(String [] args)
	{
		boolean playAgain = false;
		int numGames = 0;
		int allScores = 0;
		int minScore = 0;
		int maxScore = 0;
		do {
			Scanner s = new Scanner(System.in);
			int score;
			YahtzeeGame myGame=new YahtzeeGame();
			System.out.println("Welcome to Hunter's APCSA Yahtzee Game!");
			score=myGame.playGame();
			numGames += 1;
			allScores += score;
			if (score < minScore){
				minScore = score;
			}
			else if (score > maxScore){
				maxScore = score;
			}

			System.out.println("Would you like to play again (y or n): ");
			String userChoice = s.nextLine();

			switch (userChoice) {
				case "y":
					playAgain = true;

					break;
				case "n":
					playAgain = false;
					break;
			}
		}while(playAgain);
		System.out.println("Number of games played: " + numGames + " Min score: " + minScore + " Max Score: " + maxScore + " Average Score: " + (allScores/numGames));



	}
}

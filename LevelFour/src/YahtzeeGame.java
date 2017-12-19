import java.util.Scanner;

public class YahtzeeGame
{
	/* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */

	private YahtzeeDie die1;
	private YahtzeeDie die2;
	private YahtzeeDie die3;
	private YahtzeeDie die4;
	private YahtzeeDie die5;
	private YahtzeeScorecard score;
	public static final int NUM_SIDES = 6;


	/* initializes the dice and scoreboard */
	public YahtzeeGame()
	{
		die1 = new YahtzeeDie(NUM_SIDES);
		die2 = new YahtzeeDie(NUM_SIDES);
		die3 = new YahtzeeDie(NUM_SIDES);
		die4 = new YahtzeeDie(NUM_SIDES);
		die5 = new YahtzeeDie(NUM_SIDES);
		score = new YahtzeeScorecard();


	}

	/* check to see if the game is over, and while the game is not over call the method takeTurn()
	once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
	final scorecard and return the grand total */
	public int playGame()
	{
		for (int i = 0; i < 13; i++){
			this.takeTurn();
		}
		score.printScoreCard();
		return score.getGrandTotal();
	}

	/* 	1. call rollDice()
		2. call printDice()
		3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		4. call chooseFrozen()
		5. call rollDice()
		6. call printDice()
		7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		8. call chooseFrozen()
		9. call rollDice()
		10. call printDice()
		11. call markScore()
	*/
	private void takeTurn()
	{
		this.rollDice();
		Scanner s = new Scanner(System.in);
		System.out.print("Role 1: ");
		this.printDice();
		System.out.println("Are you (s)atisfied with your roll, or would you like to (r)oll again: ");
		String userChoice = s.nextLine();
		if (userChoice.equals("r")){
			this.chooseFrozen();
			this.rollDice();
			System.out.print("Role 2: ");
			this.printDice();
			System.out.println("Are you (s)atisfied with your roll, or would you like to (r)oll again: ");
			userChoice = s.nextLine();
			if (userChoice.equals("r")){
				this.chooseFrozen();
				this.rollDice();
				System.out.print("Role 3: ");
				this.printDice();

			}
		}
		this.markScore();

	}

	/* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
	private void rollDice()
	{
		/* your code here */
		if (!die1.isFrozen()){
			die1.rollDie();
		}
		else die1.unfreezeDie();
		if (!die2.isFrozen()){
			die2.rollDie();
		}
		else die2.unfreezeDie();
		if (!die3.isFrozen()){
			die3.rollDie();
		}
		else die3.unfreezeDie();
		if (!die4.isFrozen()){
			die4.rollDie();
		}
		else die4.unfreezeDie();
		if (!die5.isFrozen()){
			die5.rollDie();
		}
		else die5.unfreezeDie();

	}

	/* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
	private void chooseFrozen()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Please choose the numbers you want to be frozen (1-5): ");
		String userChoice = s.nextLine();
		if (userChoice.contains("1")){
			die1.freezeDie();
		}
		if (userChoice.contains("2")){
			die2.freezeDie();
		}
		if (userChoice.contains("3")){
			die3.freezeDie();
		}
		if (userChoice.contains("4")){
			die4.freezeDie();
		}
		if (userChoice.contains("5")){
			die5.freezeDie();
		}
		/* your code here */
	}

	/* Should print the value of all five dice separated by a tab (\t) to the console */
	private void printDice()
	{
		/* your code here */
		System.out.print(die1.getValue() + "\t" + die2.getValue() + "\t" + die3.getValue() + "\t" + die4.getValue() + "\t" + die5.getValue());
	}

	/* 1. Print a scoreboard
	   2. Ask the user where they would like to mark their score.
	   3. Call appropriate function
	   4. If false is returned the user entered an invalid number, so ask the user to try again	*/
	private void markScore()
	{
		Scanner s = new Scanner(System.in);
		boolean validNum = false;
		do{
			score.printScoreCard();
			int userChoice;
			do {
				System.out.println("Where would you like to mark your score?");
				System.out.println("1. Ones \n2. Twos \n3. Threes \n4. Fours \n5. Fives \n6. Sixes \n7. Three of a kind " +
						"\n8. Four of a Kind \n9. Full House \n10. Small Straight \n11. Large Straight \n12. Yahtzee \n13. Chance\n Please enter a number 1-13: ");
				userChoice = s.nextInt();
			}while(userChoice > 13 || userChoice < 1);

			switch(userChoice){
				case 1: validNum = score.markOnes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); break;
				case 2: validNum = score.markTwos(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); break;
				case 3: validNum = score.markThrees(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); break;
				case 4: validNum = score.markFours(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); break;
				case 5: validNum = score.markFives(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); break;
				case 6: validNum = score.markSixes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); break;
				case 7: validNum = score.markThreeOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); break;
				case 8: validNum = score.markFourOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); break;
				case 9: validNum = score.markFullHouse(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); break;
				case 10: validNum = score.markSmallStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); break;
				case 11: validNum = score.markLargeStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); break;
				case 12: validNum = score.markYahtzee(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); break;
				case 13: validNum = score.markChance(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); break;
				default: break;
			}
		}while(!validNum);

	}
}
package question1;

import java.io.*;
import java.util.Scanner;

public class Game {
	
	private static int playercard1, playercard2, dealercard1, dealercard2, playercardtotal, dealercardtotal;
	
	public static void playerhit()
	{
		int playercard = (int) (Math.random() * 9 + 2);
		System.out.println("You drew a " + playercard + ".");
		playercardtotal +=playercard;
		System.out.println("Your score is " + playercardtotal);
	}
	
	public static void initialPlayerCards()
	{
		System.out.println("Welcome To Susmi's Blackjack Program!");
		playercard1 = (int) (Math.random() * 9 + 2);
		playercard2 = (int) (Math.random() * 9 + 2);
		System.out.println("You drew a " + playercard1 + " and a " + playercard2 + ".");
		playercardtotal = playercard1 + playercard2;
		System.out.println("Your total is " + playercardtotal + ".");
		System.out.println();
	}
	
	public static void initialDealerCards()
	{
		dealercard1 = (int) (Math.random() * 9 + 2);
		dealercard2 = (int) (Math.random() * 9 + 2);
		dealercardtotal = dealercard1 + dealercard2;
		System.out.println("The dealer has a " + dealercard1 + " showing and the other card hidden.");
		System.out.println("His total is hidden, too.");
		System.out.println();
	}
	
	public static void dealerhit()
	{
		System.out.println("Dealer chooses to hit.");
		int dealercard = (int) (Math.random() * 9 + 2);
		System.out.println("He draws a " + dealercard + ".");
		dealercardtotal += dealercard;
		System.out.println("His total is " + dealercardtotal);
		System.out.println();
		
	}
	
	public static void main(String[] args)
	{
		initialPlayerCards();
		
		if(playercardtotal > 21)
			System.out.println("DEALER WINS!");
		
		else
		{	
			
			initialDealerCards();
			System.out.println("Would you like to hit or stay?(h/s)");
			Scanner s = new Scanner(System.in);
			String str = s.next();
			
			while(str.charAt(0) != 's')
			{
					
				if(str.charAt(0) == 'h')
					playerhit();
					
				if(playercardtotal > 21)
					{
						System.out.println("DEALER WINS!");
						break;
					}
					
				else if(str.charAt(0) != 'h' && str.charAt(0) != 's')
					{	
						System.out.println("Wrong format, please type 'h' or 's':");
					}
					
				System.out.println("Would you like to hit or stay?(h/s)");
				str = s.next();
			}
			if(playercardtotal <= 21)
			{
				System.out.println("Okay, dealer's turn.");
				while(dealercardtotal < 16)
				{
					dealerhit();
					if(dealercardtotal > 21)
						System.out.println("YOU WIN!");
				}
				if(dealercardtotal <= 21)
				{
					System.out.println("Dealer stays.");
					System.out.println();
					System.out.println("Dealer's total is " + dealercardtotal);
					System.out.println("Your total is " + playercardtotal);
					if(dealercardtotal >= playercardtotal)
					{
						System.out.println("DEALER WINS!");
					}
					else
						System.out.println("YOU WIN!");
				}
			}
		}
	}
}

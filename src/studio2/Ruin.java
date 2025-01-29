package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in); 
		 
		System.out.println("How much money have are you starting with? ");
		int startAmount = in.nextInt();
		
		System.out.println("What is the win chance?");
		double winChance = in.nextDouble();
		
		System.out.println("What is the win limit?");
		int winLimit = in.nextInt();
		
		System.out.println("What is your total simulation");
		int totalSimulations = in.nextInt();
		
	
		int numLosses;
		
		for(int i = 1; i<=totalSimulations; i++) {
			int count = 0;
			while(0<startAmount && startAmount<winLimit) {
				double m = Math.random();
				if(m < winChance) {
					startAmount ++;
					count ++;
				}
				else {
					startAmount --;
					count ++;
				}
			}
			if(startAmount==winLimit) 
				System.out.println("Simulation Day" + i + ": WIN!!" + ", in " + count + "plays");
			else
				System.out.println("Simulation Day" + i+ ": LOSE:(" + ", in "+ count + "plays");
				numLosses ++;
				
			}
			double ruinRate = numLosses/totalSimulations;
			double a = (1-winChance)/winChance;
			if(winChance == 0.5)
				double expectedRuin = 1 - (startAmount/winLimit);
			else
				(double)(Math.pow(a, startAmount) - Math.pow(a, winLimit))/(1-Math.pow(a, startAmount));
		}

	

	}


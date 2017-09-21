package main;

import java.util.ArrayList;

public class Runner {

	public static void main(String arv[])
	{
		ArrayList<Integer> numbers = findPrimes(100);
		
		System.out.println(numbers.toString());
		
	}
	
	public static ArrayList<Integer> findPrimes(int size)
	{
		ArrayList<Integer> PrimeNumbers = new ArrayList<Integer>();
		
		int counter = 0;
		int numberToCheck = 2;
		while (counter < size)
		{
			boolean isPrime = true;
			for(int i = 2; i <= numberToCheck / 2; i++)
			{
				if(numberToCheck % i == 0)
				{
					isPrime = false;
					break;
				}
			}
			
			if(isPrime == true)
			{
				PrimeNumbers.add(numberToCheck);
				counter++;
			}
			
			 numberToCheck++;
		}
		
		return PrimeNumbers;
	}
}

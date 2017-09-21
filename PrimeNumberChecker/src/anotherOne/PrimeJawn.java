package anotherOne;

import java.util.ArrayList;

public class PrimeJawn {
	public static void main(String[] args)
	{
		ArrayList<Integer> primeNumbers = primeNumbers(100);
		System.out.println(primeNumbers.toString());
		
	}
	
	
	public static ArrayList<Integer> primeNumbers(int n){
		ArrayList<Integer> primeNumberList = new ArrayList<Integer>();
		
		int numberToCheck = 2;
		while(primeNumberList.size() < n)
		{
			if (isPrime(numberToCheck)) primeNumberList.add(numberToCheck);
			numberToCheck++;
		}
		
		return primeNumberList;
	}
	
	public static boolean isPrime(int n)
	{
		if(n == 0)
		{
			return false;
		}
		for(int i = 2; i <= n/2; i++)
		{
			if(n % i == 0)
			{
				return false;
			}
		}
		
		
		return true;
	}
	
}

package org.java.se;

public class Main {

	public static void main(String[] args) {
		PrimeNumbers primeNumbers = new PrimeNumbers();
		Integer max = Integer.parseInt(args[0]);
		primeNumbers.generateNumbers(max);
	}

}

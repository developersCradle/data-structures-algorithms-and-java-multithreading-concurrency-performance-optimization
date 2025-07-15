package hashMapExample;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {


	    public static void main(String[] args) {

	        Date start = new Date();

	        Map<Integer, Book> books = new HashMap<Integer, Book>(500000, 0.9f);
	        for (int i = 0; i < 1000000; i++) {
	            books.put(i, new Book(i, "Jane Eyre", "Charlotte Bronte", 14.99));
	        }


	        books.ta
	        Date end = new Date();
	        System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) + " ms.");
	    }
	}


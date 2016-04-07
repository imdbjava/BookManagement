package com.iman.bookmanagement.service.publishment;

/**
 * Adapted from http://www.java-forum.org.
 * needs unit tests.
 * @author iman
 *
 */
public class ISBNChecks {
 // TODO unit tests
	 public static boolean checkISBN10(int[] isbn) {
	        int sum = 0;
	        for (int i = 1; i <= isbn.length; i++) {
	            sum += i * isbn[i - 1];
	        }
	        if (sum % 11 == 0) {
	            return true;
	        } else {

	            return false;
	        }

	    }

	    public static boolean checkISBN13(int[] isbn) {
	        int sum = 0;
	        for (int i = 1; i < isbn.length; i++) {
	            if (i % 2 == 0) {
	                sum += isbn[i - 1] * 3;
	            } else {
	                sum += isbn[i - 1];
	            }
	        }

	        int lastDigit = sum % 10;

	        int check = (10 - lastDigit) % 10;

	        if (isbn[isbn.length - 1] == check) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public static void main(String[] args) {
	        int[] isbn10 = new int[] { 3, 8, 6, 6, 8, 0, 1, 9, 2 };
	        System.out.println(checkISBN10(isbn10));
	        int[] isbn13 = new int[] { 9, 7, 8, 3, 7, 6, 5, 7, 2, 7, 8, 1, 8 };
	        System.out.println(checkISBN13(isbn13));
	    }
	 
	    
}

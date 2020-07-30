package questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Class majorityElement finds the majority element in an array. It uses
 * divide and conquer algorithm.
 * 
 * @author Sanyam
 *
 */
public class majorityElement {

	// n represents the number of input values
	private int n;

	// array for storing the integers
	int[] arrNum;

	public majorityElement() {
		/**
		 * Constructs a majorityElement object. The input entered must be an integer
		 * followed by a list of integers in the next line else an exception is thrown.
		 */

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter an integer n corresponding to the number of elements in list : ");

		try {

			// reads the input value for integer n
			this.n = Integer.parseInt(reader.readLine());
			System.out.println("Enter the list of numbers separated by space");

			// reads the list list of integers
			String[] num = reader.readLine().split(" ");

			// adding the list of numbers entered by the user to
			// arrNum
			arrNum = new int[n];
			for (int i = 0; i < arrNum.length; i++)
				arrNum[i] = Integer.parseInt(num[i]);

			// if any of the entered number is invalid i.e. if the exception is thrown,
			// then the execution is stopped
		} catch (Exception e) {
			System.out.println("The entered no's are not valid");
			System.exit(0);

		}

	}

	public int count(int num, int lo, int hi) {
		/**
		 * Integer count() counts the occurrences of the number num
		 * in the array arrNum from index lo to hi.
		 * 
		 * @return sum which represents the occurrences of the num
		 */
		int sum = 0;
		for (int i = lo; i <= hi; i++) {
			if (arrNum[i] == num) {
				sum++;
			}
		}
		return sum;
	}

	public int getMax(int low, int high) {
		/**
		 * getMax(Integer low, Integer high) receives the lower bound and the upper bound of the array.
		 * Based on the divide and conquer it finds the majority element.
		 * 
		 * @return the majority element if any else returns -1.
		 */

		if (low > high)
			return -1;
		
		// for array with only one element
		if (low == high)
			return arrNum[low];
		
		int mid = (high + low) / 2;
		
		// dividing the array into two parts left and right 
		int left = getMax(low, mid);
		int right = getMax(mid + 1, high);
		
		// algorithm for checking the majority element
		
		// if the left array does not have any majority element but the right array has
		if (left == -1 && right != -1) {
			int num = count(right, low, high);
			
			// if num is greater than the length of the half of an array
			// than return right else -1
			if (num > (high - low + 1) / 2) {
				return right;
			} else {
				return -1;
			}
			
			// if the right array does not have any majority element but the left array has
		} else if (right == -1 && left != -1) {
			int num = count(left, low, high);
			
			// if num is greater than the length of the half of an array
			// than return left else -1
			if (num > (high - low + 1) / 2) {
				return left;
			} else {
				return -1;
			}
			
			// if both of them has some majority element then the count of both of them is calculated
			// one with the majority is returned. If none of them is in majority then -1 is returned.
		} else if (left != -1 && right != -1) {
			
			int leftNum = count(left, low, high);
			int rightNum = count(right, low, high);
			
			// if left is in majority
			if (leftNum > (high - low + 1) / 2) {
				return left;
				
			// if right is in majority	
			} else if (rightNum > (high - low + 1) / 2) {
				return right;
				
			} else {
				return -1;
			}
			
			// if there is no majority element then return -1
		} else {
			return -1;
		}

	}

	public static void main(String[] args) {
		
		// creating an instance of class majority element
		majorityElement obj = new majorityElement();
		
		// calling getMax() to get the majority value
		int num = obj.getMax(0, obj.n - 1);
		
		// if the majority element is found
		if (num != -1) {
			System.out.println("1");
			System.out.format("%d is the majority element", num);
		}
		
		// if there is no majority element in the list
		else {
			System.out.println("0");
			System.out.println("There is no majority element in this sequence");
		}
	}
}

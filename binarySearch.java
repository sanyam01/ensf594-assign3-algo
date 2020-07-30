package questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Class binarySearch takes two lists as the input. The numbers in the second list are
 * searched in the first list using the binary search, and corresponding indices found are returned.
 * If the number is not found in the first list, then -1 is returned. 
 * 
 * @author Sanyam
 *
 */

public class binarySearch {

	// arrayList for storing the number list
	ArrayList<Long> arrNum = new ArrayList<Long>();

	// arrayList for storing the numbers whose index is to be searched
	ArrayList<Long> arrSearchNum = new ArrayList<Long>();

	public binarySearch() {
		/**
		 * Constructs a binarySearch object. The input entered must be integers
		 * separated by space else an exception is thrown.
		 * 
		 */

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the two lists in separate lines.\nEach list should be integers separated by space");

		try {

			// reads the list of numbers entered by user
			// and assigns it to the num list
			String[] num = reader.readLine().split(" ");

			// reads the list of numbers whose index is to be searched
			// and assigns it to the searchNum
			String[] searchNum = reader.readLine().split(" ");

			// adding the list of numbers entered by the user to
			// arrNum list
			for (String i : num) {
				this.arrNum.add(Long.parseLong(i));
			}

			// adding the numbers to be searched to the arrSearchNum list
			for (String i : searchNum) {

				this.arrSearchNum.add(Long.parseLong(i));
			}

			// if any of the entered number is invalid i.e. if the exception is thrown,
			// then the execution is stopped
		} catch (Exception e) {
			System.out.println("The entered no's are not valid");
			System.exit(0);

		}

	}

	public int search(Long key) {
		/**
		 * search(Integer key) finds the index of the key in the arrNum list. The key
		 * represents the number whose index is to be searched. If the number is found
		 * in the list, then its index is returned else -1 is returned.
		 * 
		 * The algorithm used to find the key is binary search. The list is already
		 * sorted.
		 * 
		 * 
		 * @return the index of the key
		 */

		// low represents the index of the first element
		int low = 1;

		// high represents index of the last element
		int high = arrNum.size()-2;

		// binary search algorithm
		while (low <= high) {
			int mid = (low + high) / 2;

			// returns the index if the key is found
			if (arrNum.get(mid) == key)
				return mid - 1;

			// low or high is changed based on the comparison of the key
			else if (key < arrNum.get(mid))
				high = mid - 1;
			else
				low = mid + 1;
		}

		// if the key is not in the list, then the -1 is returned
		return -1;
	}

	public ArrayList getIndex() {
		/**
		 * getIndex() iterates through the list of numbers whose indices are to be
		 * searched and passes them one by one to the function search as key. The index
		 * returned by the search() is added to the list outList, which is then finally
		 * returned.
		 */
		ArrayList<Integer> outList = new ArrayList<Integer>();

		// list is iterated
		for (int i = 1; i < arrSearchNum.size(); i++) {

			// res indicates the index of the element passed
			int res = this.search(arrSearchNum.get(i));

			// index added to the list
			outList.add(res);
		}
		return outList;
	}

	public void printIndex(ArrayList<Integer> arr) {
		/**
		 * printIndex(ArrayList<Integer> arr) takes the ArrayList as the parameter and
		 * prints all its elements.
		 */
		for (int i : arr)
			System.out.print(i + " ");
	}

	public static void main(String[] args) {

		// creates an object of binarySearch
		binarySearch s = new binarySearch();

		// gets the list with the indices of the numbers
		ArrayList output = s.getIndex();

		// print the indices
		s.printIndex(output);
	}

}

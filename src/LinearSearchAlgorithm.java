import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * @author Pamela Ofurum
 *
 */

//This class implements Multiple Search Algorithms
public class LinearSearchAlgorithm {
	
	// This method implements the Linear search
	public static int linearSearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return i; // If Key is Found at index i
			}
		}
		return -1; // If Key not found
	}

	// This method implements Interpolation search
	public static int interpolationSearch(int[] arr, int key) {
		int lowSearch = 0;
		int highSearch = arr.length - 1;

		while (lowSearch <= highSearch && key >= arr[lowSearch] && key <= arr[highSearch]) {
			if (lowSearch == highSearch) {
				if (arr[lowSearch] == key) {
					return lowSearch; // If key is Found at index lowSearch
				}
				return -1; // If Key not found
			}

			// Calculates the position using interpolation formula
			int position = lowSearch + ((key - arr[lowSearch]) * (highSearch - lowSearch)) / (arr[highSearch] - arr[lowSearch]);

			if (arr[position] == key) {
				return position; // If the Key is Found at position
			} else if (arr[position] < key) {
				lowSearch = position + 1; // If Key is in the upper part
			} else {
				highSearch = position - 1; // If Key is in the lower part
			}
		}

		return -1; // If Key not found
	}

	// This method implements Linear search with transposition for improvement
	public static int linearSearchWithTransposition(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				if (i > 0) {
					// Moves the search element one position closer to the beginning of the array
					int temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
				}
				return i; // If the key is Found at index i
			}
		}
		return -1; // If Key is not found
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of elements in the array: ");
		int n = scanner.nextInt();

		int[] arr = new int[n];
		System.out.println("Enter the elements in the array:");
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		System.out.print("Enter the search key: ");
		int key = scanner.nextInt();

		// Performs a linear search and checks the running time
		long linearStartTime = System.nanoTime();
		int linearResult = linearSearch(arr, key);
		long linearEndTime = System.nanoTime();

		System.out.println("Using Linear Search:");
		if (linearResult != -1) {
			System.out.println("Search key FOUND at index " + linearResult);
		} else {
			System.out.println("Search key NOT FOUND");
		}

		// Sorts the array in ascending order
		Arrays.sort(arr);

		// Performs interpolation search and checks the running time
		long interpolationStartTime = System.nanoTime();
		int interpolationResult = interpolationSearch(arr, key);
		long interpolationEndTime = System.nanoTime();

		System.out.println("Using Interpolation Search:");
		if (interpolationResult != -1) {
			System.out.println("Search key FOUND at index " + interpolationResult);
		} else {
			System.out.println("Search key NOT FOUND");
		}

		// Performs linear search with transposition for improvement and takes the start time and end time
        long improvedlinearStartTime = System.nanoTime();
        int improvedlinearResult = linearSearchWithTransposition(arr, key);
        long improvedlinearEndTime = System.nanoTime();

        System.out.println("Using Linear Search with Transposition:");
        if (linearResult != -1) {
            System.out.println("Search key FOUND at index " + improvedlinearResult);
        } else {
            System.out.println("Search key NOT FOUND");
        }
        
		// Calculates running times
		long linearRunningTime = linearEndTime - linearStartTime;
		long interpolationRunningTime = interpolationEndTime - interpolationStartTime;
		long improvedlinearRunningTime = improvedlinearEndTime - improvedlinearStartTime;
		
		System.out.println("Linear Search Running Time: " + linearRunningTime + " nanoseconds");
		System.out.println("Interpolation Search Running Time: " + interpolationRunningTime + " nanoseconds");
		System.out.println("Linear Search with Transposition Running Time: " + improvedlinearRunningTime + " nanoseconds");
		
	}
}

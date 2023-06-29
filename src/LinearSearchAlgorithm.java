import java.util.Arrays;
import java.util.Scanner;

public class LinearSearchAlgorithm {
	// Linear search implementation
	public static int linearSearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return i; // Found the key at index i
			}
		}
		return -1; // Key not found
	}

	// Interpolation search implementation
	public static int interpolationSearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high && key >= arr[low] && key <= arr[high]) {
			if (low == high) {
				if (arr[low] == key) {
					return low; // Found the key at index low
				}
				return -1; // Key not found
			}

			// Calculate the position using interpolation formula
			int position = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low]);

			if (arr[position] == key) {
				return position; // Found the key at position
			} else if (arr[position] < key) {
				low = position + 1; // Key may be in the upper part
			} else {
				high = position - 1; // Key may be in the lower part
			}
		}

		return -1; // Key not found
	}

	// Linear search implementation with transposition
	public static int linearSearchWithTransposition(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				if (i > 0) {
					// Move the found element one position closer to the beginning
					int temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
				}
				return i; // Found the key at index i
			}
		}
		return -1; // Key not found
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

		// Perform linear search
		long linearStartTime = System.nanoTime();
		int linearResult = linearSearch(arr, key);
		long linearEndTime = System.nanoTime();

		System.out.println("Using Linear Search:");
		if (linearResult != -1) {
			System.out.println("Search key FOUND at index " + linearResult);
		} else {
			System.out.println("Search key NOT FOUND");
		}

		// Sort the array
		Arrays.sort(arr);

		// Perform interpolation search
		long interpolationStartTime = System.nanoTime();
		int interpolationResult = interpolationSearch(arr, key);
		long interpolationEndTime = System.nanoTime();

		System.out.println("Using Interpolation Search:");
		if (interpolationResult != -1) {
			System.out.println("Search key FOUND at index " + interpolationResult);
		} else {
			System.out.println("Search key NOT FOUND");
		}

		// Perform linear search with transposition
        long improvedlinearStartTime = System.nanoTime();
        int improvedlinearResult = linearSearchWithTransposition(arr, key);
        long improvedlinearEndTime = System.nanoTime();

        System.out.println("Using Linear Search with Transposition:");
        if (linearResult != -1) {
            System.out.println("Search key FOUND at index " + improvedlinearResult);
        } else {
            System.out.println("Search key NOT FOUND");
        }
        
		// Calculate running times
		long linearRunningTime = linearEndTime - linearStartTime;
		long interpolationRunningTime = interpolationEndTime - interpolationStartTime;
		long improvedlinearRunningTime = improvedlinearEndTime - improvedlinearStartTime;
		
		System.out.println("Linear Search Running Time: " + linearRunningTime + " nanoseconds");
		System.out.println("Interpolation Search Running Time: " + interpolationRunningTime + " nanoseconds");
		System.out.println("Linear Search with Transposition Running Time: " + improvedlinearRunningTime + " nanoseconds");
		
	}
}

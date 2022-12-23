import java.util.ArrayList;
import java.util.List;

public class ClosestNumbers {

    public static List<Integer> findClosestNumbers(int[] arr, int K, int X) {
        // Find the index of X in the array, or the index of the number
        // immediately larger than X if X is not present in the array
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == X) {
                break;
            } else if (arr[mid] < X) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int mid = left;  // X is not present in the array, so mid will be the index of the larger number

        // Initialize two pointers to the left and right of mid
        int leftPtr = mid - 1;
        int rightPtr = mid;

        // Initialize a list to store the K closest numbers
        List<Integer> closest = new ArrayList<>(K);
        for (int i = 0; i < K; i++) {
            // If the left pointer is still within the array bounds
            // and the distance from X to the left number is smaller than
            // the distance from X to the right number, or if the right
            // pointer has reached the end of the array, add the left number
            // to the list and decrement the left pointer.
            if (leftPtr >= 0 && (rightPtr >= arr.length || Math.abs(X - arr[leftPtr]) < Math.abs(X - arr[rightPtr]))) {
                closest.add(arr[leftPtr]);
                leftPtr--;
            }
            // Otherwise, add the right number to the list and increment the right pointer.
            else {
                closest.add(arr[rightPtr]);
                rightPtr++;
            }
        }

        return closest;
    }

}

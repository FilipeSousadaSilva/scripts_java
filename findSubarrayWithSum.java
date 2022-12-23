import java.util.List;
import java.util.ArrayList;

public class Main {
  public static List<Integer> findSubarrayWithSum(int[] arr, int targetSum) {
    // Store the current sum and starting index of the subarray
    int currentSum = 0;
    int startIndex = 0;
    // Iterate through the array
    for (int i = 0; i < arr.length; i++) {
      // Update the current sum
      currentSum += arr[i];
      // If the current sum is greater than the target sum,
      // remove elements from the start of the subarray until it is equal to or less than the target sum
      while (currentSum > targetSum) {
        currentSum -= arr[startIndex];
        startIndex++;
      }
      // If the current sum is equal to the target sum, return the subarray
      if (currentSum == targetSum) {
        List<Integer> result = new ArrayList<>();
        for (int j = startIndex; j <= i; j++) {
          result.add(arr[j]);
        }
        return result;
      }
    }
    // If no subarray with the target sum was found, return an empty list
    return new ArrayList<>();
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int targetSum = 9;
    List<Integer> result = findSubarrayWithSum(arr, targetSum);
    System.out.println(result);  // [4, 5]
  }
}

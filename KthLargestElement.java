import java.util.PriorityQueue;

public class KthLargestElement {

    public static int findKthLargest(int[] stream, int k) {
        // Initialize a min heap with the first K elements of the stream
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            heap.add(stream[i]);
        }

        // Process the remaining elements of the stream
        for (int i = k; i < stream.length; i++) {
            // Compare the new element to the top element of the heap
            if (stream[i] > heap.peek()) {
                heap.poll();  // Remove the top element
                heap.add(stream[i]);  // Add the new element
            }
        }

        // The top element of the heap is the Kth largest element
        return heap.peek();
    }

}

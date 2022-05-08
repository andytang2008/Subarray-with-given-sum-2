    /* There is an idea if all the elements of the array are positive. If a subarray has sum greater than the given sum then there is no possibility that adding elements to the current subarray the sum will be x (given sum). Idea is to use a similar approach to a sliding window. Start with an empty subarray, add elements to the subarray until the sum is less than x. If the sum is greater than x, remove elements from the start of the current subarray.
 */

import java.io.*;
import java.util.Arrays;
class SubarraySum2 {

    int subArraySum(int arr[], int n, int sum)
    {
        int currentSum = arr[0], start = 0, i,j;
				System.out.print("****** Start["+"0]="+arr[0]);
				System.out.println();
        // Pick a starting point
        for (i = 1; i <= n; i++) {
            // If currentSum exceeds the sum,
            // then remove the starting elements
				
            while (currentSum > sum && start < i - 1) {
                currentSum = currentSum - arr[start];
                start++;
					System.out.println();
					System.out.print("****** Start["+start+"]="+arr[start] + "  currentSum="+currentSum);
					System.out.println();
				//System.out.println();
            }

            // If currentSum becomes equal to sum,
            // then return true
            if (currentSum == sum) {
                int p = i - 1;
                System.out.println(
                    "Sum found between indexes " + start
                    + " and " + p);
                return 1;
            }

            // Add this element to currentSum
            if (i < n)
                currentSum = currentSum + arr[i];
				
				System.out.print("   Sarr["+i+"]="+currentSum);
        }

        System.out.println("No subarray found");
        return 0;
    }

    public static void main(String[] args)
    {
        SubarraySum2 arraysum = new SubarraySum2();
	    int arr[] = { 12, 2, 3, 8, 9, 7, 11, 23, 13 };
		System.out.println(Arrays.toString(arr));
		System.out.println("------------------------------------------");
        int n = arr.length;
		 int sum = 27;
        arraysum.subArraySum(arr, n, sum);
    }
}

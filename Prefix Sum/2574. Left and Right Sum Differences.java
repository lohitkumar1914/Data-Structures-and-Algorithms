class Solution {
    public int[] leftRightDifference(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];

        // Build the left prefix sum
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + arr[i - 1];
        }

        // Build the right suffix sum
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + arr[i + 1];
        }

        // Calculate the absolute difference
        for (int i = 0; i < n; i++) {
            ans[i] = Math.abs(left[i] - right[i]);
        }

        return ans;
    }
}

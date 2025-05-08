// Consider an infinite string that consists of all positive integers in increasing order:
// 12345678910111213141516171819202122232425...
// Your task is to process q queries of the form: what is the digit at position k in the string?
// Input
// The first input line has an integer q: the number of queries.
// After this, there are q lines that describe the queries. Each line has an integer k: a 1-indexed position in the string.
// Output
// For each query, print the corresponding digit.
// Constraints

// 1 \le q \le 1000
// 1 \le k \le 10^{18}

// Example
// Input:
// 3
// 7
// 19
// 12

// Output:
// 7
// 4
// 1



import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        
        while (q-- > 0) {
            long k = sc.nextLong();
            System.out.println(findKthDigit(k));
        }
    }

    static char findKthDigit(long k) {
        long digitLength = 1;
        long count = 9;
        long start = 1;

        // Step 1: Find the length of the digit where k lies
        while (k > digitLength * count) {
            k -= digitLength * count;
            digitLength++;
            count *= 10;
            start *= 10;
        }

        // Step 2: Find the actual number
        long number = start + (k - 1) / digitLength;

        // Step 3: Find the digit in that number
        String numberStr = Long.toString(number);
        return numberStr.charAt((int)((k - 1) % digitLength));
    }
}

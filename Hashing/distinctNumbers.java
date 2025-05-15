// You are given a list of n integers, and your task is to calculate the number of distinct values in the list.
// Input
// The first input line has an integer n: the number of values.
// The second line has n integers x_1,x_2,\dots,x_n.
// Output
// Print one integers: the number of distinct values.
// Constraints

// 1 \le n \le 2 \cdot 10^5
// 1 \le x_i \le 10^9

// Example
// Input:
// 5
// 2 3 2 2 3

// Output:
// // 2]

import java.util.*;

public class DistinctValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Set<Integer> distinctSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            distinctSet.add(x); // HashSet will keep only unique values
        }

        System.out.println(distinctSet.size());
    }
}





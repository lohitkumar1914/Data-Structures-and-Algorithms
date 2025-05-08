// Online Java Compiler
// Use this editor to write, compile and run your Java code online
 import java.util.*;

public class TowerOfHanoiVisual {
    static List<Stack<Integer>> towers = new ArrayList<>();
    static int moveCount = 0;

    public static void move(int n, int source, int auxiliary, int destination) {
        if (n == 1) {
            performMove(source, destination);
            return;
        }

        move(n - 1, source, destination, auxiliary);
        performMove(source, destination);
        move(n - 1, auxiliary, source, destination);
    }

    public static void performMove(int from, int to) {
        int disk = towers.get(from).pop();
        towers.get(to).push(disk);
        moveCount++;
        System.out.println("Move " + moveCount + ": " + (from + 1) + " -> " + (to + 1));
        printTowers();
    }

    public static void printTowers() {
        System.out.println("Left:   " + towers.get(0));
        System.out.println("Middle: " + towers.get(1));
        System.out.println("Right:  " + towers.get(2));
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // Initialize 3 stacks
        for (int i = 0; i < 3; i++) {
            towers.add(new Stack<>());
        }

        // Add disks to the first stack (left), largest at bottom
        for (int i = n; i >= 1; i--) {
            towers.get(0).push(i);
        }

        System.out.println("Initial State:");
        printTowers();

        move(n, 0, 1, 2);

        System.out.println("Total moves: " + moveCount);
    }
}

import java.lang.Math;

public class Knapsack {
    // Our attributes
    private int[] weights;
    private int[] values;
    private int capacity;
    private int[][] opt;

    // Our constructor
    public Knapsack() {}

    // methode to initialize the knapsack and call the recursive function
    public int knapsack(int[] weights, int[] values, int capacity) {
        this.weights = weights;
        this.values = values;
        this.capacity = capacity;
        this.opt = new int[weights.length][capacity + 1]; // Corrected size of the memoization array
        return knapsackSolver(weights.length - 1, capacity);
    }

    // Our recursive function 
    private int knapsackSolver(int i, int x) {
        // Base case: no items or no capacity
        if (i < 0) {
            return 0;
        }

        // use the opt to store the results of the subproblems and avoid recomputing them
        if (opt[i][x] != 0) {
            return opt[i][x];
        }

        // if the weight of the i-th item is more than the current capacity x, skip the item
        if (weights[i] > x) {
            opt[i][x] = knapsackSolver(i - 1, x);
        } else {
            // Consider both taking and not taking the item
            opt[i][x] = Math.max(
                knapsackSolver(i - 1, x),
                knapsackSolver(i - 1, x - weights[i]) + values[i]
            );
        }

        return opt[i][x];
    }

    // Our main function
    public static void main(String[] args) {
        int[] weights = {9, 15, 16, 10, 12, 10, 30, 13, 17, 20, 10, 16, 15, 9, 6, 11, 1};
        int[] values = {10, 9, 6, 4, 4, 4, 10, 6, 8, 7, 8, 5, 6, 3, 2, 4, 4};
        int capacity = 96;
        for(int i = 0; i < weights.length; i++) {
            System.out.println("Item " + (i+1) + ": weight = " + weights[i] + ", value = " + values[i]);
        }
        Knapsack knapsack = new Knapsack();
        int maxVal = knapsack.knapsack(weights, values, capacity);
        System.out.println("The maximum possible value is: " + maxVal);
    }
}

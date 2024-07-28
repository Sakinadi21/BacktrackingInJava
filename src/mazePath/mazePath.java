package mazePath;

public class mazePath {
    public static void main(String[] args) {
        // Define the number of rows and columns in the maze
        int rows = 2;
        int cols = 2;

        // Calculate the number of ways to reach the end of the maze from the start
        int count = maze(1, 1, rows, cols);

        // Print the result
        System.out.println(count);
    }

    // Function to calculate the number of ways to reach the end of the maze
    // sr: starting row, sc: starting column
    // er: ending row, ec: ending column
    private static int maze(int sr, int sc, int er, int ec) {
        // If the starting point is out of maze bounds, return 0
        if (sr > er || sc > ec) return 0;

        // If the starting point is the same as the ending point, return 1
        if (sr == er && sc == ec) return 1;

        // Calculate the number of ways to reach the end by moving down
        int downWays = maze(sr + 1, sc, er, ec);

        // Calculate the number of ways to reach the end by moving right
        int rightWays = maze(sr, sc + 1, er, ec);

        // Total ways is the sum of downWays and rightWays
        int totalWays = downWays + rightWays;

        // Return the total number of ways
        return totalWays;
    }
}

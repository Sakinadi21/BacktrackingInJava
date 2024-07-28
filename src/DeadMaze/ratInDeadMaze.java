package DeadMaze;

public class ratInDeadMaze {
    public static void main(String[] args) {
        // Define the number of rows and columns in the maze
        int rows = 3;
        int cols = 4;

        // Define the maze with 1s as paths and 0s as blocked cells
        int[][] maze = {
                {1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 1}
        };

        // Start printing paths from the top-left corner (0, 0) to the bottom-right corner (rows-1, cols-1)
        print(0, 0, rows - 1, cols - 1, "", maze);
    }

    // Recursive function to print all paths from (sr, sc) to (er, ec)
    private static void print(int sr, int sc, int er, int ec, String s, int[][] maze) {
        // If the starting point is out of maze bounds, return
        if (sr > er || sc > ec || sr < 0 || sc < 0) return;

        // If the current cell is blocked, return
        if (maze[sr][sc] == 0) return;

        // If the starting point is the same as the ending point, print the path
        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }

        // Mark the cell as visited
        maze[sr][sc] = 0;

        // Go right: move to the next column, append 'R' to the path
        print(sr, sc + 1, er, ec, s + "R", maze);

        // Go down: move to the next row, append 'D' to the path
        print(sr + 1, sc, er, ec, s + "D", maze);

        // Go left: move to the previous column, append 'L' to the path
        print(sr, sc - 1, er, ec, s + "L", maze);

        // Go up: move to the previous row, append 'U' to the path
        print(sr - 1, sc, er, ec, s + "U", maze);

        // Backtrack: unmark the cell as visited
        maze[sr][sc] = 1;
    }
}

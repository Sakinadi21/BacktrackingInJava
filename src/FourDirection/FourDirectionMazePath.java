

package FourDirection;

public class FourDirectionMazePath {
    public static void main(String[] args) {
        // Define the number of rows and columns in the maze
        int rows = 3;
        int cols = 3;

        // Create a 2D boolean array to keep track of visited cells
        boolean[][] isVisited = new boolean[rows][cols];

        // Start printing paths from the top-left corner (0,0) to the bottom-right corner (rows-1, cols-1)
        print(0, 0, rows - 1, cols - 1, "", isVisited);
    }

    // Recursive function to print all paths from (sr, sc) to (er, ec)
    private static void print(int sr, int sc, int er, int ec, String s, boolean[][] isVisited) {
        // If the starting point is out of maze bounds, return
        if (sr < 0 || sc < 0 || sr > er || sc > ec) return;

        // If the cell is already visited, return
        if (isVisited[sr][sc]) return;

        // If the starting point is the same as the ending point, print the path
        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }

        // Mark the cell as visited
        isVisited[sr][sc] = true;

        // Go right: move to the next column, append 'R' to the path
        print(sr, sc + 1, er, ec, s + "R", isVisited);

        // Go down: move to the next row, append 'D' to the path
        print(sr + 1, sc, er, ec, s + "D", isVisited);

        // Go left: move to the previous column, append 'L' to the path
        print(sr, sc - 1, er, ec, s + "L", isVisited);

        // Go up: move to the previous row, append 'U' to the path
        print(sr - 1, sc, er, ec, s + "U", isVisited);

        // Backtracking: unmark the cell as visited
        isVisited[sr][sc] = false;
    }
}

package printPath;

public class printPath {
    public static void main(String[] args) {
        // Define the number of rows and columns in the maze
        int rows = 4;
        int cols = 3;

        // Call the print method to print all paths from (1,1) to (rows,cols)
        print(1, 1, rows, cols, "");
    }

    // Recursive function to print all paths from (sr, sc) to (er, ec)
    private static void print(int sr, int sc, int er, int ec, String s) {
        // If the starting point is out of maze bounds, return
        if (sr > er || sc > ec) return;

        // If the starting point is the same as the ending point, print the path
        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }

        // Go right: move to the next column, append 'R' to the path
        print(sr, sc + 1, er, ec, s + "R");

        // Go down: move to the next row, append 'D' to the path
        print(sr + 1, sc, er, ec, s + "D");
    }
}

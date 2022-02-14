package Recursion;

public class CountingCells {

    private static final int BACKGROUND_COLOR = 0;
    private static final int IMAGE_COLOR = 1;
    private static final int ALREADY_COUNTED = 2;
    private static final int N = 8;

    private static int[][] maze = {
            {0,0,0,0,0,0,0,1},
            {0,1,1,0,1,1,0,1},
            {0,0,0,1,0,0,0,1},
            {0,1,0,0,1,1,0,0},
            {0,1,1,1,0,0,1,1},
            {0,1,0,0,0,1,0,1},
            {0,0,0,1,0,0,0,1},
            {0,1,1,1,0,1,0,0}
    };

    public static int countCells(int x, int y) {

        if (x < 0 || y < 0 || x >= N || y >= N) {
            return 0;
        } else if (maze[x][y] != IMAGE_COLOR) {
            return 0;
        } else {
            maze[x][y] = ALREADY_COUNTED;
            return 1 + countCells(x - 1, y - 1) + countCells(x - 1, y)
                    + countCells(x - 1, y + 1) + countCells(x, y - 1)
                    + countCells(x, y + 1) + countCells(x + 1, y - 1)
                    + countCells(x + 1, y) + countCells(x + 1, y + 1);
        }
    }

    public static void printMaze() {
        for (int[] i : maze) {
            System.out.print("{ ");
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.print("}");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printMaze();
        System.out.println("count : " + countCells(3, 5));
        printMaze();
    }

}

package Recursion;
import java.util.*;

enum Define {
    PATHWAY_COLOUR,
    WALL_COLOUR,
    BLOCKED_COLOUR,
    PATH_COLOUR
}
public class Maze {
    private static int N = 8;
    static final int pathway = 0;
    static final int wall = 1;
    static final int blocked = 2;
    static final int path = 3;

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

    public static boolean findMazePath(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        } else if (maze[x][y] != pathway) {
            return false;
        } else if (x == N - 1 && y == N - 1) {
            maze[x][y] = path;
            return true;
        } else {
            if (findMazePath(x - 1, y) || findMazePath(x, y + 1) ||
                    findMazePath(x + 1, y) || findMazePath(x, y - 1)) {
                return true;
            }
            maze[x][y] = blocked;
            return false;
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
    }

    public static void main(String[] args) {
        printMaze();
        findMazePath(0,0);
        printMaze();
    }
}

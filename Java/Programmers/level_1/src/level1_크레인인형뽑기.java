import java.util.*;
public class level1_크레인인형뽑기 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();

        for(int i=0;i<moves.length;i++){

        }
        System.out.println(list);
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3,1},{0,2,5,0,1,3,5},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        int cont = board[moves[2]-1].length;
        for(int i=0;i<board[moves[2]].length;i++){
            System.out.println(board[2][i]);
        }
    }
}
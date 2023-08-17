package Algorithm;

import java.util.*;

public class P12905 {
    static public void main(String args[]){
        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        int result = solution(board);
        System.out.println(result);
    }

    static public int solution(int [][]board) {

        int row = board.length;
        int col = board[0].length;
        
        if(row==1 || col==1){
            return 1;
        }
        
        int max=0;
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(board[i][j]==0){
                    continue;
                }
                board[i][j]=Math.min(Math.min(board[i-1][j-1],board[i-1][j]),board[i][j-1])+1;
                
                if(max<board[i][j]){
                    max=board[i][j];
                }
            }
        }
        return max*max;
    }
}

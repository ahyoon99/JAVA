package Algorithm;

import java.util.*;

public class P160585 {
    static char[][] matrix;
    
    static int player1;
    static int player2;
    
    static int[][] dirX = { {0,0,0}, {1,1,1}, {2,2,2}, {0,1,2}, {0,1,2}, {0,1,2}, {0,1,2}, {2,1,0} };
    static int[][] dirY = { {0,1,2}, {0,1,2}, {0,1,2}, {0,0,0}, {1,1,1}, {2,2,2}, {0,1,2}, {0,1,2} };
    
    static public void main(String args[]){
        // tc1
        String[] board = {"O.X", ".O.", "..X"};

        // tc2
        // String[] board = {"OOO", "...", "XXX"};

        int result = solution(board);
        System.out.println(result);
    }

    static public int solution(String[] board) {
        matrix = new char[3][3];
        
        player1 = 0;
        player2 = 0;
        
        for(int i=0;i<3;i++){
            matrix[i] = board[i].toCharArray();
        }
        
        count();
        
        if(player1==0 && player2==0){
            return 1;
        }
        if(player1<player2){
            return 0;
        }
        if(player1>player2+1){
            return 0;
        }
        if(check('O')){
            if(player1!=player2+1){
                return 0;
            }
        }
        if(check('X')){
            if(player1!=player2){
                return 0;
            }
        }
        return 1;
    }
    
    static boolean check(char c){
        for(int i=0;i<8;i++){
            if(matrix[dirX[i][0]][dirY[i][0]]==c && matrix[dirX[i][1]][dirY[i][1]] == c && matrix[dirX[i][2]][dirY[i][2]] == c){
                return true;
            }
        }
        return false;
    }
    
    static void count(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(matrix[i][j] =='O'){
                    player1++;
                }
                else if(matrix[i][j] =='X'){
                    player2++;
                }
            }
        }
    }
}

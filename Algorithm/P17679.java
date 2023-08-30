package Algorithm;

import java.util.*;

public class P17679 {
    static boolean[][] v;

    static public void main(String args[]){
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        int result = solution(m, n, board);
        System.out.println(result);
    }

    static public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] block = new char[m][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                block[i][j]=board[i].charAt(j);
            }
        }
        
        boolean flag = true;
        while(flag){
            flag = false;
            v = new boolean[m][n];
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    if(block[i][j]=='#'){   // #은 빈칸을 의미
                        continue;
                    }
                    if(checkBlock(i,j,block)){  // 2*2 체크
                        flag = true;
                    }
                }
            }
            answer += dropBlock(n,m,block);
        }
        return answer;
    }
    
    // 2*2가 같은지 체크 -> 같으면 true로 설정해주기
    static boolean checkBlock(int x, int y, char[][] block){
        char ans = block[x][y];
        if(block[x+1][y]==ans && block[x][y+1]==ans && block[x+1][y+1]==ans){
            v[x][y]=true;
            v[x+1][y]=true;
            v[x][y+1]=true;
            v[x+1][y+1]=true;
            return true;
        }
        return false;
    }
    
    // 같은 블록 제거 (Queue를 이용해 세로로 제거 작업 진행)
    static int dropBlock(int n, int m, char[][] board){
        Queue<Character> q = new LinkedList<>();
        int cnt=0;
        
        // ** v[i][j]가 false인 것(지워지지 않는 것)을 Queue에 담기
        // ** v[i][j]가 true인 것의 개수 카운트 해주기 (cnt)
        for(int i=0;i<n;i++){
            for(int j=m-1;j>=0;j--){
                if(!v[j][i]){
                    q.add(board[j][i]);
                }
                else{
                    cnt++;
                }
            }
            
            // Queue에 담은 것들을 아래서부터 넣어주기
            int idx = m-1;
            while(!q.isEmpty()){
                board[idx][i] = q.poll();
                idx--;
            }
            // 빈칸은 #로 채워주기
            for(int j=idx;j>=0;j--){
                board[j][i]='#';
            }
        }
        return cnt;
    }
}

package Algorithm;

import java.util.*;

public class P169199 {
    static int n;
    static int m;
    
    static int[][] matrix;
    
    static Node start;
    static Node end;
    
    static int[][] cnt;
    
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    
    static class Node{
        int x;
        int y;
        
        Node(){};
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    static public int solution(String[] board) {
        int answer = 0;
        
        start = new Node(-1,-1);
        end = new Node(-1,-1);
        
        n = board.length;
        m = board[0].length();
        
        matrix = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i].charAt(j)=='D'){
                    matrix[i][j]=-1;
                }
                else if(board[i].charAt(j)=='R'){
                    start = new Node(i,j);
                }
                else if(board[i].charAt(j)=='G'){
                    end = new Node(i,j);
                }
            }
        }
        
        bfs();
        
        if(cnt[end.x][end.y]==Integer.MAX_VALUE){
            answer = -1;
        }
        else{
            answer = cnt[end.x][end.y];
        }
        return answer;
    }
    
    static public void bfs(){
        Queue<Node> q = new LinkedList<>();
        cnt = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(cnt[i], Integer.MAX_VALUE);
        }
        
        q.add(new Node(start.x, start.y));
        cnt[start.x][start.y]=0;
        int nx=-1;
        int ny=-1;
        
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            for(int i=0;i<4;i++){
                nx = x+dx[i];
                ny = y+dy[i];
                while(true){
                    if(0>nx || nx>=n || 0>ny || ny>=m){
                        nx-=dx[i];
                        ny-=dy[i];
                        if(cnt[nx][ny]>cnt[x][y]+1){
                            q.add(new Node(nx, ny));
                            cnt[nx][ny]=cnt[x][y]+1;
                            if(nx==end.x && ny ==end.y){
                                return;
                            }
                        }
                        break;
                    }
                    if(matrix[nx][ny]==-1){
                        nx-=dx[i];
                        ny-=dy[i];
                        if(cnt[nx][ny]>cnt[x][y]+1){
                            q.add(new Node(nx, ny));
                            cnt[nx][ny]=cnt[x][y]+1;
                            if(nx==end.x && ny ==end.y){
                                return;
                            }
                        }
                        break;
                    }
                    nx+=dx[i];
                    ny+=dy[i];
                }
            }
        }
    }

    static public void main(String args[]){
        
        // tc1
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};

        // tc2
        // String[] board = {".D.R", "....", ".G..", "...D"};

        int result = solution(board);
        System.out.println(result);

    }
}
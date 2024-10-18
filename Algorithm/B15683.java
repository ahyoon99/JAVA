package Algorithm;

import java.util.*;
import java.io.*;

public class B15683 {
    static int n;
    static int m;
    static int[][] matrix;
    static int totalArea;
    static int minAnswer;
    static int answer;
    static ArrayList<Node> cctv;
    static ArrayList<Integer> dirCnt;
    static int[] dir;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        input();

        dir = new int[cctv.size()];
        go(0);
        System.out.println(minAnswer);
    }
    
    static void go(int dirIdx){
        if(dirIdx>=dir.length){
            answer = totalArea;
            findDir();
            if(minAnswer>answer){
                minAnswer=answer;
            }
            return;
        }

        for(int i=0;i<dirCnt.get(dirIdx);i++){
            dir[dirIdx]=i;
            go(dirIdx+1);            
        }
    }

    static void findDir(){
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<cctv.size();i++){
            Node cctvNode = cctv.get(i);
            if(matrix[cctvNode.x][cctvNode.y]==1){
                if(dir[i]==0){
                    calculate(visited, cctvNode.x, cctvNode.y, 0);
                }
                else if(dir[i]==1){
                    calculate(visited, cctvNode.x, cctvNode.y, 1);
                }
                else if(dir[i]==2){
                    calculate(visited, cctvNode.x, cctvNode.y, 2);
                }
                else if(dir[i]==3){
                    calculate(visited, cctvNode.x, cctvNode.y, 3);
                }
            }
            else if(matrix[cctvNode.x][cctvNode.y]==2){
                if(dir[i]==0){
                    calculate(visited, cctvNode.x, cctvNode.y, 0);
                    calculate(visited, cctvNode.x, cctvNode.y, 1);
                }
                else if(dir[i]==1){
                    calculate(visited, cctvNode.x, cctvNode.y, 2);
                    calculate(visited, cctvNode.x, cctvNode.y, 3);
                }
            }
            else if(matrix[cctvNode.x][cctvNode.y]==3){
                if(dir[i]==0){
                    calculate(visited, cctvNode.x, cctvNode.y, 3);
                    calculate(visited, cctvNode.x, cctvNode.y, 0);
                }
                else if(dir[i]==1){
                    calculate(visited, cctvNode.x, cctvNode.y, 0);
                    calculate(visited, cctvNode.x, cctvNode.y, 2);
                }
                else if(dir[i]==2){
                    calculate(visited, cctvNode.x, cctvNode.y, 2);
                    calculate(visited, cctvNode.x, cctvNode.y, 1);
                }
                else if(dir[i]==3){
                    calculate(visited, cctvNode.x, cctvNode.y, 1);
                    calculate(visited, cctvNode.x, cctvNode.y, 3);
                }
            }
            else if(matrix[cctvNode.x][cctvNode.y]==4){
                if(dir[i]==0){
                    calculate(visited, cctvNode.x, cctvNode.y, 1);
                    calculate(visited, cctvNode.x, cctvNode.y, 3);
                    calculate(visited, cctvNode.x, cctvNode.y, 0);
                }
                else if(dir[i]==1){
                    calculate(visited, cctvNode.x, cctvNode.y, 3);
                    calculate(visited, cctvNode.x, cctvNode.y, 0);
                    calculate(visited, cctvNode.x, cctvNode.y, 2);
                }
                else if(dir[i]==2){
                    calculate(visited, cctvNode.x, cctvNode.y, 1);
                    calculate(visited, cctvNode.x, cctvNode.y, 2);
                    calculate(visited, cctvNode.x, cctvNode.y, 0);
                }
                else if(dir[i]==3){
                    calculate(visited, cctvNode.x, cctvNode.y, 3);
                    calculate(visited, cctvNode.x, cctvNode.y, 1);
                    calculate(visited, cctvNode.x, cctvNode.y, 2);
                }
            }
            else if(matrix[cctvNode.x][cctvNode.y]==5){
                calculate(visited, cctvNode.x, cctvNode.y, 0);
                calculate(visited, cctvNode.x, cctvNode.y, 1);
                calculate(visited, cctvNode.x, cctvNode.y, 2);
                calculate(visited, cctvNode.x, cctvNode.y, 3);
            }
        }
    }

    static void calculate(boolean[][] visited, int x, int y, int dir){
        int nx = x+dx[dir];
        int ny = y+dy[dir];
        if(0 > nx || nx>=n || 0>ny || ny>=m){
            return;
        }
        if(matrix[nx][ny]==6){
            return;
        }
        if(1<= matrix[nx][ny] && matrix[nx][ny]<=5){    // cctv는 cctv를 통과할 수 있다.
            calculate(visited, nx, ny, dir);
        }
        else if(visited[nx][ny]){
            calculate(visited, nx, ny, dir);
        }
        else if(matrix[nx][ny]==0){
            visited[nx][ny]=true;
            answer--;
            calculate(visited, nx, ny, dir);
        }
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        cctv = new ArrayList<Node>();
        dirCnt = new ArrayList<Integer>();
        totalArea = 0;
        minAnswer = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<m;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(1<= matrix[i][j] && matrix[i][j]<=5){
                    cctv.add(new Node(i,j));
                    if(matrix[i][j]==1 || matrix[i][j]==3 || matrix[i][j]==4){
                        dirCnt.add(4);
                    }
                    else if(matrix[i][j]==2){
                        dirCnt.add(2);
                    }
                    else if(matrix[i][j]==5){
                        dirCnt.add(1);
                    }
                }
                else if(matrix[i][j]==0){
                    totalArea++;
                }
            }
        }
    }
}

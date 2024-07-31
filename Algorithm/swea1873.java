package Algorithm;

import java.util.*;
import java.io.*;

public class swea1873 {
    static int t;
    static int h;
    static int w;
    static int n;
    static char[][] matrix;
    static char[] orders;
    static Pair tank;
    static int direction;
    static class Pair{
        int x;
        int y;
        Pair(){}
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());

        for(int testcase=1;testcase<=t;testcase++){
            System.out.print("#"+testcase+" ");
            input(br, st);
            solution();
        }
    }

    static void solution(){
        for(int i=0;i<n;i++){
            if(orders[i]=='U'){
                direction = 0;
                int x = tank.x+dx[direction];
                int y = tank.y+dy[direction];
                if(!isValid(x,y)){
                    matrix[tank.x][tank.y]='^';
                    continue;
                }
                
                if(matrix[x][y]=='.'){
                    matrix[tank.x][tank.y]='.';
                    tank.x=x;
                    tank.y=y;
                }
                matrix[tank.x][tank.y]='^';
                
            }
            else if(orders[i]=='D'){
                direction = 2;
                int x = tank.x+dx[direction];
                int y = tank.y+dy[direction];
                if(!isValid(x,y)){
                    matrix[tank.x][tank.y]='v';
                    continue;
                }
                if(matrix[x][y]=='.'){
                    matrix[tank.x][tank.y]='.';
                    tank.x=x;
                    tank.y=y;
                }
                matrix[tank.x][tank.y]='v';
            }
            else if(orders[i]=='R'){
                direction = 1;
                int x = tank.x+dx[direction];
                int y = tank.y+dy[direction];
                if(!isValid(x,y)){
                    matrix[tank.x][tank.y]='>';
                    continue;
                }
                if(matrix[x][y]=='.'){
                    matrix[tank.x][tank.y]='.';
                    tank.x=x;
                    tank.y=y;
                }
                matrix[tank.x][tank.y]='>';
            }
            else if(orders[i]=='L'){
                direction = 3;
                int x = tank.x+dx[direction];
                int y = tank.y+dy[direction];
                if(!isValid(x,y)){
                    matrix[tank.x][tank.y]='<';
                    continue;
                }
                if(matrix[x][y]=='.'){
                    matrix[tank.x][tank.y]='.';
                    tank.x=x;
                    tank.y=y;
                }
                matrix[tank.x][tank.y]='<';
            }
            else if(orders[i]=='S'){
                int x = tank.x;
                int y = tank.y;
                while(true){
                    x+=dx[direction];
                    y+=dy[direction];

                    if(!isValid(x, y)){
                        break;
                    }
                    if(matrix[x][y]=='#'){
                        break;
                    }
                    if(matrix[x][y]=='*'){
                        matrix[x][y]='.';
                        break;
                    }
                }
            }
        }

        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    static boolean isValid(int x, int y){
        if(0<=x && x<h && 0<=y && y<w){
            return true;
        }
        return false;
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        matrix = new char[h][w];
        for(int i=0;i<h;i++){
            st = new StringTokenizer(br.readLine(), " ");
            String temp = st.nextToken();
            for(int j=0;j<w;j++){
                matrix[i][j] = temp.charAt(j);
                if(matrix[i][j]=='^'){
                    tank = new Pair(i,j);
                    direction = 0;
                } else if(matrix[i][j]=='v'){
                    tank = new Pair(i,j);
                    direction = 2;
                } else if(matrix[i][j]=='<'){
                    tank = new Pair(i,j);
                    direction = 3;
                } else if(matrix[i][j]=='>'){
                    tank = new Pair(i,j);
                    direction = 1;
                }
            }
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        String order = st.nextToken();
        orders = new char[n];
        for(int i=0;i<n;i++){
            orders[i]=order.charAt(i);
        }
    }
}

package Algorithm;

import java.util.*;
import java.io.*;

public class B14499 {
    static int n;
    static int m;
    static Node dice;
    static int[] diceNum;
    static int k;
    static int[][] map;
    static int[] order;

    static class Node{
        int x;
        int y;
        Node(){}
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        input();

        for(int tc=0;tc<k;tc++){
            int dir = order[tc];
            int nx = dice.x+dx[dir-1];
            int ny = dice.y+dy[dir-1];
            if(!isValid(nx, ny)){
                continue;
            }
            
            dice = new Node(nx, ny);
            if(dir==1){
                int num1 = diceNum[1];
                int num3 = diceNum[3];
                int num4 = diceNum[4];
                int num5 = diceNum[5];

                diceNum[1]=num4;
                diceNum[3]=num5;
                diceNum[4]=num3;
                diceNum[5]=num1;
            }
            else if(dir==2){
                int num1 = diceNum[1];
                int num3 = diceNum[3];
                int num4 = diceNum[4];
                int num5 = diceNum[5];
                
                diceNum[1]=num5;
                diceNum[3]=num4;
                diceNum[4]=num1;
                diceNum[5]=num3;
            }
            else if(dir==3){
                int num0 = diceNum[0];
                int num1 = diceNum[1];
                int num2 = diceNum[2];
                int num3 = diceNum[3];
                
                diceNum[0]=num1;
                diceNum[1]=num2;
                diceNum[2]=num3;
                diceNum[3]=num0;
            }
            else if(dir==4){
                int num0 = diceNum[0];
                int num1 = diceNum[1];
                int num2 = diceNum[2];
                int num3 = diceNum[3];
                
                diceNum[0]=num3;
                diceNum[1]=num0;
                diceNum[2]=num1;
                diceNum[3]=num2;
            }

            if(map[nx][ny]==0){
                map[nx][ny]=diceNum[3];
            }
            else{
                diceNum[3] = map[nx][ny];
                map[nx][ny]=0;
            }
            System.out.println(diceNum[1]);
        }
    }

    static boolean isValid(int x, int y){
        if(0<=x && x<n && 0<=y && y<m){
            return true;
        }
        return false;
    }

    static void input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        dice = new Node(x,y);
        k = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        order = new int[k];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<k;i++){
            order[i] = Integer.parseInt(st.nextToken());
        }

        diceNum = new int[6];
    }
}

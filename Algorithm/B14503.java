package Algorithm;

import java.util.*;
import java.io.*;

public class B14503 {
    static int n;
    static int m;
    static int[][] matrix;
    static boolean[][] isClean;
    static Robot robot;
    static int answer;

    static class Robot{
        int x;
        int y;
        int dir;

        Robot(){}
        Robot(int x, int y, int dir){
            this.x=x;
            this.y=y;
            this.dir=dir;
        }
    }

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        input();
        clean();
        System.out.println(answer);
    }

    static void clean(){
        while(true){
            if(matrix[robot.x][robot.y]==0 && !isClean[robot.x][robot.y]){
                isClean[robot.x][robot.y] = true;
                answer++;
            }
            if(check(robot.x, robot.y)){  // 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                robot.dir=(robot.dir+3)%4;
                int nx = robot.x+dx[robot.dir];
                int ny = robot.y+dy[robot.dir];
                if(0<= nx && nx<n && 0<=ny && ny<m){
                    if(matrix[nx][ny]==0 && !isClean[nx][ny]){
                        robot.x=nx;
                        robot.y=ny;
                    }
                }
            }
            else{   // 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
                int nx = robot.x-dx[robot.dir];
                int ny = robot.y-dy[robot.dir];
                if((0 <= nx && nx<n && 0 <=ny && ny<m) && matrix[nx][ny]==0){
                    robot.x=nx;
                    robot.y=ny;
                }
                else{
                    break;
                }
            }
        }
    }

    static boolean check(int x, int y){
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(matrix[nx][ny]==0 && !isClean[nx][ny]){
                return true;
            }
        }
        return false;
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        robot = new Robot(x,y,dir);

        matrix = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<m;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer=0;
        isClean = new boolean[n][m];
    }
}

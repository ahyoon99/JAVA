package Algorithm;

import java.util.*;
import java.io.*;

/* 입력예제1
9 14
.......###....
.........#....
.#####...###..
.#.........#..
.#.#####...###
.#.#...#.....#
.###.###.....#
.....#.......#
.....#########
*/
public class H236166 {
    static class Pair{
        int x;
        int y;
        Pair(){}
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
        
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] map = new int[h][w];

        ArrayList<Pair> startPoint = new ArrayList<>();
        for(int i=0;i<h;i++){
            st = new StringTokenizer(br.readLine(), " ");
            String com = st.nextToken();
            for(int j=0;j<com.length();j++){
                if(com.charAt(j)=='#'){
                    map[i][j]=1;
                    startPoint.add(new Pair(i,j));
                }
                else if(com.charAt(j)=='.'){
                    map[i][j]=0;
                }
            }
        }

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        String answerMin = "";
        Pair point = new Pair(0,0);
        for(int tc=0;tc<startPoint.size();tc++){
            int[][] medMap = new int[h][w];
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    medMap[i][j]=map[i][j];
                }
            }
            String answer = "";
            Queue<Pair> q = new LinkedList<>();
            q.add(startPoint.get(tc));
            medMap[startPoint.get(tc).x][startPoint.get(tc).y]=-1;

            while(!q.isEmpty()){
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;
                boolean check=true;
                for(int i=0;i<4;i++){
                    if(!check){
                        break;
                    }
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    int nnx = x+(dx[i]*2);
                    int nny = y+(dy[i]*2);
                    if((0<=nx && nx<h && 0<=ny && ny<w)&&(0<=nnx && nnx<h && 0<=nny && nny<w)){
                        if(medMap[nx][ny] == 1 && medMap[nnx][nny] == 1){
                            q.add(new Pair(nnx, nny));
                            medMap[nx][ny]=-1;
                            medMap[nnx][nny]=-1;
                            answer+=String.valueOf(i);
                            check=false;
                        }
                    }
                }
            }

            boolean finish = true;
            for(int i=0;i<startPoint.size();i++){
                int x = startPoint.get(i).x;
                int y = startPoint.get(i).y;
                if(medMap[x][y]!=-1){
                    finish=false;
                    break;
                }
            }

            if(finish){
                if(answerMin.equals("") || answerMin.length()>answer.length()){
                    answerMin=answer;
                    point.x=startPoint.get(tc).x;
                    point.y=startPoint.get(tc).y;
                }
            }
        }

        sb.append((point.x+1)+" "+(point.y+1));
        sb.append("\n");
        switch(answerMin.charAt(0)){
            case '0':
                sb.append("v");
                break;
            case '1':
                sb.append(">");
                break;
            case '2':
                sb.append("^");
                break;
            case '3':
                sb.append("<");
                break;
        }

        String result = "A";
        for(int i=0;i<answerMin.length()-1;i++){
            int prev = answerMin.charAt(i)-'0';
            int next = answerMin.charAt(i+1)-'0';
            if(prev-next==2 || prev-next==-2){
                result+="LLA";
            }
            else if(prev-next==1 || prev-next==-3){
                result+="RA";
            }
            else if(prev-next==3 || prev-next==-1){
                result+="LA";
            }
            else if(prev-next==0){
                result+="A";
            }
        }
        sb.append("\n");
        sb.append(result);
        sb.append("\n");
        System.out.println(sb);
    }
}

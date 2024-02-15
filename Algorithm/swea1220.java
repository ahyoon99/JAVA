package Algorithm;

import java.util.*;
import java.io.*;

public class swea1220 {
    static int[][] ground;
    static int n;
    static public void main(String args[]) throws IOException{
        
        System.setIn(new FileInputStream("res/input_swea1220.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<10;i++){
            System.out.print("#"+(i+1)+" ");
            solution(br);
        }

    }

    static void solution(BufferedReader br) throws IOException{
        input(br);

        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            String med = "";
            for(int j=0;j<n;j++){
                if(ground[j][i]==1){
                    med+="1";
                }
                else if(ground[j][i]==2){
                    med+="2";
                }
            }
            answer[i]=med;
        }

        for(int i=0;i<n;i++){
            while(true){
                if(answer[i].length()==0){
                    break;
                }
                if(answer[i].length()==1){
                    answer[i]="";
                    break;
                }
                if((answer[i].charAt(0)!='2') && (answer[i].charAt(answer[i].length()-1)!='1')){
                    break;
                }
                if(answer[i].charAt(0)=='2'){
                    answer[i]=answer[i].substring(1);
                }
                if(answer[i].charAt(answer[i].length()-1)=='1'){
                    answer[i]=answer[i].substring(0, answer[i].length()-1);
                }
            }
        }

        
        int result = 0;
        for(int i=0;i<n;i++){
            int npole = 0;
            for(int j=0;j<answer[i].length();j++){
                if(answer[i].charAt(j)=='2' && npole==1){ // 빨간색 한 개  이상 만났을 때(npole==1), 파란색을 만난다면()
                    result++;   // 교착상태 1 증가
                    npole=0;    // 상태 초기화
                }
                if(answer[i].charAt(j)=='1'){   // 빨간색 만났을 때
                    npole=1;    // 상태 변경
                }
            }
        }

        System.out.println(result);
    }

    static void input(BufferedReader br) throws IOException{
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        ground = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                ground[i][j]=Integer.parseInt(st.nextToken());
            }
        }
    }
}

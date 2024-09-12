package Algorithm;

import java.util.*;
import java.io.*;

public class B14889 {
    static int n;
    static int[][] matrix;

    static int[] teamA;
    static int[] teamB;
    static int[] members;

    static int min;

    static public void main(String args[]) throws IOException{
        input();

        divideTeam(0,0);
        System.out.println(min);
    }

    static void divideTeam(int idx, int num){
        if(idx>=teamA.length){  // A팀 완성
            // B팀 만들기
            makeTeamB();

            // 점수계산
            int diff = Math.abs(calculate(teamA)-calculate(teamB));
            min = Math.min(min, diff);

            return;
        }
        if(num>=n){
            return;
        }
        teamA[idx]=num;
        divideTeam(idx+1, num+1);
        teamA[idx]=0;
        divideTeam(idx, num+1);
    }

    static void makeTeamB(){
        Arrays.fill(members, 0);
        for(int i=0;i<teamA.length;i++){
            members[teamA[i]]=1;
        }

        int idx=0;
        for(int i=0;i<n;i++){
            if(members[i]==0){
                teamB[idx]=i;
                idx++;
            }
        }
    }

    static int calculate(int[] arr){
        int answer = 0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                answer += matrix[arr[i]][arr[j]];
                answer += matrix[arr[j]][arr[i]];
            }
        }
        return answer;
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        teamA = new int[n/2];
        teamB = new int[n/2];
        members = new int[n];
        
        min = Integer.MAX_VALUE;
    }
}

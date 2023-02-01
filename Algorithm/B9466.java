package Algorithm;

import java.util.*;

public class B9466 {
/*
3
2 3 2

3
2 3 3
*/

    static int studentCntHavingTeamProject=0;
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int tc=0;tc<testcase;tc++){
            int n = sc.nextInt();
            boolean[] done = new boolean[n+1];
            int[] applyTeam = new int[n+1];
            studentCntHavingTeamProject=0;

            for(int i=1;i<=n;i++){
                int end = sc.nextInt();
                applyTeam[i]=end;
                if(i==end){
                    done[i]=true;
                    studentCntHavingTeamProject++;
                }
            }
            boolean[] visited = new boolean[n+1];
            for(int i=1;i<=n;i++){
                if(!done[i]){
                    dfs(applyTeam, visited, done, i,-1);
                }
            }
            //System.out.println("studentCntHavingTeamProject : "+studentCntHavingTeamProject);
            System.out.println(n-studentCntHavingTeamProject);
        }
    }

    static void dfs(int[] applyTeam, boolean[] visited, boolean[] done, int cur, int parent){
        if(visited[cur]){
            done[cur]=true;
            studentCntHavingTeamProject++;
        }
        else{
            visited[cur]=true;
        }
        int next = applyTeam[cur];
        if(!done[next]){
            dfs(applyTeam, visited, done, next, cur);
        }

        visited[cur]=false;
        done[cur]=true;
    }
}

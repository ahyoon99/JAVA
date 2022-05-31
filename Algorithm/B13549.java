package Algorithm;

import java.util.*;

public class B13549 {

    // 1. 큐 2개로 해결하기
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dist = new int[100001];
        Arrays.fill(dist, -1);

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        q1.add(n);
        dist[n]=0;
        while(!q1.isEmpty() || !q2.isEmpty()){
            if(q1.isEmpty()){
                q1 = q2;
                q2 = new LinkedList<>();
            }
            int x = q1.poll();
            
            int dx = 2*x;
            if(0<=dx && dx<100001 && dist[dx]==-1){
                q1.add(dx);
                dist[dx]=dist[x];
            }
            
            dx = x-1;
            if(0<=dx && dx<100001 && dist[dx]==-1){
                q2.add(dx);
                dist[dx]=dist[x]+1;
            }

            dx = x+1;
            if(0<=dx && dx<100001 && dist[dx]==-1){
                q2.add(dx);
                dist[dx]=dist[x]+1;
            }
        }
        System.out.println(dist[k]);
    }
}

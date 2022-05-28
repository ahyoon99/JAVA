package Algorithm;

import java.util.*;

public class B1697 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] street = new int[100001];
        Arrays.fill(street, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        street[n]=0;   // 시작점을 -1이라고 하자. 
        while(!q.isEmpty()){
            int x  = q.peek();
            q.poll();
            if(x==k){
                break;
            }
            int dx = x-1;
            if(0<=dx && dx<=100000){
                if(street[dx]==-1){
                    q.add(dx);
                    street[dx]=street[x]+1;
                }
            }
            dx = x+1;
            if(0<=dx && dx<=100000){
                if(street[dx]==-1){
                    q.add(dx);
                    street[dx]=street[x]+1;
                }
            }
            dx=x*2;
            if(0<=dx && dx<=100000){
                if(street[dx]==-1){
                    q.add(dx);
                    street[dx]=street[x]+1;
                }
            }
        }
        System.out.println(street[k]);
    }
    
}

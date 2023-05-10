package Algorithm;

import java.util.*;

public class B2075 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pq.add(sc.nextInt());
            }
        }

        int num=n;
        int result=0;
        while(num>0){
            result = pq.poll();
            num--;
        }
        System.out.println(result);
    }
}

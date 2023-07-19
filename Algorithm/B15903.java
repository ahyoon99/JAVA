package Algorithm;

import java.util.*;

public class B15903 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            long num = sc.nextInt();
            minHeap.add(num);
        }

        for(int i=0;i<m;i++){
            long first = minHeap.poll();
            long second = minHeap.poll();

            minHeap.add(first+second);
            minHeap.add(first+second);
        }

        long answer =0;
        while(!minHeap.isEmpty()){
            answer+=minHeap.poll();
        }
        System.out.println(answer);
    }
}

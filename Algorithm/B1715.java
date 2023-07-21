package Algorithm;

import java.util.*;

public class B1715 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            minHeap.add(sc.nextInt());
        }

        int result=0;
        while(minHeap.size()>1){
            int num1 = minHeap.poll();
            int num2 = minHeap.poll();
            result+=(num1+num2);
            minHeap.add(num1+num2);
        }
        System.out.println(result);
    }
}

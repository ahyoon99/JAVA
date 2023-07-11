package Algorithm;

import java.util.*;

public class B1417 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int answer = 0;
        int max = sc.nextInt();
        for(int i=1;i<n;i++){
            int num = sc.nextInt();
            maxHeap.add(num);
        }

        while(!maxHeap.isEmpty() && max<=maxHeap.peek()){
            int top = maxHeap.poll();
            maxHeap.add(top-1);
            max++;
            answer++;
        }
        System.out.println(answer);
    }
}

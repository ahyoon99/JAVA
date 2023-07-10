package Algorithm;

import java.util.*;

public class B1927 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            if(num==0){
                if(minHeap.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(minHeap.poll());
                }
            }
            else{
                minHeap.add(num);
            }
        }
    }
}

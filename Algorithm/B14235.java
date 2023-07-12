package Algorithm;

import java.util.*;

public class B14235 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            if(num==0){
                if(maxHeap.isEmpty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(maxHeap.poll());
                }
            }
            else{
                for(int j=0;j<num;j++){
                    maxHeap.add(sc.nextInt());
                }
            }
        }
    }
}

package Algorithm;

import java.io.*;
import java.util.*;

public class B1655 {
    static public void main(String args[]) throws NumberFormatException, IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            if(minHeap.size()==maxHeap.size()){
                maxHeap.add(num);
                if(!minHeap.isEmpty() && minHeap.peek()<num){
                    int min = maxHeap.poll();
                    int max = minHeap.poll();
                    maxHeap.add(max);
                    minHeap.add(min);
                }
            }
            else{
                minHeap.add(num);
                if(!maxHeap.isEmpty() && maxHeap.peek()>num){
                    int min = maxHeap.poll();
                    int max = minHeap.poll();
                    maxHeap.add(max);
                    minHeap.add(min);
                }
            }
            sb.append(maxHeap.peek()+"\n");
        }
        System.out.println(sb);
    }
}

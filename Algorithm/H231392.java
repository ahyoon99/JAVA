package Algorithm;

import java.util.*;
import java.io.*;

public class H231392 {
    static int min = -1;
    static int n;
    static int m;
    static int k;

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int[] result = new int[n];
        boolean[] visited = new boolean[n];

        go(arr, result, visited, 0);

        System.out.println(min);
        
    }

    static public void go(int[] arr, int[] result, boolean[] visited, int idx){
        if(idx>=result.length){
            calculation(result);
            return;
        }
        for(int i=0;i<result.length;i++){
            if(visited[i]==false){
                result[idx] = arr[i];
                visited[i]=true;
                go(arr, result, visited, idx+1);
                visited[i]=false;
            }
        }
    }

    static public void calculation(int[] arr){
        Queue<Integer> lane = new LinkedList<>();
        Queue<Integer> basket = new LinkedList<>();
        int result=0;
        for(int i=0;i<n;i++){
            lane.add(arr[i]);
        }

        for(int i=0;i<k;i++){
            int basketSum = 0;
            while(basketSum<m){
                if(basketSum+lane.peek()>m){
                    break;
                }
                int top = lane.poll();
                basket.add(top);
                basketSum+=top;
                result+=top;
            }
            
            for(int j=0;j<basket.size();j++){
                lane.add(basket.poll());
            }
        }

        if(min==-1 || min>result){
            min=result;
        }
    }
}

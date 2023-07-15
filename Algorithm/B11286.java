package Algorithm;

import java.util.*;

public class B11286 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);

                if(abs1==abs2){
                    return o1-o2;
                }
                return abs1-abs2;
        });

        for(int i=0;i<n;i++){
            int num=sc.nextInt();
            if(num==0){
                if(heap.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(heap.poll());
                }
            }
            else{
                heap.add(num);
            }
        }
    }
}

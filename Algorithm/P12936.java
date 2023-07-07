package Algorithm;

import java.util.*;

public class P12936 {
    static public void main(String args[]){
        int n = 3;
        int k = 5;
        int[] result = solution(n, k);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
    
    static public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        List<Integer> list = new ArrayList<>();
        long f = 1;
        for(int i=1;i<=n;i++){
            list.add(i);
            f*=i;
        }
        
        k-=1;
        int idx=0;
        while(idx<n){
            f = f/list.size();
            int index = (int) (k/f);
            answer[idx]=list.get(index);
            list.remove(index);
            k%=f;
            idx++;
        }
        return answer;
    }
}
